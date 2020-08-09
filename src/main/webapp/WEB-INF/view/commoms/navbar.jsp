<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	String path=request.getServletContext().getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

	<!--  Bootstrap 核心 CSS 文件 -->
	<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

	<!--  Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body  style=" background-color: #d1d9e0;">
	<!--  navbar  -->
    		<nav class="navbar navbar-default navbar-fixed-top" role="navigation"  style="padding-left: 150px;padding-right: 150px ;font-size: 17px;background-color: #ffffff;box-shadow: 5px 5px 10px gray;">
				<!--  -->
    			<div class="container-fluid">
    				<div class="navbar-header">
    					<a href="<%=path%>/home" class="navbar-brand" style="font-size: 28px;">XD</a>
    				</div>
    				<div>

    					<ul class="nav navbar-nav">
    						<li><a href="<%=path%>/hot">Hot</a></li>
    						<li class="dropdown">
    							<a href="#" class="dropdown-toggle" data-toggle="dropdown">list<b class="caret"></b></a>
    							<ul class="dropdown-menu">
    								<c:forEach items="${blocks}" var="block">
										<li class="divider"></li>
										<li><a href="<%=path%>/b/${block.ename}">${block.name }</a></li>
    								</c:forEach>
    							</ul>
    						</li>
    					</ul>

    					<!-- search   -->
    					<form action="<%=path%>/search" method="get" class="navbar-form navbar-left" role="search">
    						<div class="form-group">
    							<input type="text" name="words" class="form-control" placeholder="Search">
    						</div>
    						<input type="submit" class="btn btn-default" value="Search">
    					</form>


    					<!-- login & register -->
    					<c:if test="${sessionScope.user==null}">
	    					<ul class="nav navbar-nav navbar-right">
	    						<li><a href="<%=path%>/register" class="btn btn-lg"><span class="glyphicon glyphicon-user">注册</span></a></li>
	    						<li><a href="<%=path%>/login" class="btn btn-lg " ><span class="glyphicon glyphicon-log-in">登录</span></a></li>
	    					</ul>
    					</c:if>

    					<!-- had been login -->
    					<c:if test="${sessionScope.user!=null }">
    						<ul class="nav navbar-nav navbar-right">
<%--    							<c:if test="${user.status==7}">--%>
<%-- 		   							<li><a href="report_list" class="btn btn-lg"><span class="glyphicon glyphicon-tree-conifer">Manager</span></a></li>--%>
<%--	    						</c:if>--%>
	    						<li><a href="<%=path%>/profile" class="btn btn-lg"><span class="glyphicon glyphicon-user">${sessionScope.user.nickname }</span></a></li>
	    						<li><a href="<%=path%>/logout" class="btn btn-lg " ><span class="glyphicon glyphicon-log-out">Logout</span></a></li>
	    					</ul>
    					</c:if>


<%--						<ul class="nav navbar-nav navbar-right">--%>
<%--							<li><a href="<%=path%>/register" class="btn btn-lg"><span class="glyphicon glyphicon-user">注册</span></a></li>--%>
<%--							<li><a href="<%=path%>/login" class="btn btn-lg " ><span class="glyphicon glyphicon-log-in">登录</span></a></li>--%>
<%--						</ul>--%>

    				</div>
    			</div>
    		</nav>

</body>
</html>