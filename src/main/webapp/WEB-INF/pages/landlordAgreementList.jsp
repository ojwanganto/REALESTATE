<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/landlord_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/landlord_mini_header.jsp" %>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">


<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">

<script type="text/javascript">
    $(document).ready(function(){
        $('#agreements').dataTable();
    });
</script>
<body>
<br>
<h3>Landlord Agreements</h3>
<c:choose>
    <c:when test="${fn:length(landlordAgreements) > 0}">
        <table width="100%"  id="agreements">
            <thead>
            <tr>
                <td>Ref</td>
                <td>Landlord</td>
                <td>House</td>
                <td>Effective Date</td>
                <td>Expiry</td>
                <td>Commission (%)</td>
                <td>Date of Rent Remittance</td>

                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${landlordAgreements}" var="la" varStatus="status">
                <tr>
                    <td>${la.referenceNumber}</td>
                    <td>${la.landlord.name} </td>
                    <td>${la.house.name}</td>
                    <td>${la.effectiveDate}</td>
                    <td>${la.expiryDate}</td>
                    <td>${la.commissionOnRent}</td>
                    <td>${la.dateOfRentRemittance}</td>

                    <td><a href="landlordAgreementForm.aspx?id=${la.id}">Edit</a> | <a href="landlordAgreementDownload.aspx?aid=${la.id}">View Doc</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        <p>${fn:length(landlordAgreements)}</p>
    </c:otherwise>
</c:choose>


</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>