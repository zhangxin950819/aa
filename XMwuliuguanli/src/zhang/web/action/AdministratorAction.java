package zhang.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.boot.archive.scan.spi.PackageInfoArchiveEntryHandler;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.util.ValueStack;

import util.FinalUtil;
import util.LogicException;
import util.PageUtil;
import util.StringUtil;
import zhang.domain.Administrator;
import zhang.domain.AdministratorMenu;
import zhang.domain.AdministratorType;
import zhang.service.AdministratorService;

//对管理员的操作
public class AdministratorAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 1L;

	private AdministratorService administratorService;

	private Administrator administrator = new Administrator();
	private PageUtil page = new PageUtil();
	
	
	// 首页
	public String index() throws Exception {
		List<List<AdministratorMenu>> administratorMenuList = findAdminMenu();
		ActionContext.getContext().getSession().put(FinalUtil.MNUELIST_IN_SESSION, administratorMenuList);
		return "index";
	}
	
	//管理员列表
	public String adminList(){
		ActionContext context = ActionContext.getContext();
		List<AdministratorType> adminType = administratorService.findAllAdministratorType();
		context.put("adminTypeList", adminType);
		List<Administrator> adminList = administratorService.findAllAdministrator(page);
		context.put("adminList", adminList);
		context.put("page", page);
		return "adminList";
	}

	// 添加管理员
	public String addAdmin() {
		List<AdministratorType> type = administratorService.findAllAdministratorType();
		ActionContext.getContext().put("administratorTypeList", type);
		if(StringUtil.hasLength(administrator.getId()) && StringUtil.isBlank(administrator.getName())){
			Administrator admin = administratorService.findAdministratorById(administrator.getId());
			ActionContext.getContext().put("admin",admin);
			ActionContext.getContext().put("editAmin","true");
		}
		return "addAdmin";
	}
	
	// 编辑管理员
	public String editAdmin() {
		String typeId = ServletActionContext.getRequest().getParameter("typeId");
		AdministratorType administratorType = new AdministratorType();
		administratorType.setTypeId(Integer.parseInt(typeId));
		administrator.setAdministratorType(administratorType);
		if (StringUtil.isBlank(administrator.getUsername())) {
			try {
				administratorService.saveAdmin(administrator);
			} catch (LogicException e) {
				ActionContext.getContext().put("admin", administrator);
				ActionContext.getContext().put("editAdminError", e.getMessage());
				return  addAdmin();
			}
		}
		else
			administratorService.editAdmin(administrator);
		ActionContext.getContext().put("adminListMsg", "保存成功！");
		return adminList();
	}
	//删除管理员
	public String deleteAdmin(){
		administratorService.deleteAdmin(administrator.getId());
		ActionContext.getContext().put("adminListMsg", "删除成功！");
		return adminList();
	}
	// 根据权限获得菜单列表
	private List<List<AdministratorMenu>> findAdminMenu() {
		Administrator admin = (Administrator) ActionContext.getContext().getSession().get(FinalUtil.ADMIN_IN_SESSION);
		List<List<AdministratorMenu>> menuList = administratorService.findAdminMenu(admin);
		return menuList;
	}

	@Override
	public void prepare() throws Exception {
		// 获得值栈
		ValueStack stack = ActionContext.getContext().getValueStack();
		stack.push(administrator);
		stack.push(page);
	}

	public void setAdministratorService(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}

}
