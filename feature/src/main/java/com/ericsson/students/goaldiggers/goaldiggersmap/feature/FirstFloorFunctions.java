package com.ericsson.students.goaldiggers.goaldiggersmap.feature;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.chrisbanes.photoview.PhotoView;

public class FirstFloorFunctions extends AppCompatActivity {

    // define spinner

    Spinner sp;

    //make string Arrary

    String names[] = {"-----Select-----                                                               ↓", "Coffee Docks", "Toilets", "Clear All"};

    //defins array adapter of string type

    ArrayAdapter<String> adapter;

    //define string variable for record

    String record = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_firstfloorfunctions);
        sp = (Spinner) findViewById(R.id.spinner);

        PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
        photoView.setImageResource(R.drawable.ecmfirst);

//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);


        //set adapter to spinner

        sp.setAdapter(adapter);

        Button next = (Button) findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), GroundFloorFunctions.class);
                startActivityForResult(myIntent, 0);
            }

        });


        //set spinner method

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //use postion value

                switch (position)

                {

                    case 0:

                        record = "----Select----";

                        break;


                    case 1:

                        record = "Coffee Docks";
                        break;

                    case 2:

                        record = "Toilets";

                        break;

                    case 3:

                        record = "Clear All";

                        break;
                }

                diplsyResult(view);

            }

            @Override

            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

    }

    //set display button click to show result

    public void diplsyResult(View view)

    {


        if (record.equals("Coffee Docks")) {
            PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
            photoView.setImageResource(R.drawable.ecmfirstcoffee);
        }

        if (record.equals("Toilets")) {
            PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
            photoView.setImageResource(R.drawable.ecmfirsttoilets);
        }

        if (record.equals("Clear All")) {
            PhotoView photoView = (PhotoView) findViewById(R.id.photo_view);
            photoView.setImageResource(R.drawable.ecmfirst);

        }

    }

}
