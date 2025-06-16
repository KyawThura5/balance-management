<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<app:layout-member title="Profile">
	<app:page-title title="Member Profile"></app:page-title>
	<div class="row">
		<div class="col-3">
			<img src="${root }/resources/photo/profile.jpeg" alt="Profile Image"
				class="profile-image img-fluid img-thumbnail">

			<form id="profilePhotoForm" class="mt-2"
				action="${root}/member/profile/photo" method="post"
				enctype="multipart/form-data">
				<input id="profilePhotoInput" type="file" class="d-none" name="file" />
				<button type="button" id="profilePhotoButton"
					class="btn btn-primary w-100">
					<i class="bi-camera me-1"></i>Upload Profile Picture
				</button>
			</form>

		</div>

		<div class="col">
			<sf:form>
				<div class="row">
					<div class="col-8 mb-3">
						<label class="form-label">Name</label> <input type="text"
							class="form-control" placeHolder="Enter Name" />
					</div>
				</div>
				<div class="row mb-3">
					<div class="col-4">
						<label class="form-label">Gender</label> <select
							class="form-select">
							<option value="Male">Male</option>
							<option value="Female">Female
						</select>
					</div>

					<div class="col-4">
						<label class="form-label">Date of Birth</label> <input type="date"
							class="form-control" />
					</div>

				</div>

				<div class="row mb-3">
					<div class="col">
						<label class="form-label">Phone</label> <input type="text"
							class="form-control" placeHolder="Enter Phone Number" />
					</div>
					<div class="col">
						<label class="form-label">Email</label> <input type="email"
							class="form-control" placeHolder="Enter Email Address" />
					</div>
				</div>

				<div class="row mb-3">
					<div class="col">
						<label class="form-label">Region</label> <select
							class="form-select" id="region" data-fetch-api="${root }/member/location/district">
							<option value="">Select Region</option>
							<c:forEach var="item" items="${regions}">
								<option value="${item.id}">${item.name }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col">
						<label class="form-label">District</label> <select
							class="form-select" id="district" data-fetch-api="${root }/member/location/township">
							<option value="">Select One</option>
						</select>
					</div>

					<div class="col">
						<label class="form-label">TownShip</label> <select
							class="form-select" id="township">
							<option value="">Select One</option>
						</select>
					</div>

				</div>
				<div class="row">
					<div class="col mb-3">
						<label class="form-label">Address</label>
						<textarea class="form-control" cols="60" rows="3"></textarea>
					</div>
				</div>

				<button class="btn btn-danger">
					<i class="bi-save me-1"></i>Save Profile
				</button>

			</sf:form>
		</div>
	</div>
	<script src="${root }/resources/js/profile-edit.js"></script>
	<script src="${root }/resources/js/member-location.js"></script>
</app:layout-member>