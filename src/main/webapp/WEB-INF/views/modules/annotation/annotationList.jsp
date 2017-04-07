<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>注解测试管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/annotation/annotation/">注解测试列表</a></li>
		<shiro:hasPermission name="annotation:annotation:edit"><li><a href="${ctx}/annotation/annotation/form">注解测试添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="annotation" action="${ctx}/annotation/annotation/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>金额</th>
				<th>创建时间</th>
				<shiro:hasPermission name="annotation:annotation:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="annotation">
			<tr>
				<td><a href="${ctx}/annotation/annotation/form?id=${annotation.id}">
					${annotation.name}
				</a></td>
				<td>
					${annotation.amount}
				</td>
				<td>
					<fmt:formatDate value="${annotation.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="annotation:annotation:edit"><td>
    				<a href="${ctx}/annotation/annotation/form?id=${annotation.id}">修改</a>
					<a href="${ctx}/annotation/annotation/delete?id=${annotation.id}" onclick="return confirmx('确认要删除该注解测试吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>