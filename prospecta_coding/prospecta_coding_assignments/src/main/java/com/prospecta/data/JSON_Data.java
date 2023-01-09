package com.prospecta.data;

import java.util.List;

import com.prospecta.beans.Entry;

public class JSON_Data {

	private String count;
	private List<Entry> entries;
	
	public JSON_Data() {
		super();
	}

	public JSON_Data(String count, List<Entry> entries) {
		super();
		this.count = count;
		this.entries = entries;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
	
}
