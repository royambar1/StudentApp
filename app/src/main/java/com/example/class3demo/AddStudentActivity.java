package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.class3demo.model.Model;
import com.example.class3demo.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText nameEt = findViewById(R.id.addStudent_name_edit_text);
        EditText idEt = findViewById(R.id.addStudent_id_edit_text);
        TextView messageTv = findViewById(R.id.addStudent_msg);
        Button saveBtn = findViewById(R.id.student_profile_btnBack);
        Button cancelBtn = findViewById(R.id.student_profile_btnEdit);

        saveBtn.setOnClickListener(view -> {
            Student st = new Student(nameEt.getText().toString(),idEt.getText().toString(),"",false);
            Model.instance().addStudent(st);
            Intent it = new Intent(getApplicationContext(), StudentRecyclerList.class);
            startActivity(it);
        });

        cancelBtn.setOnClickListener(view -> {
            Intent it = new Intent(getApplicationContext(), StudentRecyclerList.class);
            startActivity(it);
        });

        cancelBtn.setOnClickListener(view -> finish());

    }
}