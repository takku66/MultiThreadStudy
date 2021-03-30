package MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.オークション;

import java.time.LocalDateTime;

import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.ユーザー;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.入札.入札履歴;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.入札.入札記録;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.商品.オークション商品;

/**
 * オークションを表現するクラス
 * 本インスタンス生成時には、落札額を指定する
 * オークション状態の初期設定値は、[未開催]
 *
 */
public class オークション {
	private オークションID id;
	private オークション商品 商品;
	private ユーザー 出品者;
	private 入札履歴 入札履歴;
	private int 落札額;
	private int 状態;

	private オークション(Builder builder) {
		this.id = builder.id;
		this.商品 = builder.商品;
		this.出品者 = builder.出品者;
		this.落札額 = builder.落札額;
		this.状態 = オークション状態.未開催.コード();
	}

	public static class Builder {
		private オークションID id;
		private オークション商品 商品;
		private ユーザー 出品者;
		private int 落札額;

		/** ビルダー */
		public Builder オークションID() {
			this.id = new オークションID();
			return this;
		}

		public Builder  商品(オークション商品 オークション商品) {
			this.商品 = オークション商品;
			return this;
		}

		public Builder 出品者(ユーザー 出品者) {
			if(出品者 == null) {
				throw new IllegalArgumentException("出品者が不明です。");
			}
			this.出品者 = 出品者;
			return this;
		}

		public Builder 上限入札額(int 落札額) {
			this.落札額 = 落札額;
			return this;
		}

		public オークション 開設() {
			return new オークション(this);
		}
	}


	// ------------------------- プロパティ取得メソッド
	public オークションID getId() {
		return this.id;
	}
	public String toString() {
		return new StringBuffer().append(this.id.value())
											.append(",").append(this.状態)
											.append(",").append(this.商品.toString())
											.append(",").append(this.出品者.toString())
											.append(",").append(this.落札額)
											.append(",").append(this.入札履歴.累積額())
											.toString();
	}

	// ------------------------- 各状態判定メソッド
	public boolean 未開催かどうか() {
		return this.状態 == オークション状態.未開催.コード();
	}
	public boolean 即決金額かどうか(int 入札金額) {
		if(this.落札額 > this.入札履歴.最新の入札記録().入札金額() + 入札金額) {
			return true;
		}
		return false;
	}
	 public boolean 既に落札されてるか() {
		return this.状態 == オークション状態.落札済み.コード();
	}
	public boolean 入札金額が累積額に満たないか(int 入札金額) {
		return this.入札履歴.累積額() >= 入札金額;
	}

	// ------------------------- オークションオブジェクトの各操作
	/**
	 * 入札を開始する
	 * 状態が開催中へと変更される
	 */
	public void 入札開始() {
		this.入札履歴 = new 入札履歴();
		this.状態 = オークション状態.開催中.コード();
	}

	/**
	 * 入札処理を表現する
	 * 入札によって落札額を超えた場合は、状態を落札済みへと変更する
	 * @param 入札者
	 * @param 金額
	 */
	synchronized public void 入札(ユーザー 入札者, int 金額) {
		入札記録 記録 = 入札記録.記録(this, 入札者, 金額, LocalDateTime.now());
		this.入札履歴.入札(記録);
		if(this.入札履歴.累積額() >= this.落札額) {
			this.状態 = オークション状態.落札済み.コード();
			System.out.println(入札者.getName() + "が" + 金額 + "で落札しました。");
		}
	}



}

enum オークション状態{
	未開催(1),
	開催中(2),
	落札済み(3);

	private int コード;

	private オークション状態(int コード) {
		this.コード = コード;
	}

	public int コード() {
		return this.コード;
	}
}
