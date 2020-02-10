package dk.easj.anbo.recyclerviewstarbuzz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final List<String> menuOptions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        menuOptions.add("Drinks");
        menuOptions.add("Food");
        menuOptions.add("Stores");
        Log.d("ABCDEF", menuOptions.toString());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mainMenuRecyclerView);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewSimpleAdapter<String> adapter = new RecyclerViewSimpleAdapter<>(/*this,*/ menuOptions);
        adapter.setOnItemClickListener(new RecyclerViewSimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object item) {
                String category = (String) item;
                Log.d("ABCDEF", category + " clicked");
                view.setBackgroundColor(Color.GREEN);
                if (position == 0) { // Drinks
                    Intent intent = new Intent(getBaseContext(), DrinkCategoryActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "No action", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
