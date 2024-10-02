package com.careeh.user.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.careeh.user.R;

import java.util.List;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.ViewHolder> {

    private final List<String> promotionTexts;

    public PromotionAdapter(List<String> promotionTexts) {
        this.promotionTexts = promotionTexts;
    }

    @NonNull
    @Override
    public PromotionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.promotion_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionAdapter.ViewHolder holder, int position) {
        String promotionText = promotionTexts.get(position);
        holder.bind(promotionText);
    }

    @Override
    public int getItemCount() {
        return promotionTexts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvPromotionText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPromotionText = itemView.findViewById(R.id.tv_promotion_text);
        }

        public void bind(String promotionText) {
            tvPromotionText.setText(promotionText);
        }
    }
}
