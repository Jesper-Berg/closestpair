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
		if(points.size() == 2){										//Basfall, om det endast finns ett par s� �r det n�rmsta paret
			return new PointPair(points.get(0), points.get(1));
		}
		Line line = new Line(points);
		PointPair left = closestPair(line.getLeft());
		PointPair right = closestPair(line.getRight());
		PointPair min = (left.distance() < right.distance()) ? left : right;	//Tar det n�rmsta paret fr�n h�ger eller v�nster sida
		double minDist = min.distance();										//Avst�ndet mellan n�rmsta paret
		ArrayList<Point> nearby = line.FindAndSortNearby(min.distance());
		for(int i = 0; i < nearby.size() - 1; i++){									//Kollar p� punkterna n�ra linjen
			for(int j = 1; j < 12; j++){
				if(i + j < nearby.size()){
					Point fst = nearby.get(i);
					Point snd = nearby.get(i + j);
					if(fst.getDistance(snd) < minDist){							//Byter ut min om tv� punkter n�ra linjen �r n�rmre
						min = new PointPair(fst, snd);
						minDist = min.distance();
					}
				}
			}
		}
		return min;
	}
}
