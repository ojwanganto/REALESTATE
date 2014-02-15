<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/tenant_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/tenant_mini_header.jsp" %>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">


<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">

<script type="text/javascript">
    $(document).ready(function(){
        $('#leases').dataTable();
    });
</script>
<body>
<br>
<h3>Lease Agreements</h3>
<c:choose>
    <c:when test="${fn:length(tenancyAgreements) > 0}">
        <table width="100%"  id="leases">
            <thead>
            <tr>
                <td>Ref</td>
                <td>Tenant</td>
                <td>Landlord</td>
                <td>House</td>
                <td>Unit</td>
                <td>From</td>
                <td>To</td>

                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tenancyAgreements}" var="ta" varStatus="status">
                <tr>
                    <td>${ta.referenceNumber}</td>
                    <td>${ta.tenant.firstName} ${ta.tenant.middleName} ${ta.tenant.lastName}</td>
                    <td>${ta.landlord.firstName} ${ta.landlord.middleName} ${ta.landlord.lastName}</td>
                    <td>${ta.house.name}</td>
                    <td>${ta.unit.name}</td>
                    <td>${ta.startDate}</td>
                    <td>${ta.expiry}</td>

                    <td><a href="tenancyAgreementForm.aspx?id=${ta.id}">Edit</a> | <a href="tenancyAgreementDownload.aspx?aid=${ta.id}">View Doc</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        <p>${fn:length(tenancyAgreements)}</p>
    </c:otherwise>
</c:choose>


</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>