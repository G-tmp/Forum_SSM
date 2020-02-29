<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commoms/navbar.jsp"%>


<html>
<head>

    <title>Sign up</title>

</head>

<body>


<script>
    
    var  flagEmail = false;
    var  flagNick = false;


    function checkEmail() {
        var email=$("#email").val();
        var url="check_email";

        var data={
            email:email
        };


        //校验空格
        if (email == null || email == ""){
            $("#checkResult1").html("");
        }else if(!blank(email)) {
            flagEmail = false;
            $("#checkResult1").html("<font color='red'>不能包含空格</font>");
        }else{
            $.ajax({
                type: "get",
                data: data,
                dataType: "json",
                url: url,
                success: function (result) {
                    if (result["msg"] == "duplicate"){
                        flagEmail = false;
                        $("#checkResult1").html("<font color='red'>抱歉，该邮箱已被注册，请更换！</font>");
                    }else if (result["msg"] == "unique"){
                        flagEmail = true;
                        $("#checkResult1").html("<font color='#7fffd4' '>naisuuuuuuu!</font>");
                    }
                }
            });
        }

        disableButton();
    }
    
    
    function checkName() {
        var nickname=$("#nickname").val();
        var url="check_nickname";

        var data={
            nickname:nickname
        };

        //校验空格
        if (nickname == null  ||  nickname==""){
            $("#checkResult2").html("");
        } if(!blank(nickname)) {
            flagNick = false;
            $("#checkResult2").html("<font color='red'>不能包含空格</font>");
        }else{
            $.ajax({
                type: "get",
                data: data,
                dataType: "json",
                url: url,
                success: function (result) {
                    if (result["msg"] == "duplicate"){
                        flagNick = false;
                        $("#checkResult2").html("<font color='red'>抱歉，该昵称已被注册，请更换！</font>");
                    }else if (result["msg"] == "unique") {
                        flagNick = true;
                        $("#checkResult2").html("<font color='#7fffd4' '>naisuuuuuuu!</font>");
                    }
                }
            });
        }

        disableButton();
    }
    


    function register() {
        var url="register";

        var nickname=$("#nickname").val();
        var email=$("#email").val();
        var password=$("#password").val();
        var password2=$("#password2").val();
        
        if (password != password2){
            alert("密码不一致")
            return;
        }

        var user={
            nickname:nickname,
            email:email,
            password:password
        };

        // alert(JSON.stringify(user));

        $.ajax({
            data:JSON.stringify(user),
            type:"post",
            dataType:"json",
            url:url,
            contentType : "application/json;charset=UTF-8",
            success:function (result) {
                if (result["msg"] == "success") {
                    alert("success");
                    window.location.href = "<%=path%>/login";
                }
            },
            error:function () {
                alert("error")
            }
        });
    }
    
    
    function disableButton() {
        // alert(flagNick);
        // alert("email : "+flagEmail+"\n"+"nick : "+flagNick);
        if (flagNick){
            $("#confirmButton").removeAttr("disabled");
        }else{
            $("#confirmButton").attr("disabled","disabled");
        }
    }


    function blank(str) {
        if (str.indexOf(" ") == -1){
            return true;
        } else {
            return false;
        }
    }
    
</script>




<div class="container">
    <div style="padding-top: 200px;"></div>


    <div class="panel panel-default">

        <div class="panel-heading">
            <h3 class="panel-title">
                注册
            </h3>
        </div>
        
        <div class="panel-body">
            <form class="form-horizontal" role="form">

                <!-- E-mail -->
                <div class="form-group">
                    <label class="col-sm-2 control-label">E-mail</label>
                    <div class="col-sm-8">
                        <input type="text " onkeyup="checkEmail()"  id="email"  name="email" placeholder="请输入E-mail" class="form-control"  required >
                        <span id="checkResult1"></span>
                    </div>
                </div>

                <!-- nickname -->
                <div class="form-group">
                    <label  class="col-sm-2 control-label">昵称</label>
                    <div class="col-sm-8">
                        <input type="text " onkeyup="checkName()"  name="nickname" id="nickname" placeholder="请输入昵称" class="form-control" required >
                        <span id="checkResult2"></span>
                    </div>
                </div>

                <!-- password -->
                <div class="form-group">
                    <label  class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-8">
                        <input type="password " name="password" id="password"  placeholder="请输入密码" class="form-control" required >
                    </div>
                </div>

                <!-- password again -->
                <div class="form-group">
                    <label class="col-sm-2 control-label">确认密码</label>
                    <div class="col-sm-8">
                        <input type="password"  name="password2" id="password2"  placeholder="确认密码" class="form-control" required >
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="button" onclick="register()" id="confirmButton" class="btn btn-success"  value="注册" disabled="disabled">
                    </div>
                </div>
            </form>
        </div>
    </div>

    
</div>

</body>
</html>
