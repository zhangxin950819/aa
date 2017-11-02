package zhang.domain;

import java.util.Date;

//订单表
public class Order {
	private String orderId;//订单号
	private Date time;//下单时间
	private Integer state;//订单状态
	private String address;//详细地址
	
	private ResType resTypes;// 物件类型

	private Customer fromCustomer;// 发件人
	private Customer toCustomer;// 收件人
	
	private District fromDistrict;//发件地址
	private District toDistrict;//收件地址
	
	
	private Administrator fromAdministrator;//收件处理人
	private Administrator toAdministrator;//发件处理人
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}


	public ResType getResTypes() {
		return resTypes;
	}

	public void setResTypes(ResType resTypes) {
		this.resTypes = resTypes;
	}

	public Customer getFromCustomer() {
		return fromCustomer;
	}

	public void setFromCustomer(Customer fromCustomer) {
		this.fromCustomer = fromCustomer;
	}

	public Customer getToCustomer() {
		return toCustomer;
	}

	public void setToCustomer(Customer toCustomer) {
		this.toCustomer = toCustomer;
	}

	public District getFromDistrict() {
		return fromDistrict;
	}

	public void setFromDistrict(District fromDistrict) {
		this.fromDistrict = fromDistrict;
	}

	public District getToDistrict() {
		return toDistrict;
	}

	public void setToDistrict(District toDistrict) {
		this.toDistrict = toDistrict;
	}

	public Administrator getFromAdministrator() {
		return fromAdministrator;
	}

	public void setFromAdministrator(Administrator fromAdministrator) {
		this.fromAdministrator = fromAdministrator;
	}

	public Administrator getToAdministrator() {
		return toAdministrator;
	}

	public void setToAdministrator(Administrator toAdministrator) {
		this.toAdministrator = toAdministrator;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
