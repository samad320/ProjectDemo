package com.example.projectdemo;
//
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText numberEditText;
    private Button submitButton;
    private GridView gridView;
    private RadioGroup colorRadioGroup;

    private int selectedColor;
    private int maxColorCount;
    private List<Integer> filledBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberEditText = findViewById(R.id.numberEditText);
        submitButton = findViewById(R.id.submitButton);
        gridView = findViewById(R.id.gridView);
        colorRadioGroup = findViewById(R.id.colorRadioGroup);

        filledBoxes = new ArrayList<>();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = numberEditText.getText().toString().trim();
                if (!input.isEmpty()) {
                    int number = Integer.parseInt(input);
                    if (number % 3 == 0) {
                        createBoxes(number);
                    } else {
                        Toast.makeText(MainActivity.this, "Please enter a multiple of 3", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

//        colorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.redRadioButton:
//                        selectedColor = Color.RED;
//                        maxColorCount = filledBoxes.size() + 2;
//                        break;
//                    case R.id.greenRadioButton:
//                        selectedColor = Color.GREEN;
//                        maxColorCount = filledBoxes.size() + 2;
//                        break;
//                    case R.id.blueRadioButton:
//                        selectedColor = Color.BLUE;
//                        maxColorCount = filledBoxes.size() + 2;
//                        break;
//                }
//            }
//        });


        colorRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (checkedId == R.id.redRadioButton) {
//
//                    selectedColor = Color.RED;
//                    maxColorCount = filledBoxes.size() + 2;
//                } else if (checkedId == R.id.greenRadioButton) {
//
//                    selectedColor = Color.GREEN;
////                    selectedColor=getResources().getColor(")
//                    maxColorCount = filledBoxes.size() + 2;
//                } else if (checkedId == R.id.blueRadioButton) {
//                    selectedColor = Color.BLUE;
//                    maxColorCount = filledBoxes.size() + 2;
//                }
            }
        });


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (filledBoxes.contains(position)) {
                    Toast.makeText(MainActivity.this, "This box already has a color", Toast.LENGTH_SHORT).show();
                } else if (filledBoxes.size() < maxColorCount) {
                    view.setBackgroundColor(Color.GREEN);
                    filledBoxes.add(position);
                } else {
                    Toast.makeText(MainActivity.this, "Color limit exceeded", Toast.LENGTH_SHORT).show();
                }
            }
        });

        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                if (filledBoxes.contains(position)) {
                    view.setBackgroundColor(Color.TRANSPARENT);
                    filledBoxes.remove(Integer.valueOf(position));
                }
                return true;
            }
        });
    }

    private void createBoxes(int count) {
        List<String> boxList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            boxList.add("");
        }

        BoxAdapter boxAdapter = new BoxAdapter(this, boxList);
        gridView.setAdapter(boxAdapter);
    }
}


