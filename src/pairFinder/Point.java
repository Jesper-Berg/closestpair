package pairFinder;

public class Point implements Comparable<Point>{
	private double x;
	private double y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getDistance(Point p){
		return Math.hypot(x - p.getX(), y - p.getY());
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}

	@Override
	public int compareTo(Point o) {
		if(y > o.getY()){
			return 1;
		} else if (y < o.getY()){
			return -1;
		}
		return 0;
	}
	
	

}
