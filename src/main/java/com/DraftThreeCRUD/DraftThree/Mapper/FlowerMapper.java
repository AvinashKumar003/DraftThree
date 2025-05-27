package com.DraftThreeCRUD.DraftThree.Mapper;


//we will use this mapper class to map the entity object into Dto and vice versa

import com.DraftThreeCRUD.DraftThree.Model.Flower;
import com.DraftThreeCRUD.DraftThree.dto.FlowerDto;

public class FlowerMapper {

    //this  method will convert Flower (entity) object to FlowerDto

    public static FlowerDto toDto (Flower flower){

        FlowerDto dto = new FlowerDto();
        dto.setId(flower.getId());
        dto.setName(flower.getName());
        dto.setPrice(flower.getPrice());

        return dto;
    }

    //this class will convert flowerDto into Flower (Entity)
    public static Flower toEntity(FlowerDto dto){
        Flower flower = new Flower();

        flower.setId(dto.getId());
        flower.setName(dto.getName());
        flower.setPrice(dto.getPrice());

        return flower;
    }


}
