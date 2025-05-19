<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout-member title="Member">

<app:page-title title="Edit Incomes"></app:page-title>
 <form method="post" action="${root}/member/entry/save" class=row>
 
 <div class="col-4">
 
 <div class="card">
 <div class="card-body">
 
 <h5 class="card-title mb-3">
 <i class="bi-flag me-2"></i>Ledger Entry
 </h5>
 
 <div class="mb-3">
 <label class="form-label">Ledger</label>
 <select class="form-select">
 <option value="">Select Ledger</option>
 </select>
 </div>

<div class="mb-3">
<label class="form-label">Particular</label>
<textarea class="form-control" rows="3" placeHolder="Please Enter Particular"></textarea>
</div>
 
 <div class="mb-3">
 <label class="form-label">Total Amount</label>
 <span class="form-control">100000</span>
 </div>
 
 
 </div>
 
 </div>
 </div>
 
 <div class="col">
 
 <div class="card">
 <div class="card-body">
 
 <h5 class="card-title"><i class="bi-list me-2"></i>Entry Items</h5>
 <div class="row mt-3">
 <div class="col">Item Name</div>
 <div class="col-2">Unit Price</div>
 <div class="col-2">Quantity</div>
 <div class="col-2 text-end">Total</div>
 </div>
 
 <div class="row mt-1">
 
 <div class="col">
 
<div class="input-group">

<button class="btn btn-outline-danger input-group-text">
<i class="bi bi-trash"></i>
</button>
 
 <input type="text" class="form-control" placeHolder="Enter Item Name"/>
</div>

 </div>
 
 <div class="col-2">
 <input type="number" class="form-control text-end"/>
 </div>
 <div class="col-2">
 <input type="number" class="form-control text-end"/>
 </div>
 <div class="col-2">
 <span class="form-control text-end">0</span>
 </div>
 </div>
 
 <div class="mt-2">
 <button type="button" class="btn btn-outline-primary"><i class="bi-plus"></i>Add New</button>
 <button class="btn btn-outline-danger"><i class="bi-save"></i>Save Entry</button>
 </div>
 
 </div>
 </div>
 
 </div>
 
 </form>
</app:layout-member>