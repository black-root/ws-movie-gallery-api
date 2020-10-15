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
@Table(name = "PercentDiscount")
public class PercentDiscount implements Serializable {

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
	
	@OneToMany(mappedBy = "percent_discount_sale_price", fetch = FetchType.LAZY)
	private Set<Movie> movie;
	
	@OneToMany(mappedBy = "percent_discount_rent_price", fetch = FetchType.LAZY)
	private Set<Movie> movie2;

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

	public PercentDiscount(Integer percentId) {
		this.id =  percentId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((percent == null) ? 0 : percent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PercentDiscount other = (PercentDiscount) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (percent == null) {
			if (other.percent != null)
				return false;
		} else if (!percent.equals(other.percent))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PercentDiscount [id=" + id + ", percent=" + percent + "]";
	}

}
