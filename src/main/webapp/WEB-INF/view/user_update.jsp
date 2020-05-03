<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commoms/navbar.jsp"%>


<html>
<head>
    <title>update</title>
</head>
<body>


<div class="container">

    <div style="padding-top: 150px;"></div>


    <div class="panel panel-default">

        <div class="panel-heading">
            <h3 class="panel-title">
                修改我的信息
            </h3>
        </div>

        <div class="panel-body">
            <form class="form-horizontal" role="form" action="updateMe" method="post">
                <input type="hidden"  name="id" value="${user.id}">

                <!-- E-mail -->
                <div class="form-group">
                    <label class="col-sm-2 control-label">E-mail</label>
                    <div class="col-sm-8">
                        <input type="text"  value="${user.email}"  id="email"  name="email" placeholder="请输入E-mail" class="form-control"  required >
                        <span id="checkResult1"></span>
                    </div>
                </div>

                <!-- nickname -->
                <div class="form-group">
                    <label  class="col-sm-2 control-label">昵称</label>
                    <div class="col-sm-8">
                        <input type="text" value="${user.nickname}" name="nickname" id="nickname" placeholder="请输入昵称" class="form-control" required >
                    </div>
                </div>

                <!-- bio -->
                <div class="form-group">
                    <label  class="col-sm-2 control-label">昵称</label>
                    <div class="col-sm-8">
                        <input type="text" value="${user.bio}"  name="bio" id="bio" placeholder="请输入简介" class="form-control"  >
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit"id="confirmButton" class="btn btn-success"  value="确定" >
                    </div>
                </div>
            </form>
        </div>
    </div>

</div>

</body>
</html>
