<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/admin_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/payment_type_mini_header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">

<script type="text/javascript">
    $(document).ready(function(){
        $('#paymentType').dataTable();
    });
</script>
<body>
<br>
<h3>Payment Types</h3>
<c:choose>
    <c:when test="${fn:length(paymentTypes) > 0}">
        <table width="100%"  id="paymentType">
            <thead>
            <tr>
                <td>Name</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${paymentTypes}" var="pt" varStatus="status">

                <tr>
                    <td><c:out value="${pt.name}" /></td>
                   <%-- <td>${pt.isActive}</td>--%>

                    <td><a href="paymentType.form?id=${pt.id}">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        <p>${fn:length(paymentTypes)}</p>
    </c:otherwise>
</c:choose>


</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>