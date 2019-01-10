package vo;

public class BoardVO {
	private String title;
	private String contents;
	private String writer;
	private String password;
	private int page;
	private String keyWord;
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
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public BoardVO() {
		super();
	}
	public BoardVO(String title, String contents, String writer, String password) {
		super();
		this.title = title;
		this.contents = contents;
		this.writer = writer;
		this.password = password;
	}
	

}
