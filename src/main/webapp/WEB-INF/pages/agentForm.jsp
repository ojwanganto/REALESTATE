<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<html>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/admin_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/agent_mini_header.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">
<body>
<br>
<c:if test="${not empty agent.id}">
    <h3>Edit Agent</h3>
</c:if>

<c:if test="${empty agent.id}">
    <h3>Add Agent</h3>
</c:if>

<spring:hasBindErrors name="agent">
    Please fix the errors below
    <br />
</spring:hasBindErrors>
<form method="post">
    <fieldset>
        <table>
            <tr>
                <td>Agent Name:</td>
                <td>
                    <spring:bind path="agent.name">
                        <input type="text" name="${status.expression}" value="${status.value}" size="50" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Address</td>
                <td valign="top">
                    <spring:bind path="agent.address">
                        <textarea name="${status.expression}" cols="50" rows="5"><c:out value="${status.value}"></c:out></textarea>
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Phone Contact</td>
                <td valign="top">
                    <spring:bind path="agent.phoneContact">
                        <input type="text" name="${status.expression}" value="${status.value}" size="20" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Bank Account</td>
                <td valign="top">
                    <spring:bind path="agent.bankAccount">
                        <input type="text" name="${status.expression}" value="${status.value}" size="20" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Contact Person</td>
                <td valign="top">
                    <spring:bind path="agent.contactPerson">
                        <input type="text" name="${status.expression}" value="${status.value}" size="30" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>



        </table>
        <br />

        <input type="submit" value="Save" name="save">

    </fieldset>
</form>

</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>