package com.car_repair_shop.domain.service_order;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "service_orders")
@Data
@AllArgsConstructor
public class ServiceOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;


    @Lob
    private List<byte[]> prevImages;

    @Lob
    private List<byte[]> afterImages;

    private Timestamp initialDate;
    private Timestamp finalDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;



    public void addPrevImage(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        baos.flush();
        prevImages.add(baos.toByteArray());
        baos.close();
    }

    public void addAfterImage(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        baos.flush();
        afterImages.add(baos.toByteArray());
        baos.close();
    }

    public BufferedImage getPrevImage(int index) throws IOException {
        byte[] imageData = prevImages.get(index);
        return ImageIO.read(new ByteArrayInputStream(imageData));
    }

    public BufferedImage getAfterImage(int index) throws IOException {
        byte[] imageData = afterImages.get(index);
        return ImageIO.read(new ByteArrayInputStream(imageData));
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
