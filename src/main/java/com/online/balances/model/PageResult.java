package com.online.balances.model;

import java.util.List;

public record PageResult<T>(List<T> content, long count, int size, int page) {

}
