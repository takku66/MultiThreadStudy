package MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.商品;

import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.ユーザー;

public class オークション商品 extends 商品 {
	String ユーザーID;
	public オークション商品(ユーザー user, String 商品名) {
		super(商品名);
		this.ユーザーID = user.getId();
	}
	public String getユーザーID() {
		return this.ユーザーID;
	}
	public String toString() {
		return new StringBuffer().append(super.toString())
											.append(",").append(this.ユーザーID)
											.toString();
	}
}
