<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>

<app:layout-management title="MEMBERS">
	<div class="d-flex justify-content-between align-items-start">

		<app:page-title title="Member Management" />
		<button class="btn btn-danger">
			<i class="bi-x"></i>De-Activate
		</button>
	</div>

	<div class="row mt-3">
		<div class="col-3">
			<img class="img-fulid profile-image"
				src="${root}/resources/photo/profile.jpeg" alt="Profile Image" />
		</div>

		<div class="col">

			<div class="row">
				<div class="col">
					<div class="card text-bg-info">
						<div class="card-body">
							<h5>
								<i class="bi-person-plus"></i>Register At
							</h5>
							<h4 class="mt-4">2025-01-01 10:00</h4>
						</div>
					</div>
				</div>

				<div class="col">
					<div class="card text-bg-secondary">
						<div class="card-body">
							<h5>
								<i class="bi-calendar-check"></i>Last Access
							</h5>
							<h4 class="mt-4">2025-01-01 10:00</h4>
						</div>
					</div>
				</div>

				<div class="col">
					<div class="card text-bg-primary">
						<div class="card-body">
							<h5>
								<i class="bi-shield"></i>Status
							</h5>
							<h4 class="mt-4">Active</h4>
						</div>
					</div>
				</div>
			</div>

			<div class="row mt-3">
				<div class="col">
					<div class="card">
						<div class="card-body">
							<h5>
								<i class="bi-person"></i> Personal Info
							</h5>

							<div class="mb-3">
								<span class="text-secondary">Name</span>
								<div>Sar Lone May</div>
							</div>

							<div class="mb-3">
								<span class="text-secondary">Date Of Birth</span>
								<div>1999-05-20</div>
							</div>

							<div class="mb-3">
								<span class="text-secondary">Gender</span>
								<div>Female</div>
							</div>

						</div>
					</div>
				</div>

				<div class="col">
					<div class="card">

						<div class="card-body">
							<h5>
								<i class="bi-telephone"></i>Content Info
							</h5>

							<div class="mb-3">
								<span class="text-secondary">Phone</span>
								<div>09259042095</div>
							</div>

							<div class="mb-3">
								<span class="text-secondary">Email</span>
								<div>sar@gmail.com</div>
							</div>


							<div class="mb-3">
								<span class="text-secondary">Address</span>
								<div>Japan</div>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
		<div></div>
	</div>
</app:layout-management>