package com.example.demo.data;

import java.util.Date;

public interface ApartmentDataInterface {
	public int getId();
	public void setId(int id);
	public String getName();
	public void setName(String name);
	public String getAddress();
	public void setAddress(String address);
	public String getSales();
	public void setSales(String sales);
	public float getFloorArea();
	public void setFloorArea(float floorArea);
	public Date getRegisterDate();
	public void setRegisterDate(Date registerDate);
}
