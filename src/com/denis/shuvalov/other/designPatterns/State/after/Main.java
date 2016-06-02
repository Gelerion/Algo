package com.denis.shuvalov.other.designPatterns.State.after;

public class Main
{
	public static void main(String[] args)
	{
		TvRemoteContext tv = new TvRemoteContext();
		tv.doAction();
		tv.doAction();
		tv.doAction();
		tv.doAction();
	}
}
