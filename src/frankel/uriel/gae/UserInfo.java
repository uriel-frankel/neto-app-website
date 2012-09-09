package frankel.uriel.gae;

import javax.persistence.Id;

import com.googlecode.objectify.annotation.Entity;

@Entity
public class UserInfo {
	@Id
	Long id;
	public int salary;
	public String jobTitle;
	public String company;
	public String discipline;
	public int seniority;
}