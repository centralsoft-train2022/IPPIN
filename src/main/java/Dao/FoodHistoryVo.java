package Dao;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Thu May 18 17:00:22 JST 2017
 */
import java.io.Serializable;
import java.sql.Date;

/**
 * EmployeesVo.
 * @author e.hayashi
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2017/05/18	e.hayashi		Generated.
 */
public class FoodHistoryVo implements Serializable{

	public static final String TABLE = "food_history";

	private int historyid;

	private Date date;

	private int useruserID;

	private int foodFoodID;
	

	/**
	* Constractor
	*/
	public FoodHistoryVo(){}

	/**
	* Constractor
	* @param <code>employeeid</code>
	*/
	public FoodHistoryVo(int foodid){
		this.historyid = foodid;
	}


	public int getHistoryid(){ return this.historyid; }

	public void setHistoryid(int historyid){ this.historyid = historyid; }

	public Date getDate(){ return this.date; }

	public void setDate(Date date){ this.date = date; }

	public int getUserUserid(){ return this.useruserID; }

	public void setUserUserid(int useruserid){ this.useruserID = useruserid; }

	public int getFoodFoodid(){ return this.foodFoodID; }

	public void setFoodFoodid(int foodfoodid){ this.foodFoodID = foodfoodid; }
	


	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[UserVo:");
		buffer.append(" historyid: ");
		buffer.append(historyid);
		buffer.append("\n date: ");
		buffer.append(date);
		buffer.append("\n useruserID:");
		buffer.append(useruserID);
		buffer.append("\n foodFoodID:");
		buffer.append(foodFoodID);
		buffer.append("\n]");
		return buffer.toString();
	}
}

