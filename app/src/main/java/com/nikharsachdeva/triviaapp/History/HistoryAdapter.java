package com.nikharsachdeva.triviaapp.History;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nikharsachdeva.triviaapp.R;

import java.util.List;

//Adapter for implementing recycler view.

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    private List<AnswersModel> answersModelList;
    private Context context;


    public HistoryAdapter(List<AnswersModel> answersModelList, Context context) {
        this.answersModelList = answersModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.user_game_number.setText("Game Number #"+answersModelList.get(position).getGameNumber());
        holder.user_game_date.setText(answersModelList.get(position).getDateTime());
        holder.user_name.setText(answersModelList.get(position).getName());
        holder.user_cricketer.setText(answersModelList.get(position).getCricketer());
        holder.user_colors.setText(answersModelList.get(position).getColors());


    }

    @Override
    public int getItemCount() {
        return answersModelList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView user_game_number, user_game_date, user_name, user_cricketer, user_colors;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            user_game_number = itemView.findViewById(R.id.user_game_number);
            user_game_date = itemView.findViewById(R.id.user_game_date);
            user_name = itemView.findViewById(R.id.user_name);
            user_cricketer = itemView.findViewById(R.id.user_cricketer);
            user_colors = itemView.findViewById(R.id.user_colors);


        }
    }
}
