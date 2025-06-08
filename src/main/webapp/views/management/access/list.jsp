<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<app:layout-management title="ACCESS">
	<app:page-title title="Access History"></app:page-title>

	<form class="row mb-3" id="searchForm">
	<input type="hidden" name="page" id="pageInput"/>
	<input type="hidden" name="size" id="sizeInput"/>
		<app:form-group label="Status" cssClass="col-auto">
			<select name="status" class="form-select">
				<option value=""> Select All</option>
				<option value="Success" ${param.status == 'Success' ? 'selected' : '' }>Success</option>
				<option value="Fails" ${param.status == 'Fails' ? 'selected' : '' }>Fails</option>
			</select>
		</app:form-group>

		<app:form-group label="Date From" cssClass="col-auto">
			<input name="dateFrom" type="date" class="form-control" value="${param.dateFrom }" />
		</app:form-group>

		<app:form-group label="Date To" cssClass="col-auto">
			<input name="dateTo" type="date" class="form-control" value="${param.dateTo}"/>
		</app:form-group>

		<app:form-group label="keyword" cssClass="col-auto">
			<input name="keyword" type="text" class="form-control"
				placeHolder="Search Keyword" value="${param.keyword }"/>
		</app:form-group>

		<div class="col btn-wrapper">
			<button class="btn btn-primary">
				<i class="bi-search"></i>Search
			</button>
		</div>

	</form>

	<table class="table table-bordered table-striped table-hover">
		<thead>
			<tr>
				<th>Member</th>
				<th>Access At</th>
				<th>Access Type</th>
				<th>Status</th>
				<th>Remark</th>
			</tr>
		</thead>
		</tbody>
		<c:forEach items="${result.content()}" var="items">
			<tr>
				<td>${items.member()}</td>
				<td>${dtf.formatDateTime(items.accessDateTime) }</td>
				<td>${items.type() }</td>
				<td>${items.status() }</td>
				<td>${items.remark() }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<app:pagination pageResult="${result}"/>


</app:layout-management>