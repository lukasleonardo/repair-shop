package com.car_repair_shop.dtoMappers;


import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.ownerDTO.OwnerResponseDTO;

public class OwnerDTOMapper {

    //Recebendo uma Resposta e Transformando em entidade para ser Usada pela API.
    public static Owner toEntity(OwnerResponseDTO ownerResponseDTO) {
        Owner owner = new Owner();
        owner.setName(ownerResponseDTO.name());
        owner.setPhone(ownerResponseDTO.phone());
        owner.setAddress(ownerResponseDTO.address());
        return owner;
    }

    public static OwnerResponseDTO toDTO(Owner owner) {
        return new OwnerResponseDTO(
                owner.getId(),
                owner.getName(),
                owner.getPhone(),
                owner.getAddress()

        );
    }

}
