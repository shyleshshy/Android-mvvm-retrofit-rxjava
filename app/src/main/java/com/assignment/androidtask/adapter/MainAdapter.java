package com.assignment.androidtask.adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.assignment.androidtask.databinding.ItemMainPageBinding;
import com.assignment.androidtask.model.ItemMainModel;
import com.assignment.androidtask.model.api.ResponseDummy;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<ResponseDummy> mList;

    public MainAdapter(List<ResponseDummy> mList) {
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
    }

    public void addItems(List<ResponseDummy> aList) {
        mList.addAll(aList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ItemMainPageBinding mBinding;

        private ItemMainModel mBlogItemViewModel;

        public ViewHolder(ItemMainPageBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void onBind(int position) {
            final ResponseDummy blog = mList.get(position);
            mBlogItemViewModel = new ItemMainModel(blog);
            mBinding.setViewModel(mBlogItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }

        public void onItemClick(String blogUrl) {
            if (blogUrl != null) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(blogUrl));
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
