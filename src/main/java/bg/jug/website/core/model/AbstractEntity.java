package bg.jug.website.core.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public abstract class AbstractEntity extends PanacheEntity  {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator="entitySeq")
//    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
