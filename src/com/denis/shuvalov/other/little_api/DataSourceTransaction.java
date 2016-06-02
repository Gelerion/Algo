package com.denis.shuvalov.other.little_api;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceTransaction implements Transaction
{

	@Override
	public void open(ThrowingConsumer<Connection, SQLException> logic) throws SQLException
	{
		try(Connection conn = SqlUtil.connection())
		{
			logic.accept(conn);
		}
	}
}
