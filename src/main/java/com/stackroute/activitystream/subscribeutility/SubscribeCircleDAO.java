package com.stackroute.activitystream.subscribeutility;

import java.util.List;


public interface SubscribeCircleDAO 
{
	public boolean subscribeToCircle(SubscribeCircle subscribeCircle);
	//From where you will get subscribeID?  
	//You can unsubscribe easily if you send emailID and circleID
	public boolean unSubscribeFromCircle(int subscribeID);
	//If you require only circleIDs the return type should be List<String>
	public List<SubscribeCircle> getSubscribeCircles(String emailID);
}
