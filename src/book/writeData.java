
package book;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

import job.Job;

public class writeData {
	private List<Book> books;

	public List<Book> getJobs() {
		return books;
	}

	public void setJobs(List<Book> books) {
		this.books = books;
	}

	public writeData(List<Book> books) {
		Element root = new Element("Books");
		Document doc = new Document(root);
		for(Book book : books) {
			Element e = new Element("book");
			e.addContent(new Element("title").setText(book.getTitle()));
			e.addContent(new Element("info").setText(book.getInfo()));
			e.addContent(new Element("Tating").setText(book.getTating()));
			e.addContent(new Element("evaluationNumber").setText(book.getEvaluationNumber()));
			e.addContent(new Element("introduce").setText(book.getIntroduce()));
			e.addContent(new Element("path").setText(book.getPath()));
			root.addContent(e);
		}
		XMLOutputter out = new XMLOutputter();	
		try {
			out.output(doc, new FileOutputStream("Books.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ExecutorService pools = Executors.newFixedThreadPool(8);
		for(Book book : books) {
			pools.execute(new ImgLoader(book));
		}
		pools.shutdown();
	}
	public writeData() {
		
	}
}
