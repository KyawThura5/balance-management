<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>

<app:layout-management title="MEMBERS">
	<app:page-title title="Member Management" />

	<form class="row">

		<app:form-group label="Status" cssClass="col-auto">
			<select name="status" class="form-select">
				<option value="">Select All</option>
				<option value="true">Active</option>
				<option value="false">Denied</option>
			</select>
		</app:form-group>

		<app:form-group label="Register From" cssClass="col-auto">
			<input type="date" class="form-control" name="dateFrom" />
		</app:form-group>

		<app:form-group label="Register To" cssClass="col-auto">
			<input type="date" class="form-control" name="dateTo" />
		</app:form-group>

		<app:form-group label="Name" cssClass="col-auto">
			<input type="text" class="form-control" name="name"
				placeHolder="Search Name" />
		</app:form-group>

		<div class="btn btn-wrapper col-auto">
			<button class="btn btn-primary">
				<i class="bi-search"></i>Search
			</button>
		</div>

	</form>

	<table class="table table-bordered table-striped table-hover my-3">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Register At</th>
				<th>Last Login</th>
				<th>Status</th>
				<th>Change At</th>
				<th>Remark</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>Sar Lone May</td>
				<td>2025-05-01</td>
				<td>2025-05-01</td>
				<td>Active</td>
				<td>2025-05-01</td>
				<td></td>
				<td><a href="${root}/admin/member/1" class="icon-link"><i
						class="bi-arrow-right"></i></a></td>
			</tr>
		</tbody>
	</table>
	<app:pagination></app:pagination>
</app:layout-management>