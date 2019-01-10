package vo;

public class BoardVO {
	private int num;
	private String title;
	private String text;
	private String wmember;
	private String wtime;
	private String pwd;
	private int cnt;
	
	public BoardVO() {
		super();
	}
	
	public BoardVO(String title, String text, String wmember, String pwd) {
		super();
		this.title = title;
		this.text = text;
		this.wmember = wmember;
		this.pwd = pwd;
	}

	public BoardVO(int num, String title, String text, String wmember, String wtime, String pwd, int cnt) {
		super();
		this.num = num;
		this.title = title;
		this.text = text;
		this.wmember = wmember;
		this.wtime = wtime;
		this.pwd = pwd;
		this.cnt = cnt;
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

	public String getWmember() {
		return wmember;
	}

	public void setWmember(String wmember) {
		this.wmember = wmember;
	}

	public String getWtime() {
		return wtime;
	}

	public void setWtime(String wtime) {
		this.wtime = wtime;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String toString() {
		return num + " : " + title + " : " + wmember;
	}
	
	
	
}
