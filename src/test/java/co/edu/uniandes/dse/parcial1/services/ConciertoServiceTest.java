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
import jakarta.transaction.Transactional;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@Transactional
@Import({ConciertoService.class})
class ConciertoServiceTest {
    @Autowired()
    private ConciertoService conciertoService;
    private PodamFactory factory = new PodamFactoryImpl();
    private ConciertoEntity conciertodos;
    @Autowired
	private TestEntityManager entityManager;
    public ConciertoService getConciertoService() {
        return conciertoService;
    }
    public void setConciertoService(ConciertoService conciertoService) {
        this.conciertoService = conciertoService;
    }
    public PodamFactory getFactory() {
        return factory;
    }
    public void setFactory(PodamFactory factory) {
        this.factory = factory;
    }
    public ConciertoEntity getConciertodos() {
        return conciertodos;
    }
    public void setConciertodos(ConciertoEntity conciertodos) {
        this.conciertodos = conciertodos;
    }
    public TestEntityManager getEntityManager() {
        return entityManager;
    }
    public void setEntityManager(TestEntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Test
    public void createConciertoTest() throws IllegalArgumentException {
        ConciertoEntity concierto = factory.manufacturePojo(ConciertoEntity.class);
        entityManager.persist(concierto);
        
        ConciertoEntity createdConcierto = conciertoService.createConcierto(concierto);
        
        assertNotNull(createdConcierto);
        assertNotNull(createdConcierto.getId());
        assertEquals(concierto.getNombre(), createdConcierto.getNombre());
        entityManager.remove(concierto);
    }
    
    

}
