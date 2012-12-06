package com.harataira.vinotory.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

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
        
        EditText vineyardInput = (EditText) findViewById(R.id.addVineyardInput);
        EditText yearInput = (EditText) findViewById(R.id.addYearInput);
        EditText typeInput = (EditText) findViewById(R.id.addTypeInput);
        EditText quantityInput = (EditText) findViewById(R.id.addQuantityInput);
        EditText commentInput = (EditText) findViewById(R.id.addCommentInput);
        
        String vineyard = vineyardInput.getText().toString();
        int year = Integer.parseInt(yearInput.getText().toString());
        String type = typeInput.getText().toString();
        int quantity = Integer.parseInt(quantityInput.getText().toString());
        String comment  = commentInput.getText().toString();
        
        WineBottle wineBottle = new WineBottle(vineyard, year, type, quantity, comment);
        
        wineBottleDAO.createWineBottle(wineBottle);
    }
    
    public void finishAddWineBottleActivity(View view) {
        finish();
    }
}
