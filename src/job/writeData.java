package job;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;

public class writeData {
	private List<Job> jobs;

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public writeData() {
		// TODO Auto-generated constructor stub
	}

	public writeData(List<Job> job) {
		this.jobs = job;
		Element root = new Element("jobs");
		Document doc = new Document(root);
		for(Job j:jobs){
			Element e = new Element("Job");
			e.addContent(new Element("jobTitle").setText(j.getJobTitle()));
			e.addContent(new Element("jobSaray").setText(j.getJobSaray()));
			e.addContent(new Element("jobDemand").setText(j.getJobDemand()));
			e.addContent(new Element("commpanyName").setText(j.getCommpanyName()));
			e.addContent(new Element("commpanyDesc").setText(j.getCommpanyDesc()));
			e.addContent(new Element("posCount").setText(j.getPos_count()));
			root.addContent(e);
		}
		XMLOutputter out = new XMLOutputter();	
		try {
			out.output(doc, new FileOutputStream("Jobs.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
