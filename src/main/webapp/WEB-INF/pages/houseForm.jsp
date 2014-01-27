<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<html>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/property_header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">
<body>
<c:if test="${not empty house.id}">
    <h2>Edit House</h2>
</c:if>

<c:if test="${empty house.id}">
    <h2>Add House</h2>
</c:if>

<spring:hasBindErrors name="house">
    Please fix the errors below
    <br />
</spring:hasBindErrors>
<form method="post">
    <fieldset>
        <table>
            <tr>
                <td>Name:</td>
                <td>
                    <spring:bind path="house.name">
                        <input type="text" name="${status.expression}" value="${status.value}" size="35" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Estate</td>
                <td valign="top">
                    <spring:bind path="house.estate">
                        <input type="text" name="${status.expression}" value="${status.value}" size="10" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Description</td>
                <td valign="top">
                    <spring:bind path="house.description">
                        <input type="text" name="${status.expression}" value="${status.value}" size="10" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Landlord</td>
                <td valign="top">
                    <spring:bind path="house.landlord">
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