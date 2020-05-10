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
                <caption>
                    <h2>举报帖子</h2>
                </caption>

                <thead>
                <tr>
                    <th>内容</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="post"  items="${posts}">
                    <tr>
                        <td><a href="../post/${post.id}">${post.title}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


            <table class="table table-hover">
                <caption>
                    <h2>举报回复</h2>
                </caption>

                <thead>
                <tr>
                    <th>内容</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="reply"  items="${replies}">
                    <tr>
                        <td><a href="../post/1">${reply.content}</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

</div>

</body>
</html>
