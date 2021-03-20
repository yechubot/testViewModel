package com.example.testviewmodel.adapter;

import android.content.Context;
import android.graphics.Color;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testviewmodel.R;
import com.example.testviewmodel.model.UserData;
import com.example.testviewmodel.viemodel.MainViewModel;

import java.util.ArrayList;

import timber.log.Timber;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    Context context;
    ArrayList<UserData> userDataList;

    public UserAdapter(Context context, ArrayList<UserData> userDataList) {
        this.context = context;
        this.userDataList = userDataList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView id, name;
        Button btn_follow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.instaId);
            name = itemView.findViewById(R.id.name);
            btn_follow = itemView.findViewById(R.id.btn_follow);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.user_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int pos) {
        UserData userData = userDataList.get(pos);
        holder.id.setText(userData.getId());
        holder.name.setText(userData.getName());

        MainViewModel mainViewModel  = new MainViewModel();

        holder.btn_follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.btn_follow.getText().equals("FOLLOWING")) {
                    mainViewModel.decrease();
                    holder.btn_follow.setText(R.string.bFollow);
                    holder.btn_follow.isEnabled();
                } else { //text = FOLLOW
                    mainViewModel.increase();
                    holder.btn_follow.setText(R.string.bFollowing);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }

}
