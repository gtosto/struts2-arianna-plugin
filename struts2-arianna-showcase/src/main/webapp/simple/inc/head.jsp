<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="bc" uri="/struts-arianna-tags"%>

<s:set var="theme" value="'xhtml'" scope="page" />
<c:set var='contextName' value='${pageContext.servletContext.contextPath}'/>

    <title>Struts2 - Arianna Plugin</title>
    <link rel="stylesheet" type="text/css" href="${contextName}/res/css/layout.css" media="screen" />

    <script src="http://yandex.st/highlightjs/5.16/highlight.min.js"></script>
    <link rel="stylesheet" href="http://yandex.st/highlightjs/5.16/styles/school_book.min.css">

    <link rel="stylesheet" type="text/css" href="${contextName}/res/css/site.css"/>


    <sj:head debug="false" jqueryui="true" jquerytheme="overcast" loadAtOnce='true' defaultIndicator="myDefaultIndicator"/>

    <!-- also include the jquery tools -->
    <script src="http://cdn.jquerytools.org/1.2.5/tiny/jquery.tools.min.js"></script>

    <script type="text/javascript" >
        $.subscribe('/success/effect', function(event,element) {
            $(element).effect("highlight", {}, 500);
        });
    </script>

    <script type="text/javascript">
        $(document).ready(function() {
            $('.crumb').tooltip();
            $('.tipped').tooltip();

            $( "#cases" ).accordion({
                autoHeight: false
            });

            $( "button, input:submit").button();

            $("pre.code").each(function(index,elem) {
                hljs.highlightBlock(elem, '    ', false);
            });

//			$( "#radio" ).buttonset();
        });
    </script>

    <style>
        .tooltip {
            display:none;
            background-color: red;
            font-size:12px;
/*
            height:70px;
            width:160px;
*/
            padding:25px;
            color:#fff;
        }

        a {
            text-decoration: underline;
        }

        label {
            font-family: sans-serif;
            /* color: #6EAC2C; */
        }

        #cases {
            font-size: 8pt;
        }

        #controls {
            font-size: 8pt;
        }

        #arianna2 {
            padding-top: 1px;
            padding-bottom: 1px;
            border-bottom: 1px solid silver;
            border-top: 1px solid silver;
        }
    </style>

<script type="text/javascript">
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-11437334-3']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</script>

