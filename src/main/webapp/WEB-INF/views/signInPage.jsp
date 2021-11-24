<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div align="center">
    <h1>Sign in</h1>
    <c:if test="${param.error != null}">
        <p>Invalid username / password</p>
    </c:if>
    <form action="/sign-in" method="POST">
        <table>
            <tr>
                <td><label for="login">Login:</label> </td>
                <td><input type="text" id="login" name="login" placeholder="Login"/> </td>
            </tr>
            <tr>
                <td><label for="password">Password:</label> </td>
                <td><input type="password" id="password" name="password" placeholder="Password"> </td>
            </tr>
            <br>
            <tr>
                <td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> </td>
                <td><input type="submit" value="Sign in" /> </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>