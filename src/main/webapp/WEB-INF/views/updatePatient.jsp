<html>
<title>Hospital Website</title>
<head>

</head>
<body>
<div align="center">
    <h1>Update patient form</h1>
    <form action="patient-update" method="post">
        <table>
        <tr>
            <td>Enter patient id</td>
            <td><input type="text" name="id"/></td>
        </tr>
        <br>
        <tr>
            <td>Select parameter to change</td>
            <td>
                <select name="parameter">
                    <option value="name">Full name</option>
                    <option value="number">Phone number</option>
                    <option value="email">Email</option>
                    <option value="login">Login</option>
                    <option value="password">Password</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>New parameter value</td>
            <td><input type="text" name="newValue"/></td>
        </tr>
        <br>
        </table>
        <input type="submit" value="Update"/>
    </form>
</div>
</body>
</html>