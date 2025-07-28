package edu.unl.cc.roomvibe.bussiness.services;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import edu.unl.cc.roomvibe.domain.common.Reserva;
import java.io.Serializable;
import java.util.List;

/**
 * @author Steeven Pardo, Juan Calopino, Royel Jima, Daniel Savedra
 * @version 1.0
 */

@ApplicationScoped
public class ReservaService implements Serializable {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private CrudGenericService crudService;

    @Transactional
    public void save(Reserva reserva) {
        System.out.println("Guardando reserva: " + reserva);
        crudService.create(reserva);
    }

    @Transactional
    public void update(Reserva reserva) {
        em.merge(reserva);
    }

    public List<Reserva> findAll() {
        return crudService.findWithQuery("SELECT r FROM Reserva r");
    }

    public Reserva findByCodigo(String codigo) {
        String sql = "SELECT * FROM RESERVA WHERE codigo LIKE ?";
        Query query = crudService.createNativeQuery(sql, Reserva.class);
        query.setParameter(1, codigo);
        Reserva reserva = (Reserva) crudService.findSingleResultOrNullWithQuery(query);
        if (reserva != null) {
            return reserva;
        }
        throw new EntityNotFoundException("Reserva no encontrada con código [" + codigo + "]");
    }

    public List<Reserva> buscarPorCriterio(String criterio) {
        String filtro = (criterio != null && !criterio.isEmpty())
                ? "%" + criterio.toLowerCase() + "%"
                : "%";

        return crudService.findWithNamedQuery("Reserva.buscarPorCriterio", java.util.Map.of("criterio", filtro));
    }

    public Reserva findById(Long id) {
        return em.find(Reserva.class, id);

    }
}

/*
    @PostConstruct
    public void init() {
        System.out.println("EntityManager inyectado: " + (em != null));
    }
*/

