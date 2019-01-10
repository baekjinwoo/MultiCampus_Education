package vo;

public class BoardVO {
	// MEMBER ���̺�
	private int num;// ��ȣ
	private String title;// ����
	private String main;// ����
	private String writer;// �ۼ���
	private String w_time;// �ð�
	private String pw; // ��ȣ
	private int n_view; // ��ȸ��
	
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
		System.out.println("��ȣ : " +  num + "\n���� : " + title + "\n���� : " + main + "\n�ۼ��� : " +  writer + "\n�ۼ� �ð� : " +  w_time + "\n��ȸ�� : " + n_view);
	}
	
}