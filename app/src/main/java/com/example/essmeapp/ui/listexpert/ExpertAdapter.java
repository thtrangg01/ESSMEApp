package com.example.essmeapp.ui.listexpert;

import androidx.annotation.NonNull;

import com.example.essmeapp.codebase.BaseSimpleAdapter;
import com.example.essmeapp.databinding.ItemExpertBinding;
import com.example.essmeapp.model.Expert;

public class ExpertAdapter extends BaseSimpleAdapter<Expert, ItemExpertBinding, ExpertAdapter.ExpertViewHolder> {

    public ExpertAdapter() {
        super(ItemExpertBinding::inflate);
    }

    @Override
    public ExpertViewHolder getViewHolder(ItemExpertBinding binding) {
        return new ExpertViewHolder(binding);
    }

    public class ExpertViewHolder extends BaseSimpleAdapter.ViewHolder<ItemExpertBinding>{

        public ExpertViewHolder(@NonNull ItemExpertBinding binding) {
            super(binding);
        }

        @Override
        protected void bindViews(int position) {
            Expert expert = getItem(position);
            binding.txtName.setText(expert.getName());
            binding.txtDegree.setText(expert.getDegree());
            binding.txtCompany.setText(expert.getCompany());
        }
    }
}