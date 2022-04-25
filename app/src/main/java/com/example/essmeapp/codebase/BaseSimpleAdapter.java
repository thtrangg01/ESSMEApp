package com.example.essmeapp.codebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import java.util.ArrayList;

abstract public class BaseSimpleAdapter<T, VB extends ViewBinding, VH extends BaseSimpleAdapter.ViewHolder<VB>>
        extends RecyclerView.Adapter<VH> {

    protected IFragmentInflate<VB> inflate;
    protected ArrayList<T> data = new ArrayList<>();
    protected IOnItemClickListener onItemClickListener;

    public BaseSimpleAdapter(IFragmentInflate<VB> inflate) {
        this.inflate = inflate;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        VB binding = inflate.inflate(inflater, parent, false);
        return getViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bindViews(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public T getItem(int position) {
        return data.get(position);
    }

    public void submitList(ArrayList<T> items) {
        data = items;
        notifyDataSetChanged();
    }

    public abstract VH getViewHolder(VB binding);

    public void registerOnItemClickListener(ViewHolder<VB> holder) {
        View view = holder.itemView;
        view.setOnClickListener(view1 -> {
            int position = holder.getBindingAdapterPosition();
            onItemClickListener.onItemClicked(position);
        });
    }

    public void setOnItemClickListener(IOnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    protected abstract static class ViewHolder<VB extends ViewBinding> extends RecyclerView.ViewHolder {
        protected VB binding;

        public ViewHolder(@NonNull VB binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public Context getContext() {
            return binding.getRoot().getContext();
        }

        protected abstract void bindViews(int position);
    }
}
