package Bean;

import java.util.List;

import Dao.FoodVo;

public class RecomBean
{
	private String loginid;
	private String userName;
	private String msg;
	private String ippin; 
	private List<FoodVo> ippinList;

	public RecomBean()
	{}

	public String getLoginID() {
		return loginid;
	}

	public void setLoginID(String loginid) {
		this.loginid = loginid;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<FoodVo> getIppinList() {
		return ippinList;
	}
	public void setIppinList(List<FoodVo> ippinList) {
		this.ippinList = ippinList;
	}

	public String getIppin()
	{
		return ippin;
	}

	public void setIppin( String ippin )
	{
		this.ippin = ippin;
	}
}
