<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-1.10.2.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery.dataTables.min.js'/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/dataTables_jui.css'/>">
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/admin_header.jsp" %>
<%@ include file="/WEB-INF/template/local_headers/mini_headers/agent_mini_header.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">

<script type="text/javascript">
    $(document).ready(function(){
        $('#agents').dataTable();
    });
</script>
<body>
<br>
<h3>Agent Information</h3>

        <table width="100%"  id="agents">
            <thead>
            <tr>
                <td>Name</td>
                <td>Address</td>
                <td>Phone Contact</td>
                <td>Bank Account</td>
                <td>Contact Person</td>
                <td>Action</td>
            </tr>
            </thead>
            <tbody>

                <tr>
                    <td>${agent.name}</td>
                    <td>${agent.address}</td>
                    <td>${agent.phoneContact}</td>
                    <td>${agent.bankAccount}</td>
                    <td>${agent.contactPerson}</td>

                    <td><a href="agent.form?id=${agent.id}">Edit</a></td>
                </tr>

            </tbody>
        </table>



</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>