<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="common/navigation.jspf"%>
<%@include file="common/header.jspf"%>
        <div class="container">
            <h1>Your Todo list are </h1>
            <table class = "table">
            <thead>
                  <tr>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Is Done?</th>
                    <th></th>
                    <th></th>
                   </tr>
             </thead>
            <tbody>
                <c:forEach items = "${todos}" var  = "todo">
                    <tr>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.done}</td>
                        <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
                        <td><a href="update-todo?id=${todo.id}" class="btn btn-Warning">Update</a></td>
                     </tr>
                </c:forEach>
            </tbody>
            </table>
            <a href="addTodo" class="btn btn-Dark">Add</a>
            <%@include file="common/footer.jspf"%>