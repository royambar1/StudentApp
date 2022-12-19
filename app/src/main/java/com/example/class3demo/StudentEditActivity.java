package com.example.class3demo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.class3demo.model.Model;
import com.example.class3demo.model.Student;

import java.util.List;

public class StudentEditActivity extends AppCompatActivity {

    EditText editName,editId;
    Button btnBack, btnDelete, btnSave;
    CheckBox checkBox, editCb;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);

        editName = findViewById(R.id.student_edit_name);
        editId = findViewById(R.id.student_edit_id);
        editCb = findViewById(R.id.student_edit_checkBox);

        btnBack = findViewById(R.id.student_edit_btnCancel);
        btnSave = findViewById(R.id.student_edit_btnSave);
        btnDelete = findViewById(R.id.student_edit_btnDelete);
        checkBox = findViewById(R.id.student_edit_checkBox);

        Bundle bundle = getIntent().getExtras();
        int pos =  bundle.getInt("position");
        Student st = Model.instance().getStudent(pos);
        List<Student> studentList = Model.instance().getAllStudents();

        editName.setText(Model.instance().getStudent(pos).getName());
        editId.setText(Model.instance().getStudent(pos).getId());
        editCb.setChecked(Model.instance().getStudent(pos).getCb().booleanValue());


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                st.setName(editName.getText().toString());
                st.setId(editId.getText().toString());
                st.setCb(editCb.isChecked());
                Intent it = new Intent(getApplicationContext(),StudentProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position",pos);
                it.putExtras(bundle);
                startActivity(it);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(),StudentProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("position",pos);
                it.putExtras(bundle);
                startActivity(it);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model.instance().deleteStudent(pos);
                Intent it = new Intent(getApplicationContext(),StudentRecyclerList.class);
                startActivity(it);
            }
        });
    }
}