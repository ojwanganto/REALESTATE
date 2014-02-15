<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<html>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/tenant_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/tenant_mini_header.jsp" %>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui-1.10.4.custom.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/ui-lightness/jquery-ui-1.10.4.custom.min.css'/>">

<script type="text/javascript">

    $(function() {
        $("#from").datepicker();
        $("#to").datepicker();
    });

</script>
<body>
<br>
<c:if test="${not empty tenancyAgreement.id}">
    <h3>Edit Tenancy Agreement</h3>
</c:if>

<c:if test="${empty tenancyAgreement.id}">
    <h3>Add Tenancy Agreement</h3>
</c:if>

<spring:hasBindErrors name="tenancyAgreement">
    Please fix the errors below
    <br />
</spring:hasBindErrors>
<form method="post">
    <fieldset>
        <table>

                <td>Tenant</td>
                <td valign="top">

                    <spring:bind path="tenancyAgreement.tenant.id">
                        <select name="${status.expression}">
                            <c:forEach var="tenant" items="${tenants}">
                                <option
                                        <c:if test="${status.value==tenant.id}">selected</c:if> value="
                                        ${tenant.id}">${tenant.firstName} ${tenant.middleName} ${tenant.lastName} </option>
                            </c:forEach>
                        </select>
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>County</td>
                <td valign="top">


                        <select id="countyList">
                            <c:forEach var="county" items="${counties}">
                                <option
                                        <c:if test="${status.value==county.id}">selected</c:if> value="
                                        ${county.id}">${county.code}
                                    - ${country.name} </option>
                            </c:forEach>
                        </select>

                </td>
            </tr>

            <tr>
                <td>Estate</td>
                <td valign="top">

                        <select id="estateList">
                            <c:forEach var="estate" items="${estates}">
                                <option
                                        <c:if test="${status.value==estate.id}">selected</c:if> value="
                                        ${estate.id}">${estate.name} </option>
                            </c:forEach>
                        </select>

                </td>
            </tr>

            <tr>
                <td>House</td>
                <td valign="top">

                        <select id="houseList">
                            <c:forEach var="house" items="${houses}">
                                <option
                                        <c:if test="${status.value==house.id}">selected</c:if> value="
                                        ${house.id}">${house.name} </option>
                            </c:forEach>
                        </select>

                </td>
            </tr>

            <tr>
                <td>Unit</td>
                <td valign="top">

                    <spring:bind path="tenancyAgreement.unit.id">
                        <select name="${status.expression}" id="unitList">
                            <c:forEach var="unit" items="${units}">
                                <option
                                        <c:if test="${status.value==unit.id}">selected</c:if> value="
                                        ${unit.id}">${unit.name} </option>
                            </c:forEach>
                        </select>
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td>Rent Payable (Ksh.)</td>
                <td valign="top">
                    <spring:bind path="tenancyAgreement.rentPayable">
                        <input type="text" name="${status.expression}" value="${status.value}" size="20" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>
            <tr>
                <td>Deposit (Ksh.)</td>
                <td valign="top">
                    <spring:bind path="tenancyAgreement.deposit">
                        <input type="text" name="${status.expression}" value="${status.value}" size="20" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>From</td>
                <td valign="top">
                    <spring:bind path="tenancyAgreement.startDate">
                        <input type="text" name="${status.expression}" id="from" value="${status.value}" size="25" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>Expiry</td>
                <td valign="top">
                    <spring:bind path="tenancyAgreement.expiry">
                        <input type="text" name="${status.expression}" id="to" value="${status.value}" size="25" />
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