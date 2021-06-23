package de.telekom.sea3.webserver.model;

public enum Salutation {
	MR, MRS, OTHER;

	public static Salutation fromString(final String value) {
		if (value == "") {
			throw new NullPointerException("Salutation is empty");
		}
		switch (value) {
		case "mr":
		case "MR":
		case "Mr":
		case "mister":
		case "Mister":
			return MR;
		case "MRS":
		case "mrs":
		case "Mrs":
		case "Misses":
		case "misses":
			return MRS;
		case "OTHER":
		case "other":
		case "Other":
			return OTHER;
		default:
			throw new IllegalArgumentException("Unexpected value: " + value);

		}

	}

	public String toString() {
		switch (this) {
		case MR:
			return "Mr";
		case MRS:
			return "Mrs";
		case OTHER:
			return "Other";
		}
		throw new IllegalArgumentException("Unexpected value");
	}

}
