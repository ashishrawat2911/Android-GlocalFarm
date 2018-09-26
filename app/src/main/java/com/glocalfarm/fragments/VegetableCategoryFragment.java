package com.glocalfarm.fragments;


import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;

import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.glocalfarm.adaptor.CategoriesAdaptor;
import com.glocalfarm.R;
import com.glocalfarm.models.Vegetable;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class VegetableCategoryFragment extends Fragment implements BottomSheetFragment.OnAddCartClickListener {

    List<Vegetable> categoriesList;
    RecyclerView categoriesRecyclerView;
    CategoriesAdaptor categoriesAdaptor;
    EditText searchEditText;
    NestedScrollView nestedScrollView;

    private BottomSheetBehavior<View> behavior;
    private BottomSheetDialog dialog;

    public VegetableCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vegetable_category, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //instantiate RecyclerView
        categoriesRecyclerView = view.findViewById(R.id.categories_recycler_view);
        searchEditText = view.findViewById(R.id.categories_vegetable_search_edit_text);
        editTextSearch();

        //creating a new list
        nestedScrollView = view.findViewById(R.id.nestedScrollView);
        loadCategories();
        categoriesAdaptor = new CategoriesAdaptor(getContext(), categoriesList);
        categoriesAdaptor.setOnItemClickListener(new CategoriesAdaptor.OnItemClickListener() {
            @Override
            public void onItemClick(CategoriesAdaptor.MyViewHolder item, int position) {
                //dismissDialog();
                View view = getLayoutInflater().inflate(R.layout.fragment_bottom_sheet_dialog, null);
                dialog = new BottomSheetDialog(getContext());
                dialog.setContentView(view);
                dialog.show();
                Toast.makeText(getContext(), "hi"+position, Toast.LENGTH_SHORT).show();

            }
        });
        categoriesRecyclerView.setAdapter(categoriesAdaptor);
        //setting the layout of RecyclerView as Grid
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void editTextSearch() {
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (categoriesAdaptor != null)
                    categoriesAdaptor.getFilter().filter(s.toString().toLowerCase());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void loadCategories() {
        categoriesList = new ArrayList<>();
        categoriesList.add(new Vegetable("Brinjal", R.drawable.brinjal));
        categoriesList.add(new Vegetable("Broccoli", R.drawable.broccali));
        categoriesList.add(new Vegetable("Cabbage", R.drawable.cabbage));
        categoriesList.add(new Vegetable("Cauliflower", R.drawable.cauliflower));
        categoriesList.add(new Vegetable("Chili", R.drawable.chili));
        categoriesList.add(new Vegetable("Onion", R.drawable.onion));
        categoriesList.add(new Vegetable("Potato", R.drawable.potato));
        categoriesList.add(new Vegetable("Pumpkin", R.drawable.pumpkin));
        categoriesList.add(new Vegetable("Radish", R.drawable.radish));
        categoriesList.add(new Vegetable("Tomato", R.drawable.tomato));
    }

    private boolean dismissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
            return true;
        }

        return false;
    }

    private void initBottomSheet() {

        View bottomSheet = nestedScrollView.findViewById(R.id.linearLayoutqqq);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // React to state change
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });

    }

    @Override
    public void addToCart(String ppkt) {
        Log.e("Add to cart", "addToCart: implemented"+ ppkt );
    }
}
