package sqlday7.jdcb.program;

public class BoardVO {
	private int seq;
	private String title;
	private String contents;
	private String time;
	private String writer;
	private String pw;
	private int viewcount;
	
	public BoardVO(int seq, String title, String contents, String time, String writer, String pw, int viewcount) {
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		this.time = time;
		this.writer = writer;
		this.pw = pw;
		this.viewcount = viewcount;
	}
	

	public BoardVO(String title, String contents, String writer, String pw) {
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.pw = pw;
	}
	
	@Override
	public String toString(){
		return seq + " : " + title + " : " + contents;
		//return "["+id + "번 게시물]" + "\n+ 제목 : " + title + "\n+ 내용 : " + contents + "\n+ 작성자 : " + writer + "\n+ 작성일 : " + time + "\n+ 조회수 : " + viewcount;
	}
	
	public String toStringDetail(){
		return "번호 : " + seq + "\n제목 : " + title + "\n내용 : " + contents + "\n작성자 : " + writer + "\n시간 : " + time + "\n조회수 : " + viewcount; 
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public int getViewcount() {
		return viewcount;
	}


	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	
	
}
