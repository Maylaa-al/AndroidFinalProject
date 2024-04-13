package com.example.androidfinalproject.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.androidfinalproject.AddToFragment;
import com.example.androidfinalproject.BudgetDatabase;
import com.example.androidfinalproject.R;
import com.example.androidfinalproject.api.CurrencySingleton;
import com.example.androidfinalproject.ui.Pojo.Budget;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private static CustomAdapter adapter;
    private Context context;

    private final ArrayList<Budget> budgets;

    public CustomAdapter(ArrayList<Budget> budgets, Context context) {
        this.budgets = budgets;
        this.context = context;
        adapter = this;
    }

    public void addItem(Budget newItem) {
        budgets.add(newItem);
        notifyItemInserted(budgets.size() - 1); // Notify adapter of inserted item
    }

    // Method to get the instance of the adapter
    public static CustomAdapter getInstance() {
        return adapter;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_add_to, parent, false);
        return new CustomViewHolder(view);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected EditText date;
        protected EditText accountNumber;
        protected Spinner categoriesSpinner;
        protected EditText amount;
        protected EditText notes;
        protected ImageView delete;
        protected Button edit;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.date = itemView.findViewById(R.id.editTextDate);
            this.accountNumber = itemView.findViewById(R.id.account_num);
            this.amount = itemView.findViewById(R.id.amount);
            this.notes = itemView.findViewById(R.id.notes);
            this.categoriesSpinner = itemView.findViewById(R.id.spinner);
           // this.delete = itemView.findViewById(R.id.delete_btn);
            this.edit = itemView.findViewById(R.id.save);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }

    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        //TODO: add code here for the recyclerView layout
        Budget budget = budgets.get(position);

        holder.date.setText(budget.getDate());
        holder.accountNumber.setText(budget.getAccountNum());
        holder.amount.setText(String.valueOf((int) budget.getAmount()));
        holder.notes.setText(budget.getNotes());

        // Edit records
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extra = new Bundle();
                extra.putInt(AddToFragment.ACTION_TYPE, AddToFragment.UPDATE);
                extra.putParcelable(AddToFragment.BUDGET, budgets.get(holder.getLayoutPosition()));
                Navigation.findNavController(v).navigate(R.id.navigation_addTo, extra);
            }
        });

        // Delete records
//        holder.delete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Show confirmation dialog
//                new AlertDialog.Builder(context)
//                        .setTitle("Delete")
//                        .setMessage("Are you sure you want to delete " + budgets.get(holder.getAdapterPosition()).getNotes() + "?")
//                        .setIcon(android.R.drawable.ic_dialog_alert)
//                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                BudgetDatabase db = new BudgetDatabase(context);
//                                db.deleteBudgetExpense(budgets.get(holder.getAdapterPosition()).getId());
//                                budgets.remove(holder.getAdapterPosition());
//                                notifyItemRemoved(holder.getAdapterPosition());
//                                db.close();
//                            }
//                        })
//                        .setNegativeButton("No", null)
//                        .show();
//            }
//        });
    //}


    String url = "http://api.currencylayer.com/convert" +
            "?access_key=bb273a189398508da2ebe0b840e192fd" +
            "&from=" + budget.getFromCurrency() +
            "&to=" + budget.getToCurrency() +
            "&amount=" + budget.getPrice() +
            "&format=1" +
            "&date=" + budget.getDate();

    JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONObject mainObject = response.getJSONObject("");
                        BudgetDatabase db = new BudgetDatabase(context);
                        db.updateBudgetExpense(budget);
                        db.close();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("VOLLEY_ERROR", error.getLocalizedMessage());
                }
            });
        CurrencySingleton.getInstance(context).

    getRequestQueue().

    add(request);

}

    @Override
    public int getItemCount() {
        if (budgets != null) {
            return budgets.size();
        }
        return 0;
    }


}
