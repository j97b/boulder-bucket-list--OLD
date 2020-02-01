package com.bae.persistence.domain;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String hashedPassword;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Set<Boulder> boulders;

	public User() {
		super();
	}

	public User(String username, String hashedPassword) {
		super();
		this.username = username;
		this.hashedPassword = hashedPassword;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Boulder> getBoulders() {
		return boulders;
	}

	public void setBoulders(Set<Boulder> boulders) {
		this.boulders = boulders;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHashedPassword() { return hashedPassword; }

	public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword; }

	@Override
	public int hashCode() {
		return Objects.hash(id, username, hashedPassword, boulders);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof User)) return false;
		User user = (User) o;
		return getId() == user.getId() &&
				getUsername().equals(user.getUsername()) &&
				getHashedPassword().equals(user.getHashedPassword()) &&
				Objects.equals(getBoulders(), user.getBoulders());
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", boulders=" + boulders + ", username=" + username +
				", hashedPassword=" + hashedPassword + "]";
	}

}
