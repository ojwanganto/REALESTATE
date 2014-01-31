<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<html>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/admin_header.jsp" %>

<%@ include file="/WEB-INF/template/local_headers/mini_headers/county_mini_header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">
<body>
<br>
<c:if test="${not empty county.id}">
    <h3>Edit County</h3>
</c:if>

<c:if test="${empty county.id}">
    <h3>Add County</h3>
</c:if>

<spring:hasBindErrors name="county">
    Please fix the errors below
    <br />
</spring:hasBindErrors>
<form method="post">
    <fieldset>
        <table>
            <tr>
                <td>Name:</td>
                <td>
                    <spring:bind path="county.name">
                        <input type="text" name="${status.expression}" value="${status.value}" size="35" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>Country</td>
                <td valign="top">

                    <spring:bind path="county.country.id">
                        <select name="${status.expression}">
                            <c:forEach var="country" items="${countries}">
                                <option
                                        <c:if test="${status.value==country.id}">selected</c:if> value="
                                        ${country.id}">${country.code}
                                    - ${country.name} </option>
                            </c:forEach>
                        </select>
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Code</td>
                <td valign="top">
                    <spring:bind path="county.code">
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