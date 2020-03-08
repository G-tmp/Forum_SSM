<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commoms/navbar.jsp"%>



<html>
<head>

    <title>个人资料</title>

</head>
<body>

    <script>
        function upload() {
            
            if ($("#pic_img").var()==""){
                //为空
            }else{
                //不为空
            }
            
            var formData = new formData($("#uploadForm")[0]);   //创建一个forData
            // formData.append("img",$("#pic_img")[0].file[0]);    //把file添加进去  name命名为img

            $.ajax({
                type : "POST",
                url : "<%=path%>/uploadImg",
                data : formData,
                encrypt : "multipart/form-data",
                contentType : false,
                processData : false,
                cache : false,
                success : function (result) {
                    if (result["msg"] == "success"){
                        alert("success");
                    }else {
                        alert("failed");
                    }
                },
                error : function () {
                    alert("這是替身攻擊！")
                }
            })

        }

    </script>

<div class="container">

    <div style="padding-top: 150px;"></div>

    <img src="<%=path%>/resources/img_profile/${user.profile}" class="img-rounded" width="120px" height="120px;">
    <h2>${user.nickname }</h2>

    <h3>创建于: ${user.registerTime}</h3>
    <h3>自我介绍: ${user.bio}</h3>

    <form role="form"  id="uploadForm" action="<%=path%>/uploadImg" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label>上传头像</label>
            <input type="file" id="pic_img" name="img" accept="*">
        </div>
<%--        <input type="submit" class="btn btn-default" value="D">--%>
        <button type="submit" class="btn btn-default" >提交</button>
    </form>


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