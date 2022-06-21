package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	//接続文字列の構築
	/* ユーザ名 */
	//private static final String USER = "root";
	private static final String USER = "root";

	/* パスワード */
	//private static final String PASS = "rootroot";
	private static final String PASS = "rootroot";

	/* サーバ名 */
	//private static final String SERVER_NAME = "35.78.132.52:3306";
	private static final String SERVER_NAME = "localhost:3306";
	/* DB名 */
	//private static final String DB_NAME = "ippin";
	private static final String DB_NAME = "mydb";

	// ドライバーのロード
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

	//コネクション取得の共通メソッド
	public Connection getConnection() {
		Connection con = null;

		try {
			// ドライバーのロード
			Class.forName(DRIVER_CLASS);

			//①　接続の実行とコネクションオブジェクトの取得
			con = DriverManager.getConnection(
					"jdbc:mysql://"
							+ SERVER_NAME
							+ "/"
							+ DB_NAME,
					USER,
					PASS);

			//オートコミットをOFFにする
			con.setAutoCommit(false);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}

		return con;
	}
}
