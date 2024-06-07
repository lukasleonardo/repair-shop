package com.car_repair_shop.service;

import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.ownerDTO.OwnerDTO;
import com.car_repair_shop.exception.OwnerNotFoundException;
import com.car_repair_shop.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner createOwner(OwnerDTO ownerDTO){
        Owner owner = new Owner(ownerDTO);
        return owner;
    }

    public Owner findOwnerById(Long id) throws Exception {
        Owner owner = this.ownerRepository.findById(id).orElseThrow(OwnerNotFoundException::new);
        return owner;
    }

    public List<Owner> findAllOwners(){
        List<Owner> owners = this.ownerRepository.findAll();
        return owners;
    }

    public void deleteOwnerById(Long id){
        this.ownerRepository.deleteById(id);
    }


}
