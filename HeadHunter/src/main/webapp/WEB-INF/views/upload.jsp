<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>HEAD HUNTER</title>
</head>

<body>
	<h1>//Upload//</h1>
	<form action="/upload" method="post" enctype="multipart/form-data">


		<label>Upload File</label><input type="file" name="file" required>

		<!-- <label>No. ID Employee:</label> <br> <input type="number" name="employeeId" required/> <br> -->

		<input type="submit" name="submit" value="UPLOAD">

	</form>

</body>

</html>