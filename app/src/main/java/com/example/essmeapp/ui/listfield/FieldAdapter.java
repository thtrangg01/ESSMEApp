package com.example.essmeapp.ui.listfield;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.example.essmeapp.codebase.BaseSimpleAdapter;
import com.example.essmeapp.databinding.ItemFieldBinding;
import com.example.essmeapp.model.Fields;

public class FieldAdapter extends BaseSimpleAdapter<Fields, ItemFieldBinding, FieldAdapter.FieldViewHolder> {
    public FieldAdapter() {super(ItemFieldBinding::inflate);}

    @Override
    public FieldViewHolder getViewHolder(ItemFieldBinding binding) {
        return null;
    }

    public class FieldViewHolder extends BaseSimpleAdapter.ViewHolder<ItemFieldBinding> {


        public FieldViewHolder(@NonNull ItemFieldBinding binding) {
            super(binding);
        }

        @Override
        protected void bindViews(int position) {
            Fields fields = getItem(position);
//            binding.txtField.setText(fields.getImageUrl());
            binding.txtField.setText(fields.getName());
        }
    }
}
