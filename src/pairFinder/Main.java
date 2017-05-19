package pairFinder;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		try {
			String fileName = "src/pairFinder/pairs";
			Parser pars = new Parser(fileName);
			ArrayList<Point> points = pars.readFile();
			PointPair closest = closestPair(points);
			System.out.println(fileName + ": " + points.size() + " " + closest.distance());
			System.out.println(closest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static PointPair closestPair(ArrayList<Point> points){
		if(points.size() <= 3){										//Basfall, bruteforce om 3 eller mindre
			return brute(points);
		}
		Line line = new Line(points);
		PointPair left = closestPair(line.getLeft());
		PointPair right = closestPair(line.getRight());
		PointPair min = (left.distance() < right.distance()) ? left : right;	//Tar det närmsta paret från höger eller vänster sida
		double minDist = min.distance();										//Avståndet mellan närmsta paret
		ArrayList<Point> nearby = line.FindAndSortNearby(min.distance());
		for(int i = 0; i < nearby.size() - 1; i++){								//Kollar på punkterna nära linjen
			for(int j = 1; j < 16; j++){
				if(i + j < nearby.size()){
					PointPair maybe = new PointPair(nearby.get(i), nearby.get(i + j));
					if(maybe.distance() < minDist){								//Byter ut min om två punkter nära linjen är närmre
						min = maybe;
						minDist = min.distance();
					}
				}
			}
		}
		return min;
	}

	private static PointPair brute(ArrayList<Point> points) {
		double dist = Double.MAX_VALUE;
		PointPair close = null;
		for (int i = 0; i < points.size() - 1; i++){
			for (int j = i + 1; j < points.size(); j++){
				double newDist = points.get(i).getDistance(points.get(j));
				if (newDist < dist){
					dist = newDist;
					close = new PointPair(points.get(i), points.get(j));
				}
			}
		}
		return close;
	}
	
}
