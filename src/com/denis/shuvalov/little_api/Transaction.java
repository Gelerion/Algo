package com.denis.shuvalov.little_api;

import java.sql.Connection;
import java.sql.SQLException;

public interface Transaction
{
	void open(ThrowingConsumer<Connection, SQLException> logic) throws SQLException;
}
