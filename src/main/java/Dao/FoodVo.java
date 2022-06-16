package Dao;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Thu May 18 17:00:22 JST 2017
 */
import java.io.Serializable;

/**
 * EmployeesVo.
 * @author e.hayashi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2017/05/18	e.hayashi		Generated.
 */
public class FoodVo implements Serializable{

	public static final String TABLE = "food";

	private int foodid;

	private String name;

	private String timezone;

	private String amount;
	
	private String cooktime;

	/**
	* Constractor
	*/
	public FoodVo(){}

	/**
	* Constractor
	* @param <code>employeeid</code>
	*/
	public FoodVo(int foodid){
		this.foodid = foodid;
	}


	public int getFoodid(){ return this.foodid; }

	public void setFoodid(int foodid){ this.foodid = foodid; }

	public String getFoodName(){ return this.name; }

	public void setFoodName(String foodname){ this.name = foodname; }

	public String getTimeZone(){ return this.timezone; }

	public void setTimeZone(String timezone){ this.timezone = timezone; }

	public String getAmount(){ return this.amount; }

	public void setAmount(String amount){ this.amount = amount; }
	
	public String getCookTime(){ return this.cooktime; }

	public void setCookTime(String cooktime){ this.cooktime = cooktime; }
	


	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[UserVo:");
		buffer.append(" userfoodid: ");
		buffer.append(foodid);
		buffer.append("\n foodname: ");
		buffer.append(name);
		buffer.append("\n eattime: ");
		buffer.append(timezone);
		buffer.append("\n foodamount: ");
		buffer.append(amount);
		buffer.append("\n cooktime: ");
		buffer.append(cooktime);
		buffer.append("\n]");
		return buffer.toString();
	}
}

