package com.example.essmeapp.codebase;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;


@FunctionalInterface
public interface IFragmentInflate<T> {
    T inflate(LayoutInflater inflater, @Nullable ViewGroup container, Boolean attachToParent);
}
