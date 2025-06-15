package com.online.balances.controller.member.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.util.StringUtils;

import com.online.balances.model.entity.Member;

public record MemberProfileDetails(Long id, String name, String phone, String profileImage, String email,
		String address, LocalDateTime registerAt, LocalDateTime lastAccessAt) {

	public static MemberProfileDetails from(Member entity) {

		var builder = new Builder();
		builder.id(entity.getId()).name(entity.getName()).phone(entity.getPhone()).email(entity.getEmail())
				.registerAt(entity.getActivity().getRegisterAt()).lastAccessAt(entity.getActivity().getLastAccessAt());

		var list = List.of(Optional.ofNullable(entity.getAddress()).orElse(""),
				Optional.ofNullable(entity.getTownship()).map(a -> a.getName()).orElse(""),
				Optional.ofNullable(entity.getTownship()).map(a -> a.getDistrict()).map(a -> a.getRegion())
						.map(a -> a.getName()).orElse(""));

		var address = list.stream().filter(StringUtils::hasLength).collect(Collectors.joining(", "));

		builder.address(address);

		return builder.build();
	}

	public static class Builder {
		private Long id;
		private String name;
		private String phone;
		private String profileImage;
		private String email;
		private String address;
		private LocalDateTime registerAt;
		private LocalDateTime lastAccessAt;

		public Builder id(Long id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder profileImage(String profileImage) {
			this.profileImage = profileImage;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder registerAt(LocalDateTime registerAt) {
			this.registerAt = registerAt;
			return this;
		}

		public Builder lastAccessAt(LocalDateTime lastAccessAt) {
			this.lastAccessAt = lastAccessAt;
			return this;
		}

		public MemberProfileDetails build() {
			return new MemberProfileDetails(id, name, phone, profileImage, email, address, registerAt, lastAccessAt);
		}
	}
}
