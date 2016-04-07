<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="bc" uri="/struts-arianna-tags"%>


<h1>Struts<sup>2</sup> Arianna Plugin Showcase app</h1>
<div style="margin-top:-1.5em; font-style: italic;">
    <s:property value='pluginSpec'/>
</div>
<br/>
<div id='arianna2'>
    <sj:div href="arianna.jsp" onSuccessTopics="/success/effect" listenTopics="/arianna" effect="highlight">arianna contents goes here</sj:div>
</div>
