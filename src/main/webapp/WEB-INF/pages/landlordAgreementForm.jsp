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
        $("#from").datepicker();
        $("#to").datepicker();
        $("#rentDeadline").datepicker();
        $("#remittanceDate").datepicker();
    });

</script>
<body>
<br>
<c:if test="${not empty landlordAgreement.id}">
    <h3>Edit Landlord Agreement</h3>
</c:if>

<c:if test="${empty landlordAgreement.id}">
    <h3>Add Landlord Agreement</h3>
</c:if>

<spring:hasBindErrors name="landlordAgreement">
    Please fix the errors below
    <br />
</spring:hasBindErrors>
<form method="post">
    <fieldset>
        <table>

                <td>Landlord</td>
                <td valign="top">

                    <spring:bind path="landlordAgreement.landlord.id">
                        <select name="${status.expression}">
                            <c:forEach var="landlord" items="${landlords}">
                                <option
                                        <c:if test="${status.value==landlord.id}">selected</c:if> value="
                                        ${landlord.id}">${landlord.name} </option>
                            </c:forEach>
                        </select>
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>House</td>
                <td valign="top">
                    <spring:bind path="landlordAgreement.house.id">
                        <select name="${status.expression}" id="houseList">
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

            <tr>
                <td>Commission on Rent ( % )</td>
                <td valign="top">
                    <spring:bind path="landlordAgreement.commissionOnRent">
                        <input type="text" name="${status.expression}" value="${status.value}" size="20" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>Effective Date</td>
                <td valign="top">
                    <spring:bind path="landlordAgreement.effectiveDate">
                        <input type="text" name="${status.expression}" id="from" value="${status.value}" size="25" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>Expiry Date</td>
                <td valign="top">
                    <spring:bind path="landlordAgreement.expiryDate">
                        <input type="text" name="${status.expression}" id="to" value="${status.value}" size="25" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>Date of Rent Remittance</td>
                <td valign="top">
                    <spring:bind path="landlordAgreement.dateOfRentRemittance">
                        <input type="text" name="${status.expression}" id="remittanceDate" value="${status.value}" size="25" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>Deadline for Rent Collection</td>
                <td valign="top">
                    <spring:bind path="landlordAgreement.tenantsDeadlineForRentPayment">
                        <input type="text" name="${status.expression}" id="rentDeadline" value="${status.value}" size="25" />
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