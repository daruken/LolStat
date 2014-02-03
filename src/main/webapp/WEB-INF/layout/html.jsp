<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 14. 2. 3
  Time: 오후 5:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE HTML>
<html lang="${lang}">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name='viewport' content='width=device-width, initial-scale=1.0'>
  <title><tiles:insertAttribute name="title" defaultValue="Lol Stat" /></title>
  <jsp:include page="/WEB-INF/include/common.jsp" />
</head>
<body data-spy="scroll" data-twttr-rendered="true">
  <tiles:insertAttribute name="body" />
</body>
</html>
