<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<html>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/accounts_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/in_payments_mini_header.jsp" %>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui-1.10.4.custom.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/ui-lightness/jquery-ui-1.10.4.custom.min.css'/>">

<script type="text/javascript">
    $(document).ready(function(){

        $(function() {
            $("#effectiveDate").datepicker();

        });

        $('#estateList').change(function() {
            var estateId = $('#estateList').val().trim();
            if(estateId == null)
                return false;

            var eId = $.trim(estateId);

            $.getJSON('${pageContext.request.contextPath}/ajaxCalls/houseList/' + estateId, function(houseList) {
                var inputString = '<select id="houseList"> <option>Select House</option>';
                $.each(houseList, function(){
                    inputString = inputString + '<option value="' + this['id'] + '" > ' + this['name'] + '</option>';
                    //console.log(this['id'] + " -->" + this['name']);
                });

                inputString = inputString + "</select>";
                $("#houseList").html(inputString);
                // console.log(inputString);

            });
        });

        /**
         * Handle on change event of house list
         */

        $('#houseList').change(function() {
            var houseId = $('#houseList').val().trim();
            var tenantId = $('#tenant').val().trim();
            if(houseId == null)
                return false;

            $.getJSON('${pageContext.request.contextPath}/ajaxCalls/unitList/' + houseId + '/' + tenantId, function(unitList) {
                var inputString = '<select id="unitList"> ';
                $.each(unitList, function(){
                    inputString = inputString + '<option value="' + this['id'] + '" > ' + this['name'] + '</option>';

                });

                inputString = inputString + "</select>";
                $("#unitList").html(inputString);
                // console.log(inputString);

            });
        });

        /**
         * event change for paymentMode dropdown
         */

        $('#paymentMode').change(function() {
            var modeId = $('#paymentMode').val().trim();
            var bankData = '<fieldset><table><tr>' +
                               '<td>Bank</td>' +
                               '<td><input type="text" name="bank" size="30" id="bank"/></td>' +
                               '</tr>' +
                               '<tr>' +
                               '<td>Branch</td>' +
                               '<td><input type="text" name="branch" size="30" id="branch"/></td>' +
                               '</tr>' +
                               '<tr>' +
                               '<td>Receipt-No</td>' +
                               '<td><input type="text" name="receiptNo" size="30" id="receiptNo"/></td>' +
                               '</tr>' +
                           '</table></fieldset>';

            var mobileData = '<fieldset><table><tr>' +
                                '<td>Phone No</td>' +
                                '<td><input type="text" name="phoneNo" size="30" id="phoneNo"/></td>' +
                                '</tr>' +
                                '<tr>' +
                                '<td>Transaction Code</td>' +
                                '<td><input type="text" name="transactionCode" size="30" id="transactionCode"/></td>' +
                                '</tr>' +
                              '</table></fieldset>';
            if(modeId == 2){

                $("#paymentDetails").html(bankData);
            } else if(modeId == 3){
                $("#paymentDetails").html(mobileData);
            } else {
                $("#paymentDetails").html("");
            }
        });

    });
</script>
<body>
<br>
<c:if test="${not empty payment.id}">
    <h3>Edit Payment </h3>
</c:if>

<c:if test="${empty payment.id}">
    <h3>Add Payment</h3>
</c:if>

<spring:hasBindErrors name="payment">
    Please fix the errors below
    <br />
</spring:hasBindErrors>
<form method="post">
    <fieldset>
        <table>

            <td>Tenant</td>
            <td valign="top">

                <spring:bind path="payment.tenant.id">
                    <select name="${status.expression}" id="tenant">
                        <option>Select Tenant</option>
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
                <td>Estate</td>
                <td valign="top">

                    <select id="estateList">
                        <option>Select Estate</option>
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
                        <option>Select House</option>
                    </select>

                </td>
            </tr>

            <tr>
                <td>Unit</td>
                <td valign="top">
                    <spring:bind path="payment.unit.id">

                    <select name="${status.expression}" id="unitList">
                        <option>Select Unit</option>
                       <%-- <c:forEach var="county" items="${counties}">
                            <option
                                    <c:if test="${status.value==county.id}">selected</c:if> value="
                                        ${county.id}">${county.code}
                                - ${country.name} </option>
                        </c:forEach>--%>
                    </select>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>Payment Type</td>
                <td valign="top">
                    <spring:bind path="payment.paymentType.id">
                    <select id="paymentType" name="${status.expression}">
                        <option>Select Payment Type</option>
                        <c:forEach var="pType" items="${paymentTypes}">
                            <option
                                    <c:if test="${status.value==pType.id}">selected</c:if> value="${pType.id}">${pType.name} </option>
                        </c:forEach>
                    </select>
                    </spring:bind>

                </td>
            </tr>

            <tr>
                <td>Period</td>
                <td valign="top">
                    <spring:bind path="payment.paymentPeriod">
                    <select id="paymentPeriod" name="${status.expression}">
                        <option>Select Period</option>
                        <c:forEach var="p" items="${period}">
                            <option value="${p}" >${p} </option>
                        </c:forEach>
                    </select>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>Mode of Payment</td>
                <td valign="top">
                    <spring:bind path="payment.paymentMode.id">
                    <select id="paymentMode" name="${status.expression}">
                        <option>Select Mode</option>
                        <c:forEach var="pMode" items="${paymentModes}">
                            <option
                                    <c:if test="${status.value==pMode.id}">selected</c:if> value="${pMode.id}">${pMode.name} </option>
                        </c:forEach>
                    </select>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                <td><div id="paymentDetails"></div></td>
            </tr>

            <tr>
                <td>Amount (Ksh.)</td>
                <td valign="top">
                    <spring:bind path="payment.amount">
                        <input type="text" name="${status.expression}" value="${status.value}" size="20" />
                        <c:if test="${status.errorMessage != ''}"><c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if></c:if>
                    </spring:bind>
                </td>
            </tr>

            <tr>
                <td valign="top">Description</td>
                <td valign="top">
                    <spring:bind path="payment.description">
                        <textarea name="${status.expression}" cols="50" rows="5"><c:out value="${status.value}"></c:out></textarea>
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