<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>

<app:layout-member title="BALANCES">
	<app:page-title title="Balances Report"></app:page-title>

	<form class="row mb-3">

		<div class="col-auto">
			<label for="dateInput" class="form-label">Date From</label> <input
				name="dateFrom" type="date" class="form-control" />
		</div>

		<div class="col-auto">
			<label class="form-label">Date To</label> <input type="date"
				name="dateTo" class="form-control" />
		</div>

		<div class="col-auto">
			<label class="form-label">Keyword</label> <input type="text"
				name="keyword" class="form-control" placeHolder="Search Here" />
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
				<th>Issue At</th>
				<th>Ledger</th>
				<th>Particular</th>
				<th class="text-end">Expenses</th>
				<th class="text-end">Incomes</th>
				<th class="text-end ">Balance</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>2025-02-25</td>
				<td>Service Charges</td>
				<td>Maintenance of POS</td>
				<td class="text-end">0</td>
				<td class="text-end">1000000</td>
				<td class="text-end">1000000</td>
				<td class="text-center"><a
					href="${root}/member/balance/2025-01-01"> <i
						class="bi bi-arrow-right"></i>
				</a></td>
			</tr>
		</tbody>

	</table>

	<app:pagination />
</app:layout-member>