<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">
<%@ include file="/WEB-INF/template/header.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">

<script type="text/javascript">
    $(document).ready(function(){
        $('#countries').dataTable();
    });
</script>
<body>

<h3>Units</h3>
<c:choose>
    <c:when test="${fn:length(countries) > 0}">
        <table width="100%"  id="countries">
            <thead>
            <tr>
                <td>Name</td>
                <td>Code</td>

                <td>Action</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${countries}" var="c" varStatus="status">
                <tr>
                    <td>${c.name}</td>
                    <td>${c.code}</td>

                    <td><a href="country.form?cid=${c.id}">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        <p>${fn:length(countries)}</p>
    </c:otherwise>
</c:choose>


</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>