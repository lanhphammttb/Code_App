package com.example.expensemanager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class AddExpenseActivity extends AppCompatActivity {
    private ExpenseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        db = Room.databaseBuilder(getApplicationContext(), ExpenseDatabase.class, "expense-db").allowMainThreadQueries().build();

        EditText edtTitle = findViewById(R.id.edtTitle);
        EditText edtAmount = findViewById(R.id.edtAmount);
        Button btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v -> {
            String title = edtTitle.getText().toString();
            double amount = Double.parseDouble(edtAmount.getText().toString());

            Expense expense = new Expense();
            expense.title = title;
            expense.amount = amount;
            expense.date = System.currentTimeMillis();

            db.expenseDao().insert(expense);
            finish();
        });
    }
}
