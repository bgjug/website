package bg.jug.website.producer;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer
{
    @PersistenceContext(name = "jug-website-persistence-unit")
    private EntityManager entityManagerProxy;

    @Produces
    public EntityManager defaultEntityManager()
    {
        return entityManagerProxy;
    }
}
