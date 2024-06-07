package com.car_repair_shop.domain.service_order;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "service_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;



    private List<String> prevImages;
    private List<String> afterImages;

    private LocalDate initialDate;
    private LocalDate finalDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;





}
