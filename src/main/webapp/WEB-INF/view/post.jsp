<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->

    <!--  Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!--  Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>sign in</title>

</head>
<body style="background-color: #d1d9e0;">

<script>

    function submit_button() {
        // document.getElementById('reply_form').submit();
        // $("#reply_form").submit();
        
        var postid = $("#postid").val();
        var content = $("#reply_textarea").val();

        if (content==null || content.trim()==""){
            alert("不能为空");
            return;
        }

        var data = {
            post : postid,
            content : content,
            replyTo:"0"
        };

        // alert(JSON.stringify(data));

        $.ajax({
            type : "POST",
            url : "/forum/publishReply",
            data : JSON.stringify(data),
            dataType : "json",
            contentType : "application/json;charset=UTF-8",

            success : function (result) {
                if (result["msg"] == "success") {
                    alert("回复成功");
                    window.location.href = "/forum/post/"+postid;
                }else if(result["msg"] == "unlogin"){
                    alert("请先登陆");

                    return;
                }
            },
            error : function (result) {
                alert("error"+result)
            }
        });

    }



    function report(postid,replyid){
        var reason=prompt("reason");

        if(reason!=null  &&  reason.trim()!=""){
            if(replyid==undefined)
                window.location.href="report?"+"pid="+postid+"&reason="+String(reason);
            else
                window.location.href="report?rid="+replyid+"&pid="+postid+"&reason="+String(reason);
        }
    }



    function confirm_delete(){
        if(confirm("确定删除？"))
            return true;
        return false;
    }



    function to_reply(user,rid){
        // publish_reply?pid=${post.id}
        var action=document.getElementById('reply_form').action;
        action+="&to_reply="+String(rid);
        document.getElementById('reply_form').action=action;

        //&quot;&quot; == " "
        var at='@'+user;
        document.getElementById('myModalLabelOne').innerHTML=at;
    }



    function reset_modal(){
        document.getElementById('myModalLabelOne').innerHTML="发布回复";
    }



    function appear_reply(obj,obj_this,content,time,username){
        var top=obj_this.getBoundingClientRect().top;
        var left=obj_this.getBoundingClientRect().left;


        obj.style.display="";
        obj.style.top=parseInt(top)+"px";
        obj.style.left=parseInt(left)+"px";

        document.getElementById("username").innerHTML=username;
        document.getElementById("content").innerHTML=content;
        document.getElementById("time").innerHTML=time;
    }

    function disappear_reply(obj){
        obj.style.display="none";
    }

    function test(obj){

        alert("距离顶部："+obj.offsetTop+"距离左边："+obj.offsetLeft);

    }

</script>



<%@ include file="commoms/navbar.jsp"%>

<div class="container">

    <!-- title and content  in  wall-->
    <div class="well wall-sm" style="box-shadow: 5px 5px 5px gray;">
        <div class="page-header" style="padding-top: 50px">

            <div class="media">
                <div class="media-body">
                    <h2 class="media-heading">${post.title }</h2>
                    <blockquote class="pull-right">
                        <cite title="Source Title">${post.user.nickname }</cite>
                        <small><cite title="Source Title">${post.publishTime }</cite></small>
                    </blockquote>
                </div>
                <div class="media-right">
                    <img src="${pageContext.request.contextPath }/img_profile/${post.user.profile }" class="media-object" style="width:100px">
                </div>
            </div>

            <div style="background-color: #66a9">
                <div style="float: left;width: 300px;padding-left: 400px;">
                    <strong>${post.hit }hit</strong>
                </div>
<%--                <div style="float: right">--%>
<%--                    <c:if test="${sessionScope.user!=null && sessionScope.user.status!=7}">--%>
<%--                        <!----%>
<%--                        <a href="report?pid=${post.id}" data-toggle="modal"--%>
<%--                        data-target="#report">report</a>--%>
<%--                        -->--%>
<%--                        <strong><a href="#" onclick="report(${post.id} )">report</a></strong>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${sessionScope.user.status==7 }">--%>
<%--                        <strong><a href="delete_post?pid=${post.id }" onclick="confirm_delete()">delete</a></strong>--%>
<%--                    </c:if>--%>
<%--                </div>--%>
            </div>
        </div>

        <h4>${post.content }</h4>

    </div>

    <!-- publish reply -->
    
 
    
    <!-- 
    <a href="#"   onmouseover="appear_reply(document.getElementById('float'))" onmouseout="disappear_reply(document.getElementById('float'))">>>>>>>>>>></a>
     -->

    <!--  
    <div  id="float" style=" width: 600px; height: 100px;
    background-color: #abcd; display: none;position: fixed;" 
    appear_reply(this)" onmouseout="disappear_reply(document.getElementById('float'))" >
    </div>
     -->

    <!-- display @ -->
    <div class="panel panel-default"  id="float" style="color:#abcd;position: fixed;display: none;"
         onmouseout="disappear_reply(document.getElementById('float'))">
        <div class="panel-body">
            <p id="username" style="color:#ed5736"></p>
            <strong id="content" style="width: 800px;color: #000000">content </strong>
            <p id="time" style="color: #000222"><small> asdsdf</small></p>

            <!--  <a href="report?rid=${reply.id }&pid=${reply.post_id}"> report</a>  -->
        </div>
    </div>


    <!--  display reply  -->
    <c:forEach var="reply" items="${replies}">
        <div class="panel panel-default" style="box-shadow: 5px 5px 5px gray;">
            <div class="panel-body" style="padding-top: 2px;">

                <div style="float: left;width: 100px;">
                    <div>
                        <img src="${pageContext.request.contextPath }/img_profile/${reply.user.profile }" class="img-rounded" width="50px" >
                    </div>

                        <%--                    <a href="profile/${reply.user.id }"  style="color: #ed5736">${reply.user.nickname }</a>--%>
                    <div>
                        <a href="profile/${reply.user.id }"  style="color: #ed5736">nickname</a>
                    </div>
                </div>
                
                <div style="float: left;">
                    <c:if test="${reply.replyTo!=null }">
                        <a style="color: #0c8918" href="#" onclick="test(this)" onmouseenter="appear_reply(document.getElementById('float'),this,&quot;${reply.to_reply.content }&quot; , &quot;${reply.to_reply.publishTime}&quot;,&quot;${reply.to_reply.user.username }&quot;)" >@${ reply.to_reply.user.username}</a>
                    </c:if>

                    <strong style="width: 800px;white-space: pre-wrap ;background-color: #e74c3c"> ${reply.content } </strong>

                    ${reply.publishTime }
<%--                    ${reply.replyTo.floor }--%>
                </div>



<%--                <c:if test="${reply.isBanned==1 }">--%>
<%--                    <img src="image/" class="img-rounded" width="50px">--%>
<%--                    <a>無</a>--%>

<%--                    <strong style="color: #e74c3c"> 已被删除 </strong>--%>
<%--                    ${reply.publishTime }--%>
<%--                </c:if>--%>

<%--                <span class="badge">#2 </span>--%>

<%--                <c:if test="${sessionScope.user!=null  &&  sessionScope.user.id!=reply.user.id    &&  reply.isBanned==0}">--%>
<%--                    <!--  <a href="report?rid=${reply.id }&pid=${reply.post.id}"> report</a>  -->--%>
<%--                    <c:if test="${sessionScope.user.status!=7 }">--%>
<%--                        <a href="#" onclick="report(${reply.post.id},${reply.id} )"> report</a>--%>
<%--                    </c:if>--%>
<%--                    <a href="#" data-toggle="modal" data-target="#myModal"--%>
<%--                       onclick="to_reply(&quot;${reply.user.nickname}&quot;,${reply.id })">@</a>--%>
<%--                </c:if>--%>

<%--                <c:if test="${reply.isBanned==0 }">--%>
<%--                    <c:if test="${sessionScope.user.status==7    ||   sessionScope.user.id==reply.user.id }">--%>
<%--                        <a onclick="confirm_delete(${reply.id},${reply.post.id })"  href="reply_delete?rid=${reply.id}&pid=${reply.post_id}" >delete</a>--%>
<%--                    </c:if>--%>
<%--                </c:if>--%>
            </div>

        </div>
    </c:forEach>

    <!-- 按钮触发模态框 -->
    <div >
        <button class="btn btn-primary btn-lg" data-toggle="modal"
                data-target="#myModal" onclick="reset_modal()">
            <h5>回复</h5>
        </button>
    </div>

    <!-- ---------   pagination   ------------->
<%--    <ul class="pagination pagination-lg" style="padding-top: 100px">--%>
<%--        <!-- 上一页 -->--%>
<%--        <c:if test="${page.cur!=1 }">--%>
<%--            <li><a href="post_detail?pid=${post.id }&cur=${page.cur-1}">&laquo;</a></li>--%>
<%--        </c:if>--%>


<%--        <!-- 当前页为中心前后各显示2页 -->--%>
<%--        <c:set var="size" value="2" scope="page"></c:set>--%>
<%--        <c:set var="begin" value="1" scope="page"></c:set>--%>
<%--        <c:set var="end" value="${page.totalPage }" scope="page"></c:set>--%>
<%--        <!-- 判断前面有没有2页 -->--%>
<%--        <c:if test="${page.cur>pageScope.size }">--%>
<%--            <c:set var="begin" value="${page.cur-pageScope.size }" scope="page"></c:set>--%>
<%--        </c:if>--%>
<%--        <!-- 判断后面有没有2页 -->--%>
<%--        <c:if test="${page.cur<page.totalPage-pageScope.size }">--%>
<%--            <c:set var="end" value="${page.cur +pageScope.size}" scope="page"></c:set>--%>
<%--        </c:if>--%>
<%--        <!-- 显示(begin~end) -->--%>
<%--        <c:forEach begin="${begin}" end="${end }" var="i">--%>
<%--            <c:if test="${page.cur!=i }">--%>
<%--                <li><a href="post_detail?pid=${post.id }&cur=${i}">${i }</a></li>--%>
<%--            </c:if>--%>
<%--            <c:if test="${page.cur==i }">--%>
<%--                <li class="active"><a>${i }</a></li>--%>
<%--            </c:if>--%>
<%--        </c:forEach>--%>


<%--        <!-- 下一页 -->--%>
<%--        <c:if test="${page.totalPage!=page.cur }">--%>
<%--            <li><a href="post_detail?pid=${post.id }&cur=${page.cur+1}">&raquo;</a></li>--%>
<%--        </c:if>--%>
<%--    </ul>--%>

    <!--  
			[${page.totalRecord }]
			<h2>m:${param.method }</h2>
			<h2>b:${param.bid }</h2>
			<h2>c:${param.cur }</h2>
		-->
</div>




<!-- 发布模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabelOne" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h3 class="modal-title" id="myModalLabelOne">发布回复</h3>
            </div>
            <div class="modal-body">
                <div>
                    <form action="#"  id="reply_form" role="form">
                        <input type="hidden" id="postid"  value="${post.id}">
                        <div class="form-group">
                            <label >请输入内容(<small>500字以内</small>)</label>
                            <textarea id="reply_textarea"  class="form-control" rows="4" cols="65" name="replyContent" ></textarea>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" onclick="submit_button()"
                        class="btn btn-primary">提交
                </button>
            </div>
        </div>
    </div>
</div>



</body>
</html>
