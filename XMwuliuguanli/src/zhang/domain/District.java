package zhang.domain;

import java.util.Set;

//地区表
public class District {
	private String districtId;//地区号
	private String districtName;//地区名
	
	private Set<Administrator>  administrators;
	private Set<Order> orders;
	
	private Set<Order> fromOrders;
	private Set<Order> toOrders;
	
	public Set<Administrator> getAdministrators() {
		return administrators;
	}
	public void setAdministrators(Set<Administrator> administrators) {
		this.administrators = administrators;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public String getDistrictId() {
		return districtId;
	}
	public void setDistrictId(String districtId) {
		this.districtId = districtId;
	}
	public String getDistrictName() {
		return districtName;
	}
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
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
	
	
}
