<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<html>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/admin_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/country_mini_header.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">
<body>
<br>
<c:if test="${not empty country.id}">
    <h3>Edit Country</h3>
</c:if>

<c:if test="${empty country.id}">
    <h3>Add Country</h3>
</c:if>

<spring:hasBindErrors name="country">
    Please fix the errors below
    <br />
</spring:hasBindErrors>
<form method="post">
    <fieldset>
        <table>
            <tr>
                <td>Name:</td>
                <td>
                    <spring:bind path="country.name">
                        <input type="text" name="${status.expression}" value="${status.value}" size="35" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Code</td>
                <td valign="top">
                    <spring:bind path="country.code">
                        <input type="text" name="${status.expression}" value="${status.value}" size="10" />
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