package com.sino.job;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestJob {
	
	public void test(){
		String date = new SimpleDateFormat("hh:mm:ss").format(new Date());
		System.out.println(date +"=====test===");
	}

}
