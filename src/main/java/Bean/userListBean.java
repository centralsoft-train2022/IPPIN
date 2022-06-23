package Bean;

import java.util.List;

import Dao.FoodVo;

public class userListBean
{
	private String loginid;
	private String userName;
	private String msg;
	private String ippin; 
	private List<FoodVo> ippinList;
	private String Timezone;
	private String Amount;
	
	public userListBean()
	{}
	
	public String getTimezone() {
		return Timezone;
	}

	public void setTimezone(String timezone) {
		Timezone = timezone;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getCookTime() {
		return CookTime;
	}

	public void setCookTime(String cookTime) {
		CookTime = cookTime;
	}

	private String CookTime;

	

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
