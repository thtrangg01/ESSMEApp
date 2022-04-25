package com.example.essmeapp.ui.orderhistory;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;

import com.example.essmeapp.R;
import com.example.essmeapp.SharedPrefUtils;
import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.FragmentOrderExpertBinding;
import com.example.essmeapp.model.Fields;
import com.example.essmeapp.model.Request;
import com.example.essmeapp.service.ApiClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentOrderExpert extends BaseViewBindingFragment<FragmentOrderExpertBinding> {
    private final ArrayList<String> topics = new ArrayList();
    private AlertDialog.Builder builder;

    public FragmentOrderExpert() {
        super(FragmentOrderExpertBinding::inflate);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApiClient.getAPI().getFields().clone().enqueue(new Callback<List<Fields>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<List<Fields>> call, Response<List<Fields>> response) {
                List<Fields> fields = response.body();
                if (!topics.isEmpty()) {
                    topics.clear();
                }
                if (fields != null) {
                    fields.forEach(field -> {
                        if (field.getId() != null) {
                            topics.add(field.getId());
                        }
                    });

                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireContext(),
                            android.R.layout.simple_list_item_1,
                            topics);
                    binding.txtField.setAdapter(arrayAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Fields>> call, Throwable t) {

            }
        });
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

    }

    private void orderExpert() {
        ArrayList<String> topic = new ArrayList<>();
        String content = binding.edtContent.getText().toString();
        topic.add(binding.txtField.getText().toString());
        Request request = new Request();
        request.setContent(content);
        request.setTopic(topic);
        request.setCustomerId(SharedPrefUtils.getId(requireActivity()));
        Gson gson = new Gson();
//        GsonBuilder gson = new GsonBuilder();
//
//        JsonDeserializer<Request> deserializer = new JsonDeserializer<Request>() {
//            @Override
//            public Request deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                return null;
//            }
//        };


        String authToken = SharedPrefUtils.getAuthToken(requireActivity());
        String json = gson.toJson(request);
        ApiClient.getAPI().orderExpert(json, "Bearer " + authToken).enqueue(new Callback<Request>() {
            @Override
            public void onResponse(Call<Request> call, Response<Request> response) {
                builder.setMessage(getString(R.string.ordert_expert_success))
                        .setCancelable(false)
                        .setPositiveButton(R.string.common_ok, (dialog, id) -> {
                            binding.edtContent.setText("");
                            binding.txtField.setText("");
                        })
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
            public void onFailure(Call<Request> call, Throwable t) {

            }
        });
    }
}
