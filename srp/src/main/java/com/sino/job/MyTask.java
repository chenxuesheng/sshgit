package com.sino.job;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sino.model.User;
import com.sino.service.UserServcie;

@Component
public class MyTask extends TimerTask{
	
	@Resource
	UserServcie userServcie;

	@Override
	public void run() {
		User user = userServcie.getById("001");
		System.out.println(new SimpleDateFormat("hh:mm:ss").format(new Date())+"===task end=="+user.getName());
		
	}

}
