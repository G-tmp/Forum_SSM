<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!--  Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!--  Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <%--    <script src="/js/jquery.min.js"></script>--%>

    <title>sign in</title>
</head>
<body>
<%@ include file="commoms/navbar.jsp"%>

<div class="container">

    <div style="padding-top: 150px;"></div>

    <img src="<%=path%>/img_profile/${user.profile}" class="img-rounded" width="80px" height="80px;">
    <h2>${user.nickname }</h2>

    <h3>创建于: ${user.registerTime}</h3>
    <h3>自我介绍: ${user.introduction}</h3>




<%--    <!-- 历史发帖 -->--%>
<%--    <div class="panel-group" id="accordion">--%>
<%--        <div class="panel panel-default">--%>
<%--            <div class="panel-heading">--%>
<%--                <h4 class="panel-title">--%>
<%--                    <a data-toggle="collapse" data-parent="#accordion"--%>
<%--                       href="#collapseOne">--%>
<%--                        点击我展开发帖记录--%>
<%--                    </a>--%>
<%--                </h4>--%>
<%--            </div>--%>
<%--            <div id="collapseOne" class="panel-collapse collapse">--%>
<%--                <c:if test="${postList==null }">--%>
<%--                    <small>无记录</small>--%>
<%--                </c:if>--%>
<%--                <c:forEach var="post" items="${postList }">--%>
<%--                    <div class="panel-body">--%>
<%--                        <a href="post_detail?pid=${post.id}">${post.title }</a>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


<%--    <!-- 历史回复 -->--%>
<%--    <div class="panel-group" id="accordion">--%>
<%--        <div class="panel panel-default">--%>
<%--            <div class="panel-heading">--%>
<%--                <h4 class="panel-title">--%>
<%--                    <a data-toggle="collapse" data-parent="#accordion"--%>
<%--                       href="#collapseTwo">--%>
<%--                        点击我展开回复记录--%>
<%--                    </a>--%>
<%--                </h4>--%>
<%--            </div>--%>
<%--            <div id="collapseTwo" class="panel-collapse collapse">--%>
<%--                <c:forEach var="reply" items="${replyList }">--%>
<%--                    <div class="panel-body">--%>
<%--                        <p style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 800px;"><a href="#" >${reply.content }</a>	</p>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


</div>
</body>
</html>