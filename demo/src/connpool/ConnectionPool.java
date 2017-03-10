package connpool;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Vector;

public class ConnectionPool {
	private String jdbcDriver;//数据库驱动
	private String dbUrl;//数据库url
	private String dbUsername;//数据库用户名
	private String dbPassword;//数据库密码
	private int initPoolSize = 10;//链接初始化大小
	private int maxConnection = 50;//最大连接数
	private int incrementStep = 1;//默认每次增加一个
	private Vector<PooledConnection> connections;//存放连接
	public ConnectionPool(String jdbcDriver, String dbUrl, String dbUsername, String dbPassword) {
		this.jdbcDriver = jdbcDriver;
		this.dbUrl = dbUrl;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	
	public synchronized void createpool() throws Exception {
		if (connections != null) {
			throw new Exception("连接池已经创建！无需再次创建");
		}
		// 实例化 JDBC Driver 中指定的驱动类实例
        Driver driver = (Driver) (Class.forName(this.jdbcDriver).newInstance());
        DriverManager.registerDriver(driver);
        // 创建保存连接的向量 , 初始时有 0 个元素
        connections = new Vector();
        createConnections(this.initPoolSize);
        System.out.println("连接池创建成功！");
	}

	private synchronized void createConnections(int num) {
		for (int i = 0; i < num; i++) {
			if (maxConnection>0 && this.connections.size() >= maxConnection) {
				break;
			}
			try {
				connections.addElement(new PooledConnection(newConnection()));
			} catch (SQLException e) {
				System.out.println("连接创建失败");
				e.printStackTrace();
			}
			
		}
	}
	
	public void closeCollection(Connection conn) throws SQLException{
		if (connections == null) {
			System.out.println("连接池为空");
		}
		if (conn != null) {
			  Enumeration enumerate = connections.elements();
		        while (enumerate.hasMoreElements()) {
		        	PooledConnection poolConn = (PooledConnection)enumerate.nextElement();
		        	poolConn.setBusy(false);
		        	break;
		        }
		}
	}
	
	public Connection getConnection() throws Exception{
		if (connections == null) {
			throw new Exception("连接池不存在请先创建连接池");
		}
		Connection conn = getFreeConn();
		while (conn == null) {//如果conn为空
			//wait(300);//等待3毫秒  等待连接池有可用链接
			conn = getFreeConn();
		}
		return conn;
	}
	
	private Connection getFreeConn() throws Exception {
		if (connections == null) {
			throw new Exception("连接池未创建");
		}
		Connection conn = findFreeConn();
		if (conn == null) {//连接池所有链接都在忙  就新增一个链接
			createConnections(this.incrementStep);
			//再去获取
			conn = findFreeConn();
		}
		return conn;
	}
	

	private Connection findFreeConn() {
		Connection conn = null;
		PooledConnection pConn = null;
		  // 获得连接池向量中所有的对象
        Enumeration enumerate = connections.elements();
        while (enumerate.hasMoreElements()) {
        	pConn = (PooledConnection) enumerate.nextElement();
			if (!pConn.isBusy()) {
				pConn.setBusy(true);//获取链接设置繁忙
				conn = pConn.getConnection();
				if (!testConnection(conn)) {
					try {
						conn = newConnection();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					pConn.setConnection(conn);
					break;
				}
			}
		}
		return conn;
	}

	
	private boolean testConnection(Connection conn) {
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("链接不可用------------");
			e.printStackTrace();
			closeConnection(conn);
			return false;
		}
		return true;
	}
	 private void closeConnection(Connection conn) {
	        try {
	            conn.close();
	        } catch (SQLException e) {
	            System.out.println(" 关闭数据库连接出错： " + e.getMessage());
	        }
	    }
	private Connection newConnection() throws SQLException {
        // 创建一个数据库连接
        Connection conn = DriverManager.getConnection(dbUrl, dbUsername,
                dbPassword);
        // 假如这是第一次创建数据库连接，即检查数据库，获得此数据库答应支持的
        // 最大客户连接数目
        //connections.size()==0 表示目前没有连接己被创建
        if (connections.size() == 0) {
            DatabaseMetaData metaData = conn.getMetaData();
            int driverMaxConnections = metaData.getMaxConnections();
            // 数据库返回的 driverMaxConnections 若为 0 ，表示此数据库没有最大
            // 连接限制，或数据库的最大连接限制不知道
            //driverMaxConnections 为返回的一个整数，表示此数据库答应客户连接的数目
            // 假如连接池中设置的最大连接数量大于数据库答应的连接数目 , 则置连接池的最大
            // 连接数目为数据库答应的最大数目
            if (driverMaxConnections > 0 &&
                this.maxConnection > driverMaxConnections) {
                this.maxConnection = driverMaxConnections;
            }
        }
        return conn; // 返回创建的新的数据库连接
    }

	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public String getDbUsername() {
		return dbUsername;
	}

	public void setDbUsername(String dbUsername) {
		this.dbUsername = dbUsername;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public int getInitPoolSize() {
		return initPoolSize;
	}

	public void setInitPoolSize(int initPoolSize) {
		this.initPoolSize = initPoolSize;
	}

	public int getMaxConnection() {
		return maxConnection;
	}

	public void setMaxConnection(int maxConnection) {
		this.maxConnection = maxConnection;
	}

	public int getIncrementStep() {
		return incrementStep;
	}

	public void setIncrementStep(int incrementStep) {
		this.incrementStep = incrementStep;
	}

	public Vector<PooledConnection> getConnections() {
		return connections;
	}

	public void setConnections(Vector<PooledConnection> connections) {
		this.connections = connections;
	}
}
