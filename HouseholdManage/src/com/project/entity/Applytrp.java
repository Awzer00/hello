package com.project.entity;

import java.io.Serializable;
/**
 * 
 * applytrp 实体类
 * Fri May 04 17:08:39 CST 2018
 * @author 白明 
 * 
 */ 
public class Applytrp implements Serializable{
	private int id;
	private String idcard;
	private String name;
	private String natives;
	private String address;
	private String date;
	private String endDate;
	private String status;

	public Applytrp(){
		super();
	}

	public Applytrp(int id,String idcard,String name,String natives,String address,String date,String endDate,String status){
		super();
		this.id=id;
		this.idcard=idcard;
		this.name=name;
		this.natives=natives;
		this.address=address;
		this.date=date;
		this.endDate=endDate;
		this.status=status;
	}

	@Override
	public String toString(){
		return "Applytrp [id=" + id + ", idcard=" + idcard + ", name=" + name + ", natives=" + natives + ", address=" + address + ", date=" + date + ", endDate=" + endDate + ", status=" + status + "]";
	}

	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public void setIdcard(String idcard){
		this.idcard=idcard;
	}

	public String getIdcard(){
		return idcard;
	}

	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return name;
	}

	public void setNatives(String natives){
		this.natives=natives;
	}

	public String getNatives(){
		return natives;
	}

	public void setAddress(String address){
		this.address=address;
	}

	public String getAddress(){
		return address;
	}

	public void setDate(String date){
		this.date=date;
	}

	public String getDate(){
		return date;
	}

	public void setEndDate(String endDate){
		this.endDate=endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setStatus(String status){
		this.status=status;
	}

	public String getStatus(){
		return status;
	}
}

