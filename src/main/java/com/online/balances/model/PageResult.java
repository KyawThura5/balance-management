package com.online.balances.model;

import java.util.List;

public record PageResult<T>(List<T> content, long count, int size, int page) {

	public static <T> Builder<T> builder() {
		return new Builder<T>();
	}
	public static class Builder<T> {
		private List<T> content;
		private long count;
		private int size;
		private int page;

		public Builder<T> content(List<T> content) {
			this.content = content;
			return this;
		}

		public Builder<T> count(long count) {
			this.count = count;
			return this;
		}

		public Builder<T> size(int size) {
			this.size = size;
			return this;
		}

		public Builder<T> page(int page) {
			this.page = page;
			return this;
		}

		public PageResult<T> build() {
			return new PageResult<>(content, count, size, page);
		}
	}
}
