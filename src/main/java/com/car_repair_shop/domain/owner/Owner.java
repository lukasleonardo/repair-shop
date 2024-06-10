package com.car_repair_shop.domain.owner;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.dtos.ownerDTO.OwnerRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "owners")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();;


    public Owner(OwnerRequestDTO ownerRequestDTO) {

        this.name = ownerRequestDTO.name();
        this.phone = ownerRequestDTO.phone();
        this.address = ownerRequestDTO.address();

    }


}

