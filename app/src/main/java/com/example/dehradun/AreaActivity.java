package com.example.dehradun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AreaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button ShivajiMarg, JhandaMolla, TilakRoad, Dhamawala, KalikaMandirMarg, MKP, Ghantaghar, Bakrawala, Karanpur;
    String[] options;
    String c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        ShivajiMarg = (Button) findViewById(R.id.shivajimarg);
        JhandaMolla = (Button) findViewById(R.id.jhandamohalla);
        TilakRoad = (Button) findViewById(R.id.TilakRoad);
        Dhamawala = (Button) findViewById(R.id.Dhamawala);
        KalikaMandirMarg = (Button) findViewById(R.id.KalikaMandirMarg);
        MKP = (Button) findViewById(R.id.MKP);
        Ghantaghar = (Button) findViewById(R.id.Ghantaghar);
        Bakrawala = (Button) findViewById(R.id.Bakrawala);
        Karanpur = (Button) findViewById(R.id.Karanpur);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Creating ArrayAdapter using the string array and default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Chowks, android.R.layout.simple_spinner_item);
        // Specify layout to be used when list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Applying the adapter to our spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        options = AreaActivity.this.getResources().getStringArray(R.array.Chowks);


        ShivajiMarg.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // redirect to RegisterActivity
                Intent intent = new Intent(AreaActivity.this, street.class);
                startActivity(intent);
            }
            });

        JhandaMolla.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // redirect to RegisterActivity
                Intent intent = new Intent(AreaActivity.this, Jhanda.class);
                startActivity(intent);
            }
            });

        TilakRoad.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // redirect to RegisterActivity
                Intent intent = new Intent(AreaActivity.this, TilakRoad.class);
                startActivity(intent);
            }
            });

        Dhamawala.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // redirect to RegisterActivity
                Intent intent = new Intent(AreaActivity.this, Dhamawala.class);
                startActivity(intent);
            }
            });
        KalikaMandirMarg.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // redirect to RegisterActivity
                Intent intent = new Intent(AreaActivity.this, KalikaMandirMarg.class);
                startActivity(intent);
            }
            });

        MKP.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // redirect to RegisterActivity
                Intent intent = new Intent(AreaActivity.this, MKP.class);
                startActivity(intent);
            }
            });

        Ghantaghar.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // redirect to RegisterActivity
                Intent intent = new Intent(AreaActivity.this, Ghantaghar.class);
                startActivity(intent);
            }
            });

        Bakrawala.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // redirect to RegisterActivity
                Intent intent = new Intent(AreaActivity.this, Bakrawala.class);
                startActivity(intent);
            }
            });

        Karanpur.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // redirect to RegisterActivity
                Intent intent = new Intent(AreaActivity.this, Karanpur.class);
                startActivity(intent);
            }
            });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this, " You selected "+options[position], Toast.LENGTH_SHORT).show();
        c=options[position];
        if(c.equals("Laxman Chowk") || c.equals("Rajeev Chowk"))
        {
            Intent intent = new Intent(AreaActivity.this, street.class);
            startActivity(intent);
        }
        else if(c.equals("Sharanpur") || c.equals("Lakhibagh") || c.equals("PipalMandi") || c.equals("Bhandari") || c.equals("Hanuman Chowk"))
        {
            Intent intent = new Intent(AreaActivity.this, Jhanda.class);
            startActivity(intent);
        }
        else if(c.equals("CMI Chowk") || c.equals("Araghar Chowk")|| c.equals("Dwarka")|| c.equals("Doon Hospital Chowk")|| c.equals("MKP Chowk"))
        {
            Intent intent = new Intent(AreaActivity.this, MKP.class);
            startActivity(intent);
        }
        else if(c.equals("Kanak Chowk") || c.equals("Kwality Chowk")|| c.equals("Nanys Bakery Chowk")|| c.equals("Bhel Chowk")|| c.equals("Nishvila Chowk")|| c.equals("Globe Chowk"))
        {
            Intent intent = new Intent(AreaActivity.this, Bakrawala.class);
            startActivity(intent);
        }
        else if(c.equals("Tehseel Chowk") || c.equals("Railway Station Chowk") || c.equals("Prince Chowk") || c.equals("Motibazaar Chowk") )
        {
            Intent intent = new Intent(AreaActivity.this, Dhamawala.class);
            startActivity(intent);
        }
        else if(c.equals("Clock Tower Chowk") || c.equals("CityHeart Centre")|| c.equals("Buddha Park")|| c.equals("Darsan Lal Chowk")|| c.equals("Lansdowne Chowk"))
        {
            Intent intent = new Intent(AreaActivity.this, Ghantaghar.class);
            startActivity(intent);
        }
        else if(c.equals("Survey Chowk") || c.equals("Dilaram Chowk") || c.equals("DBS Chowk") || c.equals("Karanpur Chowk"))
        {
            Intent intent = new Intent(AreaActivity.this, Karanpur.class);
            startActivity(intent);
        }
        else if(c.equals("Shampur") || c.equals("Bindal Chowk"))
        {
            Intent intent = new Intent(AreaActivity.this, TilakRoad.class);
            startActivity(intent);
        }

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}