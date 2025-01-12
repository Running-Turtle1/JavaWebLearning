<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>studentAdd</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        #container {
            width: 400px;
            margin: 30px auto;
        }
    </style>
</head>
<body>
<div id="container">
    <form class="form-horizontal" action="add" method="post">
        <div class="form-group">
            <label class="col-sm-2 control-label">编号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="id" placeholder="请输入编号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">课程号</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="cno" placeholder="请输入课程号"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">课程名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="cname" placeholder="请输入课程名"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">学分</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="credit" placeholder="请输入学分"/>
            </div>
        </div>
        <div class="form-group">
            <label class="col-sm-2 control-label">备注</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="memo" placeholder="请输入备注"/>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">添加</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>