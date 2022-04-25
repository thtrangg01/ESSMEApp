package com.example.essmeapp.ui.hptopexpert;

import android.os.Bundle;
import android.view.View;

import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.FragmentTopExpertBinding;
import com.example.essmeapp.model.Expert;

public class TopExpertFragment extends BaseViewBindingFragment<FragmentTopExpertBinding> {

    public TopExpertFragment() {
        super(FragmentTopExpertBinding::inflate);
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
