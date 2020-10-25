<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/9/23
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8"/>
    <!--在手机网站，都需要加上视口约束！！！-->
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no"/>
    <!--以最新的内核渲染页面-->
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>登录</title>
    <!--引入css文件-->
    <link rel="stylesheet" type="text/css" href="${path}/static/bs/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${path}/static/bs/css/style.min.css"/>
    <style type="text/css">


    </style>
</head>
<body class="container">
<div class="col-md-4 col-md-offset-4">
    <div class="panel" style="width: 300px;">
        <div class="middle-box text-center loginscreen  animated fadeInDown">
            <div>
                <div>

                    <h1 class="logo-name"><img src="${path}/static/img/yx-icon.png"></h1>

                </div>
                <h3>欢迎使用 应学APP</h3>

                <form class="" role="form" action="${path}/admin/login">
                    <div class="form-group">
                        <input type="text" class="form-control" name = "username" placeholder="用户名/手机号/邮箱" required="">
                    </div>
                    <div class="form-group">
                        <input type="password" name= "password" class="form-control" placeholder="密码" required="">
                    </div>
                    <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


                    <p class="text-muted text-center"><a href="login.html#">
                        <small>忘记密码了？</small>
                    </a> | <a href="#">注册一个新账号</a>
                    </p>

                </form>
            </div>
        </div>
    </div>
</div>
<!--引入jQuery-->
<script src="static/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<!--引入js文件-->
<script src="static/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>