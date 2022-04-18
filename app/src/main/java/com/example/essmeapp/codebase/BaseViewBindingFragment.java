package com.example.essmeapp.codebase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;


abstract public class BaseViewBindingFragment<VB extends ViewBinding> extends BaseCoreFragment {
    protected VB binding;
    protected IFragmentInflate<VB> inflate;

    public BaseViewBindingFragment(IFragmentInflate<VB> inflate) {
        this.inflate = inflate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = inflate.inflate(inflater, container, false);
        return binding.getRoot();
    }
}
