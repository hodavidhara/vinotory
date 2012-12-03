package com.harataira.vinotory.model;

/**
 * The model representing a wine bottle.
 */
public class WineBottle {

	private int id;
	private String vineyard;
	private int year;
	// TODO: Make this an enum?
	private String type;
	private int quantity;
	private String comment;
	// TODO: How do we add a photo? What type is it? Learn more
	// about android camera integration

	public WineBottle() {
	}

	public WineBottle(int id, String vineyard, int year, String type, int quantity, String comment) {
		this.id = id;
		this.vineyard = vineyard;
		this.year = year;
		this.type = type;
		this.quantity = quantity;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result
				+ ((vineyard == null) ? 0 : vineyard.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WineBottle other = (WineBottle) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (id != other.id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (vineyard == null) {
			if (other.vineyard != null)
				return false;
		} else if (!vineyard.equals(other.vineyard))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
}
