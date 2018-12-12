package book;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.util.concurrent.TimeUnit;

import book.Book;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ImgLoader implements Runnable {

	private Book book;

	public ImgLoader(Book book) {
		this.book = book;
	}

	public ImgLoader() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + "œ¬‘ÿ ÈºÆÕº∆¨");
		File path = new File("bookPicture");

		if (!path.exists()) {
			path.mkdir();
		}
		System.out.println(book);
		String name = book.getTitle().split(" ")[0] + ".jpg";

		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(path, name)));
			byte[] data = new OkHttpClient.Builder().build().newCall(new Request.Builder().url(book.getPath()).build())
					.execute().body().bytes();
			out.write(data);
			out.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
