package com.blackroot.movie.gallery.api.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PercentDiscount")
public class PercentDiscount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "percent")
	private Short percent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getPercent() {
		return percent;
	}

	public void setPercent(Short percent) {
		this.percent = percent;
	}

	public PercentDiscount(Integer id, Short percent) {
		super();
		this.id = id;
		this.percent = percent;
	}

	public PercentDiscount() {
		super();
	}

	@Override
	public String toString() {
		return "PercentDiscount [id=" + id + ", percent=" + percent + "]";
	}
	
}
