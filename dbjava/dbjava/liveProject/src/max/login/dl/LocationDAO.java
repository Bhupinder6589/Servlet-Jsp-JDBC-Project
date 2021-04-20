package max.login.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import max.utility.JDBCUtility;

public class LocationDAO {
	public static List<DistBean> getDistDetails(String stateCode)
	{     List<DistBean> list=new ArrayList<DistBean>();
		try {
			Connection con = JDBCUtility.getConnn();
			PreparedStatement ps = con.prepareStatement("select district_name,district_code from mst_district where state_code = ? order by district_name");
		ps.setString(1, stateCode);
			ResultSet rs = ps.executeQuery();
		  while(rs.next())
		  {
			  DistBean db = new DistBean ();
			 db.setDistName(rs.getString("district_name"));
			 db.setDistcode(rs.getString("district_code"));
			 list.add(db);
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public static StateBean getStateDetails(String shrtName)
	{    StateBean sb = new StateBean();
		try {
			Connection con = JDBCUtility.getConnn();
			PreparedStatement ps = con.prepareStatement("select * from mst_state where state_short_name = ?");
		ps.setString(1, shrtName);
			ResultSet rs = ps.executeQuery();
		  while(rs.next())
		  {
			  sb.setStateCode(rs.getString("state_code"));
			  sb.setStateName(rs.getString("state_name"));
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb;
	}

}
