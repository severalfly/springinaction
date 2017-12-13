package com.leon.soundsystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig
{
	@Bean
	public CompactDisc sgtPeppers()
	{
		BlankDisc cd = new BlankDisc();
		cd.setTitle("sgt. pepper's lonely hearts club band");
		cd.setArtist("The Beatles");
		List<String> tracks = new ArrayList<>();
		tracks.add("Sgt ");
		tracks.add("With ");
		tracks.add("Lucy ");
		tracks.add("Getting ");
		tracks.add("fixing ");
		cd.setTracks(tracks);
		return cd;
	}

	@Bean
	public TrackCounter trackCounter()
	{
		return new TrackCounter();
	}
}
