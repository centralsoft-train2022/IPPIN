package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao
{
	private Connection con;

	 private static final String SELECT_ONE_SQL =
			 "select "
		+ "   USERID"
		+ "  ,PASSWARD"
		+ "  ,USERKBN"
		+ "  ,USERNAME"
		+ " from "
		+ "   USER "
		+ " where"
		+ "   USERID=?";

	public UserDao(Connection con) {
		super();	
		this.con = con;
	}
	
	// usernameを取得
	public UserVo getUserName(int id) 
	{
		UserVo em = new UserVo();

		try(
			 PreparedStatement 	stmt = con.prepareStatement( SELECT_ONE_SQL );
			)
		{
			stmt.setInt(1 ,id );
			ResultSet 		 	rset = stmt.executeQuery();

			while (rset.next())
			{
				int eid =rset.getInt(1);
				em.setUserid( eid );
				em.setPassword( 	rset.getString(2));
				em.setUserKbn( 		rset.getString(3));
				em.setUserName(		rset.getString(4));
			}
		}
		catch( SQLException e )
		{
			throw new RuntimeException( e );
		}

		return em;
	}
	
	
	
	
}
