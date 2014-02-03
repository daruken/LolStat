<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<tiles:insertTemplate template="/WEB-INF/layout/html.jsp">
  <tiles:insertAttribute name="body">
    <form method="post" action="/SearchSummoner">

      <input type="text" name="name">
      <input type="submit" value="search">
    </form>

  </tiles:insertAttribute>
</tiles:insertTemplate>