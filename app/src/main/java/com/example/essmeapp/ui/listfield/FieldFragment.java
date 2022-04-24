package com.example.essmeapp.ui.listfield;

import android.view.View;

import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.codebase.IFragmentInflate;
import com.example.essmeapp.databinding.FragmentFieldBinding;
import com.example.essmeapp.model.Expert;
import com.example.essmeapp.model.Fields;
import com.example.essmeapp.service.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Field;

public class FieldFragment extends BaseViewBindingFragment<FragmentFieldBinding> {
    FieldAdapter adapter;
    public FieldFragment() {
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
        binding.lstField.setAdapter(adapter);

    }

    @Override
    public void initializeEvents() {

    }

    @Override
    public void initializeData() {
        ApiClient.getAPI().getFields().clone().enqueue(new Callback<List<Fields>>() {
            @Override
            public void onResponse(Call<List<Fields>> call, Response<List<Fields>> response) {
                List<Fields> fields = response.body();
            }

            @Override
            public void onFailure(Call<List<Fields>> call, Throwable t) {

            }
        });
    }
}
