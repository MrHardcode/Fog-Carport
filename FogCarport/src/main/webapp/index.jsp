<%-- 
    Document   : index
    Created on : 11-04-2019, 22:36:17
    Author     : Asger
--%>

<%@page import="java.util.ArrayList"%>
<!--The following tag is the JSTL Expression Language tag-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    ArrayList list = new ArrayList();
    String one = "one";
    String two = "two";
    String three = "three";
    String four = "four";
    list.add(one);
    list.add(two);
    list.add(three);
    list.add(four);
    request.getSession().setAttribute("items", list);
%>

<jsp:include page='/header.jsp'></jsp:include>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Fog Carport</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="partslist.jsp">Stykliste </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="makeCarport.jsp">Lav Carport </a>
      </li>
    </ul>
  </div>
</nav>
<!-- Navigation end -->

    <!-- Show errormessage to the User --> 
<c:if test="${not empty message}">
    <H2>Message: ${message} </h2>
    </c:if>

<h1>Hello my man!</h1>
<c:forEach var="item" items="${items}">
    <p>
        ${item}
    </p>
</c:forEach>
<jsp:include page='/footer.jsp'></jsp:include>
