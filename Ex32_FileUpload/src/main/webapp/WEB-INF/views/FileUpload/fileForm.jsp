<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>FileUpload</title>
</head>
<body>

<form action="uploadOk" method="post" 
       enctype="multipart/form-data">
	파일: <input type="file" name="files" multiple><br>
	<input type="submit" value="File Upload">
</form>

</body>
</html>