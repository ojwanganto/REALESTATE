<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/accounts_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/in_payments_mini_header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">

<script type="text/javascript">
    $(document).ready(function(){
        $('#paymenttable').dataTable();
    });
</script>
<body>
<br>
<h3>Payments</h3>
<c:choose>
    <c:when test="${fn:length(payments) > 0}">
        <table width="100%"  id="paymenttable">
            <thead>
            <tr>
                <td>Tenant</td>
                <td>House</td>
                <td>Unit</td>
                <td>Type</td>
                <td>Mode</td>
                <td>Period</td>
                <td>Amount</td>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${payments}" var="c" varStatus="status">
                <tr>
                    <td>${c.tenant.name}</td>
                    <td>${c.unit.house.name}</td>
                    <td>${c.unit.name}</td>
                    <td>${c.paymentType.name}</td>
                    <td>${c.paymentMode.name}</td>
                    <td>${c.paymentPeriod}</td>
                    <td>${c.amount}</td>


                    <td><a href="receipt.print?id=${c.id}">Print</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        <p>${fn:length(payments)}</p>
    </c:otherwise>
</c:choose>


</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>