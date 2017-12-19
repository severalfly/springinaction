package com.leon.spittr.data;

import java.util.List;

import org.springframework.context.annotation.Bean;

import com.leon.spittr.Spittle;

public interface SpittleRepository
{
	@Bean
	List<Spittle> findSpittles(long max, int count);
}
