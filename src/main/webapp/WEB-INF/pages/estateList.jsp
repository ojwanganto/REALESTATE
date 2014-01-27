<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/admin_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/estate_mini_header.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">

<script type="text/javascript">
    $(document).ready(function(){
        $('#estates').dataTable();
    });
</script>
<body>

<h3>Estates</h3>
<c:choose>
    <c:when test="${fn:length(countries) > 0}">
        <table width="100%"  id="estates">
            <thead>
            <tr>
                <td>Name</td>
                <td>Town</td>
                <td>Description</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${estates}" var="c" varStatus="status">
                <tr>
                    <td>${c.name}</td>
                    <td>${c.town}</td>
                    <td>${c.description}</td>

                    <td><a href="estate.form?id=${c.id}">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        <p>${fn:length(estates)}</p>
    </c:otherwise>
</c:choose>


</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>