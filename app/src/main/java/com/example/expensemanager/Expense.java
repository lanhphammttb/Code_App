package com.example.expensemanager;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Expense {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String title;
    public double amount;
    public long date;
}
