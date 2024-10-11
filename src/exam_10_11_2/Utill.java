package exam_10_11_2;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Utill {
	
	public static String getDate() {
		LocalDate now = LocalDate.now();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		return now.format(formatter);
	}
	
	
	
}
