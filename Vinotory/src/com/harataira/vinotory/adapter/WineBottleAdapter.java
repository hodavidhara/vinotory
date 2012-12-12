package com.harataira.vinotory.adapter;

import java.util.List;

import com.harataira.vinotory.model.WineBottle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.harataira.vinotory.R;

public class WineBottleAdapter extends ArrayAdapter<WineBottle> {

    private Context context;
    private List<WineBottle> values;
    
    public WineBottleAdapter(Context context, List<WineBottle> values) {
        super(context, R.layout.inventory_list_item, values);
        this.context = context;
        this.values = values;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        // Get all the views
        View rowView = inflater.inflate(R.layout.inventory_list_item, parent, false);
        TextView vineyardTextView = (TextView) rowView.findViewById(R.id.listItemVineyard);
        TextView typeTextView = (TextView) rowView.findViewById(R.id.listItemType);
        TextView yearTextView = (TextView) rowView.findViewById(R.id.listItemYear);
        
        // Get the current wine bottle.
        WineBottle currentBottle = values.get(position);
        
        // Set all the text views accordingly
        vineyardTextView.setText(currentBottle.getVineyard());
        typeTextView.setText(currentBottle.getType());
        yearTextView.setText(currentBottle.getYear());
        
        return rowView;
    }

}
