/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.annotation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.annotation.entity.Annotation;
import com.thinkgem.jeesite.modules.annotation.dao.AnnotationDao;

/**
 * 注解测试Service
 * @author lyy
 * @version 2017-04-05
 */
@Service
@Transactional(readOnly = true)
public class AnnotationService extends CrudService<AnnotationDao, Annotation> {

	public Annotation get(String id) {
		return super.get(id);
	}
	
	public List<Annotation> findList(Annotation annotation) {
		return super.findList(annotation);
	}
	
	public Page<Annotation> findPage(Page<Annotation> page, Annotation annotation) {
		return super.findPage(page, annotation);
	}
	
	@Transactional(readOnly = false)
	public void save(Annotation annotation) {
		super.save(annotation);
	}
	
	@Transactional(readOnly = false)
	public void delete(Annotation annotation) {
		super.delete(annotation);
	}
	
}