package com.blackroot.movie.gallery.api.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Rol")
public class Rol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@Column(name = "code")
	private String code;
	
	@OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
	private Set<User> user;

	public Rol(Integer id, String name, String description, String code) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.code = code;
	}

	public Rol() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	@Override
	public String toString() {
		return "Rol [id=" + id + ", name=" + name + ", description=" + description + ", code=" + code + "]";
	}	

}
