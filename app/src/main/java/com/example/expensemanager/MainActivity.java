package com.example.expensemanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ExpenseDatabase db;
    private ExpenseAdapter adapter;
    private final List<Expense> expenses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(), ExpenseDatabase.class, "expense-db").allowMainThreadQueries().build();

        RecyclerView rv = findViewById(R.id.rvExpenses);
        adapter = new ExpenseAdapter(expenses);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        loadExpenses();

        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(v -> startActivity(new Intent(this, AddExpenseActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadExpenses();
    }

    private void loadExpenses() {
        expenses.clear();
        expenses.addAll(db.expenseDao().getAll());
        adapter.notifyDataSetChanged();
    }
}
