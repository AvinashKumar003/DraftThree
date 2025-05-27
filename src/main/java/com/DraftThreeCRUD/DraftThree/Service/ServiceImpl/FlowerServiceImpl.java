package com.DraftThreeCRUD.DraftThree.Service.ServiceImpl;


import com.DraftThreeCRUD.DraftThree.Mapper.FlowerMapper;
import com.DraftThreeCRUD.DraftThree.Model.Flower;
import com.DraftThreeCRUD.DraftThree.Repository.FlowerRepo;
import com.DraftThreeCRUD.DraftThree.Service.FlowerService;
import com.DraftThreeCRUD.DraftThree.dto.FlowerDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlowerServiceImpl implements FlowerService {

//    create FlowerRepo refernce, so that it could be injected via Construtor injection
    private  final FlowerRepo repository;

//    contructor based injection

    public  FlowerServiceImpl(FlowerRepo repository){
        this.repository = repository;
    }

    @Override
    public FlowerDto createFlower(FlowerDto dto){
        //convert flowerdto object to flower (entity) using mapper class
        Flower flower = FlowerMapper.toEntity(dto);
        //convert back flower (entity) into flowerdto as our return type is FlowerDto
        return FlowerMapper.toDto(repository.save(flower));

    }

    @Override
    public FlowerDto getFlowerById(long id) {
        Flower flower = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Flower not found"));

        return FlowerMapper.toDto(flower);
    }

    @Override
    public List<FlowerDto> getAllFlowers() {
        return  repository.findAll().stream()
                .map(FlowerMapper ::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public FlowerDto UpdateFlowerById(long id, FlowerDto flowerDto) {
        Flower flower = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fruit not found"));
        flower.setName(flowerDto.getName());
        flower.setPrice(flowerDto.getPrice());

        return  FlowerMapper.toDto(repository.save(flower));

    }

    @Override
    public FlowerDto deleteFlower(long id) {
        repository.deleteById(id);
        return null;
    }


}
