package com.harataira.vinotory.activity;


import java.util.List;

import android.os.Bundle;
import android.view.View;

import com.harataira.vinotory.R;
import com.harataira.vinotory.model.WineBottle;

public class AddWineBottleActivity extends GeneralMenuActivity {
    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_addwinebottle);
    }
    
    public void addWineBottleToDatabase(View view) {
        // TODO: uncomment these and hook everything in to the view when Spencer is done.
        
//        EditText vineyardInput = (EditText) findViewById(R.id.vineyard_input);
//        EditText yearInput = (EditText) findViewById(R.id.year_input);
//        EditText typeInput = (EditText) findViewById(R.id.type_input);
//        EditText quantityInput = (EditText) findViewById(R.id.quantity_input);
//        EditText commentInput = (EditText) findViewById(R.id.comment_input);
//        
//        String vineyard = vineyardInput.getText().toString();
//        int year = Integer.parseInt(yearInput.getText().toString());
//        String type = typeInput.getText().toString();
//        int quantity = Integer.parseInt(quantityInput.getText().toString());
//        String comment  = commentInput.getText().toString();
//        
//        WineBottle wineBottle = new WineBottle(vineyard, year, type, quantity, comment);
        
        WineBottle wineBottle = new WineBottle("Awesome Vineyard", 1991, "Merlot", 42, "This is the best wine ever!");
        
        wineBottleDAO.createWineBottle(wineBottle);
        
        List<WineBottle> returnWineBottle = wineBottleDAO.readAllWineBottles();
        
        System.out.println("Found " + returnWineBottle.size() + " bottles:");
        System.out.println(returnWineBottle.get(0));
    }
}
