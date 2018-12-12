package book;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class app {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://book.douban.com/top250?start=0";
		List<Book> books = Collections.synchronizedList(new LinkedList<>());
		
		ExecutorService pools = Executors.newFixedThreadPool(5);
		for(int i = 0; i < 10; i++) {
			url = String.format("https://book.douban.com/top250?start=%d", i * 25);
			pools.execute(new BookPools(url,books));
			
			
		}
		pools.shutdown();
		while(true) {
			if(pools.isTerminated()) {
				 new writeData(books);
				break;
			} else {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
