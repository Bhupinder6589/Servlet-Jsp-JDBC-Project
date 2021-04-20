package max.shgregistration;

public class SHGMemberBO {
	public boolean getShgMemberDetails(SHGBean sHGBean)
	{
		SHGDTO sHGDTO=new SHGDTO();
		SHGMemberDTO sHGMemberDTO=new SHGMemberDTO();
		sHGDTO.setAccount(sHGBean.getAccount());
		sHGDTO.setDistrictCode(sHGBean.getDistrictCode());
		sHGDTO.setIfsc(sHGBean.getIfsc());
		sHGDTO.setShgname(sHGBean.getShgname());
		sHGDTO.setStateCode(sHGBean.getStateCode());
     sHGDTO.setShgDate(sHGBean.getDdate()+"-"+sHGBean.getMdate()+"-"+sHGBean.getYdate());
   SHGMemberBean shgm = sHGBean.getsHGMemberBean();
   sHGMemberDTO.setAge(shgm.getAge());
   sHGMemberDTO.setCadhar(shgm.getCadhar());
   sHGMemberDTO.setCname(shgm.getCname());
   return new SHGMemberDAO().getShgMemberDetails(sHGDTO, sHGMemberDTO);
	}

}
