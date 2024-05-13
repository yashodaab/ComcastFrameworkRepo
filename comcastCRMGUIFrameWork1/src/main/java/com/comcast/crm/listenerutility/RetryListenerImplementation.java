package com.comcast.crm.listenerutility;

public class RetryListenerImplementation {
	int count = 0;
	int limitcount = 5;
	public boolean retry(ITestResult result)
	{
		if(count<limitcount)
		{
			count++;
			return true;
		}
		return false;
	}

}
