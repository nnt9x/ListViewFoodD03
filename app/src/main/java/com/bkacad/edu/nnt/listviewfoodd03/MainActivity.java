package com.bkacad.edu.nnt.listviewfoodd03;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bkacad.edu.nnt.listviewfoodd03.adapter.FoodAdapter;
import com.bkacad.edu.nnt.listviewfoodd03.model.Food;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtSearch;
    private ListView lvFoods;

    private List<Food> data;
    private FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Bind id
        edtSearch = findViewById(R.id.edt_main_search);
        lvFoods = findViewById(R.id.lv_main_foods);
        // Du lieu: co the lay tu API, hoac Database
        data = new ArrayList<>();
        data.add(new Food("F1","Food 1", 3000, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7GcKireqtZsvYX5Cg7Tn6XDOowmad2j2TFw&s", 3.5f, 10));
        data.add(new Food("F2","Food 2", 5000, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7GcKireqtZsvYX5Cg7Tn6XDOowmad2j2TFw&s", 4.5f, 0));
        data.add(new Food("F3","Food 3", 6000, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7GcKireqtZsvYX5Cg7Tn6XDOowmad2j2TFw&s", 4.5f, 20));
        data.add(new Food("F4","Food 4", 7000, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7GcKireqtZsvYX5Cg7Tn6XDOowmad2j2TFw&s", 5.0f, 30));
        // Hien thi voi listview
        adapter = new FoodAdapter(this, data);
        lvFoods.setAdapter(adapter);
    }
}