package co.edu.uniandes.dse.parcial1.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;
import co.edu.uniandes.dse.parcial1.repositories.ConciertoRepository;
import co.edu.uniandes.dse.parcial1.repositories.EstadioRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ConciertoEstadioService {

    @Autowired()
    private ConciertoRepository conciertoRepository;

    @Autowired()
    private EstadioRepository estadioRepository;

    @Transactional()
    public EstadioEntity addConiertowithEstadio(Long conciertoId, Long estadioId){
        Optional<ConciertoEntity> concierto = conciertoRepository.findById(conciertoId);
        Optional<EstadioEntity> estadio = estadioRepository.findById(estadioId);
        if(concierto.get().getCapacidadAforo() > estadio.get().getCapacidadMaxima()){
            throw new IllegalArgumentException("no se puede rey");
        }
        if(estadio.get().getPrecioAlquiler() > concierto.get().getPresupuesto()){
            throw new IllegalArgumentException("mucha plata rey");
        }
        estadio.get().getConciertos().add(concierto.get());
        concierto.get().setEstadio(estadio.get());
        estadioRepository.save(estadio.get());
        conciertoRepository.save(concierto.get());


        return estadio.get();


    // Complete
    }
}
