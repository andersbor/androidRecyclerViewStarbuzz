package dk.easj.anbo.recyclerviewstarbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class DrinkCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        RecyclerView recyclerView = findViewById(R.id.drinkCategoryRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Drink> drinks = Arrays.asList(Drink.drinks);
        //RecyclerViewSimpleAdapter<Drink> adapter = new RecyclerViewSimpleAdapter<>(drinks);
        DrinkCategoryAdapter adapter = new DrinkCategoryAdapter(Drink.drinks);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewSimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("ABDCEF", "position " + position);
                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                //Drink drink = adapter.getItem(position);
                //int idInt = (int) id; // most important
                intent.putExtra(DrinkActivity.EXTRA_DRINKNO, position);
                startActivity(intent);
            }
        });

    }
}
