<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ page import="com.kulinichev.util.SortUtils" %>
    
<!DOCTYPE html>

<html>

	<head>

		<meta charset="ISO-8859-1">

		<title>List Customers</title>
	<!-- reference our style    	 -->
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/src/main/resources/css/style.css"/> 	
		
	</head>

	<body>
	
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manger </h2>			
			</div>			
		</div>
		
		<div id="container">
		
			<div id="content">
	<!-- put button: add Customer-->
			<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"
			/>
			
	<!--  add a search box -->
            <form:form action="search" method="GET">
                Search customer: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>		
			
			<!-- add our html table here--> 
				<table>
				
					<tr>
						<th><a href="${sortLinkFirstName}">First Name</a></th>
						<th><a href="${sortLinkLastName}">Last Name</a></th>
						<th><a href="${sortLinkEmail}">Email</a></th>
						<th>Action</th>				
					</tr>
					
			<!-- construct a sort link for first name -->
				<c:url var="sortLinkFirstName" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.FIRST_NAME) %>" />
				</c:url>		
			<!-- construct a sort link for last name -->
				<c:url var="sortLinkLastName" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.LAST_NAME) %>" />
				</c:url>					
 
			<!-- construct a sort link for email -->
				<c:url var="sortLinkEmail" value="/customer/list">
					<c:param name="sort" value="<%= Integer.toString(SortUtils.EMAIL) %>" />
				</c:url>				
				
			<!-- loop over and print our customer--> 
					<c:forEach var="tempCustomer" items="${customers}">
					
						<!-- construct an "update" link with customer id	 -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
										
					<!-- construct an "delete" link with customer id	 -->
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<tr>
							<td> ${tempCustomer.firstName} </td>
							<td> ${tempCustomer.lastName} </td>
							<td> ${tempCustomer.email} </td>
							
							<td>
							<!-- display the update link -->
								<a href="${updateLink}">Update</a>
								|
								<!-- display the delete link -->
								<a href="${deleteLink}"
									onclick="if (!(confirm('Are your sure you want to delete this customer?'))) return false">Delete</a>
							</td>
						</tr>
						
					</c:forEach>
					
				</table>
				 		
			</div>	
					
		</div>
	
	</body>

</html>