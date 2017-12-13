package com.leon.soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest
{
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();

	@Autowired
	private CompactDisc cd;
	@Autowired
	private TrackCounter counter;

	@Test
	public void testTrackCounter()
	{
		this.cd.playTrack(1);
		this.cd.playTrack(2);
		this.cd.playTrack(3);
		this.cd.playTrack(3);
		this.cd.playTrack(3);
		this.cd.playTrack(3);
		this.cd.playTrack(7);
		this.cd.playTrack(7);
		System.out.println("1");
		System.out.println(JSONObject.toJSONString(this.counter.getPlayCount(1)));
		//		Assert.assertEquals(2, this.counter.getPlayCount(1));
		//		Assert.assertEquals(1, this.counter.getPlayCount(2));
		//		Assert.assertEquals(4, this.counter.getPlayCount(3));
		//		Assert.assertEquals(0, this.counter.getPlayCount(4));
		//		System.out.println("--------");
		//		Assert.assertEquals(0, this.counter.getPlayCount(5));
		//		Assert.assertEquals(0, this.counter.getPlayCount(6));
		//		Assert.assertEquals(2, this.counter.getPlayCount(7));
	}
}
