package com.sshhw.core;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "sshhw", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String agname;
	private Float score;
	private Timestamp registerTime;
	private Set<Blog> blogs = new HashSet<Blog>(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password, String agname,
			Timestamp registerTime) {
		this.username = username;
		this.password = password;
		this.agname = agname;
		this.registerTime = registerTime;
	}

	/** full constructor */
	public User(String username, String password, String agname, Float score,
			Timestamp registerTime, Set<Blog> blogs) {
		this.username = username;
		this.password = password;
		this.agname = agname;
		this.score = score;
		this.registerTime = registerTime;
		this.blogs = blogs;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "agname", nullable = false, length = 50)
	public String getAgname() {
		return this.agname;
	}

	public void setAgname(String agname) {
		this.agname = agname;
	}

	@Column(name = "score", precision = 12, scale = 0)
	public Float getScore() {
		return this.score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Column(name = "registerTime", nullable = false, length = 19)
	public Timestamp getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Blog> getBlogs() {
		return this.blogs;
	}

	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}

}