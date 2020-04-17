package com.laptrinhjavaweb.enums;

public enum TransactionEnum {
	CustomerService("Chăm Sóc Khách Hàng "), GoSee("Dẫn đi xem");
	private String value;

	private TransactionEnum(String v) {
		this.value = v;
	}

	public String getEnumValue() {
		return this.value;
	}
}
