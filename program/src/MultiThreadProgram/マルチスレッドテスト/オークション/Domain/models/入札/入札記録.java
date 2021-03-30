package MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.入札;

import java.time.LocalDateTime;

import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.オークション.オークション;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.オークション.オークションID;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.ユーザー;

public class 入札記録 {
	private オークションID  id;
	private ユーザー  入札者;
	private int 入札金額;
	private LocalDateTime 入札時刻;

	private 入札記録() {
	}

	static public 入札記録 記録(オークション オークション, ユーザー 入札者, int 入札金額, LocalDateTime 入札時刻) {
		入札記録 入札記録 = new 入札記録();
		入札記録.id = オークション.getId();
		入札記録.入札者 = 入札者;
		入札記録.入札金額 = 入札金額;
		入札記録.入札時刻 = 入札時刻;
		return 入札記録;
	}
	public int 入札金額() {
		return this.入札金額;
	}
	public LocalDateTime 入札時刻() {
		return this.入札時刻;
	}
	/**
	 * <p>引数の時刻と記録上の時刻を比較する</p>
	 * <p>(1)入札時刻==比較時刻</br>
	 * => 0</p>
	 * <p>(2)入札時刻>比較時刻</br>
	 * => 1</p>
	 * <p>(3)入札時刻<比較時刻</br>
	 * => -1</p>
	 * @param 比較時刻
	 * @return
	 */
	public int 入札時刻を比較する(LocalDateTime 比較時刻) {
		if(比較時刻 == null) {
			return 1;
		}
		return this.入札時刻.compareTo(比較時刻);
	}
}
