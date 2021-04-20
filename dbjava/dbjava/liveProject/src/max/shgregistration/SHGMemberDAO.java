package max.shgregistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import max.utility.JDBCUtility;

public class SHGMemberDAO {
	
	public boolean getShgMemberDetails(SHGDTO sHGDTO, SHGMemberDTO sHGMemberDTO)
	{ Connection con = JDBCUtility.getConnn();
		try {
			
			con.setAutoCommit(false);
PreparedStatement ps = con.prepareStatement("insert into shg_master values(?,?,?,?,?,?,?) ");
   int sid=JDBCUtility.getshgID(con);
         if(sid>0){
             ps.setInt(1, sid);
			ps.setString(2, sHGDTO.getShgname());
			ps.setString(3, sHGDTO.getStateCode());
			ps.setString(4, sHGDTO.getDistrictCode());
			ps.setString(5, sHGDTO.getShgDate());
			ps.setString(6, sHGDTO.getIfsc());
			ps.setString(7, sHGDTO.getAccount());
			int i=ps.executeUpdate();
			   if(i>0)
			   {
				 String[] a = sHGMemberDTO.getAge();
				 String[] adr = sHGMemberDTO.getCadhar();
				String[] n = sHGMemberDTO.getCname();
 ps=con.prepareStatement("insert into member_master values (?,?,?,?,?)"); 
                       
                   for(int j=0;j<a.length;j++)
                     {
                    	 ps.setInt(1, sid+1+j);
                    	 ps.setString(2, n[j]);
                    	 ps.setString(3, a[j]);
                    	 ps.setString(4, adr[j]);
                    	 ps.setInt(5, sid);
                    	 ps.executeUpdate();
                    	
                     }
 
 
			    
			   }
         }
         else
         {
        	 con.rollback();
        	 return false;
         }
		con.commit();	
		return true;	
		} 
		
		catch(SQLException exception)
		{
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			exception.printStackTrace();
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		finally
		{
			
		}
		
		return false;
		
	}

}
