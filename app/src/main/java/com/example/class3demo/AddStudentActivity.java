package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText nameEt = findViewById(R.id.addStudent_name_edit_text);
        EditText idEt = findViewById(R.id.addStudent_id_edit_text);
        TextView messageTv = findViewById(R.id.addStudent_msg);
        Button saveBtn = findViewById(R.id.addStudent_save_btn);
        Button cancelBtn = findViewById(R.id.addStudent_cancel_btn);

        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            messageTv.setText(name);
        });

        cancelBtn.setOnClickListener(view -> finish());

    }
}