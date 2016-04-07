<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="bc" uri="/struts-arianna-tags"%>

<%--
    <div id='arianna' class="ui-widget-content">
        <sj:div href="arianna.jsp" onSuccessTopics="/success/effect" listenTopics="/arianna">arianna contents goes here</sj:div>
    </div>
--%>
    <hr/>
    <sj:div id="action_result" onSuccessTopics='/arianna /success/effect'>
        <p>
        This web application was developed to test the behaviour of the plugin.
        However it can also be used to show the plugin capabilities.
        </p>
        <p>
            Use the test cases availables on the left to see how the
            <a href='https://github.com/gtosto/struts2-arianna-plugin'>
                <span>struts<sup>2</sup> arianna plugin</span>
            </a> reacts to different action annotation.
        </p>

        <p>
            You can use the panel on the right to reconfigure the bread crumb trail defaults.
            Invoke the test cases with different configurations of the plugin and see how the bread crumb trail
            reacts.
        </p>
    </sj:div>
