<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page import="java.util.ArrayList"%>

<font color="green"> <%
 	ArrayList<String> namesList = (ArrayList<String>) request.getAttribute("data");
 %></font>

<table border="1">
	<tr>
		<th>Select</th>
		<th>Emp ID</th>
		<th>Emp Name</th>
		<th>Edit Employee</th>
		<th>Delete Employee</th>
	</tr>
	<%
		int i = 0;
		for (String name : namesList) {
			i++;
	%>
	<form action="delete">
	<tr>
		<td><input type="radio" name="id" value="<%=i%>"></td>
		<td>
			<%
				out.println(i);
			%>
		</td>
		<td>
			<%
				out.println(name);
			%>
		</td>
		<td><input type="submit" value="edit"></td>
		<td><input type="submit" value="delete"></td>
	</tr>
	</form>
	<%
		}
	%>
</table>

