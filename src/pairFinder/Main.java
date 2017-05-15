package pairFinder;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Point> points = new ArrayList<Point>();
		points.add(new Point(1, 1, 1));
		for(int i = 2; i < 16; i++){
			points.add(new Point(i, i*3.46, i*4.67));
		}
		points.add(new Point(16, 1.2, 1.2));
		System.out.println(closestPair(points));
	}
	
	public static PointPair closestPair(ArrayList<Point> points){
		if(points.size() == 2){
			return new PointPair(points.get(0), points.get(1));
		}
		Line line = new Line(points);
		PointPair left = closestPair(line.getLeft());
		PointPair right = closestPair(line.getRight());
		PointPair min = (left.distance() < right.distance()) ? left : right;
		double minDist = min.distance();
		ArrayList<Point> nearby = line.FindAndSortNearby(min.distance());
		for(int i = 0; i < nearby.size() - 1; i++){
			for(int j = 1; j < 12; j++){
				if(i + j < nearby.size() - 1){
					Point fst = nearby.get(i);
					Point snd = nearby.get(i + j);
					if(fst.getDistance(snd) < minDist){
						min = new PointPair(fst, snd);
						minDist = min.distance();
					}
				}
			}
		}
		return min;
	}
}
