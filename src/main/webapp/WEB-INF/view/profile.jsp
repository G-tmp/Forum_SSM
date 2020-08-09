<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commoms/navbar.jsp"%>



<html>
<head>

    <title>个人资料</title>

</head>
<body>

<script>
    function upload() {

        // if (($("#pic_img").val()){
        //     alert("null");
        //     return;
        // }

        var formData = new FormData($("#uploadForm")[0]);   //创建一个forData
            // formData.append("img",$("#pic_img")[0].file[0]);    //把file添加进去  name命名为img

        // alert(formData);

        $.ajax({
            type : "POST",
            url : "<%=path%>/uploadImg",
            data : formData,
            dataType : "json",
            encrypt : "multipart/form-data",
            contentType : false,
            processData : false,
            cache : false,
            success : function (result) {
                // alert(result.path);

                if (result.msg == "success"){
                    alert("success");
                    $("#image").attr("src",result.path);
                }else {
                    alert("failed");
                }
            },
            error : function () {
                alert("error！")
            }

        });

        // $("#pic_img").attr("value","");
    }

</script>

<div class="container">

    <div style="padding-top: 150px;"></div>

    <div class="panel panel-default">
        <div class="panel-body">
            <img id="image" src="<%=path%>/resources/img_profile/${user.profile}" class="img-rounded" width="120px" height="120px;">
            <h2 >${user.nickname }</h2>
            <h3 >email：${user.email}</h3>

<%--            <h3>创建于: <fmt:formatDate value="${user.registerTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate></h3>--%>
            <h3>创建于: ${user.registerTime}</h3>
            <h3>自我介绍: ${user.bio}</h3>

            <%--    <form role="form"  id="uploadForm" action="uploadImg" method="post" enctype="multipart/form-data">--%>
            <div class="well">
                <form role="form"  id="uploadForm">
                    <div class="form-group">
                        <label>上传头像</label>
                        <input type="file" id="pic_img" name="img" accept="*">
                    </div>
                    <%--        <input type="submit" class="btn btn-default" value="D">--%>
                    <button type="button" class="btn btn-default" onclick="upload()">upload</button>
                </form>
            </div>


            <a href="updateMe"><button type="button" class="btn btn-default" >修改个人信息</button></a>
        </div>
    </div>



    <!-- 历史发帖 -->
    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion"
                       href="#collapseOne">
                        点击我展开发帖记录
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse">
                <c:forEach var="post" items="${posts }">
                    <div class="panel-body">
                        <a href="../post/${post.id}">${post.title }</a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>


    <!-- 历史回复 -->
<%--    <div class="panel-group" >--%>
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
<%--                <c:forEach var="reply" items="${replies}">--%>
<%--                    <div class="panel-body">--%>
<%--                        <p style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width: 800px;">${reply.content }	</p>--%>
<%--                    </div>--%>
<%--                </c:forEach>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>


</div>
</body>
</html>