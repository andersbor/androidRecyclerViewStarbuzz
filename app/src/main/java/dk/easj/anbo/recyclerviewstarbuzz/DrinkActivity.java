package dk.easj.anbo.recyclerviewstarbuzz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {
    public static final String EXTRA_DRINKNO = "drink number";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        Intent intent = getIntent();
        int drinkNo = intent.getIntExtra(EXTRA_DRINKNO, 1); // default value 1
        Log.d("COFFEE", "DrinkActivity drinkNo " + drinkNo);
        Drink drink = Drink.drinks[drinkNo]; // array is zero-based

        ImageView photo = findViewById(R.id.photo);
        photo.setImageResource(drink.getImageResourceId());
        photo.setContentDescription(drink.getName());

        TextView name = findViewById(R.id.name);
        name.setText(drink.getName());

        TextView description = findViewById(R.id.description);
        description.setText(drink.getDescription());
    }
}
