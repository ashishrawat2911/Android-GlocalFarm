package com.glocalfarm.adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.glocalfarm.R;
import com.glocalfarm.models.Vegetable;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdaptor extends RecyclerView.Adapter<CategoriesAdaptor.MyViewHolder>implements Filterable {
    private Context ctx;
    private List<Vegetable> categoriesList;
    private List<Vegetable> mFilteredList;
    public CategoriesAdaptor(Context ctx, List<Vegetable> categoriesList) {
        this.ctx = ctx;
        this.categoriesList = categoriesList;
        this.mFilteredList=categoriesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(ctx).inflate(R.layout.categories_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.categoriesImage.setImageResource(mFilteredList.get(position).getImage());


        holder.categoriesTitle.setText(mFilteredList.get(position).getName());
    }


    @Override
    public int getItemCount() {
        return mFilteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    mFilteredList = categoriesList;
                } else {

                    List<Vegetable> filteredList = new ArrayList<>();

                    for (Vegetable vegetable : categoriesList) {

                        if (vegetable.getName().toLowerCase().contains(charString)||vegetable.getName().toUpperCase().contains(charString) ) {

                            filteredList.add(vegetable);
                        }
                    }

                    mFilteredList = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mFilteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                mFilteredList = (List<Vegetable>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView categoriesTitle;
        ImageView categoriesImage;
        // CardView cardView;

        MyViewHolder(View itemView) {
            super(itemView);
            categoriesTitle = itemView.findViewById(R.id.categories_title_text_view);
            categoriesImage = itemView.findViewById(R.id.categories_image_view);
           /* cardView = itemView.findViewById(R.id.catCardView);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(ctx, NewsListActivity.class);
                    i.putExtra(Constants.NEWS_TYPE, categoriesList.get(getAdapterPosition()).getNewsType());
                    ctx.startActivity(i);
                }
            });*/
        }
    }
}

