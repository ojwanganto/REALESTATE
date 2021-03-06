<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<html>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/landlord_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/landlord_mini_header.jsp" %>

<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui-1.10.4.custom.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/ui-lightness/jquery-ui-1.10.4.custom.min.css'/>">

<script type="text/javascript">

    $(function() {
        $("#dob").datepicker();
    });

</script>
<body>
<br>
<c:if test="${not empty landlord.id}">
    <h3>Edit Landlord</h3>
</c:if>

<c:if test="${empty landlord.id}">
    <h3>Add Landlord</h3>
</c:if>

<spring:hasBindErrors name="landlord">
    Please fix the errors below
    <br />
</spring:hasBindErrors>
<form method="post">
    <fieldset>
        <table>
            <tr>
                <td>First Name:</td>
                <td>
                    <spring:bind path="landlord.firstName">
                        <input type="text" name="${status.expression}" value="${status.value}" size="35" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td>Middle Name:</td>
                <td>
                    <spring:bind path="landlord.middleName">
                        <input type="text" name="${status.expression}" value="${status.value}" size="35" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>
                    <spring:bind path="landlord.lastName">
                        <input type="text" name="${status.expression}" value="${status.value}" size="35" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td valign="top">Gender:</td>
                <td valign="top">
                    <spring:bind path="landlord.gender">
                    <select name="${status.expression}">
                        <option value="M">M</option>
                        <option value="F">F</option>
                        </spring:bind>
                </td>
            </tr>
            <tr>
                <td valign="top">DOB</td>
                <td valign="top">
                    <spring:bind path="landlord.dob">
                        <input type="text" name="${status.expression}" id="dob" value="${status.value}" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>


            <tr>
                <td>National ID No</td>
                <td valign="top">
                    <spring:bind path="landlord.nationalIdNo">
                        <input type="text" name="${status.expression}" value="${status.value}" size="10" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td>Phone Number</td>
                <td valign="top">
                    <spring:bind path="landlord.phoneNumber">
                        <input type="text" name="${status.expression}" value="${status.value}" size="10" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>Address</td>
                <td valign="top">
                    <spring:bind path="landlord.address">
                        <input type="text" name="${status.expression}" value="${status.value}" size="10" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>Nationality</td>
                <td valign="top">

                    <spring:bind path="landlord.nationality.id">
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


        </table>
        <br />

        <input type="submit" value="Save" name="save">

    </fieldset>
</form>

</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>