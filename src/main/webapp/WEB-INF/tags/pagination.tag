<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ attribute name="pageResult"
	type="com.online.balances.model.PageResult"%>
<div class="d-flex justify-content-between">
	<c:if test="${pageResult ne null }">
		<div class="d-flex">

			<div class="input-group me-2">
				<span class="input-group-text">Size</span> <select id="sizeSelect"
					class="form-select">
					<option value="10" ${pageResult.size() eq '10' ? 'selected' : '' }>10</option>
					<option value="25" ${pageResult.size()  eq '25' ? 'selected' : ''}>25</option>
					<option value="50" ${pageResult.size() eq '50' ? 'selected' : '' }>50</option>
				</select>
			</div>

			<div class="d-flex page-links">
				<a href="#" data-page-number="0"
					class="btn btn-outline-primary me-1 pageLink"><i
					class="bi-arrow-left pagelinks"></i></a>

				<c:forEach items="${pageResult.pageLinks}" var="items">

					<a href="#" data-page-number="${items}"
						class="btn ${pageResult.page() eq items ? 'btn-primary' : 'btn-outline-primary' } me-1 pageLink">${items +1 }</a>
				</c:forEach>

			</div>
			<div>
				<a href="#" data-page-number="${pageResult.totalPage - 1 }"
					class="btn btn-outline-primary pageLink"><i
					class="bi-arrow-right"></i></a>
			</div>
		</div>

		<div class="d-flex">

			<div class="input-group me-2">
				<span class="input-group-text">Total Pages</span> <span
					class="form-control">${pageResult.count() }</span>
			</div>

			<div class="input-group">
				<span class="input-group-text">Page Result</span> <span
					class="form-control">${pageResult.totalPage}</span>
			</div>

		</div>
		<script type="text/javascript"
			src=" ${root}/resources/js/pagination.js"></script>
	</c:if>
</div>
