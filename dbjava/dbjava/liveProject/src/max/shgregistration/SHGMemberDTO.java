package max.shgregistration;

public class SHGMemberDTO {
      String shgMemberCode;
	private String[] cname;
	 private String[] age;
	 private String[] cadhar;
	 String shgCode;
	 
	public String getShgCode() {
		return shgCode;
	}
	public void setShgCode(String shgCode) {
		this.shgCode = shgCode;
	}
	public String getShgMemberCode() {
		return shgMemberCode;
	}
	public void setShgMemberCode(String shgMemberCode) {
		this.shgMemberCode = shgMemberCode;
	}
	public String[] getCname() {
		return cname;
	}
	public void setCname(String[] cname) {
		this.cname = cname;
	}
	public String[] getAge() {
		return age;
	}
	public void setAge(String[] age) {
		this.age = age;
	}
	public String[] getCadhar() {
		return cadhar;
	}
	public void setCadhar(String[] cadhar) {
		this.cadhar = cadhar;
	}
	 
	
}
