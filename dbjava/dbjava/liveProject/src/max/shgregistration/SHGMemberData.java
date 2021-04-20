package max.shgregistration;

import javax.servlet.http.HttpServletRequest;

public class SHGMemberData {
	
	
	public SHGBean setSHGMemeberDetail(HttpServletRequest request)
	{
		SHGBean sHGBean=new SHGBean();
		SHGMemberBean sHGMemberBean=new	SHGMemberBean();
		sHGBean.setAccount(request.getParameter("account"));
		sHGBean.setDistrictCode(request.getParameter("districtCode"));
		sHGBean.setIfsc(request.getParameter("ifsc"));
		sHGBean.setShgname(request.getParameter("shgname"));
		sHGBean.setStateCode(request.getParameter("stateCode"));
		sHGBean.setDdate(request.getParameter("ddate"));
		sHGBean.setMdate(request.getParameter("mdate"));
		sHGBean.setYdate(request.getParameter("ydate"));
		sHGMemberBean.setAge(request.getParameterValues("age"));
		sHGMemberBean.setCadhar(request.getParameterValues("cadhar"));
		sHGMemberBean.setCname(request.getParameterValues("cname"));
		sHGBean.setsHGMemberBean(sHGMemberBean);
		
		return sHGBean;
		
	}

}
