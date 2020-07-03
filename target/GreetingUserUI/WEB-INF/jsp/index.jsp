<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div>
    <form class="greeting">
        <label class="greeting1">ADD GREETING</label><br>
        <div class="greeting2">
            <input class="input1" type="text" name="name" placeholder="Enter First Name">
            <input class="input2" type="password" name="password" placeholder="Enter Last Name">
            <input class="button1" type="submit" name="submit" value="SAVE">
            <input class="button2" type="submit" name="submit" value="CANCEL"><br>
        </div>
    </form>
    <div class="greeting2">
        <table style="width: 100%;">
            <tr>
                <td class="button3">Greeting Id</td>
                <td class="button3">Content</td>
                <td class="button3">Edit</td>
                <td class="button3">Delete</td>
            </tr>
            <%-- JSTL foreach tag varStatus example to show count in JSP  --%>
            <c:forEach var="greeting" items="${Greeting}"  >
                <tr>
                    <td class="button3"> <c:out value=" ${greeting.getCounter()}"/> </td>
                    <td  class="button3"> <c:out value="${greeting.name}"/> </td>
                    <td  class="button3"></td>
                    <td  class="button3"><form method="post" action="delete">
                        <input type="hidden" name="id" value="${greeting.counter}"/>
                        <input type="submit" name="Delete" value="Delete"/>
                    </form></td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>
</body>
</html>
