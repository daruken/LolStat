<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 14. 2. 12
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class='nav navbar-fixed-top navbar-default' role='navigation'>
  <div class="container">
    <div class='navbar-header'>
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class='navbar-brand' href='#'>Quasar</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-navbar-collapse-1">
      <form class="navbar-form" role="search" action="/">
        <div class="form-group">
          <input name="name" type="search" class="form-control" placeholder="Summoner Name">
        </div>
        <button type="submit" class="btn btn-success">Search</button>
      </form>
    </div>
  </div>
</nav>