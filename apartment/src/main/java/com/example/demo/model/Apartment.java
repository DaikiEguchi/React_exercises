package com.example.demo.model;

import java.util.Date;

import com.example.demo.data.ApartmentDataInterface;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="apartment")
public class Apartment implements ApartmentDataInterface {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="address", nullable = false)
	private String address;
	
	// 物件担当者
	@Column(name="salesrep", nullable = true)
	private String sales;
	
	@Column(name="floorarea", nullable = true)
	private float floorArea;
	
	@Column(name="registerdate", nullable = true)
	private Date registerDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

	public float getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(float floorArea) {
		this.floorArea = floorArea;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
}
