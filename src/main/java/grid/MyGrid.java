package grid;

import java.util.Random;

import org.nd4j.linalg.api.buffer.DataBuffer;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class MyGrid {

	static Random rng = new Random(); 	
	
	int[] w_loc,a_loc,p_loc,g_loc;
	
	INDArray state;
	INDArray player;
	INDArray wall;
	INDArray pit;
	INDArray goal;
	
	public MyGrid() {
		
		state = Nd4j.zeros(new int[]{4,4,4}, DataBuffer.Type.FLOAT);
		
		//---- Encode the pieces ----
		player = Nd4j.zeros(4).putScalar(3, 1f); 
		wall = Nd4j.zeros(4).putScalar(2, 1f);
		pit = Nd4j.zeros(4).putScalar(1, 1f);
		goal = Nd4j.zeros(4).putScalar(0, 1f);
		
		a_loc = new int[]{0,1};
		w_loc = new int[]{2,2};
		p_loc = new int[]{1,1};
		g_loc = new int[]{3,3};
		
		state.put(a_loc, player);
		state.put(w_loc, wall);
		state.put(p_loc, pit);
		state.put(g_loc, goal);
		
	}
	
	
	
	/*
       Initializes the playing grid in a deterministic way
	*/	
	public void initializeGrid() {
				
		state = Nd4j.zeros(new int[]{4,4,4}, DataBuffer.Type.FLOAT);
		
		a_loc = new int[]{0,1};
		w_loc = new int[]{2,2};
		p_loc = new int[]{1,1};
		g_loc = new int[]{3,3};
		
		state.put(a_loc, player);
		state.put(w_loc, wall);
		state.put(p_loc, pit);
		state.put(g_loc, goal);
	}

	/*
    Initializes the playing grid in with random player start
	*/	
	public void initializeGridRandomPlayer() {
				
		state = Nd4j.zeros(new int[]{4,4,4}, DataBuffer.Type.FLOAT);
		
		boolean playerPlace = false;
		int[] randomPos = getRandomPosition();
		
		w_loc = new int[]{2,2};
		p_loc = new int[]{1,1};
		g_loc = new int[]{3,3};		
		state.put(w_loc, wall);
		state.put(p_loc, pit);
		state.put(g_loc, goal);
		
		while(playerPlace) {
			
			if((!randomPos.equals(w_loc) && !randomPos.equals(p_loc)) && !randomPos.equals(g_loc)) {
				state.put(randomPos, player);
				playerPlace = true;
			}
			else {
				randomPos = getRandomPosition();
			}	
		}
	}	
	
	public void printGrid() {
		
	}
	
	
	public static int[] getRandomPosition() {
		
		int[] posit = new int[2];
		posit[0] = rng.nextInt(4);
		posit[1] = rng.nextInt(4);
		return posit;
	}
	
	
	
	
	static class Position {
		
		float x,y;
		
		public Position(float _x, float _y) {
			this.x = _x; this.y = _y;
		}
		
		public Position() {
			this.x = 0f; this.y = 0f;
		}
		
		int[] getRandomPosition() {
			
			int[] posit = new int[2];
			posit[0] = rng.nextInt(4);
			posit[1] = rng.nextInt(4);
			return posit;
		}
		
		public static Position randomPosition() {			
			Position myPos = new Position((float)rng.nextInt(4), (float)rng.nextInt(4));	
		    return myPos; 
		}
	}
	
	
}
