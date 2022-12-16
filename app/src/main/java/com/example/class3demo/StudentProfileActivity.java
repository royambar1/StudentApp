package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.class3demo.model.Model;
import com.example.class3demo.model.Student;

public class StudentProfileActivity extends AppCompatActivity {

    TextView name,id;
    Button btnBack, btnEdit;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        name = findViewById(R.id.student_profile_name);
        id = findViewById(R.id.student_profile_id);

        btnBack = findViewById(R.id.student_profile_btnBack);
        btnEdit = findViewById(R.id.student_profile_btnEdit);


        Bundle bundle = getIntent().getExtras();
        int pos =  bundle.getInt("position");
        Student st = Model.instance().getStudent(pos);
        name.setText(name.getText() + " " + st.getName());
        id.setText(id.getText() + " " + st.getId());

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),StudentRecyclerList.class);
                startActivity(it);
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),StudentEditActivity.class);
                Bundle bundle1 = new Bundle();
                bundle1.putInt("position",pos);
                it.putExtras(bundle1);
                startActivity(it);
            }
        });
    }
}