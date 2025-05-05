<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout-management title="MEMBERS">
<app:page-title title="Member Management"/>
<div class="row">
<div class="col-3">
<img class="img-fulid profile-image" src="${root}/resources/photo/profile.jpeg" alt="Profile Image"/>

<div class="list-group mt-3">
<div class="list-group-item">
<i class="bi-person"></i>Kyaw Thuya
</div>
<div class="list-group-item">
<i class="bi-telephone"></i>09259042093
</div>
<div class="list-group-item">
<i class="bi-envelope"></i>kyawthuya@gmail.com
</div>
<div class="list-group-item">
<i class="bi-calendar-check"></i>2025-05-02
</div>
<div class="list-group-item">
<i class="bi-shield"></i>Active
</div>

<div class="mt-3">
<button class="btn btn-danger w-100">
<i class="bi-x"></i>Deactive
</button>
</div>
</div>

</div>
<div>
</div>
</div>
</app:layout-management>