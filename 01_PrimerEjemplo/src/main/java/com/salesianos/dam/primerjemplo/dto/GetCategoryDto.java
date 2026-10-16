package com.salesianos.dam.primerjemplo.dto;

import com.salesianos.dam.primerjemplo.model.Category;

public record GetCategoryDto(

        String name

) {


    public static GetCategoryDto of( Category category){

        return new GetCategoryDto(category.getName()) ;
    }

}
