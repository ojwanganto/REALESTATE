<%@ taglib prefix="spring" uri="/WEB-INF/taglibs/spring.tld" %>
<%@ taglib prefix="c" uri="/WEB-INF/taglibs/c-rt.tld" %>
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>
<html>
<%@ include file="/WEB-INF/template/header.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/navBar.css'/>">


<body>
<div><h4>${message}</h4></div>

<p><a href="createperson.form">Create a new Person</a> </p>
<p><a href="country.form">Add Country</a></p>

</body>

<%@ include file="/WEB-INF/template/footer.jsp" %>
</html>