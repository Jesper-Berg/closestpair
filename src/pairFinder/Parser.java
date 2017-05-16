package pairFinder;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Parser {
	FileReader input;
	BufferedReader br;
	
	public Parser (String fileName) throws FileNotFoundException{
		input = new FileReader(fileName);
		br = new BufferedReader(input);
	}
	
	public ArrayList<Point> readFile() throws IOException {
		String number = "[-+]?\\d*\\.?\\d+(?:[eE][-+]?\\d+)?";
		String pattern = "(\\d+)\\s+(" + number + ")\\s+(" + number + ")";
		ArrayList<Point> points = new ArrayList<Point>();
		while(br.ready()){
			String s = br.readLine().trim();
			if (s.matches(pattern)){
				String[] subS = s.split("\\s+");
				int id = Integer.valueOf(subS[0]);
				double x = Double.valueOf(subS[1]);
				double y = Double.valueOf(subS[2]);
				points.add(new Point(id, x, y));
			}
			
		}
		return points;
	}
}
