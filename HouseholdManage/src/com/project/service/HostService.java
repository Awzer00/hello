package com.project.service;

import java.util.Date;
import java.util.List;

import com.project.Dao.HostDao;
import com.project.Interface.IHostDao;
import com.project.Interface.IHostService;
import com.project.entity.Host;

public class HostService implements IHostService {
	
	private IHostDao hostDao=new HostDao();
	//增
	//新申请房屋租赁许可证
	public int addHost(Host host) {
		// TODO Auto-generated method stub
		return hostDao.insertHost(host);
	}

	//改
	//改变许可证信息(如:日期,户主名字等)
	@Override
	public int updateHost(Host host) {
		// TODO Auto-generated method stub
		return hostDao.updateHost(host);
	}
	@Override
	public int updateDateHost(Host host) {
		// TODO Auto-generated method stub
		return hostDao.updateDateHost(host);
	}
	
	//删
	//根据许可证号删除某一许可证
	@Override
	public int removeHost(String licenceID) {
		// TODO Auto-generated method stub
		return hostDao.deleteHost(licenceID);
	}
	
	//查
	//查询所有房屋许可证户主
	@Override
	public List<Host> showAllHost() {
		// TODO Auto-generated method stub
		return hostDao.selectAllHost();
	}

	//倒序
	@Override
	public List<Host> showAllHostDesc() {
		// TODO Auto-generated method stub
		return hostDao.selectAllHostDesc();
	}
	
	//分页
	@Override
	public List<Host> showAllHost(int page, int size) {
		// TODO Auto-generated method stub
		return hostDao.selectAllHost(page, size);
	}
	
	//分页倒序
	@Override
	public List<Host> showAllHostDesc(int page, int size) {
		// TODO Auto-generated method stub
		return hostDao.selectAllHostDesc(page, size);
	}
	
	//分页且按照sort进行order排序
	@Override
	public List<Host> showAllHousehold(int page, int size, String sort, String order) {
		// TODO Auto-generated method stub
		return hostDao.selectAllHost(page, size, sort, order);
	}
	
	//按照许可证id查找
	@Override
	public Host showHostByLicenceID(String licenceID) {
		// TODO Auto-generated method stub
		List<Host> host=hostDao.selectHostByLicenceID(licenceID);
		if(host.size()==0) {
			return null;
		}
		return host.get(0);
	}

	//查找此id是否存在
	public boolean showHost(String id) {
		boolean bool=false;
		List<Host> host=null;
		try {
			host=hostDao.selectHostByLicenceID(id);
			bool=host.size()>0?true:false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bool;
	}
	
	//按身份证查找某一房主
	@Override
	public Host showHostByIDCard(String IDCard) {
		// TODO Auto-generated method stub
		 List<Host> host=null;
		 try {
			 host=hostDao.selectHostByIDCard(IDCard);
			 if(host.size()==0) {
				 return null;
			 }
		} catch (Exception e) {
			// TODO: handle exception
		}
		return host.get(0);
	}
	
	//按名字查找某一房主
	@Override
	public List<Host> showHostByName(String name) {
		// TODO Auto-generated method stub
		return hostDao.selectHostByName(name);
	}
	
	//查找某一时间段内的申请的房主
	@Override
	public List<Host> showHostByDate(Date begin, Date end) {
		// TODO Auto-generated method stub
		return hostDao.selectHostByDate(begin, end);
	}

	public int showHostCount() {
		return hostDao.slectHostCount();
	};
	
	//检查身份证是否存在
	public boolean checkHadIDcard(String IDCard) {
		boolean bool=false;
		List<Host> host=null;
		try {
			host=hostDao.selectHostByIDCard(IDCard);
			bool=host.size()>0?true:false;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return bool;
	};
}

