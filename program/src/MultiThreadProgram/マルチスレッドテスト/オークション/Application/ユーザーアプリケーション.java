package MultiThreadProgram.マルチスレッドテスト.オークション.Application;

import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.IユーザーRepository;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.ユーザー;
import MultiThreadProgram.マルチスレッドテスト.オークション.Infrastructures.InMemory.ユーザー.ユーザーRepository;

public class ユーザーアプリケーション {
	// HACK: 本来はDIコンテナで管理するもの
	IユーザーRepository ユーザーrepo;

	public ユーザーアプリケーション(IユーザーRepository ユーザーrepo) {
		ユーザーrepo = new ユーザーRepository();
	}

	public boolean ユーザー情報の保存(ユーザー ユーザー) {
		return ユーザーrepo.store(ユーザー);
	}
}

