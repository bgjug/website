package bg.jug.website.core;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {

    @PersistenceContext(name = "jug-website-pu")
    private EntityManager entityManagerProxy;

    @Produces
    public EntityManager defaultEntityManager() {
        return entityManagerProxy;
    }

    public void close(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }

}
