package MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.入札;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class 入札履歴 {

	private List<入札記録> 記録 = new ArrayList<入札記録>();
	private 入札記録 初回入札記録;
	private 入札記録 最新入札記録;
	private LocalDateTime 累積額更新日時;
	private int 累積額 = 0;
	public 入札履歴() {
	}

	public void 入札(入札記録 入札記録) {
		this.記録.add(入札記録);
		if(初回入札記録 == null) {
			this.初回入札記録 = 入札記録;
		}
		this.最新入札記録 = 入札記録;
	}

	public 入札記録 最新の入札記録() {
		return this.最新入札記録;
	}
	public 入札記録 初回の入札記録() {
		return this.初回入札記録;
	}
	public int 累積額() {
		if(最新入札記録 == null) {
			return 0;
		}
		if(累積額 == 0 || 最新入札記録.入札時刻を比較する(累積額更新日時) == 1) {
			this.累積額 = (int)記録.stream().mapToDouble(e -> e.入札金額()).sum();
			this.累積額更新日時 = 最新入札記録.入札時刻();
		}
		return this.累積額;
	}
}
