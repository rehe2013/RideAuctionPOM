package com.rideauction.webtest.framework;
import java.util.Random;

public class CaptchaService {

	public CaptchaService() {
		// TODO Auto-generated constructor stub
	}

	public static String getCaptcha (){
		Random rd = new Random ();
		return String.valueOf(rd.nextGaussian());
	}

}
