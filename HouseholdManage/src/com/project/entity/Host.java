package com.project.entity;

import java.io.Serializable;
/**
 * 
 * host 实体类
 * Fri May 04 17:08:39 CST 2018
 * @author 白明 
 * 
 */ 
public class Host implements Serializable{
	private int id;
	private String licenceId;
	private String idcard;
	private String name;
	private String address;
	private String beginDate;
	private String endDate;

	public Host(){
		super();
	}

	public Host(int id,String licenceId,String idcard,String name,String address,String beginDate,String endDate){
		super();
		this.id=id;
		this.licenceId=licenceId;
		this.idcard=idcard;
		this.name=name;
		this.address=address;
		this.beginDate=beginDate;
		this.endDate=endDate;
	}

	@Override
	public String toString(){
		return "Host [id=" + id + ", licenceId=" + licenceId + ", idcard=" + idcard + ", name=" + name + ", address=" + address + ", beginDate=" + beginDate + ", endDate=" + endDate + "]";
	}

	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public void setLicenceId(String licenceId){
		this.licenceId=licenceId;
	}

	public String getLicenceId(){
		return licenceId;
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

	public void setAddress(String address){
		this.address=address;
	}

	public String getAddress(){
		return address;
	}

	public void setBeginDate(String beginDate){
		this.beginDate=beginDate;
	}

	public String getBeginDate(){
		return beginDate;
	}

	public void setEndDate(String endDate){
		this.endDate=endDate;
	}

	public String getEndDate(){
		return endDate;
	}
}

