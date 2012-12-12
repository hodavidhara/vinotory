package com.harataira.vinotory.activity;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.harataira.vinotory.adapter.WineBottleAdapter;
import com.harataira.vinotory.database.WineBottleDAO;
import com.harataira.vinotory.model.WineBottle;

public class InventoryActivity extends ListActivity {
    
    private WineBottleDAO wineBottleDAO;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Get the DAO
        wineBottleDAO = new WineBottleDAO(this);
        
        // Get the list of wine bottles.
        List<WineBottle> wineBottles = wineBottleDAO.readAllWineBottles();
 
        setListAdapter(new WineBottleAdapter(this, wineBottles));
 
    }
 
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
 
        WineBottle selectedBottle = (WineBottle) getListAdapter().getItem(position);
        
        System.out.println(selectedBottle);
 
    }

}
