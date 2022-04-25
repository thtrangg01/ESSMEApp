package com.example.essmeapp;

import android.view.View;

import androidx.navigation.Navigation;

import com.example.essmeapp.codebase.BaseViewBindingFragment;
import com.example.essmeapp.databinding.FragmentOrderHistoryBinding;
import com.example.essmeapp.model.Request;
import com.example.essmeapp.ui.orderhistory.OrderHistoryAdapter;

import java.util.ArrayList;

public class FragmentOrderHistory extends BaseViewBindingFragment<FragmentOrderHistoryBinding> {
    private OrderHistoryAdapter adapter;
    private final ArrayList<Request> requests = new ArrayList<>();

    public FragmentOrderHistory() {
        super(FragmentOrderHistoryBinding::inflate);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void initializeViews() {

    }

    @Override
    public void initializeComponents() {
        adapter = new OrderHistoryAdapter();
        binding.lstHistory.setAdapter(adapter);
    }

    @Override
    public void initializeEvents() {
        binding.btnSend.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_fragmentOrderHistory_to_fragmentOrderExpert);
        });
    }

    @Override
    public void initializeData() {
        requests.add(new Request("Demo title 1"));
        requests.add(new Request("Demo title 2"));
        requests.add(new Request("Demo title 3"));
        requests.add(new Request("Demo title 4"));
        requests.add(new Request("Demo title 5"));
        requests.add(new Request("Demo title 6"));
        requests.add(new Request("Demo title 7"));
        adapter.submitList(requests);
    }
}
