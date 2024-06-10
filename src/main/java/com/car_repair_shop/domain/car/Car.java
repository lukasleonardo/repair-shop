package com.car_repair_shop.domain.car;

import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.carDTO.CarRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String plate;
    private String brand;
    private String model;
    private String color;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Car(CarRequestDTO carRequestDTO, Owner owner) {

            this.plate = carRequestDTO.plate();
            this.brand = carRequestDTO.brand();
            this.model = carRequestDTO.model();
            this.color = carRequestDTO.color();
            setOwner(owner);
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
        if (owner != null && !owner.getCars().contains(this)) {
            owner.addCar(this);
        }
    }
}
