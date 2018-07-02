package com.project.service;

import java.util.List;

import com.project.Dao.TrpDao;
import com.project.Interface.ITrpDao;
import com.project.Interface.ITrpService;
import com.project.entity.Trp;

public class TrpService implements ITrpService {

	private ITrpDao trpDao=new TrpDao();

	//查
	//查询所有暂住证
	@Override
	public List<Trp> showAllTrp() {
		// TODO Auto-generated method stub
		return trpDao.selectAllTrp();
	}

	//查询最后一条数据
	public Trp showLastTrp() {
		List<Trp> Trp=trpDao.selectLastTrp();
		try {
			if(Trp.size()>0) {
				return Trp.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	};
	
	//倒序查询所有暂住证
	@Override
	public List<Trp> showAllTrpDesc() {
		// TODO Auto-generated method stub
		return trpDao.selectAllTrpDesc();
	}

	//分页查询正序
	@Override
	public List<Trp> showAllTrp(int page, int size) {
		// TODO Auto-generated method stub
		return trpDao.selectAllTrp(page, size);
	}

	//分页查询倒序
	@Override
	public List<Trp> showAllTrpDesc(int page, int size) {
		// TODO Auto-generated method stub
		return trpDao.selectAllTrpDesc(page, size);
	}

	//分页且按照sort进行order排序
	@Override
	public List<Trp> showAllTrp(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		return trpDao.selectAllTrp(page, size, sort, order);
	}

	//通过暂住证ID查询
	@Override
	public boolean showTrpByTrpid(String TRPID) {
		// TODO Auto-generated method stub
		boolean bool=false;
		try {
			List<Trp> trp= trpDao.selectTrpByTrpid(TRPID);
			bool=trp.size()>0?true:false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bool;
	}
	
	//通过暂住证ID查询
	@Override
	public Trp showTrpByTrp(String TRPID) {
		// TODO Auto-generated method stub
		List<Trp> trp=trpDao.selectTrpByTrpid(TRPID);
		try {
			if(trp.size()==0) {
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return trp.get(0);
	}

	//通过身份证查询暂住证
	@Override
	public Trp showTrpByIDCard(String IDCard) {
		// TODO Auto-generated method stub
		List<Trp> trp=trpDao.selectTrpByIDCard(IDCard);
		return trp.get(0);
	}

	//查询某一地区的暂住证
	@Override
	public List<Trp> showTrpByAddress(String address) {
		// TODO Auto-generated method stub
		return trpDao.selectTrpByAddress(address);
	}

	//增
	//增加暂住证
	@Override
	public int addTrp(Trp trp) {
		// TODO Auto-generated method stub
		return trpDao.insertTrp(trp);
	}
	
	//删
	//删除暂住证
	@Override
	public int removeTrp(String TRPID) {
		// TODO Auto-generated method stub
		return trpDao.delectTrp(TRPID);
	}
	
	//改
	//根据暂住证id修改暂住证居住地
	@Override
	public int updateTrpAddress(Trp trp) {
		// TODO Auto-generated method stub
		return trpDao.updateTrpAddress(trp);
	}

	//根据暂住证id修改暂住证日期
	@Override
	public int updateTrpDate(Trp trp) {
		// TODO Auto-generated method stub
		return trpDao.updateTrpDate(trp);
	}
	
	public int showTrpCount() {
		return trpDao.selectTrpCount();
	};

}
