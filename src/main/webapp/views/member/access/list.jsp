<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<app:layout-member title="Access">
	<app:page-title title="Access History"></app:page-title>
	<form class="row">

		<div class="col-auto">
			<label class="form-label">Date From</label> <input type="date"
				class="form-control" />
		</div>

		<div class="col-auto">
			<label class="form-label">Date To</label> <input type="date"
				class="form-control" />
		</div>

		<div class="col-auto">
			<label class="form-label">Keyword</label> <input type="text"
				class="form-control" placeHolder="Search Here" />
		</div>

		<div class="col btn-wrapper">
			<button class="btn btn-primary">
				<i class="bi-search"></i>Search
			</button>
		</div>

	</form>

	<table class="table table-bordered table-striped table-hover my-3">

		<thead>
			<tr>
				<th>Access At</th>
				<th>Access Type</th>
				<th>Status</th>
				<th>Remark</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>2025-02-01</td>
				<td>Login</td>
				<td>Fails</td>
				<td>Remark</td>
			</tr>
		</tbody>
	</table>
	<app:pagination></app:pagination>
</app:layout-member>