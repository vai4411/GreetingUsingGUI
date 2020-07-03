<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body onload="load();">
<div>
    <form id="myForm" class="greeting" method="post" action="add" onsubmit="return validateForm();">
        <label class="greeting1" onclick="showPanel()">ADD GREETING</label><br>
        <div id="panel" class="greeting2">
            <input class="input1" type="text" name="firstName" placeholder="Enter First Name">
            <input class="input2" type="text" name="lastName" placeholder="Enter Last Name">
            <input type="hidden" id="index" name="index" value=""/>
            <input id="mainButton" class="button1" type="submit" name="submit" value="ADD">
            <input class="button2" type="reset" name="reset"  onclick="cancel();" value="CANCEL"><br>
        </div>
    </form>
    <div class="greeting2">
        <table class="gridtable" style="width: 100%;">
            <tr>
                <th>Greeting Id</th>
                <th>Content</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <%-- JSTL foreach tag varStatus example to show count in JSP  --%>
            <c:forEach var="greeting" items="${Greeting}"  >
                <tr>
                    <td> <c:out value=" ${greeting.getCounter()}"/> </td>
                    <td> <c:out value="${greeting.name}"/> </td>
                    <td> <input type="button"  value="Update" onclick="update(${greeting.counter});"/></td>
                    <td><form method="post" action="delete">
                        <input type="hidden" name="id" value="${greeting.counter}"/>
                        <input type="submit" name="Delete" value="Delete"/>
                    </form></td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>
<script>
    function validateForm() {
        var x = document.forms["myForm"]["firstName"].value;
        var y = document.forms["myForm"]["lastName"].value;
        if (x == "" || y=="") {
            alert("Invalid Input..");
            return false;
        }
    }

    function update(id)
    {
       var button=document.getElementById("mainButton");
       button.value="UPDATE";
       var form=document.getElementById("myForm");
       document.getElementById("index").value=id;
       form.action="update";
    }

    function  cancel()
    {
        var button=document.getElementById("mainButton");
        button.value="ADD";
        var form=document.getElementById("myForm");
        form.action="add";
        var x = document.getElementById("panel");
        x.style.display = "none";
    }

    function load(){
        var x = document.getElementById("panel");
        x.style.display = "none";
    }

    function showPanel() {
        var x = document.getElementById("panel");
            x.style.display = "block";
    }
</script>
</body>
</html>
