package zhang.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import zhang.domain.District;

public class DistrictDao extends HibernateDaoSupport{
	//查询所有地区
	public List<District> findAllDistrict(){
		DetachedCriteria dc = DetachedCriteria.forClass(District.class); 
		return (List<District>) getHibernateTemplate().findByCriteria(dc);
	}
	//根据ID查询地区
	public District findDistrictById(String districtId) {
		DetachedCriteria dc = DetachedCriteria.forClass(District.class); 
		dc.add(Restrictions.eq("districtId",districtId));
		List<District> districtList =  (List<District>) getHibernateTemplate().findByCriteria(dc);
		if(districtList.size() > 0 ) return districtList.get(0);
		return  null;
	}
}
