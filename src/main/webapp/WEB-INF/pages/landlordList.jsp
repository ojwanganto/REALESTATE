<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/landlord_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/landlord_mini_header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">

<script type="text/javascript">
    $(document).ready(function(){
        $('#landlord').dataTable();
    });
</script>
<body>
<br>
<h3>Landlords</h3>
<c:choose>
    <c:when test="${fn:length(landlords) > 0}">
        <table width="100%"  id="landlord">
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
            <c:forEach items="${landlords}" var="c" varStatus="status">

                <tr>
                    <td><c:out value="${c.firstName}  ${c.middleName}  ${c.lastName}" /></td>
                    <td>${c.gender}</td>
                    <td>${c.nationality.name}</td>
                    <td>${c.nationalIdNo}</td>
                    <td>${c.phoneNumber}</td>

                    <td><a href="landlord.form?id=${c.id}">Edit</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </c:when>
    <c:otherwise>
        <p>${fn:length(landlords)}</p>
    </c:otherwise>
</c:choose>


</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>