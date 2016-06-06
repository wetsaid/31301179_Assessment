package com.sshhw.core;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Blog entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "blog", catalog = "sshhw")
public class Blog implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private String title;
	private String context;
	private Timestamp publishTime;

	// Constructors

	/** default constructor */
	public Blog() {
	}

	/** minimal constructor */
	public Blog(User user) {
		this.user = user;
	}

	/** full constructor */
	public Blog(User user, String title, String context, Timestamp publishTime) {
		this.user = user;
		this.title = title;
		this.context = context;
		this.publishTime = publishTime;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "title", length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "context", length = 8000)
	public String getContext() {
		return this.context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Column(name = "publishTime", length = 19)
	public Timestamp getPublishTime() {
		return this.publishTime;
	}

	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}

}