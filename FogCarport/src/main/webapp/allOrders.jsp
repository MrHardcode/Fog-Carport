
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <table class="table table-hover">
        <thead>
            <tr>
                <th scope="col">Order #</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="id" items="${ids}">
            <tr>
                <td> <!-- This is pretty fugly imo - Please improve if you wish -->
                    <a type="button" class="btn btn-secondary btn-lg btn-block" href="FrontController?command=viewOrder&orderid=${id}">ID#: ${id}</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
