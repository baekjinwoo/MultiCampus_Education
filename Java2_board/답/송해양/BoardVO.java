package vo;

public class BoardVO {
	// MEMBER 테이블
	private int num;// 번호
	private String title;// 제목
	private String main;// 본문
	private String writer;// 작성자
	private String w_time;// 시간
	private String pw; // 암호
	private int n_view; // 조회수
	
	public BoardVO() {
		super();
	}

	public BoardVO(String title, String main, String writer, String pw) {
		super();
		this.title = title;
		this.main = main;
		this.writer = writer;
		this.pw = pw;
	}

	public BoardVO(int num, String title, String main, String writer, String w_time, String pw, int n_view) {
		super();
		this.num = num;
		this.title = title;
		this.main = main;
		this.writer = writer;
		this.w_time = w_time;
		this.pw = pw;
		this.n_view = n_view;
	}
	
	public BoardVO(int num, String title, String main, String writer, String w_time, int n_view) {
		this.num = num;
		this.title = title;
		this.main = main;
		this.writer = writer;
		this.w_time = w_time;
		this.n_view = n_view;
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

	public String getMain() {
		return main;
	}

	public void setMain(String main) {
		this.main = main;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getW_time() {
		return w_time;
	}

	public void setW_time(String w_time) {
		this.w_time = w_time;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getN_view() {
		return n_view;
	}

	public void setN_view(int n_view) {
		this.n_view = n_view;
	}

	@Override
	public String toString() {
		return num + " : " + title + " : " + writer;
	}
	
	public void getBoard() {
		System.out.println("번호 : " +  num + "\n제목 : " + title + "\n본문 : " + main + "\n작성자 : " +  writer + "\n작성 시간 : " +  w_time + "\n조회수 : " + n_view);
	}
	
}