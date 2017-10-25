<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="bc" uri="/struts-arianna-tags"%>

    <div id="cases">
        <h3><a href='#'>Simple Actions</a></h3>
        <div class='case'>
            <p>
                five simple actions marked with annotation like:
                <pre class='code'><code class='java'>@BreadCrumb("Simple <i>...</i>")</code></pre>
            </p>
            <ul>
                <s:iterator status="s" var="v" value="{1,2,3,4,5}">
                <li>
                    <sj:a href="simple-simple%{v}.do"
                        onSuccessTopics="/arianna"
                        effect="highlight"
                        targets="action_result">Simple <s:property value='#s.index + 1'/></sj:a>
                </li>
                </s:iterator>
            </ul>
        </div>

        <h3><a href='#'>Action with different parameter value</a></h3>
        <div class='case'>
            <p>
                Here you can invoke the same action with different parameters values.<br/>
            </p>
            <s:form action="pAction" theme='xhtml' id="pForm">
                <s:select name='p' list="{'pippo','pluto','paperino','topolino','minnie'}" label="p parameter"/>
                <sj:submit value="execute" onSuccessTopics="/arianna" targets="action_result" effect="highlight" formIds="pForm"/>
            </s:form>
            <p>
                If you you are using the <code>RequestComparator</code> it will compares values and recognize
                the actions inequalities.
            </p>
        </div>

        <h3><a href='#'>Different actions with equals  annotation</a></h3>
        <div class='case'>
            <p>
                Here you can invoke different actions annotated with the <em>same</em> @BreadCrumb annotation.
                If the crumb produced by such actions are considered equals or not depends by the actual comparator.
            </p>
            <pre class='code'><code>@BreadCrumb("Crumb-A")</code></pre>
            <ul>
                <s:iterator var="a" value="{'A1','A2','A3'}" status="s">
                    <li>
                        invoke
                        <sj:a href="same-%{a}.do"
                            onSuccessTopics="/arianna"
                            effect="highlight"
                            targets="action_result">
                            Action-${a}
                        </sj:a>
                    </li>
                </s:iterator>
            </ul>
            <pre class='code'><code>@BreadCrumb("Crumb-B")</code></pre>
            <ul>
                <s:iterator var="b" value="{'B1','B2','B3'}" status="s">
                    <li>
                        invoke
                        <sj:a href="same-%{b}.do"
                            onSuccessTopics="/arianna"
                            effect="highlight"
                            targets="action_result">
                            Action-${b}
                        </sj:a>
                    </li>
                </s:iterator>
            </ul>
        </div>

        <h3><a href='#'>Breadcrumb's' name as OGNL expression</a></h3>
        <div class='case'>
            <p>
                clicking <i>execute</i> invokes an action annotated with
                <pre class='code'><code class='java'>@Breadcrumb("%{name}")</code></pre>
                as a result the typed text will be used as the bread crumb name.
            </p>
            <s:form id='ognl1' action="ognl-name">
                <s:textfield name='name' label="name" required="true"></s:textfield>
                <sj:submit value="execute" onSuccessTopics="/arianna" targets="action_result" effect="highlight" formIds="ognl1"/>
            </s:form>
            <hr/>
            <p>
                clicking <i>execute</i> invokes an action annotated with
                <pre class='code'><code class='java'>@BreadCrumb(value="%{name}",afterAction=true)</code></pre>
                as a result the %{name} expression will be evaluated <u>after</u> the action's execution, giving
                it a chance to compute the expression.<br/>
                In this example the action just reverse the typed text.
            </p>
            <s:form id='ognl2' action="ognl-reverse">
                <s:textfield name='name' label="name" required="true" value="hello"></s:textfield>
                <sj:submit value="execute" onSuccessTopics="/arianna" targets="action_result" effect="highlight"  formIds="ognl2"/>
            </s:form>

        </div>

        <h3><a href='#'>Actions overriding the default behaviour</a></h3>
        <div class='case'>
            <p>Whathever the breadcrumb trail configuration is, it can be overriden
                by any <code>@BreadCrumb</code> annotation.
                <br/>
            </p>
            <p>

            <ul>
                <li>
                    <!--
                    <pre class='code'><code class='java'>@Breadcrumb("Test")</code></pre>
                     -->
                    <sj:a href='override-Test.do'
                        onSuccessTopics="/arianna"
                        targets="action_result">test</sj:a>
                </li>
            <%--
                <li>
                    <pre class='source'><code class='java'>@BreadCrumb(value="")</code></pre>
                    override rewind mode with <sj:a href='override-RewindModeNEVER.do'
                        onSuccessTopics="/arianna"
                        targets="action_result">NEVER</sj:a>
                </li>
                <li>
                    override rewind mode with <sj:a href='override-RewindModeAUTO.do'
                        onSuccessTopics="/arianna"
                        targets="action_result">AUTO</sj:a>
                </li>
             --%>
                <li>
                <%--
                    <pre class='code'><code class='java'>@Breadcrumb(value="Test",comparator=NameComparator.class)</code>
                    </pre>
                --%>
                    use <sj:a href='override-NameComparator.do'
                        onSuccessTopics="/arianna"
                        targets="action_result">NameComparator</sj:a>
                </li>
                <li>
                    use <sj:a href='override-ActionComparator.do'
                        onSuccessTopics="/arianna"
                        targets="action_result">ActionComparator</sj:a>
                </li>
                <li>
                    use <sj:a href='override-RequestComparator.do'
                        onSuccessTopics="/arianna"
                        targets="action_result">RequestComparator</sj:a>

                </li>
            </ul>
        </div>
    </div>

