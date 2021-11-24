<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>HospitalApp</title>
</head>
<body>
<div>
    <%@ page contentType="text/html;charset=utf-8" %>
    <h1>Doctor home page</h1>
    <p>Name: "${name}"</p>
    <p>Login: "${login}"</p>
    <p>Phone: "${phone}"</p>
    <p>Email: "${email}"</p>
    <p>Speciality: "${speciality}"</p>
    <form action="/doctor/doctors-get" method="get">
        <input type="submit" value="Go to all doctors list" />
    </form>
    <form action="/doctor/doctor-update" method="get">
        <input type="submit" value="Edit personal info" />
    </form>
    <form action="/doctor/doctor-delete" method="get">
        <input type="submit" value="Delete current doctor account" />
    </form>
    <form action="/logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Log out" />
    </form>
</div>
</body>
</html>