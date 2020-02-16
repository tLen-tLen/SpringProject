<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p align="center">Список животных: </p>
<table border="3" width="50%" cellpadding="2" align="center">
    <tr>
        <th>ID</th>
        <th>ИМЯ</th>
        <th>ВОЗРАСТ</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach var="animal" items="${list}">
        <tr>
            <td>${animal.id}</td>
            <td>${animal.name}</td>
            <td>${animal.age}</td>
            <td><a href="editAnimal/${animal.id}">Редактировать</a></td>
            <td><a href="deleteAnimal/${animal.id}">Удалить</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="index">Назад</a>