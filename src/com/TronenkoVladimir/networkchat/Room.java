package com.TronenkoVladimir.networkchat;

public class Room {
	
	private String Description;

	public Room(String n) {
		name = n;
	}

	public final String name;

	public enum Status {
		inside, ok, banned;
	};

	private Status mStatus;
	private int mPepoleCount;

	public Status getmStatus() {
		return mStatus;
	}

	public Room setmStatus(Status mStatus) {
		this.mStatus = mStatus;
		return this;
	}

	public int getmPepoleCount() {
		return mPepoleCount;
	}

	public Room setmPepoleCount(int mPepoleCount) {
		this.mPepoleCount = mPepoleCount;
		return this;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
}
