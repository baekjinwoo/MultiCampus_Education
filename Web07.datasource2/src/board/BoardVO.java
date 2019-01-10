package board;
//HTML-JSP입력 저장- db insert
//db select -저장 - 출력
public class BoardVO {
	int seq;
	String title;
	String contents;
	String Writer;
	String time;
	String pw;
	int view;
	
	public BoardVO(int seq, String title, String contents, String writer, String time, String pw, int view) {
		super();
		this.seq = seq;
		this.title = title;
		this.contents = contents;
		Writer = writer;
		this.time = time;
		this.pw = pw;
		this.view = view;
	}
	public BoardVO() {

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
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
}
