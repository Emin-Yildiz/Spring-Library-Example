package com.example.library.controller;

import com.example.library.dto.request.PbHouseUpdateDTO;
import com.example.library.dto.response.PbHouseGetResponseDTO;
import com.example.library.entities.PublishingHouse;
import com.example.library.services.PublishingHouseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PbHouseGetResponseDTO>> getAllPbHouse(){
        return ResponseEntity.ok(pbHouseService.getAllPbHouse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PbHouseGetResponseDTO> getPbHouseById(@PathVariable Long id){
        return ResponseEntity.ok(pbHouseService.getPbHouseById(id));
    }

    @PostMapping
    public ResponseEntity<PublishingHouse> addPbHouse(@RequestBody PublishingHouse pbHouse){
        return new ResponseEntity<>(pbHouseService.addPbHouse(pbHouse), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublishingHouse> updatePbHouse(@PathVariable Long id, @RequestBody PbHouseUpdateDTO updateDTO){
        return new ResponseEntity<>(pbHouseService.updatePbHouseById(id, updateDTO),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePbHouse(@PathVariable Long id){
        pbHouseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
