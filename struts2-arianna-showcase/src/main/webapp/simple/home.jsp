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
    <jsp:include page='inc/head.jsp'/>
    
<body>


<div id="header">
	<img id="myDefaultIndicator" src="images/ajax-loader.gif" alt="Loading..." style="display:none"/>
    <jsp:include page='inc/header.jsp'/>
</div>

<div id="gutter">
    <!-- this is the gutter -->
</div>
<div id="col2">
    <div id='wrp'>
       <jsp:include page='inc/test-cases.jsp'/>
    </div>
</div>

<!-- === Column 1 (center)======================================================================================-->
<div id="col1">
    <sj:div id="action_result" onSuccessTopics='/arianna /success/effect'>
        <jsp:include page='body.jsp'/>
    </sj:div>
</div>

<!-- === Column 3 (right)======================================================================================-->
<div id="col3">
    <div id='controls' class='ui-widget ui-corner-all'>
<%--		<h4 class='ui-state-default' style='margin:0 0 0 0; padding:0.3em 0.3em 0.3em 0.3em'><a>Breadcrumb trail configuration</a></h4>  --%>
        <h4 class='ui-widget-header' style='margin-top: 1px; margin-bottom: 1px;'>Behaviour configuration</h4>
        <div class='ui-widget-content'>
            <c:import url="controls.jsp" />
        </div>
    </div>
</div>
<div id="footer">
    <jsp:include page='inc/footer.jsp'/>
</div>
</body>
</html>