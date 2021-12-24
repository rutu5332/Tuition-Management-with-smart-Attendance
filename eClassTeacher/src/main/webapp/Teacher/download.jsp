<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
HttpSession s = request.getSession();
String filename = (String)s.getAttribute("path");
//String filepath = "f:\\";   
String savepath = "C:\\Users\\hp\\Downloads\\eClass (2)\\eClass\\src\\main\\webapp\\Assests\\Assignment_files\\";
response.setContentType("APPLICATION/OCTET-STREAM");   
response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
System.out.println(filename);
response.setContentType("APPLICATION/OCTET-STREAM");   

java.io.FileInputStream fileInputStream=new java.io.FileInputStream(savepath+filename);  
          
int i;   
while ((i=fileInputStream.read()) != -1) {  
  out.write(i);   
}   
fileInputStream.close();   

%>
</body>
</html>