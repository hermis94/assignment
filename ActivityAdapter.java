
package com.example.communityvolunteertracker.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.communityvolunteertracker.R;
import com.example.communityvolunteertracker.data.VolunteerActivity;

import java.util.List;

public class ActivityAdapter extends RecyclerView.Adapter<ActivityAdapter.VH> {

    public interface OnItemInteractionListener {
        void onItemClicked(VolunteerActivity activity);
        void onItemLongPressed(VolunteerActivity activity);
    }

    private List<VolunteerActivity> items;
    private Context ctx;
    private OnItemInteractionListener listener;

    public ActivityAdapter(Context ctx, List<VolunteerActivity> items, OnItemInteractionListener listener) {
        this.ctx = ctx;
        this.items = items;
        this.listener = listener;
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        VolunteerActivity item = items.get(position);
        holder.tvTitle.setText(item.title);
        holder.tvDateHours.setText(item.date + " • " + item.hours + " hrs");
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) listener.onItemClicked(item);
        });
        holder.itemView.setOnLongClickListener(v -> {
            if (listener != null) listener.onItemLongPressed(item);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void update(List<VolunteerActivity> newItems) {
        this.items = newItems;
        notifyDataSetChanged();
    }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDateHours;
        VH(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvDateHours = v.findViewById(R.id.tvDateHours);
        }
    }
}
