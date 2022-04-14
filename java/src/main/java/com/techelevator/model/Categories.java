package com.techelevator.model;

public class Categories {
    private Long category_ID;
    private String category_name;

    public Categories(Long category_ID, String category_name) {
        this.category_ID = category_ID;
        this.category_name = category_name;

    }
    public Categories(){}

    public Long getCategory_ID() {
        return category_ID;
    }

    public void setCategory_ID(Long category_ID) {
        this.category_ID = category_ID;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
