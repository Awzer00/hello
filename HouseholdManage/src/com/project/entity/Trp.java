package com.project.entity;

import java.io.Serializable;
/**
 * 
 * trp 实体类
 * Fri May 04 17:08:39 CST 2018
 * @author 白明 
 * 
 */ 
public class Trp implements Serializable{
	private int trpid;
	private String idcard;
	private String name;
	private String natives;
	private String address;
	private String beginDate;
	private String endDate;

	public Trp(){
		super();
	}

	public Trp(int trpid,String idcard,String name,String natives,String address,String beginDate,String endDate){
		super();
		this.trpid=trpid;
		this.idcard=idcard;
		this.name=name;
		this.natives=natives;
		this.address=address;
		this.beginDate=beginDate;
		this.endDate=endDate;
	}

	@Override
	public String toString(){
		return "Trp [trpid=" + trpid + ", idcard=" + idcard + ", name=" + name + ", natives=" + natives + ", address=" + address + ", beginDate=" + beginDate + ", endDate=" + endDate + "]";
	}

	public void setTrpid(int trpid){
		this.trpid=trpid;
	}

	public int getTrpid(){
		return trpid;
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

