<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>

<app:layout-management title="MEMBERS">
	<div class="d-flex justify-content-between align-items-start">

		<app:page-title title="Member Management" />
		<button class="btn btn-danger">
			<i class="bi-x"></i>${result.status() eq 'Active' ? 'Denied' : 'Active' }
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
							<h4 class="mt-4">${dtf.formatDateTime(result.registerAt()) }</h4>
						</div>
					</div>
				</div>

				<div class="col">
					<div class="card text-bg-secondary">
						<div class="card-body">
							<h5>
								<i class="bi-calendar-check"></i>Last Access
							</h5>
							<h4 class="mt-4">${dtf.formatDateTime(result.LastAccessAt()) }</h4>
						</div>
					</div>
				</div>

				<div class="col">
					<div class="card text-bg-primary">
						<div class="card-body">
							<h5>
								<i class="bi-shield"></i>Status
							</h5>
							<h4 class="mt-4">${result.status() }</h4>
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
								<div>${result.name() }</div>
							</div>

							<div class="mb-3">
								<span class="text-secondary">Date Of Birth</span>
								<div>${result.dateOfBirth() ne null ? dtf.formatDate(result.dateOfBirth()) : 'Un Defined' }</div>
							</div>

							<div class="mb-3">
								<span class="text-secondary">Gender</span>
								<div>${result.gender() ne null ? result.gender() : 'Un Defined' }</div>
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
								<div>${result.phone() ne null and result.phone() ne '' ? result.phone() : 'Un Defined'}</div>
							</div>

							<div class="mb-3">
								<span class="text-secondary">Email</span>
								<div>${result.email() ne null and result.email() ne '' ? result.email() : 'Un Defined'}</div>
							</div>


							<div class="mb-3">
								<span class="text-secondary">Address</span>
								<div>${result.displayName() ne null and result.displayName() ne '' ? result.displayName() : 'Un Defined'}</div>
							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
		<div></div>
	</div>
</app:layout-management>