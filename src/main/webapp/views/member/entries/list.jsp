<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout-member title="${type.name().toUpperCase()}">
<app:page-title title="${type} Management"></app:page-title>
<form class="row mb-3">

<div class="col-auto">
<label for="dateInput" class="form-label">Date From</label>
<input type="date" class="form-control"/>
</div>

<div class="col-auto">
<label class="form-label">Date To</label>
<input type="date" class="form-control"/>
</div>

<div class="col-auto">
<label class="form-label">Keyword</label>
<input type="text" class="form-control" placeHolder="Search Here"/>
</div>

<div class="col btn-wrapper">
<button class="btn btn-primary">
<i class="bi-search"></i>Search</button>
<a href="${root}/member/entry/add-new/${type.name().toLowerCase()}" class="btn btn-danger"><i class="bi-plus"></i>New Entry</a>
</div>
</form>

<table class="table table-bordered table-striped table-hover my-3">
<thead>
<tr>
<th>Code</th>
<th>Issue At</th>
<th>Category</th>
<th>Particular</th>
<th>Amount</th>
<th></th>
</tr>
</thead>
<tbody>
<tr>
<td>2025-02-01</td>
<td>2025-02-01</td>
<td>Service Charge</td>
<td>Maintenance of POS</td>
<td class="text-end">1000000</td>
<td class="text-center">
<a href="${root}/member/balance/2025-02-01">
<i class="bi bi-arrow-right"></i>
</a>
</td>
</tr>
</tbody>

</table>
<app:pagination/>
</app:layout-member>