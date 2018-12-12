package job;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "http://job.csdn.net/Search/index";
		try {
			
			Document doc = Jsoup.connect(url).get();
			System.out.println(doc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
