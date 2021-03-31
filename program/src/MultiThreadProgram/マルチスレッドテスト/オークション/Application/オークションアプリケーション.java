package MultiThreadProgram.マルチスレッドテスト.オークション.Application;

import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.オークション.オークション;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.ユーザー;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.商品.オークション商品;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.service.オークション.オークションService;

public class オークションアプリケーション {

	オークションService オークションservice;

	public オークションアプリケーション(オークションService オークションservice) {
		this.オークションservice = オークションservice;
	}

	public オークション オークション開催(ユーザー 出品者, オークション商品 商品, int 上限入札額) {
		return new オークション.Builder().オークションID()
											.出品者(出品者)
											.商品(商品)
											.上限入札額(上限入札額)
											.開設();
	}


	public boolean 入札(オークション オークション, ユーザー 入札者, int 入札金額) {
		return オークションservice.入札(オークション, 入札者, 入札金額);
	}


}


