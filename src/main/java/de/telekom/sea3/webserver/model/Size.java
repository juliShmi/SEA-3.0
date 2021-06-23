package de.telekom.sea3.webserver.model;

public class Size {
	private long size;

	public Size(long l) {
		super();
		this.size = l;
	}

	public long count() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
