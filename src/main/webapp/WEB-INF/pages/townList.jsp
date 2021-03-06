<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/admin_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/town_mini_header.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">

<script type="text/javascript">
    $(document).ready(function(){
        $('#town').dataTable();
    });
</script>
<body>
<br>
<h3>Towns</h3>
<c:choose>
    <c:when test="${fn:length(towns) > 0}">
        <table width="100%"  id="town">
            <thead>
            <tr>
                <td>Name</td>
                <td>County</td>

                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${towns}" var="c" varStatus="status">
                <tr>
                    <td>${c.name}</td>
                    <td>${c.county.name}</td>

                    <td><a href="town.form?id=${c.id}">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        <p>${fn:length(towns)}</p>
    </c:otherwise>
</c:choose>


</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>