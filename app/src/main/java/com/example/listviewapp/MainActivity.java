package com.example.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //defining varibles and linking to design
    Spinner sp;
    TextView city,visitors;
    ImageView img;
    ListView list;
    Button calculate;
    TextView totalamount;
    int price,noofvisitors;
    String[] countries = {"Canada","USA","England"};
    List<PlacesofVisit> placeslist = new ArrayList<PlacesofVisit>();
    List<PlacesofVisit> tempPlacesList = new ArrayList<PlacesofVisit>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initializing variables
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=findViewById(R.id.spinner);
        city = findViewById(R.id.city);
        visitors = findViewById(R.id.visitors);
        list = findViewById(R.id.listview);
        img=findViewById(R.id.imageView);
        calculate = findViewById(R.id.calculate);
        totalamount = findViewById(R.id.amount);
        //filling temp data
        fillData();
        //setting up spinner
        ArrayAdapter aa=new ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,countries);
        sp.setAdapter(aa);
        calculate.setOnClickListener(new View.OnClickListener() {
            //calculating the amount
            Double amount;
            Double discount;
            @Override
            public void onClick(View v) {
                noofvisitors = Integer.parseInt(visitors.getText().toString());
                if(noofvisitors>15) {
                    amount = Double.valueOf(noofvisitors*price);
                    discount = 0.05 * amount;
                    amount = amount - discount;
                }
                else {
                    amount = Double.valueOf(noofvisitors*price);
                }
               totalamount.setText(String.valueOf(amount));
            }
        });
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //On spinner select item, fill the places accroding to country
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setCaptialCity(position); // setting capital according to country
               tempPlacesList.clear();
               String country = countries[position];
               for(int i=0;i<placeslist.size();i++) {
                   if(placeslist.get(i).getCountry().equals(country)) {
                       tempPlacesList.add(placeslist.get(i)); //filling the places of visit
                   }
               }
               list.setAdapter(new PlaceListAdaptor(getApplicationContext(),tempPlacesList));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the price of selected place.
                price = tempPlacesList.get(i).getPrice();

            }
        });
    }

    public void setCaptialCity(int i) {
        if(i==0) {
            city.setText("Ottawa");
            int id = getResources().getIdentifier("canadaflag","drawable",getApplicationContext().getPackageName());
            img.setImageResource(id);
        }
        if(i==1) {
            city.setText("Washington");
            int id = getResources().getIdentifier("usaflag","drawable",getApplicationContext().getPackageName());
            img.setImageResource(id);
        }
        if(i==2) {
            city.setText("London");
            int id = getResources().getIdentifier("englandflag","drawable",getApplicationContext().getPackageName());
            img.setImageResource(id);
        }
    }

    public void fillData() {
        placeslist.add(new PlacesofVisit(countries[0],"Niagara","niagara",100));
        placeslist.add(new PlacesofVisit(countries[0],"CN Tower","cntower",30));
        placeslist.add(new PlacesofVisit(countries[0],"The Butchart gardens","buchartgardens",30));
        placeslist.add(new PlacesofVisit(countries[0],"Notre-Dam Basilica","notredam",50));
        placeslist.add(new PlacesofVisit(countries[1],"The statue of liberty","statueofliberty",90));
        placeslist.add(new PlacesofVisit(countries[1],"The White house","whitehouse",60));
        placeslist.add(new PlacesofVisit(countries[1],"TimsSquare","timssquare",75));
        placeslist.add(new PlacesofVisit(countries[2],"Big Ben","bigben",30));
        placeslist.add(new PlacesofVisit(countries[2],"WestMinster Abbey","westminister",25));
        placeslist.add(new PlacesofVisit(countries[2],"Hyde Park","hydepark",15));
    }
}