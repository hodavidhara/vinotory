package com.harataira.vinotory.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.harataira.vinotory.model.WineBottle;

/**
 * DAO for the wine bottle table. Includes the basic CRUD operations.
 */
public class WineBottleDAO {

    private DatabaseHelper databaseHelper;

    public WineBottleDAO(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    /**
     * Adds a new row to the WINE_BOTTLE table.
     * 
     * @param wineBottle
     */
    public long createWineBottle(WineBottle wineBottle) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.KEY_WINE_BOTTLE_VINEYARD,
                wineBottle.getVineyard());
        values.put(DatabaseHelper.KEY_WINE_BOTTLE_YEAR, wineBottle.getYear());
        values.put(DatabaseHelper.KEY_WINE_BOTTLE_TYPE, wineBottle.getType());
        values.put(DatabaseHelper.KEY_WINE_BOTTLE_QUANTITY, wineBottle.getQuantity());
        values.put(DatabaseHelper.KEY_WINE_BOTTLE_COMMENT, wineBottle.getComment());

        // Inserting Row
        long returnLong = db.insert(DatabaseHelper.TABLE_WINE_BOTTLE, null, values);
        db.close(); // Closing database connection
        return returnLong;
    }

    /**
     * Get a list of all wine bottles in the database.
     * 
     * @return a list of wine bottles.
     */
    public List<WineBottle> readAllWineBottles() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        
        List<WineBottle> wineBottleList = new ArrayList<WineBottle>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DatabaseHelper.TABLE_WINE_BOTTLE;
     
        Cursor cursor = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                WineBottle wineBottle = new WineBottle(
                        Integer.parseInt(cursor.getString(0)), // id
                        cursor.getString(1), // Vineyard
                        Integer.parseInt(cursor.getString(2)), // Year
                        cursor.getString(3), // Type
                        Integer.parseInt(cursor.getString(4)), // Quantity
                        cursor.getString(5)); // Comment
                // Adding contact to list
                wineBottleList.add(wineBottle);
            } while (cursor.moveToNext());
        }
     
        // return contact list
        db.close();
        return wineBottleList;
    }
    
    /**
     * Gets a row from the WINE_BOTTLE table by id.
     * 
     * @param id the id of the bottle we're looking for.
     * @return The wine bottle.
     */
    public WineBottle readWineBottleById(long id) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        Cursor cursor = db.query(DatabaseHelper.TABLE_WINE_BOTTLE,
                new String[] { DatabaseHelper.KEY_WINE_BOTTLE_ID,
                        DatabaseHelper.KEY_WINE_BOTTLE_VINEYARD,
                        DatabaseHelper.KEY_WINE_BOTTLE_YEAR,
                        DatabaseHelper.KEY_WINE_BOTTLE_TYPE,
                        DatabaseHelper.KEY_WINE_BOTTLE_QUANTITY,
                        DatabaseHelper.KEY_WINE_BOTTLE_COMMENT },
                DatabaseHelper.KEY_WINE_BOTTLE_ID + " = ?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        
        if (cursor != null) {
            cursor.moveToFirst();
        }

        WineBottle wineBottle = new WineBottle(
                Integer.parseInt(cursor.getString(0)), // id
                cursor.getString(1), // Vineyard
                Integer.parseInt(cursor.getString(2)), // Year
                cursor.getString(3), // Type
                Integer.parseInt(cursor.getString(4)), // Quantity
                cursor.getString(5)); // Comment
        // return wine bottle
        db.close();
        return wineBottle;
    }
    
    /**
     * Gets a row from the database that matches the given distinguishing traits.
     * 
     * @param Vineyard The vineyard of the wine.
     * @param Year The year of the wine.
     * @param Type The type of wine.
     * @return The matching wine bottle, or null if no match.
     */
    public WineBottle readWineBottleByTraits(String vineyard, int year, String type) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        
        String queryString = DatabaseHelper.KEY_WINE_BOTTLE_VINEYARD + " = ? and " +
                DatabaseHelper.KEY_WINE_BOTTLE_YEAR + " = ? and " +
                DatabaseHelper.KEY_WINE_BOTTLE_TYPE + " = ?";

        Cursor cursor = db.query(DatabaseHelper.TABLE_WINE_BOTTLE,
                new String[] { DatabaseHelper.KEY_WINE_BOTTLE_ID,
                        DatabaseHelper.KEY_WINE_BOTTLE_VINEYARD,
                        DatabaseHelper.KEY_WINE_BOTTLE_YEAR,
                        DatabaseHelper.KEY_WINE_BOTTLE_TYPE,
                        DatabaseHelper.KEY_WINE_BOTTLE_QUANTITY,
                        DatabaseHelper.KEY_WINE_BOTTLE_COMMENT },
                queryString,
                new String[] { vineyard, String.valueOf(year), type }, null, null, null, null);
        
        if (cursor != null) {
            cursor.moveToFirst();
        }

        WineBottle wineBottle = new WineBottle(
                Integer.parseInt(cursor.getString(0)), // id
                cursor.getString(1), // Vineyard
                Integer.parseInt(cursor.getString(2)), // Year
                cursor.getString(3), // Type
                Integer.parseInt(cursor.getString(4)), // Quantity
                cursor.getString(5)); // Comment
        // return wine bottle
        db.close();
        return wineBottle;
    }
    
    /**
     * Updates a wine bottle row in the database
     * TODO: maybe we just want to make this void.
     * 
     * @param wineBottle the wine bottle object that needs to be updated in the database.
     * @return the number of rows updated
     */
    public int updateWineBottle(WineBottle wineBottle) {
    	SQLiteDatabase db = databaseHelper.getWritableDatabase();
    		
    	ContentValues values = new ContentValues();
    	values.put(DatabaseHelper.KEY_WINE_BOTTLE_VINEYARD, wineBottle.getVineyard());
        values.put(DatabaseHelper.KEY_WINE_BOTTLE_YEAR, wineBottle.getYear());
        values.put(DatabaseHelper.KEY_WINE_BOTTLE_TYPE, wineBottle.getType());
        values.put(DatabaseHelper.KEY_WINE_BOTTLE_COMMENT,wineBottle.getComment());
    	
        int returnInt = db.update(DatabaseHelper.TABLE_WINE_BOTTLE, values, DatabaseHelper.KEY_WINE_BOTTLE_ID + " = ?",
                new String[] { String.valueOf(wineBottle.getId()) });
        
        db.close();
    	// updating row
    	return returnInt;
    }

    /**
     * Deletes a wine bottle row from the database
     * 
     * @param wineBottle the wine bottle to remove.
     */
    public void deleteWineBottle(WineBottle wineBottle) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        
        // deleting row
        db.delete(DatabaseHelper.TABLE_WINE_BOTTLE, DatabaseHelper.KEY_WINE_BOTTLE_ID + " = ?",
        		new String[] { String.valueOf(wineBottle.getId()) });
        db.close(); // closing database connection
    }
    
    /**
     * Deletes all rows from the table
     */
    public void deleteAllWineBottles() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        
        // Delete all rows.
        db.delete(DatabaseHelper.TABLE_WINE_BOTTLE, null, null);
        db.close();
    }
}
