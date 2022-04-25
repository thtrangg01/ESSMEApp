package com.example.essmeapp;

import android.view.View;

import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.FragmentPersonalInformationBinding;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class PersonalInformationFragment extends BaseViewBindingFragment<FragmentPersonalInformationBinding> {
    ArrayList<String> names = new ArrayList<>();
    PersonalInformationAdapter adapter;

    public PersonalInformationFragment() {
        super(FragmentPersonalInformationBinding::inflate);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void initializeComponents() {
        adapter = new PersonalInformationAdapter(this);
        binding.vpgInfo.setAdapter(adapter);
        names.add("Experts");
        names.add("Customer");

        new TabLayoutMediator(binding.tabLayout, binding.vpgInfo, ((tab, position) -> {
            tab.setText(names.get(position));
        })).attach();

    }

    @Override
    public void initializeEvents() {

    }

    @Override
    public void initializeData() {

    }
}
