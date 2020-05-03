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
                    <h2>版块信息</h2>
                    <a href="addBlock">
                        <button type="button" class="btn btn-default">
                            添加
                        </button>
                    </a>
                </caption>

                <thead>
                <tr>
                    <th>名称</th>
                    <th>英文名称</th>
                    <th>简介</th>
                    <th>修改</th>
                </tr>
                </thead>

                <tbody>
                    <c:forEach var="block"  items="${blocks}">
                        <tr>
                            <td>${block.name}</td>
                            <td>${block.ename}</td>
                            <td>${block.description}</td>
                            <td><a href="modifyBlock/${block.ename}">修改</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


</div>

</body>
</html>
