package max.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mst_state")
public class State {
    @Id
    @Column(name="state_code")
	String stateCode;
    @Column(name="state_name")
	String stateName;
    @Column(name="state_short_name")
	String shrtanme;
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getShrtanme() {
		return shrtanme;
	}
	public void setShrtanme(String shrtanme) {
		this.shrtanme = shrtanme;
	}
	
}
