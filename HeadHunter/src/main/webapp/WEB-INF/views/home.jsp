<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>HEAD HUNTER</title>
</head>

<body>

	<form action="/HeadHunter/insert" method="post">


		<br> <input type="text" name="nik" placeholder="Nik" required /> <br>
		<input type="text" name="firstname" placeholder="First Name" required /> <br>
		<input type="text" name="lastname" placeholder="Last Name" required /> <br>
		<input type="text" name="username" placeholder="Username" required /> <br>
		<input type="password" name="password" placeholder="Password" required /> <br>
		<input type="text" name="address" placeholder="address" required /> <br>
		<input type="text" name="email" placeholder="Email" required /> <br>
		<input type="text" name="noTelp" placeholder="No Telp" required /> <br>
		<input type="date" name="dob" placeholder="Date Of Birth" required /> <br>
		<!-- <label>No. ID Employee:</label> <br> <input type="number" name="employeeId" required/> <br> -->

		<input type="submit" name="submit" value="Create">

	</form>

</body>

</html>