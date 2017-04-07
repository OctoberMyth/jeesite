/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.test;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.Validate;
import com.thinkgem.jeesite.common.utils.excel.annotation.ValidateProcess;
import com.thinkgem.jeesite.modules.sys.entity.Area;
import com.thinkgem.jeesite.modules.sys.entity.Office;
import com.thinkgem.jeesite.modules.sys.entity.User;

/**
 * 单表生成Entity
 * @author ThinkGem
 * @version 2015-04-06
 */
public class TestData extends DataEntity<TestData> {
	
	private static final long serialVersionUID = 1L;
	private User user;		// 归属用户
	private Office office;		// 归属部门
	private Area area;		// 归属区域
	private String name;		// 名称
	private String sex;		// 性别
	@Validate(required = true,regex = "",method="")
	private BigDecimal amount;		// 金额
	private int number;		// 数字
	private Date beginInDate;		// 开始 加入日期
	private Date endInDate;		// 结束 加入日期
	
	public TestData() {
		super();
	}

	public TestData(String id){
		super(id);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	@Length(min=0, max=100, message="名称长度必须介于 0 和100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Validate(required = true,method = "name")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Validate(required = true,method = "amount")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Validate(required = true,method = "number")
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Validate(required = true,method = "date")//datetime
	public Date getBeginInDate() {
		return beginInDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public void setBeginInDate(Date beginInDate) {
		this.beginInDate = beginInDate;
	}
	
	public Date getEndInDate() {
		return endInDate;
	}

	public void setEndInDate(Date endInDate) {
		this.endInDate = endInDate;
	}
	
	public static void main(String[] agrs){
		TestData t = new TestData();
		t.setAmount(new BigDecimal(10.00));
		t.setSex("nan");
		t.setNumber(1);
		t.setBeginInDate(new Date());
		ValidateProcess.process(t);
	}
		
}