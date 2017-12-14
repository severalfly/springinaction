package com.leon.spittr.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

import com.leon.spittr.Spittle;
import com.leon.spittr.data.SpittleRepository;

public class HomeControllerTest
{
	//	@Test
	//	public void testHomePage()
	//	{
	//		HomeController controller = new HomeController();
	//		Assert.assertEquals("home", controller.home());
	//	}
	@Test
	public void testHomePage() throws Exception
	{
		HomeController controller = new HomeController();
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/homepage")).andExpect(MockMvcResultMatchers.view().name("home"));
	}

	@Test
	public void shouldShowRecentSpittles() throws Exception
	{
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		mockMvc.perform(get("/spittles")).andExpect(MockMvcResultMatchers.view().name("spittles")).andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"));

	}

	private List<Spittle> createSpittleList(int count)
	{
		List<Spittle> spittles = new ArrayList<>();
		for (int i = 0; i < count; i++)
		{
			spittles.add(new Spittle("Spittle " + i, new Date()));
		}
		return spittles;
	}

}
