package cart;

public class CartVO {

	private int code; //품번
	private int buyamount; //구매할 수량
	
	public CartVO(int code, int buyamount) {
		this.code = code;
		this.buyamount = buyamount;
	}
	public CartVO() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getBuyamount() {
		return buyamount;
	}
	public void setBuyamount(int buyamount) {
		this.buyamount = buyamount;
	}
	
}
