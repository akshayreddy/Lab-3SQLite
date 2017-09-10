package com.example.akshay.lab_3sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper mydb;
    EditText editName, editSurname, editCgpa;
    Button addData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText);
        editSurname = (EditText)findViewById(R.id.editText2);
        editCgpa = (EditText)findViewById(R.id.editText3);
        addData = (Button)findViewById(R.id.add_button);
        AddData();

    }

    public  void AddData() {
        addData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = mydb.insertData(editName.getText().toString(),
                                editSurname.getText().toString(),
                                editCgpa.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(MainActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }



}
