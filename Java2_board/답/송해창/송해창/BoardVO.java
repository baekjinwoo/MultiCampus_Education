package vo;

public class BoardVO {

	private int numberr;
	private String title;
	private String story;
	private String writer;
	private String timee;
	private String pass;
	private int vieww;
	
	public BoardVO() {
		super();
	}
	
	
	
	
	public BoardVO(int numberr, String title, String story, String writer, String pass) {
		super();
		this.numberr = numberr;
		this.title = title;
		this.story = story;
		this.writer = writer;
		this.pass = pass;
	}




	public BoardVO(int numberr, String title, String story, String writer, String timee, int vieww) {
		super();
		this.numberr = numberr;
		this.title = title;
		this.story = story;
		this.writer = writer;
		this.timee = timee;
		this.vieww = vieww;
	}


	public BoardVO(String title, String story, String writer, String pass) {
		super();
		this.title = title;
		this.story = story;
		this.writer = writer;
		this.pass = pass;
	}
	public BoardVO(int numberr, String title, String story, String writer, String timee, String pass, int vieww) {
		super();
		this.numberr = numberr;
		this.title = title;
		this.story = story;
		this.writer = writer;
		this.timee = timee;
		this.pass = pass;
		this.vieww = vieww;
	}
	public BoardVO(int numberr) {
		// TODO Auto-generated constructor stub
	}


	public int getNumberr() {
		return numberr;
	}
	public void setNumberr(int numberr) {
		this.numberr = numberr;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStory() {
		return story;
	}
	public void setStory(String story) {
		this.story = story;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTimee() {
		return timee;
	}
	public void setTimee(String timee) {
		this.timee = timee;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}	
	public int getVieww() {
		return vieww;
	}
	public void setVieww(int vieww) {
		this.vieww = vieww;
	}
	@Override
	public String toString() {
		return numberr + ":" + title + ":" + writer;
	}
	
	public void getBoard(){
		System.out.println("번호 : " +  numberr + ("\n") +  "제목 : " + title  + ("\n") + "내용 : " + story + ("\n") + "작가 : " + writer  + ("\n") + "시간 : " + timee  + ("\n") + "조회수 : " + vieww);
	}

	}
	
	
	

