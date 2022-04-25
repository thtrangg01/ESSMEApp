package com.example.essmeapp.ui;

import android.view.View;

import com.example.essmeapp.MainActivity;
import com.example.essmeapp.R;
import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.ActivityLoginBinding;

public class LoginFragment extends BaseViewBindingFragment<ActivityLoginBinding> {
    public LoginFragment() {
        super(ActivityLoginBinding::inflate);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignIn:
                ((MainActivity)getActivity()).signIn();
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
        binding.btnSignIn.setOnClickListener(this);
    }

    @Override
    public void initializeData() {

    }
}