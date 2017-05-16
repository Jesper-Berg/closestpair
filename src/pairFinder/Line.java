package pairFinder;

import java.util.ArrayList;
import java.util.Comparator;

public class Line {
	private ArrayList<Point> leftHalf = new ArrayList<Point>();
	private ArrayList<Point> rightHalf = new ArrayList<Point>();
	private double x;
	
	public Line(ArrayList<Point> all){
		int half = all.size() / 2;
		all.sort(new XComp()); 				//Sorterar efter X-koordinaten
		for(int i = 0; i < half; i++){
			leftHalf.add(all.get(i));
			rightHalf.add(all.get(half + i));
		}
		x = (leftHalf.get(leftHalf.size() - 1).getX() + rightHalf.get(0).getX()) / 2;//Sätter linjen mellan de två närmsta punkterna
	}
	
	public ArrayList<Point> getLeft(){
		return leftHalf;
	}
	
	public ArrayList<Point> getRight(){
		return rightHalf;
	}
	
	public ArrayList<Point> FindAndSortNearby(double length){
		ArrayList<Point> all = leftHalf;
		all.addAll(rightHalf);
		ArrayList<Point> closeBy = new ArrayList<Point>();	
		for(Point p : all){								//Hittar alla punkter length ifrån linjen
			if(Math.abs(p.getX() - x) <= length ){
				closeBy.add(p);
			}
		}
		closeBy.sort(null);				//Sorterar efter y-koordinaten
		return closeBy;
	}
	
	private class XComp implements Comparator<Point> {

		@Override
		public int compare(Point arg0, Point arg1) {
			if(arg0.getX() > arg1.getX()){
				return 1;
			} else if (arg0.getX() < arg1.getX()){
				return -1;
			}
			return 0;
		}

	}

}
