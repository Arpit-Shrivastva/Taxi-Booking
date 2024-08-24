package com.example.Taxi_Booking.Services;

import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.Taxi_Booking.Models.ServiceForm;
import com.example.Taxi_Booking.Repository.ServiceFromRepository;

import jakarta.transaction.Transactional;

@Service
public class ServiceFormServiceImpl implements ServiceFormService {

    private final ServiceFromRepository serviceFromRepository;

    @Autowired
    public ServiceFormServiceImpl(ServiceFromRepository serviceFromRepository) {
        this.serviceFromRepository = serviceFromRepository;
    }

    @Transactional(rollbackOn = Exception.class)
    @Override
    public ServiceForm addService(ServiceForm serviceForm, MultipartFile multipartFile) {
        ServiceForm save = null;
        try {
            save = serviceFromRepository.save(serviceForm);

            if (save != null) {
                String path = "D:\\Coding Practice\\Taxi-Booking\\src\\main\\resources\\static\\myserviceimg\\"
                        + multipartFile.getOriginalFilename();
                byte[] bytes = multipartFile.getBytes();

                FileOutputStream fos = new FileOutputStream(path);
                fos.write(bytes);

            }

        } catch (Exception e) {
            save = null;
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<ServiceForm> readAllServices() {
        return serviceFromRepository.findAll();
    }

}
