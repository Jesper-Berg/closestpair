package pairFinder;

public class PointPair {
	private Point fst;
	private Point snd;
	
	public PointPair (Point a, Point b){
		fst = a;
		snd = b;
	}
	
	public double distance(){
		return fst.getDistance(snd);
	}
	
	public String toString(){
		return "(" + fst + "," + snd + ")";
	}
}
