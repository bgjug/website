package bg.jug.website.cms.model;

import bg.jug.website.core.model.AbstractEntity;
import bg.jug.website.taxonomy.model.Tag;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Event extends Article {

	public static final String FIND_ALL = "SELECT e FROM Event e LEFT JOIN FETCH e.author ORDER BY a.eventDate DESC";
	public static final String FIND_ALL_BY_TAG = "SELECT e FROM Event e JOIN e.tags t WHERE t.name = ?1 ORDER BY a.eventDate DESC";

	@NotNull
	@Size(min=1, max=250)
	private String location;

	private LocalDateTime eventDate = LocalDateTime.now();

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}
}
