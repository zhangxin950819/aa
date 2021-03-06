package zhang.domain;

import java.util.Set;

//管理员表
public class Administrator {

	private	String id;//身份证号 主键  
	private String username; //账号
	private String password;//密码
	private String name;//姓名
	private String phonenumber;//联系电话
	private String address;//家庭住址
	
	private District district; //所属地区
 	private AdministratorType administratorType;//管理员权限
	
	private Set<Order> fromOrders;
	private Set<Order> toOrders;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AdministratorType getAdministratorType() {
		return administratorType;
	}
	public void setAdministratorType(AdministratorType administratorType) {
		this.administratorType = administratorType;
	}
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public Set<Order> getFromOrders() {
		return fromOrders;
	}
	public void setFromOrders(Set<Order> fromOrders) {
		this.fromOrders = fromOrders;
	}
	public Set<Order> getToOrders() {
		return toOrders;
	}
	public void setToOrders(Set<Order> toOrders) {
		this.toOrders = toOrders;
	}
	@Override
	public String toString() {
		return "Administrator [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name
				+ ", phonenumber=" + phonenumber + ", address=" + address + ", district=" + district
				+ "]";
	}
	
}
