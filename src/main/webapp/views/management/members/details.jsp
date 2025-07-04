<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<app:layout-management title="MEMBERS">
	<div class="d-flex justify-content-between align-items-start">

		<app:page-title title="Member Management" />
		<button id="statusChangeButton" class="btn btn-danger">
			<i class="${result.status() eq 'Active' ? 'bi-x' : 'bi-check' }"></i>${result.status() eq 'Active' ? 'Denied' : 'Activate' }
		</button>
	</div>

	<div class="row mt-3">
		<div class="col-3">
			<img src="${root }/resources/photo/${result.profileImage()}" alt="Profile Image"
				class="profile-image img-fluid img-thumbnail">
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

	<div id="statusChangeDialog" class="modal">

		<div class="modal-dialog">
			<form action="${root }/admin/member/${result.id()}/update"
				method="post" class="modal-content">
				<sec:csrfInput />
				<input type="hidden" name="status"
					value="${result.status() ne 'Active' }" />
				<div class="modal-header">
					<h5 class="modal-title">${result.status() eq 'Active' ? 'Denied' : 'Activate' }
						Access</h5>
				</div>

				<div class="modal-body">

					<div>
						<label class="form-label">Reason</label>
						<textarea name="reason" class="form-control" required='required'></textarea>
					</div>


				</div>

				<div class="modal-footer">
					<button class="btn btn-outline-primary">
						<i class="bi-save"></i>Change Status
					</button>

				</div>
			</form>
		</div>

	</div>
	<script src="${root }/resources/js/member-details.js"></script>
</app:layout-management>