package book;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class BookPools implements Runnable{
	private String url;
	private List<Book> books;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	

	public BookPools(String url, List<Book> books) {
		
		this.url = url;
		this.books = books;
	}

	public BookPools() {

	}
	public BookPools(String url) {
		this.url = url;
		
	}
	@Override
	public void run() {
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements links = doc.select(".article .item");
		for(Element e : links) {
			String title  = e.select(".pl2").text();
			String info = e.select(".pl").first().text();
			String tating  = e.select(".rating_nums").text();
			String evaluationNumber = e.select(".star .pl").text();
			String introduce = e.select(".quote").text();
			String path = e.select(".nbg img").attr("src");
			Book book = new Book();
			book.setTitle(title);
			book.setInfo(info);
			book.setEvaluationNumber(evaluationNumber);
			book.setTating(tating);
			book.setIntroduce(introduce);
			book.setPath(path);
			books.add(book);
			System.out.println(book);
		}
		
	}

}
