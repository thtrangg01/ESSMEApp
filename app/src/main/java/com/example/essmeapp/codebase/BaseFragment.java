package com.example.essmeapp.codebase;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;

abstract public class BaseFragment<VB extends ViewBinding, VM extends BaseViewModel> extends BaseCoreFragment {
    protected VB binding;
    protected VM viewModel;
    protected IFragmentInflate<VB> inflate;

    public BaseFragment(IFragmentInflate<VB> inflate) {
        this.inflate = inflate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        binding = inflate.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(getViewModel());
        return binding.getRoot();
    }

    protected abstract Class<VM> getViewModel();
}
