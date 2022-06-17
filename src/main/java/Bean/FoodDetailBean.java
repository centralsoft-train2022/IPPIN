package Bean;

public class FoodDetailBean {
	private String foodName;
	private String explanation;
	private String amount;
	private String cookTime;
	private String photoFileName;
	private int foodID;
	private String TimeZone;
	private String UserID;
	
	
	public String getTimeZone()
	{
		return TimeZone;
	}
	public void setTimeZone( String timeZone )
	{
		TimeZone = timeZone;
	}
	public String getUserID()
	{
		return UserID;
	}
	public void setUserID( String userID )
	{
		UserID = userID;
	}
	public int getFoodID()
	{
		return foodID;
	}
	public void setFoodID( int foodID )
	{
		this.foodID = foodID;
	}
	public String getFoodName()
	{
		return foodName;
	}
	public void setFoodName( String foodName )
	{
		this.foodName = foodName;
	}
	public String getExplanation()
	{
		return explanation;
	}
	public void setExplanation( String explanation )
	{
		this.explanation = explanation;
	}
	public String getAmount()
	{
		return amount;
	}
	public void setAmount( String amount )
	{
		this.amount = amount;
	}
	public String getCookTime()
	{
		return cookTime;
	}
	public void setCookTime( String cookTime )
	{
		this.cookTime = cookTime;
	}
	public String getPhotoFileName()
	{
		return photoFileName;
	}
	public void setPhotoFileName( String photoFileName )
	{
		this.photoFileName = photoFileName;
	}
	
	
}