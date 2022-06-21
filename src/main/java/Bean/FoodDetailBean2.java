package Bean;

public class FoodDetailBean2
{
	private String userName;
	private String msg;
	private String ippin; 
	private String Timezone;
	private String Amount;
	private String CookTime;
	
	public FoodDetailBean2()
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

	public String getIppin()
	{
		return ippin;
	}

	public void setIppin( String ippin )
	{
		this.ippin = ippin;
	}
}
