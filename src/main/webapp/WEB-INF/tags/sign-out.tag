<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set value="${pageContext.request.contextPath}" var="root"
	scope="request"></c:set>
<form id="signOutForm" class="d-none" action="${root}/signout" method="post">
<sec:csrfInput/>
</form>
<script src="/resources/js/sign-out.js"></script>
