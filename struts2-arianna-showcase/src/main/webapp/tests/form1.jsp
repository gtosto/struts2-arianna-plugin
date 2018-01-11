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

<jsp:include page="default.jsp"></jsp:include>
<hr/>

<s:form namespace="/tests">
	<s:textfield name="text1" label="text1"></s:textfield>	
	<s:textfield name="text2" label="text2"></s:textfield>
	<s:textfield name="p1" label="p1"></s:textfield>
	<s:textfield name="qui" label="qui"></s:textfield>
	<s:textfield name="quo" label="quo"></s:textfield>
	<s:textfield name="qua" label="qua"></s:textfield>
	
	<s:submit name="submission_1" label="s1"></s:submit>	
	<s:submit name="submission_2" label="s2"></s:submit>	
</s:form>

</body>
</html>