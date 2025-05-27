package com.DraftThreeCRUD.DraftThree.Controller;


import com.DraftThreeCRUD.DraftThree.Service.FlowerService;
import com.DraftThreeCRUD.DraftThree.Service.ServiceImpl.FlowerServiceImpl;
import com.DraftThreeCRUD.DraftThree.dto.FlowerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flower")
public class FlowerController {

    //create a reference of FlowerServiceImpl

    public final FlowerService flowerService;

    //constructor based injection of FlowerService into FlowerController

    public FlowerController (FlowerService flowerService){
        this.flowerService = flowerService;
    }

//    create user
    @PostMapping
    public ResponseEntity<FlowerDto> createUser (@RequestBody FlowerDto flowerDto){
        return  ResponseEntity.ok(flowerService.createFlower(flowerDto));
    }

    @GetMapping("/{id}")

    public  ResponseEntity<FlowerDto> getFlowerById (@PathVariable long id){
        return  ResponseEntity.ok(flowerService.getFlowerById(id));
    }

    @GetMapping
    public ResponseEntity <List<FlowerDto>> getAllFlowers(){
        return  ResponseEntity.ok(flowerService.getAllFlowers());
    }

    @PutMapping("/{id}/")
    public ResponseEntity <FlowerDto> UpdateFlowerById (@PathVariable long id , @RequestBody FlowerDto flowerDto){
        return ResponseEntity.ok(flowerService.UpdateFlowerById(id,flowerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteFlower (@PathVariable long id){
        flowerService.deleteFlower(id);
        return  ResponseEntity.noContent().build();
    }


}
