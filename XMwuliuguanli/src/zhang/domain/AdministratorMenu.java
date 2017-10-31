package zhang.domain;

public class AdministratorMenu {
	
	
	private Integer menuId;//菜单编号
	private String menuName;//菜单名
	private String url;//路径
	private Integer parentMenuId;//父级菜单
	private String img;//小图标
	
	private AdministratorType administratorType;//管理员权限
	
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getParentMenuId() {
		return parentMenuId;
	}
	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}
	public AdministratorType getAdministratorType() {
		return administratorType;
	}
	public void setAdministratorType(AdministratorType administratorType) {
		this.administratorType = administratorType;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}


	
}
