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
					<td>${items.accessAt()}</td>
					<td>${items.type() }</td>
					<td>${items.status() }</td>
					<td>${items.remark() }</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<app:pagination></app:pagination>
</app:layout-member>