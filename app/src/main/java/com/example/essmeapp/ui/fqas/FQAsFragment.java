package com.example.essmeapp.ui.fqas;

import android.view.View;

import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.FragmentFqasBinding;
import com.example.essmeapp.model.Question;
import com.example.essmeapp.service.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FQAsFragment extends BaseViewBindingFragment<FragmentFqasBinding> {
    private QuestionAdapter adapter;

    public FQAsFragment() {
        super(FragmentFqasBinding::inflate);
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public void initializeViews() {
    }

    @Override
    public void initializeComponents() {
        adapter = new QuestionAdapter();
        binding.lstQuestion.setAdapter(adapter);
    }

    @Override
    public void initializeEvents() {
    }

    @Override
    public void initializeData() {
        ApiClient.getAPI().getQuestions().clone().enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {
                List<Question> questions = response.body();
                if (questions == null) return;
                adapter.submitList((ArrayList<Question>) questions);
            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {

            }
        });
    }
}