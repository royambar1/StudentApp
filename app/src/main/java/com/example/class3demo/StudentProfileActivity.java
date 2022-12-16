package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.example.class3demo.model.Model;
import com.example.class3demo.model.Student;

public class StudentProfileActivity extends AppCompatActivity {

    TextView name,id;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        name = findViewById(R.id.student_profile_name);
        id = findViewById(R.id.student_profile_id);

        Bundle bundle = getIntent().getExtras();

// getting the string back
        int pos =  bundle.getInt("position");

        Student st = Model.instance().getStudent(pos);

        name.setText(name.getText() + " " + st.getName());
    }
}