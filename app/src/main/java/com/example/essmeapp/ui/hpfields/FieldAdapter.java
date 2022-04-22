package com.example.essmeapp.ui.hpfields;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essmeapp.R;
import com.example.essmeapp.model.ResearchArea;

import java.util.List;

public class FieldAdapter extends RecyclerView.Adapter<FieldAdapter.FieldViewHolder> {
    private final Context context;
    private List<ResearchArea> fields;

    public FieldAdapter(Context context) {
        this.context = context;
    }

    public void submitList(List<ResearchArea> fields) {
        this.fields = fields;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FieldViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_field, parent, false);
        return new FieldViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FieldViewHolder holder, int position) {
        ResearchArea researchArea = getItem(position);
        if (fields == null) {
            return;
        }
        holder.txtField.setText(researchArea.getName_vn());
    }

    @Override
    public int getItemCount() {
        if (fields != null) {
            return fields.size();
        }
        return 0;
    }

    private ResearchArea getItem(int position) {
        return fields.get(position);
    }

    public static class FieldViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgField;
        private final TextView txtField;

        public FieldViewHolder(@NonNull View itemView) {
            super(itemView);

            imgField = itemView.findViewById(R.id.imvFields);
            txtField = itemView.findViewById(R.id.txtField);
        }
    }
}