package job;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Spider  implements Runnable{
     private String url;
     private List<Job> jobs;
     
	public Spider(String url, List<Job> jobs) {
		super();
		this.url = url;
		this.jobs = jobs;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
     
	public Spider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Elements elems = doc.select(".right-side .position_list");
		
		for(Element e:elems){
			String jobTitile = e.select(".position_name a[title]").text();
			String jobSaray = e.select(".salary").text();
			String jobDemand = e.select(".position_require li").next().text();
			String commpanyName = e.select(".enterprise_name").text();
			String commpanyDesc = e.select(".position_welfire").text();
			String pos_count = e.select(".pos_count").text();
			
			Job job = new Job();
			job.setJobTitle(jobTitile);
			job.setJobSaray(jobSaray);
			job.setJobDemand(jobDemand);
			job.setCommpanyName(commpanyName);
			job.setPos_count(pos_count);
			if(commpanyDesc.equals("")) {
				
				job.setCommpanyDesc("нч");
			} else {
				job.setCommpanyDesc(commpanyDesc);	
			}
			jobs.add(job);
			System.out.println(job);
		}

		
	}
     
     
}
