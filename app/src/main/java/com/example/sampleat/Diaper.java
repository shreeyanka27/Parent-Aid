package com.example.sampleat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Diaper extends AppCompatActivity {

    private CheckBox checkBoxYellow, checkBoxOrange, checkBoxBlack, checkBoxBrown;
    private CheckBox checkBoxSolid, checkBoxSemiSolid, checkBoxLiquid;
    private EditText editTextTime2, editTextTime3;
    private Button recordButton;
    private TableLayout dataTable;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaper);

        checkBoxYellow = findViewById(R.id.checkBox6);
        checkBoxOrange = findViewById(R.id.checkBox3);
        checkBoxBlack = findViewById(R.id.checkBox7);
        checkBoxBrown = findViewById(R.id.checkBox5);
        checkBoxSolid = findViewById(R.id.checkBox2);
        checkBoxSemiSolid = findViewById(R.id.checkBox4);
        checkBoxLiquid = findViewById(R.id.checkBox);
        editTextTime2 = findViewById(R.id.editTextTime2);
        editTextTime3 = findViewById(R.id.editTextTime3);
        recordButton = findViewById(R.id.button7);
        dataTable = findViewById(R.id.dataTable);
        myDb=new DatabaseHelper(this);
        recordButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                addDataToTable();
                //AddDiaperData();
            }

        });
    }

    public void  AddDiaperData (String poop_time, String diaper_time, String color_poop, String consist){

        boolean isInserted = myDb.insertDiaperData(poop_time,diaper_time,color_poop,consist);
       if(isInserted==true)
            Toast.makeText(Diaper.this, "Data inserted", Toast.LENGTH_SHORT).show();
       else
            Toast.makeText(Diaper.this, "Data not inserted", Toast.LENGTH_SHORT).show();
    }


    private void addDataToTable() {
        TableRow newRow = new TableRow(this);

        TextView poopValue = new TextView(this);
        poopValue.setText(editTextTime3.getText().toString());
        poopValue.setBackgroundResource(R.drawable.cell_border); // Set background drawable for cell borders
        poopValue.setPadding(5, 5, 5, 5); // Set padding for cell content
        newRow.addView(poopValue);

        TextView diaperValue = new TextView(this);
        diaperValue.setText(editTextTime2.getText().toString());
        diaperValue.setBackgroundResource(R.drawable.cell_border); // Set background drawable for cell borders
        diaperValue.setPadding(5, 5, 5, 5); // Set padding for cell content
        newRow.addView(diaperValue);

        TextView colorValue = new TextView(this);
        if (checkBoxYellow.isChecked()) {
            colorValue.append("Yellow ");
        }
        if (checkBoxOrange.isChecked()) {
            colorValue.append("Orange ");
        }
        if (checkBoxBlack.isChecked()) {
            colorValue.append("Black ");
        }
        if (checkBoxBrown.isChecked()) {
            colorValue.append("Brown ");
        }
        colorValue.setBackgroundResource(R.drawable.cell_border); // Set background drawable for cell borders
        colorValue.setPadding(5, 5, 5, 5); // Set padding for cell content
        newRow.addView(colorValue);

        TextView consistencyValue = new TextView(this);
        if (checkBoxSolid.isChecked()) {
            consistencyValue.append("Solid ");
        }
        if (checkBoxSemiSolid.isChecked()) {
            consistencyValue.append("Semi-Solid ");
        }
        if (checkBoxLiquid.isChecked()) {
            consistencyValue.append("Liquid ");
        }
        consistencyValue.setBackgroundResource(R.drawable.cell_border); // Set background drawable for cell borders
        consistencyValue.setPadding(5, 5, 5, 5); // Set padding for cell content
        newRow.addView(consistencyValue);
        String poop_time = poopValue.getText().toString();
        String diaper_time=diaperValue.getText().toString();
        String poop_color = colorValue.getText().toString();
        String poop_consistency=consistencyValue.getText().toString();
        dataTable.addView(newRow, 1);
        AddDiaperData(poop_time,diaper_time,poop_color,poop_consistency);
    }
}