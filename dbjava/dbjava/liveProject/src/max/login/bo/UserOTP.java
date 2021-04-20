package max.login.bo;

import java.util.Random;

import max.login.dl.UserDAO;
import max.utility.EncryptionPasswordANDVerification;

public class UserOTP {
	public String setLoginDeatils(String uid,String pass,String mobile,String otp)
	{
		return new UserDAO().login(uid, EncryptionPasswordANDVerification.encryptionPassword(pass), mobile, otp);
		
	}
	
	
	public  String generateOTP(String mobile)
	{
		if(mobile.length()==10)
		{
			StringBuffer sb = new StringBuffer();
			for(int i=1; i<=9;i++)
			{
				sb.append(new Random().nextInt(10));
			}
			String s=sb.substring(5);
			return new UserDAO().insertOTP(mobile, s);
		}
		return null;
		
		
	}
	

}
