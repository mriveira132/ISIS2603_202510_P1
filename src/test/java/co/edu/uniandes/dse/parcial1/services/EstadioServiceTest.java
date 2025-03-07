package co.edu.uniandes.dse.parcial1.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.uniandes.dse.parcial1.entities.ConciertoEntity;
import co.edu.uniandes.dse.parcial1.entities.EstadioEntity;
import co.edu.uniandes.dse.parcial1.services.EstadioService;
import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import({EstadioService.class})
public class EstadioServiceTest {
    @Autowired()
    private EstadioService estadioService;
    private PodamFactory factory = new PodamFactoryImpl();
    private EstadioEntity estadiodos;
    @Autowired
	private TestEntityManager entityManager;
    @Test
    public void createEstadioTest() throws IllegalArgumentException {
        EstadioEntity estadio = factory.manufacturePojo(EstadioEntity.class);
        entityManager.persist(estadio);
        
        EstadioEntity createdEstadio = estadioService.createEstadio(estadio);
        
        assertNotNull(createdEstadio);
        assertNotNull(createdEstadio.getId());
        assertEquals(estadio.getNombre(), createdEstadio.getNombre());
        entityManager.remove(estadio);

    }

}
