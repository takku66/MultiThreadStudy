package MultiThreadProgram.マルチスレッドテスト.オークション.Application;

import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.IユーザーRepository;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.ユーザー;

public class ユーザーアプリケーション {
	// HACK: 本来はDIコンテナで管理するもの
	IユーザーRepository ユーザーrepo;

	public ユーザーアプリケーション(IユーザーRepository ユーザーrepo) {
		this.ユーザーrepo = ユーザーrepo;
	}

	public boolean ユーザー情報の保存(ユーザー ユーザー) {
		return ユーザーrepo.store(ユーザー);
	}
}

