package com.harataira.vinotory.service;

import java.util.List;

import android.content.Context;

import com.harataira.vinotory.database.WineBottleDAO;
import com.harataira.vinotory.model.WineBottle;

/**
 * The wine bottle service layer that sits on top of the wine bottle DAO.
 */
public class WineBottleService {
    
    private WineBottleDAO wineBottleDAO;
    
    public WineBottleService(Context context) {
        wineBottleDAO = new WineBottleDAO(context);
    }
    
    /**
     * Gets a wine bottle by its Id.
     * 
     * @param Id the id of the wine bottle.
     * @return The wine bottle with the matching id.
     */
    public WineBottle getWineBottle(String id) {
        return wineBottleDAO.readWineBottleById(Long.parseLong(id));
    }
    
    /**
     * Adds a winebottle to the database.
     * This method will handle checking if the user already has a collection of the same type
     * of wine bottle. If it does, it will just increment the amount the user has has. If not,
     * it will add a new row to the table. 
     * 
     * @param wineBottle The wine bottle object to be added to the inventory.
     */
    public void addWineBottle(WineBottle wineBottle) {
    	String vineyard = wineBottle.getVineyard();
    	int year = wineBottle.getYear();
    	String type = wineBottle.getType();
    	
    	// Search for a wine bottle in the database with matching types
    	WineBottle wineBottleFromDatabase = wineBottleDAO.readWineBottleByTraits(vineyard, year, type);
    	
    	if (wineBottleFromDatabase == null) {
    	    // If no wine bottle exists, just create it
    	    wineBottleDAO.createWineBottle(wineBottle);
		} else {
		    
		    // If a wine bottle does exist, add the quantities and update the row in the DB.
			int totalQuantity = wineBottle.getQuantity() + wineBottleFromDatabase.getQuantity();
    		wineBottleFromDatabase.setQuantity(totalQuantity);
    		
    		// TODO: We probably want some way to track the comments if the user adds another comment. 
    		wineBottleDAO.updateWineBottle(wineBottleFromDatabase);
		}
    }
    
    /**
     * Deletes a wine bottle from the inventory
     * @param wineBottle The wine bottle to be deleted
     */
    public void deleteWineBottle(WineBottle wineBottle) {
        wineBottleDAO.deleteWineBottle(wineBottle);
    }
    
    /**
     * Gets a list of all the wine bottles in the inventory.
     * @return The entire list of wine bottles in the inventory.
     */
    public List<WineBottle> getAllWineBottles() {
        return wineBottleDAO.readAllWineBottles();
    }
    
    /**
     * Deletes all the wine bottles in the inventory
     */
    public void deleteAllWineBottles() {
        wineBottleDAO.deleteAllWineBottles();
    }
}
