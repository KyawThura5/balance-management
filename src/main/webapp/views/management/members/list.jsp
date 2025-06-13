<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<app:layout-management title="MEMBERS">
	<app:page-title title="Member Management" />

	<form class="row" id ="searchForm">
	<input type="hidden" name="page" id="pageInput"/>
	<input type="hidden" name="size" id="sizeInput"/>
		<app:form-group label="Status" cssClass="col-auto">
			<select name="status" class="form-select">
				<option value="">Select All</option>
				<option value="Active" ${param.status eq 'Active' ? 'selected' : '' }>Active</option>
				<option value="Denied" ${param.status eq 'Denied' ? 'selected' : '' }>Denied</option>
			</select>
		</app:form-group>

		<app:form-group label="Register From" cssClass="col-auto">
			<input type="date" class="form-control" name="dateFrom" />
		</app:form-group>

		<app:form-group label="Register To" cssClass="col-auto">
			<input type="date" class="form-control" name="dateTo" />
		</app:form-group>

		<app:form-group label="Nam e" cssClass="col-auto">
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
			<c:forEach var="item" items="${result.content() }">
			<tr>
				<td>${item.id()}</td>
				<td>${item.name() }</td>
				<td>${dtf.formatDateTime(item.registerAt()) }</td>
			    <td>${dtf.formatDateTime(item.lastLogin()) }</td>
				<td>${item.status()}</td>
			    <td>${dtf.formatDateTime(item.changeAt()) }</td>
				<td>${item.remark() }</td>
				<td><a href="${root}/admin/member/${item.id()}" class="icon-link"><i
						class="bi-arrow-right"></i></a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<app:pagination pageResult="${result}"></app:pagination>
</app:layout-management>