package com.leon.soundsystem;

public class SgtPeppers implements CompactDisc
{

	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";

	public void play()
	{
		System.out.println("Playing " + title + " by " + artist);
	}

	@Override
	public void playTrack(int trackNumber)
	{
		System.out.println("playtrack " + trackNumber);

	}

}
