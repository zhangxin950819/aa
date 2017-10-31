package util;

import java.util.ArrayList;
import java.util.List;

//分页工具类

public class PageUtil {
	private Integer nowPage = 1;//当前页
	private Integer totalResultNumber;//总记录数
	private Integer pageNumber = 5;//每页记录数
	//查询条件
	private Integer adminType = 0;//管理员类别
	private String adminName;//管理员姓名
	private List<Integer> pageNumberList = new ArrayList<>();//每页记录数的选择
	{
		pageNumberList.add(5);
		pageNumberList.add(10);
		pageNumberList.add(15);
		pageNumberList.add(20);
	}
	
	public Integer getNowPage() {
		return nowPage;
	}
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
	//获得总页数
	public Integer getTotalPageNumber() {
		return totalResultNumber%pageNumber==0? totalResultNumber/pageNumber : totalResultNumber/pageNumber + 1;
	}

	
	public Integer getTotalResultNumber() {
		return totalResultNumber;
	}
	public void setTotalResultNumber(Integer totalResultNumber) {
		this.totalResultNumber = totalResultNumber;
	}
	
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}
	
	public Integer getAdminType() {
		return adminType;
	}
	public void setAdminType(Integer adminType) {
		this.adminType = adminType;
	}
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
	public List<Integer> getPageNumberList() {
		return pageNumberList;
	}
	
}
