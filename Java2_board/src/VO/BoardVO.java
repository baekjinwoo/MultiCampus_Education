package VO;

public class BoardVO {
	private int num;
	private String title;
	private String text;
	private String writer;
	private String pw;
	private int total;
	private String editime;
	
	public BoardVO(){
		
	}
	
	public BoardVO(int num, String title, String text, String writer, String pw, int total, String editime) {
		this.num = num;
		this.title = title;
		this.text = text;
		this.writer = writer;
		this.pw = pw;
		this.total = total;
		this.editime = editime;
	}

	public BoardVO(String title, String text, String writer, String pw) {
		super();
		this.title = title;
		this.text=text;
		this.writer = writer;
		this.pw=pw;
	}
		
		public BoardVO(int num, String title, String writer) {
		super();
		this.title = title;
		this.writer = writer;
		this.num=num;
	}
		
		
//	public BoardVO(int num, String title, String text, String writer,String editime,int password,int total) {
//			super();
//			this.num = num;
//			this.title = title;
//			this.text = text;
//			this.writer = writer;
//			this.pw = pw;
//			this.total = total;
//			this.editime=editime;
//		}
		
	

	public BoardVO(int num, String title, String text, String writer, String pw) {
		this.num=num;
		this.title=title;
		this.text=text;
		this.writer=writer;
		this.pw=pw;
		}

	@Override
	public String toString() {
		return num + " : " +  title + " : " +  writer; //text·Î »Ì±âx
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getEditime() {
		return editime;
	}

	public void setEditime(String editime) {
		this.editime = editime;
	}
}
