package com.car_repair_shop.service;

import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.ownerDTO.OwnerRequestDTO;
import com.car_repair_shop.dtos.ownerDTO.OwnerResponseDTO;
import com.car_repair_shop.exception.NotFoundException;
import com.car_repair_shop.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner createOwner(OwnerRequestDTO ownerRequestDTO){
        Owner owner = new Owner(ownerRequestDTO);
        return this.ownerRepository.save(owner);
    }

    public Owner findOwnerById(Long id) throws NotFoundException {
        return this.ownerRepository.findById(id).orElseThrow(()-> new NotFoundException("Proprietário não encontrado com ID: "+id));
    }

    public List<OwnerResponseDTO> findAllOwners(){
        return this.ownerRepository.findAll().stream().map(OwnerResponseDTO::new).toList();
    }

    public void deleteOwnerById(Long id){
        this.ownerRepository.deleteById(id);
    }


}
