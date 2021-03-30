package MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.オークション;

import java.util.UUID;

public class オークションID {
	private String id;
	public オークションID() {
		this.id = UUID.randomUUID().toString();
	}
	public String value() {
		return this.id;
	}
}
