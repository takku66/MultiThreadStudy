package MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー;

public class ユーザー {

	String ユーザーID;
	String ユーザー名;
	int 持ち金;
	private ユーザー() {
	}
	static ユーザー 構築(String id, String 名前) {
		ユーザー ユーザー = new ユーザー();
		ユーザー.ユーザーID = id;
		ユーザー.ユーザー名 = 名前;
		return ユーザー;
	}
	public int 持ち金を加える(int 金額) {
		this.持ち金 += 金額;
		if(持ち金 < 0) {
			throw new IllegalArgumentException("持ち金がマイナスとなる金額が指定されています。");
		}
		return 持ち金;
	}
	synchronized public int 持ち金から払う(int 金額) {
		this.持ち金 -= 金額;
		if(持ち金 < 0) {
			throw new IllegalArgumentException("持ち金以上の支払いをしようとしています。");
		}
		return 持ち金;
	}
	public boolean 持ち金で足りるか判定(int 金額) {
		if(持ち金 < 金額) {
			return false;
		}
		return true;
	}
	public String getId() {
		return this.ユーザーID;
	}
	public String getName() {
		return this.ユーザー名;
	}
	public String toString() {
		return new StringBuffer().append(this.ユーザーID)
											.append(",").append(this.ユーザー名)
											.append(",").append(this.持ち金)
											.toString();
	}
}
