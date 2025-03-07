package co.edu.uniandes.dse.parcial1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;
import co.edu.uniandes.dse.parcial1.repositories.EstadioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EstadioService {
    @Autowired()
    private EstadioRepository estadioRepository;
    @Transactional
    public EstadioEntity createEstadio(EstadioEntity estadioEntity){
        log.info("creando estadio rey");
        if(estadioEntity.getCiudad().length() < 4){
            throw new IllegalArgumentException("no vale esta ciudad rey");
        }
        if(estadioEntity.getCapacidadMaxima() < 1000){
            throw new IllegalArgumentException("consiguete un estadio de verdad ");
        }
        if(estadioEntity.getPrecioAlquiler() < 100000){
            throw new IllegalArgumentException("falta plata rey");
        }
        
        
        
        estadioRepository.save(estadioEntity);
        return estadioEntity;
        
    }

    // Complete

}
