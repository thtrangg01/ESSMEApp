package com.example.essmeapp.ui.hpfields;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.FragmentTopFieldBinding;
import com.example.essmeapp.model.ResearchArea;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class TopFieldsFragment extends BaseViewBindingFragment<FragmentTopFieldBinding> {

    private FieldAdapter adapter;
    private List<ResearchArea> fields;

    public TopFieldsFragment() {
        super(FragmentTopFieldBinding::inflate);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void initializeComponents() {
        adapter = new FieldAdapter(requireContext());
        GridLayoutManager layoutManager = new GridLayoutManager(requireContext(), 2);
        binding.lstField.setLayoutManager(layoutManager);
        binding.lstField.setAdapter(adapter);
    }

    @Override
    public void initializeEvents() {

    }

    @Override
    public void initializeData() {
        Bundle bundle = getArguments();
        String json = bundle.getString("list_fields");
        fields = new Gson().fromJson(json, new TypeToken<List<ResearchArea>>() {
        }.getType());
        adapter.submitList(fields);
    }
}
