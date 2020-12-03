<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %> 
<%@ page import="connectiondb.Connectiondb" %>

<html>
<head>
<title>display data from the table using jsp</title>
</head>
<body>
<h2>Data from the table 'park' of database 'mydb'</h2>
<%

try {
ResultSet rs = null;
Statement statement = null;
Connection db = null;
Connectiondb.getdb();
        //DriverManager.getConnection(url,user,password);
// sql query to retrieve values from the secified table.
String QueryString = "SELECT * FROM park";
rs = statement.executeQuery(QueryString);
%>
<TABLE cellpadding="15" border="1" style="background-color: #ffffcc;">
<%
while (rs.next()) {
%>
<TR>
<TD><%=rs.getString(1)%></TD>
<TD><%=rs.getString(2)%></TD>
<TD><%=rs.getString(3)%></TD>
</TR>
<% } %>
<%
// close all the connections.
rs.close();
statement.close();
//db.close();
} catch (Exception ex){
%>
</font>
<font size="+3" color="red"></b>
<%
out.println("Unable to connect to database.");
}
%>
</TABLE><TABLE>
<TR>
<TD><FORM ACTION="index.jsp" method="get" >
<button type="submit"><-- back</button></TD>
</TR>
</TABLE>
</font>
</body>
</html>
