package MultiThreadProgram.マルチスレッドテスト.オークション.Infrastructures.InMemory.ユーザー;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.IユーザーRepository;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.ユーザー;

public class ユーザーRepository implements IユーザーRepository {
	static  final Map<String, ユーザー> ユーザーマップ = new HashMap<String, ユーザー>();

	@Override
	public ユーザー idで探索(String id) {
		return ユーザーマップ.get(id);
	}

	@Override
	public List<ユーザー> 探索(ユーザー user) {
		return new ArrayList<ユーザー>();
	}

	@Override
	public boolean store(ユーザー user) {
		ユーザーマップ.put(user.getId(), user);
		return true;
	}

}
