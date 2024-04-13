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

//    // Currency converter table
//    public static final String TABLE_BUDGET = "budgetexpense";
//    public static final String COLUMN_PRICE = "price";
//    public static final String COLUMN_CURRENCY_FROM = "fromcurrency";
//    public static final String COLUMN_CURRENCY_TO = "tocurrency";
    // Common
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";

    // Categories table
    public static final String TABLE_CATEGORIES = "categories";
    public static final String COLUMN_CAT_NAME = "category";
        // Create Categories table
    private static final String CREATE_TABLE_CATEGORIES = "CREATE TABLE " + TABLE_CATEGORIES +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CAT_NAME + " TEXT NOT NULL" +
                ")";

    // Transactions table
    public static final String TABLE_TRANSACTIONS = "transactions";
    public static final String COLUMN_TRANS_DATE = "trans_date";
    public static final String COLUMN_ACCOUNT_NUM = "accountNum";
    public static final String COLUMN_AMOUNT = "amount";
    public static final String COLUMN_NOTES = "notes";
        // Create transactions table
    private static final String CREATE_TABLE_TRANSACTIONS = "CREATE TABLE " + TABLE_TRANSACTIONS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_DATE + " TEXT," +
                COLUMN_ACCOUNT_NUM + " TEXT," + // Reference to Account Number
                COLUMN_CAT_NAME + " TEXT," +
                COLUMN_AMOUNT + " REAL," +
                COLUMN_NOTES + " TEXT" +
                ")";


    // Account table
    public static final String TABLE_ACCOUNTS = "accounts";
        // Create accounts table
    public static final String CREATE_TABLE_ACCOUNTS = "CREATE TABLE " + TABLE_ACCOUNTS +
                "(" +
                COLUMN_ACCOUNT_NUM + " TEXT PRIMARY KEY" + // Account number is the primary key
                ")";


//    public static final String CREATE_TABLE_BUDGET_EXPENSE = "CREATE TABLE " +
//            TABLE_BUDGET + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//            COLUMN_PRICE + " DOUBLE, " + COLUMN_CURRENCY_FROM + " TEXT, " +
//            COLUMN_CURRENCY_TO + " TEXT, " + COLUMN_DATE + " TEXT)";
//            //todo: create more columns for table here

    public BudgetDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the required tables
        Log.d("BudgetDatabase", "onCreate method called"); // Add this line

        db.execSQL(CREATE_TABLE_CATEGORIES);
        db.execSQL(CREATE_TABLE_TRANSACTIONS);
        db.execSQL(CREATE_TABLE_ACCOUNTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if exists
    }

    public void addBudgetExpense(Budget budgetExpense) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //TODO: add code here to match the contructor
//        values.put(COLUMN_PRICE, budgetExpense.getPrice());
//        values.put(COLUMN_CURRENCY_FROM, budgetExpense.getFromCurrency());
//        values.put(COLUMN_CURRENCY_TO, budgetExpense.getToCurrency());
//        db.insert(TABLE_BUDGET, null, values);

        values.put("date", budgetExpense.getDate());
        values.put("accountNum", budgetExpense.getAccountNum());
        values.put("category", budgetExpense.getCategory());
        values.put("amount", budgetExpense.getAmount());
        values.put("notes", budgetExpense.getNotes());
        db.insert(TABLE_TRANSACTIONS, null, values);

        //db.close();
        Log.d("SQL", "Component added");

    }

    public Budget getBudget(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Budget budget = null;
        Cursor cursor = db.query(TABLE_TRANSACTIONS, new String[]{COLUMN_ID, COLUMN_DATE, COLUMN_ACCOUNT_NUM, COLUMN_CAT_NAME,
                        COLUMN_AMOUNT, COLUMN_NOTES},COLUMN_ID + "= ?",
                new String[]{String.valueOf(id)}, null, null, null);
        if(cursor.moveToFirst()) {
            budget = new
                    Budget(cursor.getInt(0),
                           cursor.getString(1),
                           cursor.getString(2),
                           cursor.getString(3),
                           cursor.getDouble(4),
                           cursor.getString(5));
                           //TODO: add more code here to match the constructor
        }
       // db.close();
        return budget;
    }

    public ArrayList<Budget> getAllBudgetExpense() {
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<Budget> budgetExpense = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_TRANSACTIONS, null);
        while(cursor.moveToNext()){
            budgetExpense.add(new
                    Budget(cursor.getInt(0),
                           cursor.getString(1),
                           cursor.getString(2),
                           cursor.getString(3),
                           cursor.getDouble(4),
                           cursor.getString(5)));
                           //TODO: add more code here to match the constructor
        }
       // db.close();
        return budgetExpense;
    }

    public void updateBudgetExpense(Budget budgetExpense) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        //TODO: add code here to match the contructor
        values.put(COLUMN_DATE, budgetExpense.getDate());
        values.put(COLUMN_ACCOUNT_NUM, budgetExpense.getAccountNum());
        values.put(COLUMN_CAT_NAME, budgetExpense.getCategory());
        values.put(COLUMN_AMOUNT, budgetExpense.getAmount());
        values.put(COLUMN_NOTES, budgetExpense.getNotes());
        db.update(TABLE_TRANSACTIONS, values, COLUMN_ID + "=?",
                new String[]{String.valueOf(budgetExpense.getId())});
    }

    public void deleteBudgetExpense (int budgetExpense) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TRANSACTIONS, COLUMN_ID + "=?",
                new String[]{String.valueOf(budgetExpense)});
        //db.close();
    }
}
