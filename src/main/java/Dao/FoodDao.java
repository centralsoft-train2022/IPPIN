package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.FoodDetailBean;
import Bean.IppinBean;

public class FoodDao {
	private Connection con;

	//逸品リストの名前取得
	private static final String SELECT_IPPINNAME_SQL = "select "
			+ "   name "
			+ "   from "
			+ "   food ";

	public List<FoodVo> getIppinname() {
		List<FoodVo> list = new ArrayList<FoodVo>();

		try (PreparedStatement stmt = con.prepareStatement(SELECT_IPPINNAME_SQL);) {
			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {
				FoodVo em = new FoodVo();

				em.setFoodName(rset.getString(1));

				list.add(em);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}
	
	// 選択された逸品の詳細を取得
	private static final String SELECT_DETAIL_SQL = "select "
			+ "   name"
			+ "   ,cooktime"
			+ "   ,amount"
			+ "   ,timezone"
			+ "   ,photofilename"
			+ "   from "
			+ "   food "
			+ "   where "
			+ "   name = ? ";

	
	public FoodVo getFoodDetail(String name) {
		
		FoodVo em = new FoodVo();
		try (PreparedStatement stmt = con.prepareStatement(SELECT_DETAIL_SQL);) {
			stmt.setString(1, name);
			ResultSet rset = stmt.executeQuery();
			
			while (rset.next()) {	
				em.setFoodName(rset.getString(1));
				em.setCookTime(rset.getString(2));
				em.setAmount(rset.getString(3));
				em.setTimeZone(rset.getString(4));
				em.setFilename(rset.getString(5));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return em;
	}

	// 逸品の名前を逸品goodカウントが高い順に取得
	private static final String SELECT_NAME_SQL = "SELECT\n"
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

	public List<String> getIppin() {
		List<String> list = new ArrayList<String>();

		try (PreparedStatement stmt = con.prepareStatement(SELECT_NAME_SQL);) {
			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {
				FoodVo em = new FoodVo();
				//em.setFoodid(rset.getInt(1));
				em.setFoodName(rset.getString(1));

				list.add(em.getFoodName());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
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
	@SuppressWarnings("null")
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

	private static final String SELECT_ID_SQL = "select "
			+ "   Foodid"
			+ "   from "
			+ "   food "
			+ "   where "
			+ "   name = ? ";

	// 逸品になったfoodidを取得
	public int getFoodid(String name) {
		int foodid = 0;
		try (PreparedStatement stmt = con.prepareStatement(SELECT_ID_SQL);) {
			stmt.setString(1, name);
			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {
				FoodVo em = new FoodVo();
				//em.setFoodid(rset.getInt(1));
				em.setFoodid(rset.getInt(1));
				foodid = em.getFoodid();
				//System.out.println(foodid);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return foodid;
	}

	private static final String SELECT_NEARLYNAME_SQL = "select "
			+ "   Name"
			+ "   from "
			+ "   food "
			+ "   where "
			+ "   foodid = ? ";

	// 一番最近取得した逸品の名前
	public String getNearlyIppin(int foodid) {
		FoodVo fvo = new FoodVo();

		try (PreparedStatement stmt = con.prepareStatement(SELECT_NEARLYNAME_SQL);) {
			stmt.setInt(1, foodid);
			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {
				fvo.setFoodName(rset.getString(1));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		String nearlyName = fvo.getFoodName();

		return nearlyName;
	}

	private static final String SELECT_SUM_SQL = "UPDATE \n"
			+ "food \n"
			+ "SET \n"
			+ "ippingoodcount = coalesce(ippingoodcount,0) + 1 \n"
			+ "WHERE \n"
			+ "foodid = ?";

	// 一番最近取得した逸品の名前
	public void sumIppinGoodCount(int foodid) {
		try (PreparedStatement stmt = con.prepareStatement(SELECT_SUM_SQL);) {
			stmt.setInt(1, foodid);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static final String SELECT_SUB_SQL = "UPDATE \n"
			+ "food \n"
			+ "SET \n"
			+ "ippingoodcount = coalesce(ippingoodcount,0) - 1 \n"
			+ "WHERE \n"
			+ "foodid = ?";

	// 一番最近取得した逸品の名前
	public void subIppinGoodCount(int foodid) {
		try (PreparedStatement stmt = con.prepareStatement(SELECT_SUB_SQL);) {
			stmt.setInt(1, foodid);
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<String> getZyoukentukiName(String timezone, String amount, String cooktime) {
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
			if (!flag) {
				SELECT_ZYOUKEN_SQL += " WHERE Amount = ?"; //TimeZoneが空欄の時はこの?が1番目
				flag = true;
			} else {
				SELECT_ZYOUKEN_SQL += " AND Amount = ?"; //TimeZoneが入力されればこの?は2番目
			}
		}
		//CookTimeが入力されていれば処理を実施
		if (!bean.getCookTime().equals("未選択")) {
			//TimeZoneもAmountも空欄だった場合はwhere、どちらかもしくは両方入力されていたらAND
			if (!flag) {
				SELECT_ZYOUKEN_SQL += " WHERE CookTime = ?";
			} else {
				SELECT_ZYOUKEN_SQL += " AND CookTime = ?";
			}
		}

		System.out.println(SELECT_ZYOUKEN_SQL);

		List<String> list = new ArrayList<String>();

		try (PreparedStatement stmt = con.prepareStatement(SELECT_ZYOUKEN_SQL);) {
			//timeZoneが入力されていれば処理を実施
			if (!bean.getTimezone().equals("未選択")) {
				stmt.setString(1, bean.getTimezone());
				flag = true;
			}
			//Amountが入力されていれば処理を実施
			if (!bean.getAmount().equals("未選択")) {
				if (!flag) {
					stmt.setString(1, bean.getAmount());
					flag2 = true;
				} else {
					stmt.setString(2, bean.getAmount());
					flag2 = true;
				}
			}
			//CookTimeが入力されていれば処理を実施
			if (!bean.getCookTime().equals("未選択")) {

				//TimeZoneもAmountも空欄だった場合はwhere、どちらかもしくは両方入力されていたらAND

				if (!flag && !flag2) {
					stmt.setString(1, bean.getCookTime());
				} else if ((!flag && flag2) || (flag && !flag2)) {
					stmt.setString(2, bean.getCookTime());
				} else {
					stmt.setString(3, bean.getCookTime());
				}
			}

			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {
				FoodVo em = new FoodVo();
				em.setFoodName(rset.getString(1));

				list.add(em.getFoodName());
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	//------------------------------------------------------------------------------
	//絞り込み用メソッド追加
	private static final String SELECT_ZYOUKEN_FOODVO_SQL = "SELECT `food`.`FoodID`,\r\n"
			+ "    `food`.`Amount`,\r\n"
			+ "    `food`.`TimeZone`,\r\n"
			+ "    `food`.`CookTime`,\r\n"
			+ "    `food`.`Name`,\r\n"
			+ "    `food`.`Explanation`,\r\n"
			+ "    `food`.`PhotoFileName`,\r\n"
			+ "    `food`.`User_UserID`\r\n"
			+ "FROM `food`\r\n";

	public List<FoodVo> getZyoukentukiFoodVo(String timezone, String amount, String cooktime) {
		IppinBean bean = new IppinBean();
		bean.setTimezone(timezone);
		bean.setAmount(amount);
		bean.setCookTime(cooktime);

		String sql = SELECT_ZYOUKEN_FOODVO_SQL;

		System.out.println(bean.getTimezone());
		boolean flag = false;
		boolean flag2 = false;

		//TimeZoneが入力されていればwhere句で連結、されなければスキップ
		if (!bean.getTimezone().equals("未選択")) {
			sql += " WHERE TimeZone = ?";
			flag = true;
		}
		//Amountが入力されていれば処理を実施
		if (!bean.getAmount().equals("未選択")) {
			//TimeZoneが入力されていなかった場合はWHERE、されていたらAND
			if (!flag) {
				sql += " WHERE Amount = ?"; //TimeZoneが空欄の時はこの?が1番目
				flag = true;
			} else {
				sql += " AND Amount = ?"; //TimeZoneが入力されればこの?は2番目
			}
		}
		//CookTimeが入力されていれば処理を実施
		if (!bean.getCookTime().equals("未選択")) {
			//TimeZoneもAmountも空欄だった場合はwhere、どちらかもしくは両方入力されていたらAND
			if (!flag) {
				sql += " WHERE CookTime = ?";
			} else {
				sql += " AND CookTime = ?";
			}
		}

		System.out.println(sql);

		List<FoodVo> list = new ArrayList<FoodVo>();

		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			//timeZoneが入力されていれば処理を実施
			if (!bean.getTimezone().equals("未選択")) {
				stmt.setString(1, bean.getTimezone());
				flag = true;
			}
			//Amountが入力されていれば処理を実施
			if (!bean.getAmount().equals("未選択")) {
				if (!flag) {
					stmt.setString(1, bean.getAmount());
					flag2 = true;
				} else {
					stmt.setString(2, bean.getAmount());
					flag2 = true;
				}
			}
			//CookTimeが入力されていれば処理を実施
			if (!bean.getCookTime().equals("未選択")) {

				//TimeZoneもAmountも空欄だった場合はwhere、どちらかもしくは両方入力されていたらAND

				if (!flag && !flag2) {
					stmt.setString(1, bean.getCookTime());
				} else if ((!flag && flag2) || (flag && !flag2)) {
					stmt.setString(2, bean.getCookTime());
				} else {
					stmt.setString(3, bean.getCookTime());
				}
			}

			ResultSet rset = stmt.executeQuery();

			while (rset.next()) {
				FoodVo em = new FoodVo();
				em.setFoodName(rset.getString(5));

				list.add(em);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	//逸品登録
	private static final String INSERT_TAG_SQL = "insert\n"
			+ " into food\n"
			+ " (\n"
			+ " Name\n"
			+ ",timezone\n"
			+ ",amount\n"
			+ ",cooktime\n"
			+ ",photoFileName\n"
			+ ",user_userid\n"
			+ " )\n"
			+ " values\n"
			+ " (\n"
			+ "  ?\n"
			+ "  ,?\n"
			+ "  ,?\n"
			+ "  ,?\n"
			+ "  ,?\n"
			+ "  ,?\n"
			+ " )";

	public void insert(
			String ippinName, String timeZone, String amount, String cookTime, String photoFileName,
			int userid) {

		System.out.println(ippinName + timeZone + amount + cookTime + photoFileName);

		try (PreparedStatement stmt = this.con.prepareStatement(INSERT_TAG_SQL)) {
			stmt.setString(1, ippinName);
			stmt.setString(2, timeZone);
			stmt.setString(3, amount);
			stmt.setString(4, cookTime);
			stmt.setString(5, photoFileName);
			stmt.setInt(6, userid);

			/* ｓｑｌ実行 */
			stmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	private static final String GET_FOOD_SQL = "SELECT `food`.`FoodID`,\n"
			+ "    `food`.`Amount`,\n"
			+ "    `food`.`TimeZone`,\n"
			+ "    `food`.`CookTime`,\n"
			+ "    `food`.`Name`,\n"
			+ "    `food`.`Explanation`,\n"
			+ "    `food`.`PhotoFileName`,\n"
			+ "    `food`.`User_UserID`\n"
			+ "FROM `food`\n"
			+ "WHERE FoodID = ?\n"
			+ ";";

	public FoodDetailBean getFoodDetailBean(int foodID) {
		FoodDetailBean bean = null;
		try (PreparedStatement stmt = this.con.prepareStatement(GET_FOOD_SQL)) {
			/* ｓｑｌ実行 */
			stmt.setInt(1, foodID);
			ResultSet rset = stmt.executeQuery();

			/* 取得したデータをEmployeesVoのインスタンスにまとめます */

			while (rset.next()) {
				bean = new FoodDetailBean();
				bean.setFoodID(foodID);
				bean.setAmount(rset.getString(2));
				bean.setTimeZone(rset.getString(3));
				bean.setCookTime(rset.getString(4));
				bean.setFoodName(rset.getString(5));
				bean.setExplanation(rset.getString(6));
				bean.setPhotoFileName(rset.getString(7));
				bean.setUserID(rset.getString(8));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return bean;
	}

}