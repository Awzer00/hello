package com.project.entity;

import java.io.Serializable;
/**
 * 
 * alldata 实体类
 * Fri May 04 17:08:39 CST 2018
 * @author 白明 
 * 
 */ 
public class Alldata implements Serializable{
	private int id;
	private String idcard;
	private String name;
	private String sex;
	private String natives;
	private String nation;
	private int trpid;

	public Alldata(){
		super();
	}

	public Alldata(int id,String idcard,String name,String sex,String natives,String nation,int trpid){
		super();
		this.id=id;
		this.idcard=idcard;
		this.name=name;
		this.sex=sex;
		this.natives=natives;
		this.nation=nation;
		this.trpid=trpid;
	}

	@Override
	public String toString(){
		return "Alldata [id=" + id + ", idcard=" + idcard + ", name=" + name + ", sex=" + sex + ", natives=" + natives + ", nation=" + nation + ", trpid=" + trpid + "]";
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

	public void setSex(String sex){
		this.sex=sex;
	}

	public String getSex(){
		return sex;
	}

	public void setNatives(String natives){
		this.natives=natives;
	}

	public String getNatives(){
		return natives;
	}

	public void setNation(String nation){
		this.nation=nation;
	}

	public String getNation(){
		return nation;
	}

	public void setTrpid(int trpid){
		this.trpid=trpid;
	}

	public int getTrpid(){
		return trpid;
	}
}

