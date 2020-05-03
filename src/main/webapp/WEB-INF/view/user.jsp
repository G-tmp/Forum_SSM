<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commoms/navbar.jsp"%>



<html>
<head>

    <title>${user.nickname}</title>

</head>
<body>

<div class="container">

    <div style="padding-top: 150px;"></div>

    <div class="panel panel-default">
        <div class="panel-body">
            <img src="<%=path%>/resources/img_profile/${user.profile}" class="img-rounded" width="120px" height="120px;">
            <h2>${user.nickname }</h2>

            <h3>创建于: <fmt:formatDate value="${user.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></h3>
            <h3>自我介绍: ${user.bio}</h3>
        </div>
    </div>



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