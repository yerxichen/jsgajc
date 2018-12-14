package com.sjq.jsgajc.utils;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrimaryGenerater {

	private static final String SERIAL_NUMBER = "XXXXXXX"; // 
	private static PrimaryGenerater primaryGenerater = null;
	private static String sno="000000";
	private static String LAST_DATE="";
	
	private PrimaryGenerater() {
	}

	/**
	 * 
	 * @return
	 */
	public static PrimaryGenerater getInstance() {
		if (primaryGenerater == null) {
			synchronized (PrimaryGenerater.class) {
				if (primaryGenerater == null) {
					primaryGenerater = new PrimaryGenerater();
				}
			}
		}
		return primaryGenerater;
	}

	/**
	 * 
	 */
	public synchronized String generaterNextNumber() {
		String id = null;
		Date date = new Date();
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMdd");
		if(!LAST_DATE.equals(formatter1.format(date))){
			sno="000000";
			LAST_DATE=formatter1.format(date);
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		int count = SERIAL_NUMBER.length();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append("0");
		}
		
		id = formatter.format(date)+sno;
		DecimalFormat df = new DecimalFormat("000000");
		sno=df.format(1 + Integer.parseInt(sno));
		return "W"+id;
	}
	
	

	
	public static void main(String [] args){
		System.out.println(PrimaryGenerater.getInstance().generaterNextNumber().length());
		System.out.println(PrimaryGenerater.getInstance().generaterNextNumber());
		System.out.println(PrimaryGenerater.getInstance().generaterNextNumber());
		System.out.println(PrimaryGenerater.getInstance().generaterNextNumber());
		System.out.println(PrimaryGenerater.getInstance().generaterNextNumber());
	}
}