<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <!--  Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!--  Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>XD</title>

</head>
<body style=" background-color: #d1d9e0;">


<script>

    function show_time() {
        return new date();
    }
    
    
    function submit_button(){

        var title = $("#title111").val();
        var content = $("#content111").val();
        var block = $("#block111").val();

        var data = {
            title:title,
            content:content,
            block:block
        };

        $.ajax({
            type : "post",
            url : "/forum/publishPost",
            data : JSON.stringify(data),
            dataType : "json",
            contentType : "application/json;charset=UTF-8",
            success : function (result) {
                if (result["msg"] == "success") {
                    alert("发帖成功");
                    window.location.href = "/forum/home";
                }else if(result["msg"] == "unlogin"){
                    alert("请先登陆");
                    return;
                }
            },
            error : function (result) {
                alert("error")
            }
        });
    };
    
</script>


<!-- 
      <body  onload="location.href='IndexServlet?method=getAllPost'">
   -->
<!-- 运行IndexServlet -->



<div class="container">
    <%@ include file="commoms/navbar.jsp"%>
<%--    <c:import url="commoms/navbar.jsp" var="data"/>--%>
<%--    ${data}--%>

    <div style="padding-top: 100px;"></div>

<%--    面包屑导航--%>
<%--    <ul class="breadcrumb">--%>
<%--        <li><a href="#">XD</a></li>--%>
<%--        <li><a href="#">${board.name}</a></li>--%>
<%--    </ul>--%>

    <!-- 发帖按钮 -->
    <div>
    <!-- 按钮触发模态框 -->
        <button class="btn btn-primary btn-lg" data-toggle="modal"
            data-target="#myModalll">
            <h5>发帖</h5>
        </button>
    </div>

    <div style="padding-top: 20px;"></div>



    <c:forEach var="post" items="${posts}">
        <!-- 面板 -->
        <div class="panel panel-default"
             style="box-shadow: 5px 5px 5px gray;">

            <div class="panel-body">
                <div style="float: left; width: 55px; height: 55px; margin-top: -5px;" class="pull-left">
                    <img src="${pageContext.request.contextPath}/img_profile/default.png" class="img-rounded" width="60px" height="60px"><br>
                </div>

                <div  style="float: left; margin-left: 50px; width: 900px; height: 60px; margin-bottom: -10px; margin-top: -5px;">
                    <div style="width: 900px; height: 50px;">
                        <a href="post/${post.id}" style="font-size: 19px; color: #000000"> ${post.title }</a>
                        <blockquote class="pull-right">
                            <a href="profile/${post.user.nickname }">${post.user.nickname }</a>
                            <small><cite  title="Source Title">${post.publishTime }</cite></small>
                        </blockquote>
                    </div>

                    <div style="width: 900px; height: 20px;">
                        <div style="float: left; width: 100px;padding-left: 200px;padding-top: 10px;">
								<span class="label label-info">
                                    <a style="font-size: 12px; color: #222222;"
                                        href="b/${post.block.ename}"
                                        class="text-info">${post.block.name }
                                    </a>
                                </span>
                        </div>
                    </div>
                </div>

                <div style="float: right; width: 60px; height: 60px; padding-top: 20px;">
                    <span class="badge">${post.replyCount}</span>
                </div>
            </div>
        </div>
    </c:forEach>


    <!-- ---------   pagination   ------------->
<%--    <ul class="pagination pagination-lg" style="padding-top: 100px">--%>
<%--        <!-- 上一页 -->--%>
<%--        <c:if test="${page.cur!=1 }">--%>
<%--            <li><a href="index?method=${param.method }&cur=${page.cur-1 }&bid=${param.bid }">&laquo;</a></li>--%>
<%--        </c:if>--%>


<%--        <!-- 当前页为中心前后各显示2页 -->--%>
<%--        <c:set var="begin" value="1" scope="page"></c:set>--%>
<%--        <c:set var="end" value="${page.totalPage }" scope="page"></c:set>--%>
<%--        <!-- 判断前面有没有2页 -->--%>
<%--        <c:if test="${page.cur>2 }">--%>
<%--            <c:set var="begin" value="${page.cur-2 }" scope="page"></c:set>--%>
<%--        </c:if>--%>
<%--        <!-- 判断后面有没有2页 -->--%>
<%--        <c:if test="${page.cur<page.totalPage-2 }">--%>
<%--            <c:set var="end" value="${page.cur+2 }" scope="page"></c:set>--%>
<%--        </c:if>--%>
<%--        <!-- 显示(begin~end) -->--%>
<%--        <c:forEach begin="${begin}" end="${end }" var="i">--%>
<%--            <c:if test="${page.cur!=i }">--%>
<%--                <li><a href="index?method=${param.method }&cur=${i }&bid=${param.bid }">${i }</a></li>--%>
<%--            </c:if>--%>
<%--            <c:if test="${page.cur==i }">--%>
<%--                <li class="active"><a href="index?method=${param.method }&cur=${i }&bid=${param.bid }">${i }</a></li>--%>
<%--            </c:if>--%>
<%--        </c:forEach>--%>


<%--        <!-- 下一页 -->--%>
<%--        <c:if test="${page.totalPage!=page.cur && page.totalRecord>0}">--%>
<%--            <li><a href="index?cur=${page.cur+1 }&method=${param.method}&bid=${param.bid }">&raquo;</a></li>--%>
<%--        </c:if>--%>
<%--    </ul>--%>

    <!--  
			[${requestScope.page.totalRecord }]		
			<h2>m:${param.method }</h2>
			<h2>b:${param.bid }</h2>
			<h2>c:${param.cur }</h2>
		-->

</div>



<!-- 模态框（Modal） -->
<div class="modal fade" id="myModalll" tabindex="0" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h3 class="modal-title" id="myModalLabel">标题</h3>
            </div>
            <div class="modal-body">
                <form action="#" name="post" role="form">
                    <div class="form-group">
                        <label>请输入标题(<small>50字以内</small>)</label>
                        <textarea class="form-control" rows="2" cols="65" name="title" id="title111" required></textarea>
                    </div>
                    <div class="form-group">
                        <label>请输入内容(<small>500字以内</small>)</label>
                        <textarea class="form-control" rows="4" cols="65" name="content" id="content111"></textarea>
                    </div>
                    <div class="form-group">
                        <label>选择版块</label>
                        <select class="form-control" id="block111" name="block">
                            <c:forEach var="block" items="${blocks}">
                                <option value="${block.id}">${block.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" onclick="submit_button()"
                        class="btn btn-primary">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>

</body>

</html>