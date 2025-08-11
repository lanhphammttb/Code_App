package com.example.expensemanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ExpenseDao {
    @Query("SELECT * FROM Expense ORDER BY date DESC")
    List<Expense> getAll();

    @Insert
    void insert(Expense expense);

    @Delete
    void delete(Expense expense);
}
