package com.example.essmeapp;

import android.util.Log;
import android.view.View;

import androidx.navigation.Navigation;

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
            case R.id.btnOrderHistory:
                Navigation.findNavController(view).navigate(R.id.action_accountFragment_to_fragmentOrderExpert);
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
        binding.btnOrderHistory.setOnClickListener(this);
    }

    @Override
    public void initializeData() {
        Log.d(this.getClass().getSimpleName(), SharedPrefUtils.getAuthToken(requireActivity()));
    }
}