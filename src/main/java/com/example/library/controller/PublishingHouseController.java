package com.example.library.controller;

import com.example.library.dto.request.PbHouseUpdateDTO;
import com.example.library.dto.response.PbHouseGetResponseDTO;
import com.example.library.entities.PublishingHouse;
import com.example.library.services.PublishingHouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pb_house")
public class PublishingHouseController {

    private final PublishingHouseService pbHouseService;


    public PublishingHouseController(PublishingHouseService pbHouseService){
        this.pbHouseService = pbHouseService;
    }

    @GetMapping
    public List<PbHouseGetResponseDTO> getAllPbHouse(){
        return pbHouseService.getAllPbHouse();
    }

    @GetMapping("/{id}")
    public PbHouseGetResponseDTO getPbHouseById(@PathVariable Long id){
        return pbHouseService.getPbHouseById(id);
    }

    @PostMapping
    public PublishingHouse addPbHouse(@RequestBody PublishingHouse pbHouse){
        return pbHouseService.addPbHouse(pbHouse);
    }

    @PutMapping("/{id}")
    public PublishingHouse updatePbHouse(@PathVariable Long id, @RequestBody PbHouseUpdateDTO updateDTO){
        return pbHouseService.updatePbHouseById(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void deletePbHouse(@PathVariable Long id){
        pbHouseService.deleteById(id);
    }

}
