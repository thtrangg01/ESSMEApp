package com.example.essmeapp.ui.hptopexpert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.codebase.IFragmentInflate;
import com.example.essmeapp.databinding.FragmentExpertBinding;
import com.example.essmeapp.model.Expert;


public class ExpertFragment extends BaseViewBindingFragment<FragmentExpertBinding> {

    public ExpertFragment() {
        super(FragmentExpertBinding::inflate);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void initializeComponents() {

    }

    @Override
    public void initializeEvents() {

    }

    @Override
    public void initializeData() {
        Bundle bundle = getArguments();
        Expert expert = (Expert) bundle.get("expert");

        binding.txtName.setText(expert.getName());
        binding.txtDegree.setText(expert.getDegree());
        binding.txtCompany.setText(expert.getCompany());
    }
}
