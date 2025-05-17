<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout-member title="LEDGERS">
<app:page-title title="Ledgers Management"></app:page-title>
<form class="row">

<div class="col-auto">
<label class="form-label">Type</label>
<select class="form-select">
<option>Select All</option>
<c:forEach items="${balanceType}" var="item">
<option value="${item}">${item}</option>
</c:forEach> 
</select>
</div>

<div class="col-auto">
<label class="form-label">Keyword</label>
<input type="text" class="form-control" placeHolder="Search Keyword Here"/>
</div>

<div class="col-auto btn btn-wrapper">
<button class="btn btn-primary"><i class="bi-search"></i>Search</button>
<a href="#" class="btn btn-danger"><i class="bi-plus"></i>New Ledger</a>
</div>

</form>


<table class="table table-striped table-bordered table-hover mt-3">
<thead>
<tr>
<th>ID</th>
<th>Name</th>
<th>Type</th>
<th>Status</th>
<th>Created At</th>
<th>Modify At</th>
<th class="text-end">Total</th>
</tr>
</thead>
<tbody>
<tr>
<td>1</td>
<td>Service Charges</td>
<td>Incomes</td>
<td>Active</td>
<td>2025-01-01</td>
<td>2025-01-01</td>
<td class="text-end">100000</td>
<td class="text-center">
<a href="#" class="icon-links"><i class="bi-pencil"></i></a>

</td>

</tr>
</tbody>
</table>
</app:layout-member>