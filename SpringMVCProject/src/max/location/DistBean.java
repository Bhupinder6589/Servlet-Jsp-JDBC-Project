package max.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_district")
public class DistBean {
	@Id
	@Column(name="district_name")
 String distName;
	@Column(name="district_code")
 String distCode;
	@Column(name="state_code")
 String stateCode;
public String getDistName() {
	return distName;
}
public void setDistName(String distName) {
	this.distName = distName;
}
public String getDistCode() {
	return distCode;
}
public void setDistCode(String distCode) {
	this.distCode = distCode;
}
public String getStateCode() {
	return stateCode;
}
public void setStateCode(String stateCode) {
	this.stateCode = stateCode;
}
 
}
