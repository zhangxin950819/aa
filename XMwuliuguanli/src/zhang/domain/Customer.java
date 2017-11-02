package zhang.domain;

import java.util.Set;

//客户表
public class Customer {
	private String customerId;
	private String customerName;
	private String phoneNumber;
	private String address;
	
	private Set<Order> fromOrders;
	private Set<Order> toOrders;

	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
