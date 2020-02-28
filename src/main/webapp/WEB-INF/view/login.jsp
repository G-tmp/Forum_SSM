<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commoms/navbar.jsp"%>

<html>
<head>

    <title>sign in</title>
    
</head>
<body>


<script>
    function confirm() {
        var url="<%=path%>/login";
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
