package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class FoodHistoryDao
{
	private Connection con;
	
	public FoodHistoryDao(Connection con) {
		super();	
		this.con = con;
	}
	 private static final String SELECT_TIME_SQL =
			 "SELECT \n"
			 + "Food_foodID\n"
			 + "from \n"
			 + "food_history \n"
			 + "order by \n"
			 + "date \n"
			 + "DESC\n"
			 + "LIMIT \n"
			 + "1";
	
	// もっとも更新が最近のfoodidを取得
	public int getFoodid() 
	{	
		FoodHistoryVo fhvo = new FoodHistoryVo();
		try(PreparedStatement stmt = con.prepareStatement( SELECT_TIME_SQL );)
		{
			ResultSet rset = stmt.executeQuery();

			while (rset.next())
			{
				
	            fhvo.setFoodFoodid(rset.getInt(1));
	            
			}
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
		
		int foodid = fhvo.getFoodFoodid();
		
		return foodid;
	}
	
	private static final String INSERT_SQL = "insert\n"
	        + "into food_history\n"
	        + "(\n"
	        + "     date\n"
	        + "    ,User_userID\n"
	        + "    ,Food_FoodID\n"
	        + ")\n"
	        + "values\n"
	        + "(\n"
	        + " ?"
	        + ",?"
	        + ",?"
	        + ")";
    
	//food_historyに追加
	public void insert(Timestamp date, int User_userID, int Food_FoodID)
	{
		try( PreparedStatement stmt = this.con.prepareStatement( INSERT_SQL ) )
		{			
			//stmt.setInt( 1, Historyid );
			stmt.setTimestamp( 1, date );
			stmt.setInt( 2, User_userID );
			stmt.setInt( 3, Food_FoodID);

			/* ｓｑｌ実行 */
			stmt.executeUpdate( );
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}
	}
}