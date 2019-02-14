package com.rikkei.demomvp.screen.list_user;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rikkei.demomvp.R;
import com.rikkei.demomvp.data.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private Context mContext;
    private List<User> mUsers;
    private OnItemClickListener mListener;

    public UserAdapter(Context context, List<User> users, OnItemClickListener listener) {
        mContext = context;
        mUsers = users;
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_user, viewGroup, false);
        return new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindItemView(mUsers.get(i));
    }

    @Override
    public int getItemCount() {
        return mUsers != null ? mUsers.size() : 0;
    }

    public void insertUsers(List<User> users) {
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextId;
        private TextView mTextUsername;
        private TextView mTextEmail;
        private ConstraintLayout mLayoutItemUser;
        private OnItemClickListener mListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);
            mListener = listener;
            mTextId = itemView.findViewById(R.id.text_id);
            mTextUsername = itemView.findViewById(R.id.text_username);
            mTextEmail = itemView.findViewById(R.id.text_email);
            mLayoutItemUser = itemView.findViewById(R.id.layout_item_user);
            mLayoutItemUser.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick(getAdapterPosition());
                }
            });
        }

        private void bindItemView(User user) {
            mTextId.setText(String.valueOf(user.getId()));
            mTextUsername.setText(user.getUsername());
            mTextEmail.setText(user.getEmail());
        }
    }

    interface OnItemClickListener {
        void onItemClick(int position);
    }
}
