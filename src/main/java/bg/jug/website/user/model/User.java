package bg.jug.website.user.model;

import bg.jug.website.core.model.AbstractEntity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collections;
import java.util.List;

@Entity
public class User extends AbstractEntity {

	private final static String DEFAULT_ROLE = "reader";
	
	private String nickname;

	private String fullname;

	@JsonbTransient
	private String email;
	
	@Lob
	@JsonbTransient
	private byte[] photo;

	@JsonbTransient
	private String bio;

	@JsonbTransient
	private String password;

	@JsonbTransient
	private String salt;

	@ElementCollection
	@JsonbTransient
	private List<String> roles;

	public User() {
	}

	public User(String email, String password, String salt) {
		this(null, null, email, null, null, password, salt,
				Collections.singletonList(DEFAULT_ROLE));
	}

	public User(String nickname, String fullname, String email, byte[] photo,
				String bio, String password, String salt, List<String> roles) {
		this.nickname = nickname;
		this.fullname = fullname;
		this.email = email;
		this.photo = photo;
		this.bio = bio;
		this.password = password;
		this.salt = salt;
		this.roles = roles;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
