package com.example.androidfinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.androidfinalproject.ui.Pojo.Budget;

import java.util.ArrayList;

public class BudgetDatabase extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "budgetdatabase";
    public static final String TABLE_BUDGET = "budgetexpense";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CURRENCY = "currency";


    public static final String CREATE_TABLE_BUDGET_EXPENSE = "CREATE TABLE " +
            TABLE_BUDGET + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_CURRENCY + " TEXT, ";
            //todo: create table here

    public BudgetDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO: Execute table here
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addComponent(Budget budgetExpense) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //TODO: add code here to match the contructor
        values.put(COLUMN_CURRENCY, budgetExpense.getCurrency());
        db.insert(TABLE_BUDGET, null, values);
        db.close();
        Log.d("SQL", "Component added");

    }

    public Budget budget(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Budget budget = null;
        Cursor cursor = db.query(TABLE_BUDGET, new String[]{ COLUMN_ID, COLUMN_CURRENCY},COLUMN_ID + "= ?",
                new String[]{String.valueOf(id)}, null, null, null);
        if(cursor.moveToFirst()) {
            budget = new
                    Budget(cursor.getInt(0),
                           cursor.getDouble(1),
                           cursor.getString(2));
                           //TODO: add more code here to match the constructor
        }
        db.close();
        return budget;
    }

    public ArrayList<Budget> getAllBudgetExpense() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Budget> budgetExpense = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_BUDGET, null);
        while(cursor.moveToNext()){
            budgetExpense.add(new
                    Budget(cursor.getInt(0),
                           cursor.getDouble(1),
                           cursor.getString(2)));
                           //TODO: add more code here to match the constructor
        }
        db.close();
        return budgetExpense;
    }

    public void updateComponent(Budget budgetExpense) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        //TODO: add code here to match the contructor
        values.put(COLUMN_CURRENCY, budgetExpense.getCurrency());
        db.update(TABLE_BUDGET, values, COLUMN_ID + "=?",
                new String[]{String.valueOf(budgetExpense.getId())});
    }

    public void deleteBudgetExpense (int budgetExpense) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BUDGET, COLUMN_ID + "=?",
                new String[]{String.valueOf(budgetExpense)});
        db.close();
    }
}
