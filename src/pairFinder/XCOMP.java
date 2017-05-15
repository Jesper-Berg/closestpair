package pairFinder;

import java.util.Comparator;

public class XCOMP implements Comparator<Point> {

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
