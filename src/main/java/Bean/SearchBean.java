package Bean;

import java.util.List;

import Dao.FoodVo;

//テスト
public class SearchBean {
	//食べる時間、量、手間で選んだものを名前として出す
	//画面に出すものは作る
	private String TimeZone;
	private String Amount;
	private String CookTime;
	private String Name;

	private List<FoodVo> foodList;

	public List<FoodVo> getFoodList() {
		return foodList;
	}

	public void setFoodList(List<FoodVo> foodList) {
		this.foodList = foodList;
	}

	public String getTimeZone() {
		return TimeZone;
	}

	public void setTimeZone(String timeZone) {
		TimeZone = timeZone;
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	@Override
	public String toString() {
		return "SearchBean [TimeZone=" + TimeZone + ", Amount=" + Amount + ", CookTime=" + CookTime + ", Name=" + Name
				+ ", foodList=" + foodList + "]";
	}

}
