package com.car_repair_shop.domain.service_order;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
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


    @Lob
    @ElementCollection
    private List<byte[]> prevImages;

    @Lob
    @ElementCollection
    private List<byte[]> afterImages;

    private LocalDate initialDate;
    private LocalDate finalDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;



    public void addPrevImage(byte[] image) {
        prevImages.add(image);
    }

    public void addAfterImage(byte[] image) {
        afterImages.add(image);
    }


    public void removePrevImage(int index) {
        prevImages.remove(index);
    }

    public void removeAfterImage(int index) {
        afterImages.remove(index);
    }

    public int getPrevImageCount() {
        return prevImages.size();
    }

    public int getAfterImageCount() {
        return afterImages.size();
    }


}
