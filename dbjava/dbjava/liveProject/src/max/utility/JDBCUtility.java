package max.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JDBCUtility {
	private JDBCUtility(){
		
	}
	
	public static void updateUser(String mobile, Connection con)
	{
		try {
			PreparedStatement ps = con.prepareStatement("update mst_login set status = ? where mobile = ?");
		  ps.setString(1, "N");
		  ps.setString(2, mobile);
		  ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static String getLockTime()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		 return dtf.format(now); 
	}
	
	
	
	
	static Connection con;
	static
	{
		try {
			Class.forName("org.postgresql.Driver");
 con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ram", "postgres", "postgres");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void updateTime(String mobile,String locktime,Connection con)
	{
		try {
			PreparedStatement ps = con.prepareStatement("update mst_login set locktime= ?, status=? where mobile = ?");
		  ps.setString(1, locktime);
		  ps.setString(2, locktime.length()==1?"Y":"L");
		  ps.setString(3, mobile);
		   ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static int count(Connection con,String mobile)
	{
		try {
			PreparedStatement ps = con.prepareStatement("select locktime from mst_login where mobile=?");
		 ps.setString(1, mobile);
			ResultSet rs = ps.executeQuery();
		    while(rs.next())
		    {
		    	String ltime = rs.getString("locktime");
		    	return 1+Integer.parseInt(ltime);
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	public static Connection getConnn()
	{
		return con;
	}

	public static int getshgID(Connection con)
	{
		try {
			PreparedStatement ps = con.prepareStatement("select max(membercode) as mcode from member_master");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int mcode=rs.getInt("mcode");
			return 1+mcode;
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	
}
