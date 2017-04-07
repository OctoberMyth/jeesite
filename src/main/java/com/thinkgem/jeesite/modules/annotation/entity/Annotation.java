/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.annotation.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

import java.math.BigDecimal;

/**
 * 注解测试Entity
 * @author lyy
 * @version 2017-04-05
 */
public class Annotation extends DataEntity<Annotation> {
	
	private static final long serialVersionUID = 1L;
	private String name;// 名称
	private BigDecimal amount;		// 金额
	
	public Annotation() {
		super();
	}

	public Annotation(String id){
		super(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}