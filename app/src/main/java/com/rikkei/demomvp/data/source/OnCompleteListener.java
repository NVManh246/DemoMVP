package com.rikkei.demomvp.data.source;

public interface OnCompleteListener<T> {
    void onSuccess(T t);
    void onError(Exception t);
}
