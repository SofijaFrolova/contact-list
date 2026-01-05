package com.example.contact_list.dto;

public class PersonListDto {
    private String name;
    private String imageUrl;

    public PersonListDto(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}