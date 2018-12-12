package job;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;






public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String url = "http://job.csdn.net/Search/index";
        
        List<Job> jobs =Collections.synchronizedList(new LinkedList<>());
        ExecutorService pool = Executors.newFixedThreadPool(9);
        
        for(int i = 1; i <= 30; i++ ) {
        	url = String.format("http://job.csdn.net/Search/index" + "?k=&t=1&f=%d", i);
        	pool.execute(new Spider(url,jobs));
        }
        pool.shutdown();
        while(true) {
        	if(pool.isTerminated()) {
        		new writeData(jobs);
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
