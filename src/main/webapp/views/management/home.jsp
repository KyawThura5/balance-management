<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>

<app:layout-management title="HOME">
	<div class="d-flex justify-content-between align-items-start mb-3">

		<app:page-title title="Admin Home"></app:page-title>
		<div class="btn-group" role="group" aria-label="Display toggle">
			<input type="radio" class="btn-check" name="display" id="monthly"
				autocomplete="off" checked /> <label
				class="btn btn-outline-secondary" for="monthly">Monthly</label> <input
				type="radio" class="btn-check" name="display" id="yearly"
				autocomplete="off" /> <label class="btn btn-outline-secondary"
				for="yearly">Yearly</label>
		</div>

	</div>

	<div class="row">

		<div class="col-3">

			<div class="card mb-3 text-bg-light">
				<div class="card-header">
					<h5 class="card-title">Last Month</h5>
				</div>
				<div class="card-body">
					<h4>15</h4>
				</div>
			</div>

			<div class="card mb-3 text-bg-secondary">
				<div class="card-header">
					<h5 class="card-title">Last Year</h5>
				</div>
				<div class="card-body">
					<h4>150</h4>
				</div>
			</div>


			<div class="card text-bg-dark">
				<div class="card-header">
					<h5 class="card-title">Total Members</h5>
				</div>
				<div class="card-body">
					<h4>1,506</h4>
				</div>
			</div>
		</div>

		<div class="col">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">
						<i class="bi-people me-2"></i>Member Access
					</h5>
					
					<div id="adminChart"></div>
				</div>
			</div>
		</div>
	</div>
<script src="https://cdn.amcharts.com/lib/5/index.js"></script>
<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
<script src="${root}/resources/js/management-home.js"></script>
</app:layout-management>