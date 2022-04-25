package com.example.essmeapp.ui.listexpert;

import android.os.Bundle;
import android.view.View;

import androidx.navigation.Navigation;

import com.example.essmeapp.R;
import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.FragmentExpertBinding;
import com.example.essmeapp.model.Expert;
import com.example.essmeapp.model.ExpertResponse;
import com.example.essmeapp.service.ApiClient;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpertFragment extends BaseViewBindingFragment<FragmentExpertBinding> {
    ExpertAdapter adapter;

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
        adapter = new ExpertAdapter();
        binding.lstExpert.setAdapter(adapter);
    }

    @Override
    public void initializeEvents() {
        adapter.setOnItemClickListener(position -> {
            Expert expert = adapter.getItem(position);
            Bundle bundle = new Bundle();
            bundle.putString("expert_detail", new Gson().toJson(expert));
            Navigation.findNavController(requireView()).navigate(R.id.action_expertFragment_to_expertDetailFragment, bundle);
        });
    }

    @Override
    public void initializeData() {
        ApiClient.getAPI().getExperts().clone().enqueue(new Callback<ExpertResponse>() {
            @Override
            public void onResponse(Call<ExpertResponse> call, Response<ExpertResponse> response) {
                if (response.body() == null) return;
                List<Expert> experts = response.body().getContent();
                adapter.submitList((ArrayList<Expert>) experts);
            }

            @Override
            public void onFailure(Call<ExpertResponse> call, Throwable t) {

            }
        });

    }
}
