
public class Stopwatch {
	public double startTime;
	public double stopTime;
	
	public Stopwatch() {
		
	}
	
	public void start() {
		startTime = System.currentTimeMillis();
	}
	
	public void stop() {
		stopTime = System.currentTimeMillis();
	}
	
	public double getTime() {
		return stopTime-startTime;
	}
}
