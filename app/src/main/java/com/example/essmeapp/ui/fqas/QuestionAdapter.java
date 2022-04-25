package com.example.essmeapp.ui.fqas;

import androidx.annotation.NonNull;

import com.example.essmeapp.R;
import com.example.essmeapp.codebase.BaseSimpleAdapter;
import com.example.essmeapp.databinding.ItemFunctionalQuestionAnswersBinding;
import com.example.essmeapp.model.Question;

public class QuestionAdapter extends BaseSimpleAdapter<Question, ItemFunctionalQuestionAnswersBinding, QuestionAdapter.ViewHolder> {
    private AnswerAdapter answerAdapter;

    public QuestionAdapter() {
        super(ItemFunctionalQuestionAnswersBinding::inflate);
    }

    @Override
    public ViewHolder getViewHolder(ItemFunctionalQuestionAnswersBinding binding) {
        return new ViewHolder(binding);
    }

    public class ViewHolder extends BaseSimpleAdapter.ViewHolder<ItemFunctionalQuestionAnswersBinding> {

        public ViewHolder(@NonNull ItemFunctionalQuestionAnswersBinding binding) {
            super(binding);
        }

        @Override
        protected void bindViews(int position) {
            binding.getRoot().setBackgroundResource(R.drawable.bg_rounded_8dp_no_ripple);
            binding.getRoot().setElevation(4f);
            Question question = getItem(position);
            if (question != null) {
                binding.txtQuestion.setText(question.getTitle());
                answerAdapter = new AnswerAdapter();
                answerAdapter.submitList(question.getAnswers());
                binding.lstAnswer.setAdapter(answerAdapter);
            }
        }
    }
}
