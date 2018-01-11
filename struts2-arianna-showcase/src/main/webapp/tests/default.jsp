<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="bc" uri="/struts-arianna-tags"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>

	<pre>
	action <s:property default="???" value="%{#action}"/>
	request <s:property default="???" value="%{#request}"/>
	
	
	parameters <s:property default="action?" value="%{#parameters}"/>
	</pre>
	
	Breadcrumb:
	<bc:breadcrumbs var="crumb">
		<s:property value="name"/>
		<s:url var="url" action="%{action}" namespace="%{namespace}" includeContext="false"/>
		crumb url : ${url}
		<c:forEach items="${crumb.params}" var="p">
			<c:out value="${p.key}"/>=<c:out value="${p.value[0]}"/>
			<c:out value=" "></c:out>
		</c:forEach>
				
	</bc:breadcrumbs>
</body>
</html>