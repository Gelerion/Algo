package com.denis.shuvalov.little_api;

import java.sql.SQLException;

public class Test
{
	public static void main(String[] args) throws SQLException
	{
		DataSourceTransaction transaction = new DataSourceTransaction();

		transaction.open(connection -> connection.prepareStatement("SELECT"));
	}
}
