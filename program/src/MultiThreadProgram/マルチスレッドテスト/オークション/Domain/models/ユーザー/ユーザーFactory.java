package MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー;

import java.util.UUID;

public class ユーザーFactory {
	static public ユーザー 新規ユーザー生成(String 名前) {
		String id = UUID.randomUUID().toString();
		ユーザー user = ユーザー.構築(id, 名前);
		return user;
	}
}
