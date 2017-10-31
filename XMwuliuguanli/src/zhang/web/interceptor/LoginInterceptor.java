package zhang.web.interceptor;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import util.FinalUtil;
import zhang.domain.AdministratorMenu;
import zhang.web.action.AdministratorAction;

public class LoginInterceptor extends MethodFilterInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		Object object = ActionContext.getContext().getSession().get(FinalUtil.ADMIN_IN_SESSION);
		if(object != null ){
			return invocation.invoke();
		}
		return "toLogin";
	}

	
}
