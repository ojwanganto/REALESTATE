package org.restate.project.model;

/**
 * Defines properties of a single unit in a house
 */
public class Unit extends BaseObject {

    private House house;
    private String description;
    private Integer category;
    private Integer categoryType;
	private boolean occupied;

    public Unit() {
    }

    public Unit(House house, String description) {
        this.house = house;
        this.description = description;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(Integer categoryType) {
        this.categoryType = categoryType;
    }

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
}
