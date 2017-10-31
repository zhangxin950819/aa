package zhang.dao;

import java.util.ArrayList;
import java.util.List;

import javax.naming.ldap.PagedResultsControl;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import util.PageUtil;
import util.StringUtil;
import zhang.domain.Administrator;
import zhang.domain.AdministratorMenu;
import zhang.domain.AdministratorType;

public class AdministratorDao extends HibernateDaoSupport {
	
	//根据权限查询管理员菜单列表
	public List<AdministratorMenu> findMenuByTypeId(Integer typeId) {
		DetachedCriteria dc = DetachedCriteria.forClass(AdministratorMenu.class);
		if(typeId != 0){
			AdministratorType administratorType = new AdministratorType();
			administratorType.setTypeId(typeId);
			dc.add(Restrictions.eq("administratorType", administratorType));
		}
		List<AdministratorMenu> administratorMenuList = (List<AdministratorMenu>) getHibernateTemplate().findByCriteria(dc);
		return administratorMenuList;
	}
	//查询管理员类别
	public List<AdministratorType> findAllAdministratorType() {
		DetachedCriteria dc = DetachedCriteria.forClass(AdministratorType.class);
		dc.add(Restrictions.ne("typeId",0));
		return (List<AdministratorType>) getHibernateTemplate().findByCriteria(dc);
	}
	//根据id查询管理员类别
	public AdministratorType findAllAdministratorTypeByTypeId(Integer typeId) {
		DetachedCriteria dc = DetachedCriteria.forClass(AdministratorType.class);
		dc.add(Restrictions.eq("typeId",typeId));
		List<AdministratorType> typeList = (List<AdministratorType>) getHibernateTemplate().findByCriteria(dc);
		if(typeList.size() > 0) return typeList.get(0);
		return null;
	}
	//编辑管理员
	public void editAdmin(Administrator administrator) {
		getHibernateTemplate().saveOrUpdate(administrator);
	}
	//根据id查询管理员
	public Administrator findAdministratorById(String id) {
		DetachedCriteria dc = DetachedCriteria.forClass(Administrator.class);
		dc.add(Restrictions.eq("id", id));
		List<Administrator> adminList = (List<Administrator>) getHibernateTemplate().findByCriteria(dc);
		if(adminList.size() > 0) return adminList.get(0);
		return null;
	}
	//查询所有管理员
	public List<Administrator> findAllAdministrator(PageUtil page) {
		DetachedCriteria dc = DetachedCriteria.forClass(Administrator.class);
		if(page.getAdminType() != 0){
			AdministratorType administratorType = new AdministratorType();
			administratorType.setTypeId(page.getAdminType());
			dc.add(Restrictions.eq("administratorType",administratorType));
		}
		if(StringUtil.hasLength(page.getAdminName())){
			dc.add(Restrictions.like("name", "%"+page.getAdminName()+"%"));
		}
		List<Administrator> adminList = (List<Administrator>) getHibernateTemplate().findByCriteria(dc);
		page.setTotalResultNumber(adminList.size());
		List<Administrator> returnList = new ArrayList<>();
		if(adminList.size() < page.getPageNumber()) return adminList;
		for(int i = (page.getNowPage()-1) * page.getPageNumber() ;i < page.getNowPage() * page.getPageNumber() && i < adminList.size(); i ++){
			Administrator administrator = adminList.get(i);
			if(StringUtil.isBlank(administrator.getAdministratorType().getTypeName())){
				administrator.setAdministratorType(findAllAdministratorTypeByTypeId(administrator.getAdministratorType().getTypeId()));
			}
			returnList.add(administrator);
		}
		return returnList;
	}
	//删除管理员
	public void deleteAdmin(Administrator administrator) {
		getHibernateTemplate().delete(administrator);
	}
}
