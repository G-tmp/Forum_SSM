<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<body style=" background-color: #d1d9e0;">
<%@ include file="/WEB-INF/view/commoms/navbar.jsp"%>

<script>
    function confirm() {
        var url="login";
        var email=$("#email").val();
        var password=$("#password").val();

        var user={
            email:email,
            password:password
        };

        $.ajax({
            type : "post",
            url : url,
            data : JSON.stringify(user),
            dataType : "json",
            contentType : "application/json;charset=UTF-8",
            success : function (result) {
                if (result["msg"] == "success")
                    window.location.href="home";
                else if (result["msg"] == "wrong")
                    alert("密码错误")
                else if (result["msg"] == "null")
                    alert("账号不存在");
            },
            error : function () {
                alert("error");
            }
        })
    }

</script>


<div class="container">
    <div style="padding-top: 200px;"></div>

    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title">
                登陆
            </h3>
        </div>
        
        <div class="panel-body">
            <!-- form -->
            <form  class="form-horizontal" role="form">
                <!-- email -->
                <div class="form-group">
                    <label  class="col-sm-2 control-label">邮箱</label>
                    <div class="col-sm-8">
                        <input type="text "  name="email" id="email" placeholder="请输入邮箱" class="form-control" required >
                    </div>
                </div>
                <!-- password -->
                <div class="form-group">
                    <label class="col-sm-2 control-label">
                        密码
                    </label>
                    <div class="col-sm-8">
                        <input type="password" name="password" id="password" class="form-control" placeholder="请输入密码" required >
                    </div>
                </div>
                <!-- submit -->
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="button" class="btn btn-success" value="登陆" onclick="confirm()">
                    </div>
                </div>
            </form>
        </div>
    </div>
    
    
</div>

</body>
</html>
