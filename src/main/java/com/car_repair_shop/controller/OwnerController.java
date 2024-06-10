package com.car_repair_shop.controller;

import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtoMappers.OwnerDTOMapper;
import com.car_repair_shop.dtos.ownerDTO.OwnerRequestDTO;
import com.car_repair_shop.dtos.ownerDTO.OwnerResponseDTO;
import com.car_repair_shop.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public ResponseEntity<OwnerResponseDTO> createOwner(@RequestBody OwnerRequestDTO ownerRequestDTO){
        Owner owner = this.ownerService.createOwner(ownerRequestDTO);
        OwnerResponseDTO ownerResponse = OwnerDTOMapper.toDTO(owner);
        return ResponseEntity.ok(ownerResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerResponseDTO> findOwnerById(@PathVariable Long id){
         Owner owner = this.ownerService.findOwnerById(id);
        OwnerResponseDTO ownerResponse = OwnerDTOMapper.toDTO(owner);
        return ResponseEntity.ok(ownerResponse);
    }

    @GetMapping
    public ResponseEntity<List<OwnerResponseDTO>> findAllOwners(){
        List<OwnerResponseDTO> owners = this.ownerService.findAllOwners();
        return ResponseEntity.ok(owners);
    }

    @DeleteMapping("/{id}")
    public void deleteOwnerById(@PathVariable  Long id){
        this.ownerService.deleteOwnerById(id);
    }

}
