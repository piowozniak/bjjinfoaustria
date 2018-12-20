package pl.bjjinfoaustria.enums;

public enum StatusE {
	
	ACTIVE("ACTIVE"),
	SUBMITTED("SUBMITTED"),
	DRAFT("DRAFT"),
	NONACTIVE("NONACTIVE"),
	ACCEPTED("ACCEPTED"),
	SIGNED("SIGNED"),
	REJECTED("REJECTED");
	
	private final String value;

	private StatusE(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
