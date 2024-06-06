package com.car_repair_shop.service;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;
import com.car_repair_shop.domain.service_order.ServiceOrder;
import com.car_repair_shop.dtos.ServiceOrderDTO;
import com.car_repair_shop.repository.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private CarService carService;

    @Transactional
    public ServiceOrder createServiceOrder(ServiceOrderDTO serviceOrderDTO) throws Exception {
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setDescription(serviceOrderDTO.description());
        serviceOrder.setInitialDate(LocalDate.now());


        Owner ownerOptional = ownerService.findOwnerById(serviceOrderDTO.owner_id());
        if (ownerOptional!=null) {
            serviceOrder.setOwner(ownerOptional);
        } else {
            throw new RuntimeException("Proprietário não encontrado");
        }

        Car carOptional = carService.findCarById(serviceOrderDTO.car_id());
        if (carOptional!=null) {
            serviceOrder.setCar(carOptional);
        } else {
            throw new RuntimeException("Carro não encontrado");
        }


        for (MultipartFile file : serviceOrderDTO.prevImages()) {
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "jpg", baos);
            baos.flush();
            serviceOrder.addPrevImage(baos.toByteArray());
            baos.close();
        }


        return  serviceOrder;
    }

    public ServiceOrder FindById(Long id) throws Exception {
        ServiceOrder serviceOrder = this.serviceOrderRepository.findById(id).orElseThrow(()-> new Exception("Ordem de serviço não Encontrada"));
        return serviceOrder;
    }

    public List<ServiceOrder> FindAll(){
        return this.serviceOrderRepository.findAll();
    }


    public void deleteOrderById(Long id){
        this.serviceOrderRepository.deleteById(id);
    }





}
