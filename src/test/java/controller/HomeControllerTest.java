package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.game.Application;
import com.game.service.interfaces.GameService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class HomeControllerTest {
	
	
	
	@Autowired
	private WebApplicationContext context;
	
	@Mock
	private GameService gameService;
	
	private MockMvc mvc;
	
	
	@Before
	public void setup() {
		this.mvc = webAppContextSetup(context).build();
	}
	
	
	@Test
	public void testInit() throws Exception {		
		this.mvc.perform(post("/init").accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());
	}
	
	@Test
	public void testPlay() throws Exception {
		
		String json = String.format("{\"winPlayer1\":0,\"winPlayer2\":0,\"cont\":0,\"move1\":\"S\",\"move2\":\"R\",\"result\":\"Win Player2\"}");
		
		this.mvc.perform(post("/play").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(status().isOk())
	    .andReturn();
	
	}
	
	
	
	@Test
	public void testPlayNoGame() throws Exception {
		this.mvc.perform(post("/play")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
	}
	
	@Test
	public void testGetAllScore() throws Exception {
		this.mvc.perform(get("/score").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
