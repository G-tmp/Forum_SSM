<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../commoms/navbar.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <div style="padding-top: 100px;"></div>


    <div class="panel panel-default">
        <div class="panel-body">
            <table class="table table-hover">
                <caption><h2>用户信息</h2></caption>
                <thead>
                <tr>
                    <th>email</th>
                    <th>昵称</th>
                    <th>个人简介</th>
                    <th>注册时间</th>
                    <th>是否封禁</th>
                    <th>是否管理员</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="user"  items="${users}">
                    <tr>
                        <td>${user.email}</td>
                        <td><a href="../u/${user.nickname}">${user.nickname}</a></td>
                        <td>${user.bio}</td>
<%--                        <td><fmt:formatDate value="${user.registerTime }" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></td>--%>
                        <td>${user.registerTime }</td>
                        <td>${user.isBanned}</td>
                        <td>${user.states}</td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
