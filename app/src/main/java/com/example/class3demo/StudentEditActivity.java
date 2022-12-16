package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.class3demo.model.Model;
import com.example.class3demo.model.Student;

public class StudentEditActivity extends AppCompatActivity {

    EditText editName,editId;
    Button btnBack, btnSave;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);

        editName = findViewById(R.id.student_edit_name);
        editId = findViewById(R.id.student_edit_id);

        btnSave = findViewById(R.id.student_edit_btnSave);

        Bundle bundle = getIntent().getExtras();
        int pos =  bundle.getInt("position");
        Student st = Model.instance().getStudent(pos);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st.setName(editName.getText().toString());
                st.setId(editId.getText().toString());
                Intent it = new Intent(getApplicationContext(),StudentProfileActivity.class);
                startActivity(it);
            }
        });

    }
}