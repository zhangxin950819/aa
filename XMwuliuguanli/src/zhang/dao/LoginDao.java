package zhang.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import zhang.domain.Administrator;

public class LoginDao extends HibernateDaoSupport{

	public Administrator findByUserName(String userName) {
		DetachedCriteria dc = DetachedCriteria.forClass(Administrator.class);
		dc.add(Restrictions.eq("username", userName));
		List<Administrator> adminList = (List<Administrator>) getHibernateTemplate().findByCriteria(dc);
		return adminList.size()==0 ? null : adminList.get(0);
	}

}
