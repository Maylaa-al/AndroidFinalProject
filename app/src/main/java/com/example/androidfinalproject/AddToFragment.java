package com.example.androidfinalproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidfinalproject.ui.Pojo.Budget;

public class AddToFragment extends Fragment {

    private Spinner spinner;
    private EditText dateInput;
    private EditText accountNumInput;
    private Spinner categoriesSpinner;
    private EditText amountInput;
    private EditText notesInput;

    public static final int UPDATE = 1;
    public static final int CREATE = 2;
    public static final String BUDGET = "budget";
    public static final String ACTION_TYPE = "action_type";

    Budget budget;

    public AddToFragment() {
        // Required empty public constructor
    }

    public static AddToFragment newInstance(Budget budget, int actionType) {
        AddToFragment fragment = new AddToFragment();
        Bundle args = new Bundle();
        args.putParcelable(BUDGET, budget);
        args.putInt(ACTION_TYPE, actionType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        if (getArguments() != null) {
            Log.d("budget", "Got here: ");
            int actionType = getArguments().getInt(ACTION_TYPE);
            if (actionType == UPDATE) {
                // Handle update scenario
            } else if (actionType == CREATE) {
                // Handle create scenario
            }
        }

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_to, container, false);
        dateInput = view.findViewById(R.id.editTextDate);
        accountNumInput = view.findViewById(R.id.account_num);
        categoriesSpinner = view.findViewById(R.id.spinner);
        amountInput = view.findViewById(R.id.amount);
        notesInput = view.findViewById(R.id.notes);

        Button saveButton = view.findViewById(R.id.save);


        if (getArguments() != null) {


            // If the user wants to update a location
            if (getArguments().getInt(ACTION_TYPE) == UPDATE) {
                saveButton.setText("Update");

                // Read the location
                budget = getArguments().getParcelable(BUDGET);

                // populate the current locations value into the respective fields
                dateInput.setText(budget.getDate());
                accountNumInput.setText(budget.getAccountNum());
                categoriesSpinner.setAdapter(categoriesSpinner.getAdapter());
                amountInput.setText((int) budget.getAmount());
                notesInput.setText(budget.getNotes());


            }
            else {
                budget = new Budget();
                saveButton.setText("Add Recored");
            }

        }
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("MYAPP", "onClick: button clicked");

                    // Create a new DatabaseLocation object
                   // Budget newRecord = new Budget();
                    budget.setDate(dateInput.getText().toString());
                    budget.setAccountNum(accountNumInput.getText().toString());
                    budget.setCategory(categoriesSpinner.getSelectedItem().toString());
                    budget.setAmount(Double.parseDouble(amountInput.getText().toString()));
                    budget.setNotes(notesInput.getText().toString());

                    // program the submit button to set the
                    //values of the location and either update or insert the
                    //location into the database
                    BudgetDatabase db = new BudgetDatabase(getContext());
//                    assert getArguments() != null;
                    if (getArguments().getInt(ACTION_TYPE) == UPDATE) {
                        db.updateBudgetExpense(budget);
                    } else if (getArguments().getInt(ACTION_TYPE) == CREATE) {
                        db.addBudgetExpense(budget);
                    }

                    db.close();
                    NavController navController = Navigation.findNavController(v);
                    navController.navigate(R.id.action_navigation_addTo_to_categoryFragment);
                    // Navigation.findNavController(view).popBackStack();

                }
            });

        return view;
    }



//            // Show a successful save message
//            Toast.makeText(getContext(), "Budget saved!", Toast.LENGTH_SHORT).show();
//
//            // Go back to the previous fragment
//            getParentFragmentManager().popBackStack();



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinner = view.findViewById(R.id.spinner);

        // Create an array of categories
        String[] items = {"Household", "Education", "Food", "Health", "Apparel", "Beauty", "Gas", "Cultural"};

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, items);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        categoriesSpinner.setAdapter(adapter);
    }
}
