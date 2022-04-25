package com.example.essmeapp.ui.fqas;

import androidx.annotation.NonNull;

import com.example.essmeapp.R;
import com.example.essmeapp.codebase.BaseSimpleAdapter;
import com.example.essmeapp.databinding.ItemAnswerBinding;
import com.example.essmeapp.model.Answer;

public class AnswerAdapter extends BaseSimpleAdapter<Answer, ItemAnswerBinding, AnswerAdapter.ViewHolder> {

    public AnswerAdapter() {
        super(ItemAnswerBinding::inflate);
    }

    @Override
    public ViewHolder getViewHolder(ItemAnswerBinding binding) {
        return new ViewHolder(binding);
    }

    public class ViewHolder extends BaseSimpleAdapter.ViewHolder<ItemAnswerBinding> {

        public ViewHolder(@NonNull ItemAnswerBinding binding) {
            super(binding);
        }

        @Override
        protected void bindViews(int position) {
            binding.getRoot().setBackgroundResource(R.drawable.bg_rounded_8dp_no_ripple_white);
            Answer answer = getItem(position);
            if (answer != null) {
                binding.txtAnswer.setText(answer.getAnswer());
            }
        }
    }
}
