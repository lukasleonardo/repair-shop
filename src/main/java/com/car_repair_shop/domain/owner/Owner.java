package com.car_repair_shop.domain.owner;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.dtos.OwnerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "owners")
@Data
@AllArgsConstructor
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String address;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Car> cars = new ArrayList<>();;


    public Owner(OwnerDTO ownerDTO) {

        this.name = ownerDTO.name();
        this.phone = ownerDTO.phone();
        this.address = ownerDTO.address();

    }
}

