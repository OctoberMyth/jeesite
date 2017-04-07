/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.annotation.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.annotation.entity.Annotation;
import com.thinkgem.jeesite.modules.annotation.service.AnnotationService;

import java.util.Date;

/**
 * 注解测试Controller
 * @author lyy
 * @version 2017-04-05
 */
@Controller
@RequestMapping(value = "${adminPath}/annotation/annotation")
public class AnnotationController extends BaseController {

	@Autowired
	private AnnotationService annotationService;
	
	@ModelAttribute
	public Annotation get(@RequestParam(required=false) String id) {
		Annotation entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = annotationService.get(id);
		}
		if (entity == null){
			entity = new Annotation();
		}
		return entity;
	}
	
	@RequiresPermissions("annotation:annotation:view")
	@RequestMapping(value = {"list", ""})
	public String list(Annotation annotation, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Annotation> page = annotationService.findPage(new Page<Annotation>(request, response), annotation); 
		model.addAttribute("page", page);
		return "modules/annotation/annotationList";
	}

	@RequiresPermissions("annotation:annotation:view")
	@RequestMapping(value = "form")
	public String form(Annotation annotation, Model model) {
		model.addAttribute("annotation", annotation);
		return "modules/annotation/annotationForm";
	}

	@RequiresPermissions("annotation:annotation:edit")
	@RequestMapping(value = "save")
	public String save(Annotation annotation, Model model, RedirectAttributes redirectAttributes) {
		annotation.setCreateDate(new Date());

		annotationService.save(annotation);
		addMessage(redirectAttributes, "保存注解测试成功");
		return "redirect:"+Global.getAdminPath()+"/annotation/annotation/?repage";
	}
	
	@RequiresPermissions("annotation:annotation:edit")
	@RequestMapping(value = "delete")
	public String delete(Annotation annotation, RedirectAttributes redirectAttributes) {
		annotationService.delete(annotation);
		addMessage(redirectAttributes, "删除注解测试成功");
		return "redirect:"+Global.getAdminPath()+"/annotation/annotation/?repage";
	}

}