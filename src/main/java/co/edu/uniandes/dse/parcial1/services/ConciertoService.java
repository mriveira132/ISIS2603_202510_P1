package co.edu.uniandes.dse.parcial1.services;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.repositories.ConciertoRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConciertoService {
    @Autowired()
    private ConciertoRepository conciertoRepository;

    @Transactional
    public ConciertoEntity createConcierto(ConciertoEntity conciertoEntity){
        log.info("Creando Concierto");
        if(Duration.between(conciertoEntity.getFecha(), LocalDateTime.now()).isPositive()){
            throw new IllegalArgumentException("fecha invalida");
        }
        if(conciertoEntity.getCapacidadAforo() <10){
            throw new IllegalArgumentException("Falta gente mi rey");
        }
        if(conciertoEntity.getPresupuesto() <1000){
            throw new IllegalArgumentException("falta plata mi rey");
        }
        conciertoRepository.save(conciertoEntity);  
        return conciertoEntity;

    }


    // Complete

}
