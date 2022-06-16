package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDao
{
	private Connection con;

	 private static final String SELECT_NAME_SQL =
			"SELECT\n"
			+ "name\n"
			+ "from\n"
			+ "food\n"
			+ "order by\n"
			+ "ippingoodcount\n"
			+ "DESC";

	public FoodDao(Connection con) {
		super();	
		this.con = con;
	}
	
	// 逸品の名前を逸品goodカウントが高い順に取得
	public List<String> getIppin() 
	{
		List<String> list = new ArrayList<String>();
		
		try(PreparedStatement stmt = con.prepareStatement( SELECT_NAME_SQL );)
		{
			ResultSet rset = stmt.executeQuery();

			while (rset.next())
			{
				FoodVo em = new FoodVo();
				//em.setFoodid(rset.getInt(1));
	            em.setFoodName(rset.getString(1));

				list.add(em.getFoodName());
			}
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}

		return list;
	}
	
	private static final String SELECT_ID_SQL =
			 "select "
		+ "   Foodid"
		+ "   from "
		+ "   food "
		+ "   where "
		+ "   name = ? ";
	
	// 逸品になったfoodidを取得
		public int getFoodid(String name) 
		{
			int foodid = 0;
			try(PreparedStatement stmt = con.prepareStatement( SELECT_ID_SQL );)
			{
				stmt.setString( 1, name );
				ResultSet rset = stmt.executeQuery();

				while (rset.next())
				{
					FoodVo em = new FoodVo();
					//em.setFoodid(rset.getInt(1));
		            em.setFoodid(rset.getInt(1));
		            foodid = em.getFoodid();
		            //System.out.println(foodid);
				}
			}
			catch( SQLException e )
			{
				throw new RuntimeException( e );
			}

			return foodid;
		}
		
	 private static final String SELECT_NEARLYNAME_SQL =
				 "select "
			+ "   Name"
			+ "   from "
			+ "   food "
			+ "   where "
			+ "   foodid = ? ";

		
		// 一番最近取得した逸品の名前
		public String getNearlyIppin(int foodid) 
		{
			FoodVo fvo = new FoodVo();
			
			try(PreparedStatement stmt = con.prepareStatement( SELECT_NEARLYNAME_SQL );)
			{
				stmt.setInt( 1, foodid );
				ResultSet rset = stmt.executeQuery();

				while (rset.next())
				{
		            fvo.setFoodName(rset.getString(1));
		 
			    }
			}
			catch( SQLException e )
			{
				throw new RuntimeException( e );
			}
			
			String nearlyName = fvo.getFoodName();
			
			
			
			return nearlyName;
		}
		
		private static final String SELECT_SUM_SQL =
				 "UPDATE \n"
				 + "food \n"
				 + "SET \n"
				 + "ippingoodcount = coalesce(ippingoodcount,0) + 1 \n"
				 + "WHERE \n"
				 + "foodid = ?";

		
		// 一番最近取得した逸品の名前
		public void  sumIppinGoodCount(int foodid) 
		{
			try(PreparedStatement stmt = con.prepareStatement( SELECT_SUM_SQL );)
			{
				stmt.setInt( 1, foodid );
				stmt.executeUpdate();
			}
			catch( SQLException e )
			{
				throw new RuntimeException( e );
			}	
		}

		private static final String SELECT_SUB_SQL =
				 "UPDATE \n"
				 + "food \n"
				 + "SET \n"
				 + "ippingoodcount = coalesce(ippingoodcount,0) - 1 \n"
				 + "WHERE \n"
				 + "foodid = ?";

		
		// 一番最近取得した逸品の名前
		public void  subIppinGoodCount(int foodid) 
		{
			try(PreparedStatement stmt = con.prepareStatement( SELECT_SUB_SQL );)
			{
				stmt.setInt( 1, foodid );
				stmt.executeUpdate();
			}
			catch( SQLException e )
			{
				throw new RuntimeException( e );
			}	
		}
}