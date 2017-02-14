package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbDao {
	private Connection connection;
	private String driver;
	private String url;
	private String username;
	private String password;
	public DbDao(){}
	public DbDao(String driver, String url, String username, String password) {
		super();
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	//��Ա���Ե�getter��setter����
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//��ȡ���ݿ�����
	public Connection getConnection() throws SQLException, ClassNotFoundException{
		if(connection == null){
			Class.forName(driver);
			connection = DriverManager.getConnection(url, username, password);
		}
		return connection;
	}
	//�����¼
	public boolean insert(String sql,Object...args) throws ClassNotFoundException, SQLException{
		PreparedStatement pstm = getConnection().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		for(int i = 0; i < args.length; i++){
			pstm.setObject(i + 1, args[i]);
		}
		if(pstm.executeUpdate() != 1){
			return false;
		}
		return true;
	}
	//ִ�в�ѯ
	public ResultSet query(String sql,Object...args) throws ClassNotFoundException, SQLException{
		PreparedStatement pstm = getConnection().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		for(int i = 0; i < args.length; i++){
			pstm.setObject(i + 1, args[i]);
		}
		return pstm.executeQuery();
	}
	//ִ���޸�
	public void modify(String sql,Object...args) throws ClassNotFoundException, SQLException{
		PreparedStatement pstm = getConnection().prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		for(int i = 0; i < args.length; i++){
			pstm.setObject(i + 1, args[i]);
		}
		pstm.executeUpdate();
		pstm.close();
	}
	//�ر����ݿ�����
	public void closeConnection() throws SQLException{
		if(connection != null && !connection.isClosed()){
			connection.close();
		}
	}
}
