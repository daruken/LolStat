<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 14. 2. 12
  Time: 오후 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--[if lt IE 9]>
<script src="//cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.js"></script>
<![endif]-->
<script src="//cdnjs.cloudflare.com/ajax/libs/modernizr/2.7.1/modernizr.min.js"></script>
<script src='//cdnjs.cloudflare.com/ajax/libs/Base64/0.2.0/base64.min.js'></script>
<script src='//cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.3.1/jquery.cookie.min.js'></script>
<script src='//cdnjs.cloudflare.com/ajax/libs/lodash.js/2.4.1/lodash.min.js'></script>
<script src='//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.0.0/backbone-min.js'></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.1.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/json2/20121008/json2.js"></script>
<script>
  _.templateSettings = {
    interpolate: /\<\@\=(.+?)\@\>/gim,
    evaluate: /\<\@(.+?)\@\>/gim,
    escape: /\<\@\-(.+?)\@\>/gim
  };
</script>

<script src="${pageContext.request.contextPath}/resources/js/lolstat.js"></script>
