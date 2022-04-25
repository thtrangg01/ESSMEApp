package com.example.essmeapp;

import android.view.View;

import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.FragmentAccountBinding;

public class AccountFragment extends BaseViewBindingFragment<FragmentAccountBinding> {
    public AccountFragment() {
        super(FragmentAccountBinding::inflate);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignOut:
                ((MainActivity) getActivity()).signOut();
                break;
        }
    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void initializeComponents() {

    }

    @Override
    public void initializeEvents() {
        binding.btnSignOut.setOnClickListener(this);
    }

    @Override
    public void initializeData() {

    }
}