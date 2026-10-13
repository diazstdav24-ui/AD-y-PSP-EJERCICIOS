package com.salesianos.dam.primerjemplo.dto;

import com.salesianos.dam.primerjemplo.model.Category;

public record GetCategoryList(

        String name

) {

    public static GetCategoryList of( Category category){

        return new GetCategoryList(category.getName()) ;
    }
}
