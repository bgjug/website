package bg.jug.website.core.model;

import javax.annotation.Generated;
import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Version
	private Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	


}

