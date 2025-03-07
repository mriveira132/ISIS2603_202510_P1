package co.edu.uniandes.dse.parcial1.entities;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import uk.co.jemos.podam.common.PodamExclude;

@Data
@Entity
public class ConciertoEntity extends BaseEntity {

    private String nombre;
    private String nombreArtista;
    private LocalDate fecha;
    private Long capacidadAforo;
    private Long presupuesto;


    @PodamExclude
    @ManyToOne
    private EstadioEntity estadio;
}
