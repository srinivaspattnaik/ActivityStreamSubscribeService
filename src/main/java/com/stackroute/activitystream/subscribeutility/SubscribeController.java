package com.stackroute.activitystream.subscribeutility;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscribeController 
{
	@Autowired
	SubscribeCircleDAO subscribeCircleDAO;
	
	@PostMapping("/subscribetoCircle")
	public ResponseEntity<String> subscribeToCircle(@RequestBody SubscribeCircle subscribeCircle)
	{
		subscribeCircle.setSubscribe_id((int)(Math.random()*10000));
		subscribeCircle.setSubscribe_date(new Date());
		subscribeCircle.setStatus("A");
				
		if(subscribeCircleDAO.subscribeToCircle(subscribeCircle))
		{  
		return new ResponseEntity<String>("Added to Circle",HttpStatus.ACCEPTED);
		}
		else
		{
		return new ResponseEntity<String>("Problem Occured:",HttpStatus.OK);	
		}
	}
	
	@GetMapping("/unsubscribeCircle/{subscribeid}")
	public ResponseEntity<String> unsubscribeCircle(@PathVariable("subscribeid")int subscribeid)
	{
		if(subscribeCircleDAO.unSubscribeFromCircle(subscribeid))
		{
		return new ResponseEntity<String>("You have been removed from Circle",HttpStatus.OK);
		}
		else
		{
		return new ResponseEntity<String>("Problem in Removing",HttpStatus.OK);
		}
	}
	
	@GetMapping("/getAllSubscribeCircle/{emailid}")
	public ResponseEntity<List<SubscribeCircle>> getAllSubscribeCircle(@PathVariable("emailid")String emailid)
	{
		emailid=emailid+".com";
		List<SubscribeCircle> listCircles=subscribeCircleDAO.getSubscribeCircles(emailid);
		return new ResponseEntity<List<SubscribeCircle>>(listCircles,HttpStatus.OK);
	}
}
