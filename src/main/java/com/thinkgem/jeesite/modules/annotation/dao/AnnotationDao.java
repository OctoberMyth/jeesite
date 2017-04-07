/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.annotation.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.annotation.entity.Annotation;

/**
 * 注解测试DAO接口
 * @author lyy
 * @version 2017-04-05
 */
@MyBatisDao
public interface AnnotationDao extends CrudDao<Annotation> {
	
}