 package book;

public class Book {
	private String Title;//书名
	private String Info;//作者和书价
	private String Tating;//评分
	private String EvaluationNumber;//评价人数
	private String Introduce;//书籍介绍
	private String Path;//書籍圖片
	
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getInfo() {
		return Info;
	}
	public void setInfo(String info) {
		Info = info;
	}
	public String getTating() {
		return Tating;
	}
	public void setTating(String tating) {
		Tating = tating;
	}
	public String getEvaluationNumber() {
		return EvaluationNumber;
	}
	public void setEvaluationNumber(String evaluationNumber) {
		EvaluationNumber = evaluationNumber;
	}
	public String getIntroduce() {
		return Introduce;
	}
	public void setIntroduce(String introduce) {
		Introduce = introduce;
	}
	
	public Book(String title, String info, String tating, String evaluationNumber, String introduce, String path) {
		super();
		Title = title;
		Info = info;
		Tating = tating;
		EvaluationNumber = evaluationNumber;
		Introduce = introduce;
		Path = path;
	}
	public Book() {

	}
	@Override
	public String toString() {
		return "Book [Title=" + Title + ", Info=" + Info + ", Tating=" + Tating + ", EvaluationNumber="
				+ EvaluationNumber + ", Introduce=" + Introduce + ", Path=" + Path + "]";
	}
	
	
	
	
}
