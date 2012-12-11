package com.harataira.vinotory.adapter;

import java.util.List;

import com.harataira.vinotory.model.WineBottle;

import android.content.Context;
import android.widget.ArrayAdapter;

public class InventoryArrayAdapter extends ArrayAdapter {

    public InventoryArrayAdapter(Context context, int textViewResourceId,
            List<WineBottle> objects) {
        super(context, textViewResourceId, objects);
        // TODO Auto-generated constructor stub
    }

}
