package com.TronenkoVladimir.networkchat;

public class Message {
	
	private String sender;
	private String receiver;
	private String text;
	public final long time;
	
	public Message(String sender, String receiver, String text) {
		this.sender = sender;
		this.receiver = receiver;
		this.text = text;
		time=System.currentTimeMillis();
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReciever() {
		return receiver;
	}

	public void setReciever(String reciever) {
		this.receiver = reciever;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
