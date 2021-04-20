package max.login.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import max.utility.EncryptionPasswordANDVerification;
import max.utility.JDBCUtility;

public class UserDAO {
	public boolean logout(String uid)
	{
		try {
			Connection con = JDBCUtility.getConnn();
PreparedStatement ps = con.prepareStatement("update mst_login set status = ? where uid= ?");
			ps.setString(1, "Y");
			ps.setString(2, uid);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	public String login(String uid,String pass,String mobile,String otp)
	{
		try {
			Connection con = JDBCUtility.getConnn();
PreparedStatement ps = con.prepareStatement("select uid,pass,status,mobile from mst_login where otp=?");
			ps.setInt(1, Integer.parseInt(otp));
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String ud=rs.getString("uid");
				String pss=rs.getString("pass");
				String stts=rs.getString("status");
				if(!pss.equalsIgnoreCase(pass))
				{
					int locktime=JDBCUtility.count(con,mobile);
					if(locktime==1 || locktime==2)
					{
						JDBCUtility.updateTime(mobile,String.valueOf(locktime), con);
						return "WP";
					}
						if(locktime==3)
						{
							
					   JDBCUtility.updateTime(mobile,JDBCUtility.getLockTime(), con);
						return "L";
						}
					}
				else if(stts.equalsIgnoreCase("N"))
				{
					return "AL";
				}
				else if(stts.equalsIgnoreCase("L"))
				{
					return "L";
				}
				else if(stts.equalsIgnoreCase("Y"))
				{
					JDBCUtility.updateUser(mobile, con);
					return ud;
				}
				
				
				
		} 
			
		}
	catch(Exception e) {
			e.printStackTrace();
		}
		return "W";
	}
	
	
	
	
 public String insertOTP(String mobile,String otp)
 {
	 try {
		Connection con = JDBCUtility.getConnn();
		PreparedStatement ps = con.prepareStatement("update mst_login set otp = ? where mobile = ?");
	  ps.setInt(1, Integer.parseInt(otp));
	   ps.setString(2, mobile);
	 int i= ps.executeUpdate();
	 if(i>0)
		 return otp;
	 } catch (Exception e) {
		e.printStackTrace();
	}
	 
	return "wrong";
	 
 }
	
}
