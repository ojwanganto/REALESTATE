<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<html>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/property_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/unit_mini_header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">
<body>
<br>
<c:if test="${not empty unit.id}">
    <h3>Edit Unit</h3>
</c:if>

<c:if test="${empty unit.id}">
    <h3>Add Unit</h3>
</c:if>

<spring:hasBindErrors name="unit">
    Please fix the errors below
    <br />
</spring:hasBindErrors>
<form method="post">
    <fieldset>
        <table>
            <tr>
                <td>Name:</td>
                <td>
                    <spring:bind path="unit.name">
                        <input type="text" name="${status.expression}" value="${status.value}" size="35" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Description</td>
                <td valign="top">
                    <spring:bind path="unit.description">
                        <textarea name="${status.expression}" cols="50" rows="5"><c:out value="${status.value}"></c:out></textarea>
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>House</td>
                <td valign="top">

                    <spring:bind path="unit.house.id">
                        <select name="${status.expression}">
                            <c:forEach var="house" items="${houses}">
                                <option
                                        <c:if test="${status.value==house.id}">selected</c:if> value="
                                        ${house.id}">${house.name}</option>
                            </c:forEach>
                        </select>
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