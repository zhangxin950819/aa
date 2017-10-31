package zhang.web.action;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

import util.FinalUtil;
import util.LogicException;
import util.StringUtil;
import zhang.domain.Administrator;
import zhang.service.LoginService;

public class LoginAction extends ActionSupport implements Preparable{

	private static final long serialVersionUID = 1L;
	
	private LoginService loginService ;
	
	private String verifyCode;
	private Administrator administrator = new Administrator();	
	
	//登录方法
	public String login() throws Exception{
		ActionContext context = ActionContext.getContext();
		Map<String , String > errorMap = new HashMap<>();
		String verifyCodeInSession =(String)context.getSession().get(FinalUtil.VERIFYCODE_IN_SESSION);
		if(StringUtil.isBlank(verifyCode) || !verifyCodeInSession.toLowerCase().equals(verifyCode.toLowerCase())){
			errorMap.put("verifycode", "验证码错误");
			context.put("admin", administrator);
			context.put("error", errorMap);
			return "fail";
		}
		Administrator admin;
		try {
			admin = loginService.checkLogin(administrator,errorMap);
		} catch (LogicException logicException) {
			context.put("admin", administrator);
			context.put("error", errorMap);
			return "fail";
		}
		context.getSession().put(FinalUtil.ADMIN_IN_SESSION, admin);
		return "index";
	}
	
	
	@Override
	public void prepare() throws Exception {
		//获得值栈
		ValueStack stack = ActionContext.getContext().getValueStack();
		stack.push(administrator);
	}
	

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
}
