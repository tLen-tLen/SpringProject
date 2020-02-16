<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Edit Employee</h1>
<form:form method="POST" action="/editsave">
    <table >
        <tr>
            <td></td>
            <td><form:hidden  path="id" /></td>
        </tr>
        <tr>
            <td>Имя : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Возраст :</td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form:form>
