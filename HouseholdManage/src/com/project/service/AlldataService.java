package com.project.service;

import java.util.List;

import com.project.Dao.AlldataDao;
import com.project.Interface.IAlldataDao;
import com.project.Interface.IAlldataService;
import com.project.entity.Alldata;

public class AlldataService implements IAlldataService {
	
	private IAlldataDao iad=new AlldataDao();
	
	public int showPeopleCount() {
		return iad.selectPeopleCount();
	}
	
	//查询所有户口
	@Override
	public List<Alldata> showAllPeople() {
		// TODO Auto-generated method stub
		return iad.selectAllHousehold();
	}

	//分页查询所有户口
	@Override
	public List<Alldata> showAllPeople(int page, int size) {
		// TODO Auto-generated method stub
		return iad.selectAlldata(page,size);
	}

	//倒序查询
	@Override
	public List<Alldata> showAllPeopleDesc() {
		// TODO Auto-generated method stub
		return iad.selectAllHouseholdByDesc();
	}

	//倒序查询分页
	@Override
	public List<Alldata> showAllPeopleDesc(int page, int size) {
		// TODO Auto-generated method stub
		return iad.selectAllHouseholdByDesc(page, size);
	}

	//分页且按照sort进行order排序
	@Override
	public List<Alldata> showAllPeople(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		return iad.selectAllHousehold(page, size, sort, order);
	}

	//查询有暂住证的户口
	@Override
	public List<Alldata> showTrpPeople() {
		// TODO Auto-generated method stub
		return iad.selectTrpHousehold();
	}

	//查询所有没有暂住证
	@Override
	public List<Alldata> showNoTrpPeople() {
		// TODO Auto-generated method stub
		return iad.selectNoTrpHousehold();
	}

	//通过身份证查找
	@Override
	public Alldata showPeopleByIDCard(String IDCard) {
		// TODO Auto-generated method stub
		return iad.selectByIDCard(IDCard);
	}

	//通过名字查找
	@Override
	public List<Alldata> showPeopleByName(String name) {
		// TODO Auto-generated method stub
		return iad.selectByName(name);
	}

	//按照地区名查找该地区范围
	@Override
	public List<Alldata> showPeopleByNatives(String natives) {
		// TODO Auto-generated method stub
		return iad.selectByNatives(natives);
	}

	//查找某一性别的户口
	@Override
	public List<Alldata> showPeopleBySex(String sex) {
		// TODO Auto-generated method stub
		return iad.selectBySex(sex);
	}

	//查找某一民族的户口
	@Override
	public List<Alldata> showPeopleByNation(String nation) {
		// TODO Auto-generated method stub
		return iad.selectByNation(nation);
	}

	//查找某一民族的户口数
	@Override
	public List<Alldata> showPeopleCountByNation(String nation) {
		// TODO Auto-generated method stub
		return iad.selectCountByNation(nation);
	}

	//统计有暂住证中某一性别的
	@Override
	public List<Alldata> showPeopleByTrpAndSex(String sex) {
		// TODO Auto-generated method stub
		return iad.selectByTrpAndSex(sex);
	}

	//统计有暂住证中某一民族
	@Override
	public List<Alldata> showPeopleByTrpAndNation(String nation) {
		// TODO Auto-generated method stub
		return iad.selectByTrpAndNation(nation);
	}

	//统计某一地区中有暂住证的户口
	@Override
	public List<Alldata> showPeopleByTrpAndNatives(String natives) {
		// TODO Auto-generated method stub
		return iad.selectByTrpAndNatives(natives);
	}

	//增加新来人员
	@Override
	public int addNewPeople(Alldata data) {
		// TODO Auto-generated method stub
		return iad.insertAlldata(data);
	}

	//删除人员(按照身份证)
	@Override
	public int removePeople(String IDCard) {
		// TODO Auto-generated method stub
		return iad.deleteAlldata(IDCard);
	}
	//修改人员信息
	public int updatePeople(Alldata data) {
		return iad.updatePeopledata(data);		
	}
	

	//根据身份证修改有无暂住证状态
	@Override
	public int updateTrpStatus(String IDCard, int TRPID) {
		// TODO Auto-generated method stub
		return iad.updateAlldata(IDCard, TRPID);
	}

}
