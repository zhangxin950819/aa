package zhang.domain;

import java.util.HashSet;
import java.util.Set;

//管理员权限表
public class AdministratorType {
	
	private Integer typeId;//权限号
	private String typeName;//权限名
	
	private Set<Administrator> adminintrators = new HashSet<>();
	private Set<AdministratorMenu> administratorMenus = new HashSet<>();
	
	
	public Set<AdministratorMenu> getAdministratorMenus() {
		return administratorMenus;
	}
	public void setAdministratorMenus(Set<AdministratorMenu> administratorMenus) {
		this.administratorMenus = administratorMenus;
	}
	public Set<Administrator> getAdminintrators() {
		return adminintrators;
	}
	public void setAdminintrators(Set<Administrator> adminintrators) {
		this.adminintrators = adminintrators;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
	@Override
	public String toString() {
		return "AdministratorType [typeId=" + typeId + ", typeName=" + typeName + "]";
	}
	

	
}
