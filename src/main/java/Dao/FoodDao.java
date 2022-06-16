package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.IppinBean;

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
	
	private static final String SELECT_SEARCHNAME_SQL = "select "
			+ "   name"
			+ "   from "
			+ "   food "
			+ "   where "
			+ "   amount = ? "
			+ "   timezone = ? "
			+ "   cooktime = ? ";

	// 逸品になったfoodidを取得
	public List<String> getFoodname(String Amount, String TimeZone, String CookTime) {
		List<String> foodname = null;
		try (PreparedStatement stmt = con.prepareStatement(SELECT_SEARCHNAME_SQL);) {
			stmt.setString(1, Amount);
			stmt.setString(2, TimeZone);
			stmt.setString(3, CookTime);

			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {
				FoodVo em = new FoodVo();
				//em.setFoodid(rset.getInt(1));
				em.setFoodid(rset.getInt(1));
				foodname.add(em.getFoodName());
				//System.out.println(foodid);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return foodname;
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
		
		
		
		public List<String> getZyoukentukiName(String timezone, String amount, String cooktime) 
		{
			IppinBean bean = new IppinBean();
			bean.setTimezone(timezone);
			bean.setAmount(amount);
			bean.setCookTime(cooktime);
			
			System.out.println(bean.getTimezone());
			String SELECT_ZYOUKEN_SQL = "select Name from food ";	
			boolean flag = false;
			boolean flag2 = false;
			 
			//TimeZoneが入力されていればwhere句で連結、されなければスキップ
			            if (!bean.getTimezone().equals("未選択")) {
			            	SELECT_ZYOUKEN_SQL += " WHERE TimeZone = ?";
			                flag = true;
			            }
			                //Amountが入力されていれば処理を実施
			            if (!bean.getAmount().equals("未選択")) {
			                  //TimeZoneが入力されていなかった場合はWHERE、されていたらAND
			                if(!flag){
			                	SELECT_ZYOUKEN_SQL += " WHERE Amount = ?"; //TimeZoneが空欄の時はこの?が1番目
			                    flag = true;
			                }else{
			                	SELECT_ZYOUKEN_SQL += " AND Amount = ?"; //TimeZoneが入力されればこの?は2番目
			                }
			            }
			               //CookTimeが入力されていれば処理を実施
			            if (!bean.getCookTime().equals("未選択")) {
			                   //TimeZoneもAmountも空欄だった場合はwhere、どちらかもしくは両方入力されていたらAND
			                if(!flag){
			                	SELECT_ZYOUKEN_SQL += " WHERE CookTime = ?";
			                }else{
			                	SELECT_ZYOUKEN_SQL += " AND CookTime = ?";
			                }
			            }
			            
			            System.out.println(SELECT_ZYOUKEN_SQL);
			            
			List<String> list = new ArrayList<String>();
			
			try(PreparedStatement stmt = con.prepareStatement( SELECT_ZYOUKEN_SQL );)
			{
				     //timeZoneが入力されていれば処理を実施
				 if (!bean.getTimezone().equals("未選択")) {
					    stmt.setString( 1, bean.getTimezone() );
		                flag = true;
		            }
		              //Amountが入力されていれば処理を実施
		            if (!bean.getAmount().equals("未選択")) {
		                if(!flag){
		                	stmt.setString( 1, bean.getAmount() ); 
		                    flag2 = true;
		                }else{
		                	stmt.setString( 2, bean.getAmount() ); 
		                	flag2 = true;
		                }
		            }
		                //CookTimeが入力されていれば処理を実施
		            if (!bean.getCookTime().equals("未選択")) {
		            	
		                 //TimeZoneもAmountも空欄だった場合はwhere、どちらかもしくは両方入力されていたらAND
		            	
		                if(!flag && !flag2){
		                	stmt.setString( 1, bean.getCookTime() );
		                }else if( (!flag && flag2) || (flag && !flag2) ){
		                	stmt.setString( 2, bean.getCookTime() );
		                }else {
		                	stmt.setString( 3, bean.getCookTime() );
		                }
		            }
				
				ResultSet rset = stmt.executeQuery();

				while (rset.next())
				{
					FoodVo em = new FoodVo();
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
}