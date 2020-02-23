package com.midooabdaim.room.adpter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midooabdaim.room.R;
import com.midooabdaim.room.data.local.item;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class usersAdapter extends RecyclerView.Adapter<usersAdapter.ViewHolder> {

    private Context context;
    private Activity activity;
    private List<item> itemList = new ArrayList<>();

    public usersAdapter(Context context, List<item> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        try {
            holder.itemUserName.setText(itemList.get(position).getName());
            holder.itemUserPass.setText(itemList.get(position).getPass());
            holder.itemUserAge.setText(String.valueOf(itemList.get(position).getAge()));
        } catch (Exception e) {

        }
    }

    private void setAction(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_user_name)
        TextView itemUserName;
        @BindView(R.id.item_user_pass)
        TextView itemUserPass;
        @BindView(R.id.item_user_age)
        TextView itemUserAge;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
