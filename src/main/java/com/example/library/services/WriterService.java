package com.example.library.services;

import com.example.library.dto.request.WriterUpdateDTO;
import com.example.library.dto.response.WriterResponseDTO;
import com.example.library.entities.Writer;
import com.example.library.repossitory.WriterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WriterService{

    private final WriterRepository writerRepository;
    private final ModelMapper mapper;

    public WriterService(WriterRepository writerRepository,ModelMapper mapper) {
        this.writerRepository = writerRepository;
        this.mapper = mapper;
    }

    // bütün yazarları getirme
    public List<WriterResponseDTO> getAllWriter() {
        List<Writer> writers = writerRepository.findAll();
        List<WriterResponseDTO> writerResponse =new ArrayList<>();

        writers.forEach(writer -> {
            writerResponse.add(mapper.map(writer,WriterResponseDTO.class));
        });

        return writerResponse;
    }

    // Arayüzde yazarın sadece ismi ve telefon bilgisinin gözükmesin için
    public WriterResponseDTO getWriterById(Long id) {
        Optional<Writer> foundWriter = writerRepository.findById(id);
        if (foundWriter.isPresent()) {
            WriterResponseDTO responseDTO = mapper.map(foundWriter.get(), WriterResponseDTO.class);
            return responseDTO;
        } else {
            return null;
        }
    }

    // yazarla ilgili bütün alanları getiren metod
    public Writer getWriterAllFieldById(Long id){
        Optional<Writer> foundWriter = writerRepository.findById(id);
        if (foundWriter.isPresent()) {
            return foundWriter.get();
        } else {
            return null;
        }
    }

    // yazar ekleme metodu
    public Writer addWriter(Writer writer){
        return writerRepository.save(writer);
    }

    /*
     verilen id bilgisine göre yazarı güncelleme
     güncelleme yaparken saece telefon ve site alanlarının güncellenmesine izin verilir.
     */
    public Writer updateWriterById(Long id, WriterUpdateDTO updateDTO){
        Optional<Writer> foundWriter = writerRepository.findById(id);
        if (foundWriter.isPresent()){
            Writer writer = foundWriter.get();
            mapper.map(updateDTO,writer);
            return writerRepository.save(writer);
        }else {
            return null;
        }
    }

    // id'ye göre yazar silme
    public void deleteById(Long id) {
        writerRepository.deleteById(id);
    }
}