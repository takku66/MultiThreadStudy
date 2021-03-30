package MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー;

import java.util.List;

public interface IユーザーRepository {
	public boolean store(ユーザー user);
	public ユーザー idで探索(String id);
	public List<ユーザー> 探索(ユーザー user);
}
