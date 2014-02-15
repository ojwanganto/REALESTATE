<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/tenant_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/tenant_mini_header.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">

<script type="text/javascript">
    $(document).ready(function(){
        $('#tenant').dataTable();
    });
</script>
<body>
<br>
<h3>Tenants</h3>
<c:choose>
    <c:when test="${fn:length(tenants) > 0}">
        <table width="100%"  id="tenant">
            <thead>
            <tr>
                <td>Name</td>
                <td>Gender</td>
                <td>Nationality</td>
                <td>ID NO</td>
                <td>Contact No</td>

                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tenants}" var="c" varStatus="status">
                <tr>
                    <td><c:out value="${c.firstName}  ${c.middleName}  ${c.lastName}" /></td>
                    <td>${c.gender}</td>
                    <td>${c.nationality.name}</td>
                    <td>${c.nationalIdNo}</td>
                    <td>${c.phoneNumber}</td>

                    <td><a href="tenant.form?id=${c.id}">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        <p>${fn:length(tenants)}</p>
    </c:otherwise>
</c:choose>


</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>