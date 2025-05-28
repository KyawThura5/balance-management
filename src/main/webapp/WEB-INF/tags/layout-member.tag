<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
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
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<link rel="stylesheet" href="${root}/resources/css/common.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light sticky-top shadow">
		<div class="container">

			<a href="${root}/member/home" class="navbar-brand"> <i
				class="bi-house"></i>Balance Management
			</a>
			<ul class="navbar-nav">

				<li class="nav-item"><a href="${root }/member/balance"
					class="nav-link ${title eq 'BALANCES' ? 'active' : '' }"> <i
						class="bi-bar-chart"></i>Balances
				</a></li>

				<li class="nav-item ${title eq 'INCOMES' ? 'active' : '' }"><a
					href="${root }/member/entry/incomes" class="nav-link"> <i
						class="bi-flag"></i>Incomes
				</a></li>

				<li class="nav-item ${title eq 'EXPENSES' ? 'active' : '' }"><a
					href="${root }/member/entry/expenses" class="nav-link"> <i
						class="bi-cart"></i>Expenses
				</a></li>

				<li class="nav-item ${title eq 'LEDGERS' ? 'active' : '' }"><a
					href="${root }/member/ledger" class="nav-link"> <i
						class="bi-tags"></i>Ledgers
				</a></li>

				<li class="nav-item"><a href="${root}/signin" class="nav-link">
						<i class="bi-lock"></i>Sign Out
				</a></li>

			</ul>
		</div>
	</nav>
	<main class="container mt-4">
		<jsp:doBody></jsp:doBody>
	</main>
</body>
</html>