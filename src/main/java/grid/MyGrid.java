package grid;

import java.util.Random;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

public class MyGrid {

	static Random rng; 	
	INDArray state;
	
	public MyGrid() {
		
		float[] flat = new float[64];
		int[] shape = {4,4,4};	
		INDArray state = Nd4j.create(flat,shape,'c');
		
		
	}
	
	
	static class Position {
		
		float x,y;
		
		public Position(float _x, float _y) {
			this.x = _x; this.y = _y;
		}
		
		public Position() {
			this.x = 0f; this.y = 0f;
		}
		
		public static Position randomPosition() {			
			Position myPos = new Position((float)rng.nextInt(4), (float)rng.nextInt(4));	
		    return myPos; 
		}
	}
	
	
}
