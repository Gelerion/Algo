package com.denis.shuvalov.other.designPatterns.State.after;

public class TvOffState implements State
{
	@Override
	public void doAction(TvRemoteContext tv)
	{
		System.out.println("TV is turned on");
	}
}
