package com.denis.shuvalov.designPatterns.State.after;

public class TvRemoteContext
{
	private State currentState = new TvOffState();

	public TvRemoteContext setCurrentState(State currentState)
	{
		this.currentState = currentState;
		return this;
	}

	public void doAction()
	{
		currentState.doAction(this);

		if (currentState.getClass().equals(TvOnState.class))
			currentState = new TvOffState();
		else
			currentState = new TvOnState();
	}
}