package com.leon.spittr.data;

import java.util.List;

import com.leon.spittr.Spittle;

public interface SpittleRepository
{
	List<Spittle> findSpittles(long max, int count);
}
