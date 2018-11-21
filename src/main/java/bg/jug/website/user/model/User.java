package bg.jug.website.user.model;

import bg.jug.website.core.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity {
	
	private String nickname;

	@NotNull
	@Size(min = 1, max = 500)
	private String fullname;
	
	@Size(min = 1, max = 500)
	@NotNull
	private String email;
	
	@Lob
	private byte[] photo;
	
	@Size(min = 1, max = 1000)
	private String bio;
	
	@NotNull
	private String password;
	
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
}
