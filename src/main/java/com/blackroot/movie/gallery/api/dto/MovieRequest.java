package com.blackroot.movie.gallery.api.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MovieRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String tittle;

	private String description;

	private String url_image;

	private Integer categoryId;

	private BigDecimal sale_price;

	private Integer percent_discount_sale_price_id;

	private Integer percent_discount_rent_price_id;

	private Date startdate_renting;

	private Date enddate_renting;

	private Integer stock;

	private BigDecimal rent_price;

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

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public BigDecimal getSale_price() {
		return sale_price;
	}

	public void setSale_price(BigDecimal sale_price) {
		this.sale_price = sale_price;
	}

	public Integer getPercent_discount_sale_price_id() {
		return percent_discount_sale_price_id;
	}

	public void setPercent_discount_sale_price_id(Integer percent_discount_sale_price_id) {
		this.percent_discount_sale_price_id = percent_discount_sale_price_id;
	}

	public Integer getPercent_discount_rent_price_id() {
		return percent_discount_rent_price_id;
	}

	public void setPercent_discount_rent_price_id(Integer percent_discount_rent_price_id) {
		this.percent_discount_rent_price_id = percent_discount_rent_price_id;
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getRent_price() {
		return rent_price;
	}

	public void setRent_price(BigDecimal rent_price) {
		this.rent_price = rent_price;
	}

	@Override
	public String toString() {
		return "MovieRequest [id=" + id + ", tittle=" + tittle + ", description=" + description + ", url_image="
				+ url_image + ", categoryId=" + categoryId + ", sale_price=" + sale_price
				+ ", percent_discount_sale_price_id=" + percent_discount_sale_price_id
				+ ", percent_discount_rent_price_id=" + percent_discount_rent_price_id + ", startdate_renting="
				+ startdate_renting + ", enddate_renting=" + enddate_renting + ", stock=" + stock + ", rent_price="
				+ rent_price + "]";
	}

}
