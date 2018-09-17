package com.glocalfarm.fragments;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import com.glocalfarm.R;
import com.glocalfarm.adaptor.CategoriesAdaptor;
import com.glocalfarm.models.Vegetable;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FruitsCategoryFragment extends Fragment {

    List<Vegetable> categoriesList;
    RecyclerView categoriesRecyclerView;
    CategoriesAdaptor categoriesAdaptor;
    EditText searchEditText;

    public FruitsCategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fruits_category, container, false);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //instantiate RecyclerView
        categoriesRecyclerView = view.findViewById(R.id.categories_recycler_view);
        searchEditText = view.findViewById(R.id.categories_vegetable_search_edit_text);
        editTextSearch();
        //creating a new list

        loadCategories();
        categoriesAdaptor = new CategoriesAdaptor(getContext(), categoriesList);
        categoriesRecyclerView.setAdapter(categoriesAdaptor);
        //setting the layout of RecyclerView as Grid
        categoriesRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
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

}
