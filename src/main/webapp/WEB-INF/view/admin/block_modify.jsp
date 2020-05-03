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
        <div class="panel-heading">
            <h3 class="panel-title">
                修改版块
            </h3>
        </div>

        <div class="panel-body">
            <!-- form -->
            <form  class="form-horizontal" role="form" method="post" action="../modifyBlock">
                <input type="hidden" value="${block.id}" name="id" id="id">

                <!-- name -->
                <div class="form-group">
                    <label  class="col-sm-2 control-label">
                        名称
                    </label>
                    <div class="col-sm-8">
                        <input type="text" value="${block.name}"  name="name" id="name" placeholder="请输入版块名称" class="form-control" required >
                    </div>
                </div>
                <!-- ename -->
                <div class="form-group">
                    <label class="col-sm-2 control-label">
                        英文名称
                    </label>
                    <div class="col-sm-8">
                        <input type="text" value="${block.ename}" name="ename" id="ename" class="form-control" placeholder="请输入版块英文名称" required >
                    </div>
                </div>
                <!-- description -->
                <div class="form-group">
                    <label class="col-sm-2 control-label">
                        简介
                    </label>
                    <div class="col-sm-8">
                        <input type="text" value="${block.description}" name="description" id="description" class="form-control" placeholder="请输入版块简介"  >
                    </div>
                </div>
                <!-- submit -->
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-success" value="确定">
                    </div>
                </div>
            </form>
        </div>
    </div>


</div>

</body>
</html>
