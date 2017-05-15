package pairFinder;

public class Point implements Comparable<Point>{
	private double x;
	private double y;
	private int id;
	
	public Point(int id, double x, double y){
		this.id = id;
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
	//Jämför efter y-koordinaten
	public int compareTo(Point o) {
		if(y > o.getY()){
			return 1;
		} else if (y < o.getY()){
			return -1;
		}
		return 0;
	}
	
	public String toString(){
		return "" + id;
	}
	
	

}
