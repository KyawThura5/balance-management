package com.online.balances.utils;

import java.util.Optional;

import com.online.balances.utils.exception.AppBussinessException;

public class EntityOperations {

	public static <T, ID> T safeCalls(Optional<T> optional, String resourceName, String keyName, ID keyValue) {

		return optional.orElseThrow(() -> new AppBussinessException(
				"There is no %s with %s : %s ".formatted(resourceName, keyName, keyValue)));
	}

}
