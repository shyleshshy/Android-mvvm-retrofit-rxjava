package com.assignment.androidtask.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.assignment.androidtask.databinding.ItemMainPageBinding;
import com.assignment.androidtask.model.ItemMainModel;
import com.assignment.androidtask.model.api.ItemsBean;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<ItemsBean> mList;

    public MainAdapter(List<ItemsBean> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMainPageBinding blogViewBinding = ItemMainPageBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new ViewHolder(blogViewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void clearItems() {
        mList.clear();
        notifyDataSetChanged();
    }

    public void addItems(List<ItemsBean> aList) {
        int aInitSize = mList.size();
        mList.addAll(aList);
        notifyItemRangeInserted(aInitSize, mList.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemMainPageBinding mBinding;

        private ItemMainModel mBlogItemViewModel;

        public ViewHolder(ItemMainPageBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void onBind(int position) {
            final ItemsBean blog = mList.get(position);
            mBlogItemViewModel = new ItemMainModel(blog);
            mBinding.setViewModel(mBlogItemViewModel);

            mBinding.executePendingBindings();
        }
    }
}
