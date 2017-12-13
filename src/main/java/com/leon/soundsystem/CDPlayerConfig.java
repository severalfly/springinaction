package com.leon.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class CDPlayerConfig
{

	@Bean
	public CompactDisc compactDisc()
	{
		return new SgtPeppers();
	}

	@Bean
	public CDPlayer cdPlayer(CompactDisc compactDisc)
	{
		return new CDPlayer(compactDisc);
	}

}
