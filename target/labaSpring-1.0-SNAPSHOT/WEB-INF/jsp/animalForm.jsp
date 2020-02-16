<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p align="center">Новое животное: </p>
<form:form method="post" action="insert">
    <table align="center" border="3">
        <tr>
            <td>Введите имя: </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Введите возраст :</td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Сохранить" /></td>
        </tr>
    </table>
</form:form>
