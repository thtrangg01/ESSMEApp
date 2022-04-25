package com.example.essmeapp.ui.hpfields;

import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.FragmentFieldBinding;
import com.example.essmeapp.model.Fields;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class FieldsFragment extends BaseViewBindingFragment<FragmentFieldBinding> {
    private FieldAdapter adapter;
    private ArrayList<Fields> fields;

    public FieldsFragment() {
        super(FragmentFieldBinding::inflate);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void initializeComponents() {
        adapter = new FieldAdapter();
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
        fields = new Gson().fromJson(json, new TypeToken<List<Fields>>() {
        }.getType());
        adapter.submitList(fields);
    }
}
