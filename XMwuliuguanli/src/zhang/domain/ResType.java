package zhang.domain;

import java.util.Set;

//物件类型表
public class ResType {
	private Integer resTypeId;
	private String resTypeName;
	
	private Set<Order> orders;

	public Integer getResTypeId() {
		return resTypeId;
	}

	public void setResTypeId(Integer resTypeId) {
		this.resTypeId = resTypeId;
	}

	public String getResTypeName() {
		return resTypeName;
	}

	public void setResTypeName(String resTypeName) {
		this.resTypeName = resTypeName;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
	
	
	
	
}
