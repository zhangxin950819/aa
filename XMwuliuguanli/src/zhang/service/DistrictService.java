package zhang.service;

import java.util.List;

import zhang.dao.DistrictDao;
import zhang.domain.District;

public class DistrictService {
	private DistrictDao districtDao;
	
	//查询所有地区
	public List<District> findAllDistrict() {
		return districtDao.findAllDistrict();
	}
	//根据ID查询地区
	public District findDistrictById(String districtId) {
		return districtDao.findDistrictById(districtId);
	}
	
	public void setDistrictDao(DistrictDao districtDao) {
		this.districtDao = districtDao;
	}


}
