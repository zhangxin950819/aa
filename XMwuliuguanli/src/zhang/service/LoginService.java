package zhang.service;

import java.util.Map;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import util.LogicException;
import zhang.dao.LoginDao;
import zhang.domain.Administrator;

@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = true)
public class LoginService {
	private LoginDao loginDao;
  
	public Administrator checkLogin(Administrator administrator,Map<String, String> errorMap) {
		Administrator admin = loginDao.findByUserName(administrator.getUsername());
		if(admin == null){
			errorMap.put("username", "账号错误!");
			throw new LogicException();
		}
		if(!admin.getPassword().equals(administrator.getPassword())) {
			errorMap.put("password", "密码错误!");
			throw new LogicException();
		}
		return admin;
	}
	
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	
}
