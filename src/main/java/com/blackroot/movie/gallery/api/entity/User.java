package com.blackroot.movie.gallery.api.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "User")
public class User implements Serializable{

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
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phones", nullable = true)
	private String phones;
	
	@Column(name = "address", nullable = true)
	private String address;
	
	//Document column could be such as; DUI, NIT, etc
	@Column(name = "document", nullable = true)
	private String document;
	
	//The picture file supposes to be storaged in a bucket
	@Column(name = "url_picture", nullable = true)
	private String url_picture;
	
	@JsonIgnore
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "birthdate", nullable = true)
	private Date birthdate;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rol_id")
	private Rol rol;
	
	public User() {
		super();
	}


	public User(Integer id, String name, String lastname, String email, String phones, String address, String document,
			String url_picture, String password, Date birthdate, Rol rol) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.phones = phones;
		this.address = address;
		this.document = document;
		this.url_picture = url_picture;
		this.password = password;
		this.birthdate = birthdate;
		this.rol = rol;
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


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhones() {
		return phones;
	}


	public void setPhones(String phones) {
		this.phones = phones;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getDocument() {
		return document;
	}


	public void setDocument(String document) {
		this.document = document;
	}


	public String getUrl_picture() {
		return url_picture;
	}


	public void setUrl_picture(String url_picture) {
		this.url_picture = url_picture;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}


	public Rol getRol() {
		return rol;
	}


	public void setRol(Rol rol) {
		this.rol = rol;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", phones="
				+ phones + ", address=" + address + ", document=" + document + ", url_picture=" + url_picture
				+ ", password=" + password + ", birthdate=" + birthdate + ", rol=" + rol + "]";
	}
	
	
}
