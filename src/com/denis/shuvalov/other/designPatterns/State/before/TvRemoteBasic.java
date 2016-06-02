package com.denis.shuvalov.other.designPatterns.State.before;

public class TvRemoteBasic
{
	private String state = "";

    public static void main(String[] args) {
        TvRemoteBasic tv = new TvRemoteBasic();

        tv.setState("OFF");
        tv.doAction();

        tv.setState("ON");
        tv.doAction();
    }

	public TvRemoteBasic setState(String state)
	{
		this.state = state;
		return this;
	}

	public void doAction()
	{
		if ("ON".equals(state))
			System.out.println("TV is turned off");
		else if("OFF".equals(state))
			System.out.println("TV is turned on");
	}
}
