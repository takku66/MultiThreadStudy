package MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.商品;

public class 商品 {
	String 商品名;
	@SuppressWarnings("unused")
	private 商品() {}
	public 商品(String 商品名) {
		this.商品名 = 商品名;
	}
	public String toString() {
		return new StringBuffer().append(this.商品名)
											.toString();
	}
}
