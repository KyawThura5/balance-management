<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ attribute name="title" required="true"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BALANCE | ${title.toUpperCase()}</title>
<c:set value="${pageContext.request.contextPath}" var="root"
	scope="request"></c:set>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href=" https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="${root}/resources/css/common.css" />

</head>
<body>
	<!-- nav bar -->
	<nav class="navbar navbar-expand sticky-top navbar-dark bg-dark">
		<div class="container">
			<a href="${root}/admin/home" class="navbar-brand"> <i
				class="bi-house"></i>Balance Admin
			</a>
			<ul class="navbar-nav">

				<li class="nav-item"><a href="${root}/admin/access  "
					class="nav-link ${title eq 'ACCESS' ? 'active' : '' }"><i
						class="bi-calendar"></i>AccessHistory</a></li>

				<li class="nav-item"><a href="${root}/admin/member"
					class="nav-link ${title eq 'MEMBERS' ? 'active' : '' }"><i
						class="bi-people"></i>Members</a></li>

				<li class="nav-item"><a href="#" id="signOutMenu" class="nav-link"><i
						class="bi-lock"></i>Sign Out</a></li>

			</ul>
		</div>
	</nav>
	<main class="container mt-4">
		<jsp:doBody></jsp:doBody>
	</main>
	<app:sign-out/>
</body>
</html>