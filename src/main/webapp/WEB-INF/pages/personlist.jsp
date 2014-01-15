<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">
<script type="text/javascript">
    $(document).ready(function(){
        $('#persons').dataTable();
    });
</script>
<body>

 <h3>List of Persons</h3>
 <c:choose>
     <c:when test="${fn:length(persons) > 0}">
         <table width="100%"  id="persons">
             <thead>
             <tr>
                 <td>Name</td>
                 <td>Gender</td>
                 <td>DOB</td>
                 <td>Occupation</td>
                 <td>Action</td>
             </tr>
             </thead>
             <tbody>
             <c:forEach items="${persons}" var="person" varStatus="status">
                 <tr>
                     <td>${person.name}</td>
                     <td>${person.gender}</td>
                     <td>${person.dob}</td>
                     <td>${person.occupation}</td>
                     <td><a href="createperson.form?personId=${person.id}">Edit</a></td>
                 </tr>
             </c:forEach>
             </tbody>
         </table>

     </c:when>
     <c:otherwise>
         <p>${fn:length(persons)}</p>
     </c:otherwise>
 </c:choose>


</body>
</html>