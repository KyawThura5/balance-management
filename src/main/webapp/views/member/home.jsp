<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout-member title="HOME">
<div class="d-flex justify-content-between align-items-start">
<app:page-title title="Member Home"></app:page-title>
<div class="btn-group">
<input type="radio" name="display" class="btn-check" id="monthly" checked/>
<label for="monthly" class="btn btn-outline-primary">Monthly</label>
<input type="radio" name="display" class="btn-check" id="yearly"/>
<label for="yearly" class="btn btn-outline-primary">Yearly</label>
</div>
</div>

<div class="row">

<div class="col-3">

<div class="card">
<div class="card-body">

<div class="d-flex justify-content-between">
<h5 class="card-title">
<i class="bi-person"></i>Profile
</h5>
<a href="#" class="btn-link">
<i class="bi-pencil"></i>
</a>
</div>
</div>

<img alt="Profile Image" src="${root }/resources/photo/profile.jpeg" class="profile-image">


<div class="card-body">
<div class="list-group list-group-flush">

<div class="list-group-item">
<i class="bi-person me-2"></i>Kyaw Thuya
</div>

<div class="list-group-item">
<i class="bi-telephone me-2"></i>09426716263
</div>

<div class="list-group-item">
<i class="bi-envelope me-2"></i>kyaw@gmail.com
</div>

</div>
</div>

</div>
</div>

<div class="col">
<app:summary-info title="Expenses" icon="bi-cart" value="100000" color="text-bg-danger">
</app:summary-info>
</div>

<div class="col">
<app:summary-info title="Incomes" icon="bi-flag" value="500000" color="text-bg-warning">
</app:summary-info>
</div>

<div class="col">
<app:summary-info title="Balances" icon="bi-bar-chart" value="400000" color="text-bg-primary">
</app:summary-info>
</div>

</div>
</app:layout-member>