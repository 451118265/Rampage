package job;

public class Job {
	private String jobTitle; //��������
	private String jobSaray;//н��
	private String jobDemand;//�����غ����蹤�������ѧ������
	private String commpanyName;//��˾����
	private String commpanyDesc;//��˾����
	private String pos_count;//��˾����
	
	
	
	
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobSaray() {
		return jobSaray;
	}
	public void setJobSaray(String jobSaray) {
		this.jobSaray = jobSaray;
	}
	public String getJobDemand() {
		return jobDemand;
	}
	public void setJobDemand(String jobDemand) {
		this.jobDemand = jobDemand;
	}
	public String getCommpanyName() {
		return commpanyName;
	}
	public void setCommpanyName(String commpanyName) {
		this.commpanyName = commpanyName;
	}
	public String getCommpanyDesc() {
		return commpanyDesc;
	}
	public void setCommpanyDesc(String commpanyDesc) {
		this.commpanyDesc = commpanyDesc;
	}
	public Job(String jobTitle, String jobSaray, String jobDemand, String commpanyName, String commpanyDesc,
			String pos_count) {
		this.jobTitle = jobTitle;
		this.jobSaray = jobSaray;
		this.jobDemand = jobDemand;
		this.commpanyName = commpanyName;
		this.commpanyDesc = commpanyDesc;
		this.pos_count = pos_count;
	}
	public Job() {
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Job [jobTitle=" + jobTitle + ", jobSaray=" + jobSaray + ", jobDemand=" + jobDemand + ", commpanyName="
				+ commpanyName + ", commpanyDesc=" + commpanyDesc + ", pos_count=" + pos_count + "]";
	}
	public String getPos_count() {
		return pos_count;
	}
	public void setPos_count(String pos_count) {
		this.pos_count = pos_count;
	}

	
	
}
