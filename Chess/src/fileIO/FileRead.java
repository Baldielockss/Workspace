package fileIO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileRead {

	public static void main(String[] args) {
		String fileName = args[0];
		readFile(fileName);
	}

	public static void readFile(String fileName){

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fileReader);
			while(reader.ready()){
				String s = reader.readLine();
				placePiece(s);
				moveSinglePiece(s);
				moveTwoPieces(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void moveTwoPieces(String s) {
		String pattern = "([a-h][1-8])\\s([a-h][1-8])\\s([a-h][1-8])\\s([a-h][1-8])";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);
		
		if(m.matches()){
			System.out.println(String.format("Move the king from %s to %s and move the rook from %s to %s",
					m.group(1).toUpperCase(), m.group(2).toUpperCase(), m.group(3).toUpperCase(), m.group(4).toUpperCase()));
		}
	}

	public static void moveSinglePiece(String s) {
		String pattern = "([a-h][1-8])\\s([a-h][1-8])\\**";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);

		if(m.matches()){
			String statement;
			if(s.endsWith("*")){
				statement = String.format("Move the piece at %s to %s and capture piece at %s",
						m.group(1).toUpperCase(), m.group(2).toUpperCase(), m.group(2).toUpperCase());
			}else{
				statement = String.format("Move the piece at %s to %s",
						m.group(1).toUpperCase(), m.group(2).toUpperCase());
			}
			System.out.println(statement);
		}
	}

	public static void placePiece(String s) {
		String pattern = "([KQBNRP])([ld])([a-h][1-8])";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(s);

		if(m.matches()){
			String piece = m.group(1);
			String color = m.group(2);
			switch(piece){
			case "K":
				piece = "king";
				break;
			case "Q":
				piece = "queen";
				break;
			case "B":
				piece = "bishop";
				break;
			case "N":
				piece = "knight";
				break;
			case "R":
				piece = "rook";
				break;
			case "P":
				piece = "pawn";
				break;
			}
			if(color.equals("l")){
				color = "white";
			}else if(color.equals("d")){
				color = "black";
			}
			String statement = String.format("Place the %s %s on %s" , color, piece, m.group(3));
			System.out.println(statement);
		}
	}
}
