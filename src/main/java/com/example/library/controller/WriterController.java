package com.example.library.controller;

import com.example.library.dto.request.WriterUpdateDTO;
import com.example.library.dto.response.WriterResponseDTO;
import com.example.library.entities.Writer;
import com.example.library.services.WriterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/writer")
public class WriterController {

    private final WriterService writerService;


    public WriterController(WriterService writerService){
        this.writerService = writerService;
    }


    @GetMapping
    public ResponseEntity<List<WriterResponseDTO>> getAllWriter(){
        return ResponseEntity.ok(writerService.getAllWriter());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WriterResponseDTO> getWriterById(@PathVariable Long id){
        return ResponseEntity.ok(writerService.getWriterById(id));
    }

    @PostMapping
    public Writer addWriter(@RequestBody Writer writer){
        return writerService.addWriter(writer);
    }

    @PutMapping("/{id}")
    public Writer updateWritter(@PathVariable Long id, @RequestBody WriterUpdateDTO updateDTO){
        return writerService.updateWriterById(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteWritter(@PathVariable Long id){
        writerService.deleteById(id);
    }
}
