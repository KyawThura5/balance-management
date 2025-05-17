<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout-member title="BALANCES">

<div class="d-flex justify-content-between align-items-start">
<app:page-title title="Incomes Details"></app:page-title>
<a href="${root}/member/entry/edit/2025-01-01" class="btn btn-danger"><i class="bi-pencil"></i>Edit Entry</a>
</div>

<div class="row">
<div class="col">

<div class="card">
<div class="card-body">
<h5 class="card-title">
<i class="bi-list"></i>Entry Summary
</h5>

<table class="table table-striped">
<thead>
<tr>
<th>No.</th>
<th>Item Name</th>
<th class="text-end">Price</th>
<th class="text-end">Quantity</th>
<th class="text-end">Total</th>
</tr>
</thead>

<tbody>
<tr>
<td>1</td>
<td>Print Paper</td>
<td class="text-end">300000</td>
<td class="text-end">2</td>
<td class="text-end">70000</td>
</tr>

<tr>
<td>2</td>
<td>Maintanence Fees</td>
<td class="text-end">35000</td>
<td class="text-end">1</td>
<td class="text-end">43000</td>
</tr>

<tr>
<td colspan="4">
All Total
</td>
<td class="text-end">1500000</td>
</tr>

</tbody>
</table>
</div>
</div>

</div>
<div class="col-4">
<div class="card">
<div class="card-body">
<h5 class="card-title">
<i class="bi-flag"></i>Incomes Summary
</h5>

<div class="list-group list-group-flush">

<div class="list-group-item">
<div>Code</div>
<div>2025-05-01</div>
</div>

<div class="list-group-item">
<div>Ledger</div>
<div>Service Charges</div>
</div>

<div class="list-group-item">
<div>Amount</div>
<div>100000</div>
</div>


<div class="list-group-item">
<div>Issue At</div>
<div>2025-05-01</div>
</div>

<div class="list-group-item">
<div>Particular</div>
<div>Maintain Fees for POS</div>
</div>

</div>

</div>
</div>
</div>
</div>
</app:layout-member>