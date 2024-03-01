package com.example.androidfinalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BudgetDatabase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "budgetdatabase";
    public static final String TABLE_BUDGET = "budget";
    public static final String COLUMN_ID = "id";

    public BudgetDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void deleteBudgetExpense (int budgetExpense) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BUDGET, COLUMN_ID + "=?",
                new String[]{String.valueOf(budgetExpense)});
        db.close();
    }
}
