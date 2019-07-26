package model;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertTrue;
import com.game.model.Machine;

@RunWith(SpringJUnit4ClassRunner.class)
public class MachineTest {
	
	String[] movimientos = {"R", "P", "S"};
	
	@Test
	public void testMoveMachine() {
		
		Machine machine = new Machine();
		String m = machine.getMachineMove();
		
		assertTrue(Arrays.asList(movimientos).contains(m));
	}
	
}
