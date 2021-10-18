<html lang="en" xmlns:th="http://thymeleaf.org">
<title>Hospital Website</title>

<head>
</head>
<body>
<br>
<br>
    <div th:each="patient : ${patients}" align="center">
        <p th:text="${patient.toString()}"></p>
    </div>
</body>
</html>