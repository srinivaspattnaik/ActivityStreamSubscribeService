package com.stackroute.activitystream;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream.subscribeutility"})
@EntityScan(basePackages={"com.stackroute.activitystream.subscribeutility"})
public class SubscribeCircleBoot 
{
	public static void main(String arg[])
	{
		SpringApplication.run(SubscribeCircleBoot.class,arg);
	}
	@Bean
	public SessionFactory getSessionFactory(HibernateEntityManagerFactory hibernateEntityManagerFactory)
	{
		return hibernateEntityManagerFactory.getSessionFactory();
	}
	

}
