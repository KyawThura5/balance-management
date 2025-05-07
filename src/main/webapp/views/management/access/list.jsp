<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout-management title="ACCESS">
<app:page-title title="Access History"></app:page-title>

<form class="row mb-3">

<app:form-group label="Status" cssClass="col-auto">
<select class="form-select">
<option value="">Select All</option>
<option value="Success">Success</option>
<option value="Fails">Fails</option>
</select>
</app:form-group>

<app:form-group label="Date From" cssClass="col-auto">
<input type="date" class="form-control"/>
</app:form-group>

<app:form-group label="Date To" cssClass="col-auto">
<input type="date" class="form-control"/>
</app:form-group>

<app:form-group label="keyword" cssClass="col-auto">
<input type="text" class="form-control" placeHolder="Search Keyword"/>
</app:form-group>

<div class="col btn-wrapper">
<button class="btn btn-primary"><i class="bi-search"></i>Search</button>
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
<tr>
<td>Kyaw Thuya</td>
<td>2025-05-01</td>
<td>Login</td>
<td>Success</td>
<td></td>
</tr>
</tbody>
</table>

<app:pagination/>


</app:layout-management>