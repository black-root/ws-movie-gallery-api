package com.blackroot.movie.gallery.api.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Movie")
public class Movie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", length = 8)
	private Integer id;

	@Column(name = "tittle")
	private String tittle;

	@Column(name = "description", nullable = true)
	private String description;

	@Column(name = "synopsis", nullable = true)
	private String synopsis;

	@Column(name = "url_image", nullable = true)
	private String image;

	@Column(name = "sale_price")
	private BigDecimal sale_price;

	@Column(name = "rent_price")
	private BigDecimal rent_price;

	@Column(name = "startdate_renting")
	private Date startdate_renting;

	@Column(name = "enddate_renting")
	private Date enddate_renting;

	@Column(name = "suspend_movie")
	private Date suspend_movie;

	@Column(name = "stock", nullable = false, length = 8)
	private Integer stock;

	@Column(name = "availability_status")
	private Boolean availabilityStatus;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private UserEntity user;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "percent_discount_rent_price_id")
	private PercentDiscount percent_discount_rent_price;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "percent_discount_sale_price_id")
	private PercentDiscount percent_discount_sale_price;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private MovieCategory category;

	
	
	
	public Movie(Movie movieCopy) {
		super();
		this.id = movieCopy.id;
		this.tittle = movieCopy.tittle;
		this.description = movieCopy.description;
		this.synopsis = movieCopy.synopsis;
		this.image = movieCopy.image;
		this.sale_price = movieCopy.sale_price;
		this.rent_price = movieCopy.rent_price;
		this.startdate_renting = movieCopy.startdate_renting;
		this.enddate_renting = movieCopy.enddate_renting;
		this.suspend_movie = movieCopy.suspend_movie;
		this.stock = movieCopy.stock;
		this.availabilityStatus = movieCopy.availabilityStatus;
		this.user = movieCopy.user;
		this.percent_discount_rent_price = movieCopy.percent_discount_rent_price;
		this.percent_discount_sale_price = movieCopy.percent_discount_sale_price;
		this.category = movieCopy.category;
	}

	public Movie(Integer id, String tittle, String description, String synopsis, String image, BigDecimal sale_price,
			BigDecimal rent_price, Date startdate_renting, Date enddate_renting, Date suspend_movie, Integer stock,
			Boolean availabilityStatus, UserEntity user, PercentDiscount percent_discount_rent_price,
			PercentDiscount percent_discount_sale_price, MovieCategory category) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.description = description;
		this.synopsis = synopsis;
		this.image = image;
		this.sale_price = sale_price;
		this.rent_price = rent_price;
		this.startdate_renting = startdate_renting;
		this.enddate_renting = enddate_renting;
		this.suspend_movie = suspend_movie;
		this.stock = stock;
		this.availabilityStatus = availabilityStatus;
		this.user = user;
		this.percent_discount_rent_price = percent_discount_rent_price;
		this.percent_discount_sale_price = percent_discount_sale_price;
		this.category = category;
	}

	public Movie() {
		super();
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public PercentDiscount getPercent_discount_rent_price() {
		return percent_discount_rent_price;
	}

	public void setPercent_discount_rent_price(PercentDiscount percent_discount_rent_price) {
		this.percent_discount_rent_price = percent_discount_rent_price;
	}

	public PercentDiscount getPercent_discount_sale_price() {
		return percent_discount_sale_price;
	}

	public void setPercent_discount_sale_price(PercentDiscount percent_discount_sale_price) {
		this.percent_discount_sale_price = percent_discount_sale_price;
	}

	public MovieCategory getCategory() {
		return category;
	}

	public void setCategory(MovieCategory category) {
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSypnopsis() {
		return synopsis;
	}

	public void setSypnopsis(String sypnopsis) {
		this.synopsis = sypnopsis;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getSale_price() {
		return sale_price;
	}

	public void setSale_price(BigDecimal sale_price) {
		this.sale_price = sale_price;
	}

	public BigDecimal getRent_price() {
		return rent_price;
	}

	public void setRent_price(BigDecimal rent_price) {
		this.rent_price = rent_price;
	}

	public Date getStartdate_renting() {
		return startdate_renting;
	}

	public void setStartdate_renting(Date startdate_renting) {
		this.startdate_renting = startdate_renting;
	}

	public Date getEnddate_renting() {
		return enddate_renting;
	}

	public void setEnddate_renting(Date enddate_renting) {
		this.enddate_renting = enddate_renting;
	}

	public Date getSuspend_movie() {
		return suspend_movie;
	}

	public void setSuspend_movie(Date suspend_movie) {
		this.suspend_movie = suspend_movie;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Boolean getAvailabilityStatus() {
		return availabilityStatus;
	}

	public void setAvailability_status(Boolean availability_status) {
		this.availabilityStatus = availability_status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availabilityStatus == null) ? 0 : availabilityStatus.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((enddate_renting == null) ? 0 : enddate_renting.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + ((percent_discount_rent_price == null) ? 0 : percent_discount_rent_price.hashCode());
		result = prime * result + ((percent_discount_sale_price == null) ? 0 : percent_discount_sale_price.hashCode());
		result = prime * result + ((rent_price == null) ? 0 : rent_price.hashCode());
		result = prime * result + ((sale_price == null) ? 0 : sale_price.hashCode());
		result = prime * result + ((startdate_renting == null) ? 0 : startdate_renting.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((suspend_movie == null) ? 0 : suspend_movie.hashCode());
		result = prime * result + ((synopsis == null) ? 0 : synopsis.hashCode());
		result = prime * result + ((tittle == null) ? 0 : tittle.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Movie other = (Movie) obj;
		if (availabilityStatus == null) {
			if (other.availabilityStatus != null)
				return false;
		} else if (!availabilityStatus.equals(other.availabilityStatus))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enddate_renting == null) {
			if (other.enddate_renting != null)
				return false;
		} else if (!enddate_renting.equals(other.enddate_renting))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (percent_discount_rent_price == null) {
			if (other.percent_discount_rent_price != null)
				return false;
		} else if (!percent_discount_rent_price.equals(other.percent_discount_rent_price))
			return false;
		if (percent_discount_sale_price == null) {
			if (other.percent_discount_sale_price != null)
				return false;
		} else if (!percent_discount_sale_price.equals(other.percent_discount_sale_price))
			return false;
		if (rent_price == null) {
			if (other.rent_price != null)
				return false;
		} else if (!rent_price.equals(other.rent_price))
			return false;
		if (sale_price == null) {
			if (other.sale_price != null)
				return false;
		} else if (!sale_price.equals(other.sale_price))
			return false;
		if (startdate_renting == null) {
			if (other.startdate_renting != null)
				return false;
		} else if (!startdate_renting.equals(other.startdate_renting))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (suspend_movie == null) {
			if (other.suspend_movie != null)
				return false;
		} else if (!suspend_movie.equals(other.suspend_movie))
			return false;
		if (synopsis == null) {
			if (other.synopsis != null)
				return false;
		} else if (!synopsis.equals(other.synopsis))
			return false;
		if (tittle == null) {
			if (other.tittle != null)
				return false;
		} else if (!tittle.equals(other.tittle))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", tittle=" + tittle + ", description=" + description + ", synopsis=" + synopsis
				+ ", image=" + image + ", sale_price=" + sale_price + ", rent_price=" + rent_price
				+ ", startdate_renting=" + startdate_renting + ", enddate_renting=" + enddate_renting
				+ ", suspend_movie=" + suspend_movie + ", stock=" + stock + ", availability_status="
				+ availabilityStatus + ", user=" + user + ", percent_discount_rent_price="
				+ percent_discount_rent_price + ", percent_discount_sale_price=" + percent_discount_sale_price
				+ ", category=" + category + "]";
	}

}
