/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.usa.Servicio;

import com.usa.Repositorio.CloudRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usa.Modelo.Cloud;
/**
 *
 * @author USUARIO
 */

@Service

public class CloudService {
      @Autowired
    private CloudRepository cloudRepository;
    
    public List<Cloud> getAll(){
        return cloudRepository.getAll();
    }
    
    public Optional<Cloud> getCloud(int id){
        return cloudRepository.getCloud(id);
    }
    
    public Cloud save (Cloud cloud){
        if (cloud.getId() == null){
            return cloudRepository.save(cloud);
        } else {
            Optional<Cloud> cloud1 = cloudRepository.getCloud(cloud.getId());
            if(cloud1.isEmpty()){
                return cloudRepository.save(cloud);
            } else {
                return cloud;
            }
        }
    }
}
