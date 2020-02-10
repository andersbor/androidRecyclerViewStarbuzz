package dk.easj.anbo.recyclerviewstarbuzz;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DrinkCategoryAdapter extends RecyclerView.Adapter<DrinkCategoryAdapter.MyViewHolder> {
    private static final String LOG_TAG = "SPEC_ADAPTER";
    private final Drink[] drinks ;
    private RecyclerViewSimpleAdapter.OnItemClickListener onItemClickListener;

    public DrinkCategoryAdapter(Drink[] drinks) {
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public DrinkCategoryAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.drink_category_row, parent, false);
        //View v = makeView(parent.getContext());
        Log.d(LOG_TAG, v.toString());
        DrinkCategoryAdapter.MyViewHolder vh = new DrinkCategoryAdapter.MyViewHolder(v);
        Log.d(LOG_TAG, "onCreateViewHolder called");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DrinkCategoryAdapter.MyViewHolder holder, int position) {
        Drink dataItem = drinks[position];
        holder.descriptionView.setText(dataItem.getDescription());
        holder.nameView.setText(dataItem.getName());
        Log.d(LOG_TAG, "onBindViewHolder called " + position);
    }

    @Override
    public int getItemCount() {
        return drinks.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // https://www.javatpoint.com/android-recyclerview-list-example
        final TextView nameView, descriptionView;

        MyViewHolder(@NonNull final View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.drinklist_item_name);
            descriptionView = itemView.findViewById(R.id.drinklist_item_description);
            //view = itemView.findViewById(viewId);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }

    void setOnItemClickListener(RecyclerViewSimpleAdapter.OnItemClickListener itemClickListener) {
        this.onItemClickListener = itemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

}
