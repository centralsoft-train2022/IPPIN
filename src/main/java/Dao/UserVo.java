package Dao;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Thu May 18 17:00:22 JST 2017
 */
import java.io.Serializable;


public class UserVo implements Serializable{

	public static final String TABLE = "User";

	private int userid;

	private String password;

	private String userkbn;
	
	private String userName;
	
	public UserVo(){}

	/**
	* Constractor
	* @param <code>employeeid</code>
	*/
	public UserVo(int userid){
		this.userid = userid;
	}


	public int getUserid(){ return this.userid; }

	public void setUserid(int userid){ this.userid = userid; }

	public String getPassword(){ return this.password; }

	public void setPassword(String password){ this.password = password; }

	public String getUserKbn(){ return this.userkbn; }

	public void setUserKbn(String userKbn){ this.userkbn = userKbn; }

	public String getUserName(){ return this.userName; }

	public void setUserName(String userName){ this.userName = userName; }
	


	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[UserVo:");
		buffer.append(" userid: ");
		buffer.append(userid);
		buffer.append("\n password: ");
		buffer.append(password);
		buffer.append("\n userkbn: ");
		buffer.append(userkbn);
		buffer.append("\n userName: ");
		buffer.append(userName);
		buffer.append("\n]");
		return buffer.toString();
	}

}
