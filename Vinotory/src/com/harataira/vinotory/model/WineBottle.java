package com.harataira.crazyandroidapp.model;

/**
 * The model representing a wine bottle.
 */
public class WineBottle {

	private String vineyard;
	private int year;
	// TODO: Make this an enum?
	private String type;
	// TODO: maybe this should just be a photo? What type is it? Learn more
	// about android camera integration
	private String pathToPhoto;
	private String comment;

	public WineBottle() {
	}

	public WineBottle(String vineyard, int year, String type,
			String pathToPhoto, String comment) {
		this.vineyard = vineyard;
		this.year = year;
		this.type = type;
		this.pathToPhoto = pathToPhoto;
		this.comment = comment;
	}

	public String getVineyard() {
		return vineyard;
	}

	public void setVineyard(String vineyard) {
		this.vineyard = vineyard;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPathToPhoto() {
		return pathToPhoto;
	}

	public void setPathToPhoto(String pathToPhoto) {
		this.pathToPhoto = pathToPhoto;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
