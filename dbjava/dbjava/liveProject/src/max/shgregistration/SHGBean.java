package max.shgregistration;

public class SHGBean {
 private String stateCode;
 private String districtCode;
 private String shgname;
 private String account;
 private String ifsc;
 private String ddate;
 private String mdate;
 private String ydate;
 private SHGMemberBean sHGMemberBean;
 
 
public SHGMemberBean getsHGMemberBean() {
	return sHGMemberBean;
}
public void setsHGMemberBean(SHGMemberBean sHGMemberBean) {
	this.sHGMemberBean = sHGMemberBean;
}
public String getStateCode() {
	return stateCode;
}
public void setStateCode(String stateCode) {
	this.stateCode = stateCode;
}
public String getDistrictCode() {
	return districtCode;
}
public void setDistrictCode(String districtCode) {
	this.districtCode = districtCode;
}
public String getShgname() {
	return shgname;
}
public void setShgname(String shgname) {
	this.shgname = shgname;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getIfsc() {
	return ifsc;
}
public void setIfsc(String ifsc) {
	this.ifsc = ifsc;
}
public String getDdate() {
	return ddate;
}
public void setDdate(String ddate) {
	this.ddate = ddate;
}
public String getMdate() {
	return mdate;
}
public void setMdate(String mdate) {
	this.mdate = mdate;
}
public String getYdate() {
	return ydate;
}
public void setYdate(String ydate) {
	this.ydate = ydate;
}
 
}
