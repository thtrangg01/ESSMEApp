package com.example.essmeapp.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.essmeapp.R;
import com.example.essmeapp.SharedPrefUtils;
import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.FragmentExpertDetailBinding;
import com.example.essmeapp.model.DirectRequest;
import com.example.essmeapp.model.Expert;
import com.example.essmeapp.service.ApiClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpertDetailFragment extends BaseViewBindingFragment<FragmentExpertDetailBinding> {
    private Expert expert;
    private AlertDialog.Builder builder;

    public ExpertDetailFragment() {
        super(FragmentExpertDetailBinding::inflate);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = requireArguments();
        expert = new Gson().fromJson(bundle.getString("expert_detail"), Expert.class);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSend:
                orderExpert();
                break;
        }
    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void initializeComponents() {
        builder = new AlertDialog.Builder(requireContext());

    }

    @Override
    public void initializeEvents() {
        binding.btnSend.setOnClickListener(this);
    }

    @Override
    public void initializeData() {
        binding.txtName.setText(expert.getName());
        binding.txtDegree.setText(expert.getDegree());
        binding.txtCompany.setText(expert.getCompany());
    }

    private void orderExpert() {
        String content = binding.edtContent.getText().toString();
        DirectRequest directRequest = new DirectRequest();
        directRequest.setContent(content);
        directRequest.setExpertId(expert.getId());
        Gson gson = new Gson();

        String authToken = SharedPrefUtils.getAuthToken(requireActivity());
        ApiClient.getAPI().orderExpertDirect(gson.toJson(directRequest), "Bearer " + authToken).enqueue(new Callback<DirectRequest>() {
            @Override
            public void onResponse(Call<DirectRequest> call, Response<DirectRequest> response) {
                builder.setMessage(getString(R.string.ordert_expert_success))
                        .setCancelable(false)
                        .setPositiveButton(R.string.common_ok, (dialog, id) -> binding.edtContent.setText(""))
                        .setNegativeButton("No", (dialog, id) -> {
                            dialog.cancel();
                        });

                AlertDialog alert = builder.create();
                alert.setTitle("");
                alert.show();
                alert.getButton(AlertDialog.BUTTON_NEGATIVE).setVisibility(View.GONE);
                Log.d(this.getClass().getSimpleName(), "Order Expert Success....");
            }

            @Override
            public void onFailure(Call<DirectRequest> call, Throwable t) {

            }
        });
    }
}
