package com.example.library.services;

import com.example.library.dto.request.PbHouseUpdateDTO;
import com.example.library.dto.response.PbHouseGetResponseDTO;
import com.example.library.entities.PublishingHouse;
import com.example.library.repossitory.PublishingHouseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PublishingHouseService {

    private final PublishingHouseRepository publishingHouseRepository;
    private final ModelMapper mapper;

    public PublishingHouseService(PublishingHouseRepository publishingHouseRepository, ModelMapper mapper) {
        this.publishingHouseRepository = publishingHouseRepository;
        this.mapper = mapper;
    }

    // bütün yayınevlerini getirme
    public List<PbHouseGetResponseDTO> getAllPbHouse() {
        List<PublishingHouse> publishingHouses = publishingHouseRepository.findAll();
        List<PbHouseGetResponseDTO> pbHouseGetResponse = new ArrayList<>();

        publishingHouses.forEach(pbHouse -> {
            pbHouseGetResponse.add(mapper.map(pbHouse,PbHouseGetResponseDTO.class));
        });
        return pbHouseGetResponse;
    }

    // id'ye göre yayınevi getirme
    public PbHouseGetResponseDTO getPbHouseById(Long id) {
        Optional<PublishingHouse> foundPbHouse = publishingHouseRepository.findById(id);
        if (foundPbHouse.isPresent()) {
            PbHouseGetResponseDTO responseDTO = mapper.map(foundPbHouse.get(), PbHouseGetResponseDTO.class);
            return responseDTO;
        } else {
            return null;
        }
    }

    // bir model veri tabanına eklenirken tüm alanların eklenmesi gerekir bu durumda bütün alanları getirmek için aşağıdaki metod kullanılır.
    public PublishingHouse getPbHouseAllFieldById(Long id) {
        Optional<PublishingHouse> foundPbHouse = publishingHouseRepository.findById(id);
        if (foundPbHouse.isPresent()) {
            return foundPbHouse.get();
        } else {
            return null;
        }
    }

    // yayınevi ekleme
    public PublishingHouse addPbHouse(PublishingHouse pbHosue){
        return publishingHouseRepository.save(pbHosue);
    }

    /*
    yayınevi güncelleme güncellerken sadece adres, telefon ve site bilgileri güncellenir.
     */
    public PublishingHouse updatePbHouseById(Long id, PbHouseUpdateDTO updateDTO){
        Optional<PublishingHouse> foundWriter = publishingHouseRepository.findById(id);
        if (foundWriter.isPresent()){
            PublishingHouse pbHouse = foundWriter.get();
            mapper.map(updateDTO,pbHouse);
            return publishingHouseRepository.save(pbHouse);
        }else {
            return null;
        }
    }

    // yayınevi silme
    public void deleteById(Long id) {
        publishingHouseRepository.deleteById(id);
    }
}
