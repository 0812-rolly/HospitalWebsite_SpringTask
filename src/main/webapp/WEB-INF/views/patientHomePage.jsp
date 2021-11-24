<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HospitalApp</title>
</head>
<body>
<div>
    <%@ page contentType="text/html;charset=utf-8" %>
    <h1>Patient home page</h1>
    <p>Name: "${name}"</p>
    <p>Login: "${login}"</p>
    <p>Phone: "${phone}"</p>
    <p>Email: "${email}"</p>
    <form action="/patient/patients-get" method="get">
        <input type="submit" value="Go to all patients list" />
    </form>
    <form action="/patient/patient-update" method="get">
        <input type="submit" value="Edit personal info" />
    </form>
    <form action="/patient/patient-delete" method="get">
        <input type="submit" value="Delete current patient account" />
    </form>
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Log out" />
    </form>
</div>
</body>
</html>