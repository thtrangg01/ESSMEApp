package com.example.essmeapp.ui.orderhistory;

import androidx.annotation.NonNull;

import com.example.essmeapp.codebase.BaseSimpleAdapter;
import com.example.essmeapp.databinding.ItemHistoryBinding;
import com.example.essmeapp.model.Request;

public class OrderHistoryAdapter extends BaseSimpleAdapter<Request, ItemHistoryBinding, OrderHistoryAdapter.ViewHolder> {

    public OrderHistoryAdapter() {
        super(ItemHistoryBinding::inflate);
    }

    @Override
    public ViewHolder getViewHolder(ItemHistoryBinding binding) {
        return new ViewHolder(binding);
    }

    public class ViewHolder extends BaseSimpleAdapter.ViewHolder<ItemHistoryBinding> {

        public ViewHolder(@NonNull ItemHistoryBinding binding) {
            super(binding);
        }

        @Override
        protected void bindViews(int position) {
            Request request = getItem(position);
            binding.txtTitle.setText(request.getTitle());
            binding.txtExpert.setText("Expert's name");
        }
    }
}
