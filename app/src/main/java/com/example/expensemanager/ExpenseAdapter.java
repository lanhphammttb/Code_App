package com.example.expensemanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ViewHolder> {
    private final List<Expense> data;

    public ExpenseAdapter(List<Expense> data) {
        this.data = data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, amount;

        public ViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.txtTitle);
            amount = view.findViewById(R.id.txtAmount);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expense, parent, false);
        return new ViewHolder(v);
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Expense expense = data.get(position);
        holder.title.setText(expense.title);
        holder.amount.setText(String.valueOf(expense.amount));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
