<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<app:layout-member title="Access">
	<app:page-title title="Access History"></app:page-title>
	<form class="row" id="searchForm">
	<input type="hidden" name="page" id="pageInput"/>
	<input type="hidden" name="size" id="sizeInput"/>
		<div class="col-auto">
		<label class="form-label">Status</label>
			<select name="status" class="form-select">
				<option value="">Select All</option>
				<option value="Success"
					${param.status == 'Success' ? 'selected' : '' }>Success</option>
				<option value="Fails" ${param.status == 'Fails' ? 'selected' : '' }>Fails</option>
			</select>
		</div>
		<div class="col-auto">
			<label class="form-label">Date From</label> <input type="date"
				class="form-control" name="dateFrom" value="${param.dateFrom }" />
		</div>

		<div class="col-auto">
			<label class="form-label">Date To</label> <input type="date"
				class="form-control" name="dateTo" value="${param.dateTo}" />
		</div>

		<div class="col-auto">
			<label class="form-label">Keyword</label> <input type="text"
				class="form-control" name="keyword" placeHolder="Search Here"
				value="${param.keyword}" />
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
				<th>Name</th>
				<th>Access At</th>
				<th>Access Type</th>
				<th>Status</th>
				<th>Remark</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${result.content()}" var="items">

				<tr>
					<td>${items.member()}</td>
					<td>${dtf.formatDateTime(items.accessDateTime)}</td>
					<td>${items.type() }</td>
					<td>${items.status() }</td>
					<td>${items.remark() }</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<app:pagination pageResult="${result}"/>
</app:layout-member>