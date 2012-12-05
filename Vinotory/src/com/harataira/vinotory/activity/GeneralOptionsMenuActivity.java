package com.harataira.vinotory.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.harataira.vinotory.R;
import com.harataira.vinotory.database.WineBottleDAO;

public abstract class GeneralOptionsMenuActivity extends Activity {

    protected WineBottleDAO wineBottleDAO;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        wineBottleDAO = new WineBottleDAO(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_settings :
                return true;
            case R.id.menu_empty_db :
                return emptyDatabase();
            default:
                return super.onOptionsItemSelected(item);
        }
    }    
    
    private boolean emptyDatabase() {
        try {
            wineBottleDAO.deleteAllWineBottles();
            System.out.println("Success removing all wine bottles from the table!");
            return true;    
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
