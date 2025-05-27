package com.DraftThreeCRUD.DraftThree.Service;


import com.DraftThreeCRUD.DraftThree.dto.FlowerDto;

import java.util.List;

public interface FlowerService {

    FlowerDto createFlower (FlowerDto flowerDto);

    FlowerDto getFlowerById (long id);

   List<FlowerDto> getAllFlowers();

   FlowerDto UpdateFlowerById (long id , FlowerDto flowerDto);

    FlowerDto deleteFlower(long id);
}
