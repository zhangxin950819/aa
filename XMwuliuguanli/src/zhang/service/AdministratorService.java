package zhang.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import util.LogicException;
import util.PageUtil;
import zhang.dao.AdministratorDao;
import zhang.domain.Administrator;
import zhang.domain.AdministratorMenu;
import zhang.domain.AdministratorType;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class AdministratorService {

	private AdministratorDao administratorDao;

	//查询管理员菜单列表
	public List<List<AdministratorMenu>> findAdminMenu(Administrator admin) {
		List<AdministratorMenu> administratorMenuList = administratorDao.findMenuByTypeId(admin.getAdministratorType().getTypeId());
		List<AdministratorMenu> parentMenuList = new LinkedList<>();
		List<AdministratorMenu> menuList = new LinkedList<>();
		for (AdministratorMenu administratorMenu : administratorMenuList) {
			if(administratorMenu.getParentMenuId()==0)
				parentMenuList.add(administratorMenu);
			else 
				menuList.add(administratorMenu);
		}
		List<List<AdministratorMenu>> list = new LinkedList<>();
		list.add(parentMenuList);
		list.add(menuList);
		return list;
	}
	//查询所有管理员类别
	public List<AdministratorType> findAllAdministratorType() {
		return administratorDao.findAllAdministratorType();
	}
	//根据id查询管理员
	public Administrator findAdministratorById(String id) {
		return administratorDao.findAdministratorById(id);
	}
	//查询所有管理员
	public List<Administrator> findAllAdministrator(PageUtil page) {
		return administratorDao.findAllAdministrator(page);
	}
	//编辑管理员
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void editAdmin(Administrator administrator) {
		administratorDao.editAdmin(administrator);
	}
	//保存管理员
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveAdmin(Administrator administrator) {
		Administrator admin = administratorDao.findAdministratorById(administrator.getId());
		if(admin != null) throw new LogicException("该管理员已存在");
		administrator.setUsername(administrator.getId());
		administrator.setPassword(administrator.getId().substring(administrator.getId().length() - 6));
		editAdmin(administrator);
	}
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	//删除管理员
	public void deleteAdmin(String id) {
		administratorDao.deleteAdmin(findAdministratorById(id));
	}
	
	// ------------------------------------------------------------------
	public void setAdministratorDao(AdministratorDao administratorDao) {
		this.administratorDao = administratorDao;
	}
}
