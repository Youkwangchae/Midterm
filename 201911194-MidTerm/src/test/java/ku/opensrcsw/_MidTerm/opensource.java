package ku.opensrcsw._MidTerm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class opensource {

	public static void main(String[] args) throws ParseException, IOException {
		System.out.print("Enter the keyword you are looking for: ");
		Scanner scan = new Scanner(System.in);
		String text = scan.next();

		FileReader responseBody;
		try {
			responseBody = new FileReader(
					"C:\\자바학습\\201911194-MidTerm\\target\\classes\\ku\\opensrcsw\\_MidTerm\\midterm.json");
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(responseBody);
			JSONArray infoArray = (JSONArray) jsonObject.get("poem");

			for (int i = 0; i < infoArray.size(); i++) {

				JSONObject itemObject = (JSONObject) infoArray.get(i);
				String a = (String) itemObject.get("item");
				if (a.contains(text)) {
					System.out.print("item " + i + ":");
					System.out.println(a);
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("해당 파일이 존재하지 않습니다.");
			e.printStackTrace();
		}

	}
}