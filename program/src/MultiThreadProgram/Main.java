package MultiThreadProgram;

import MultiThreadProgram.マルチスレッドテスト.オークション.Application.オークションアプリケーション;
import MultiThreadProgram.マルチスレッドテスト.オークション.Application.ユーザーアプリケーション;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.オークション.オークション;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.ユーザー;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.ユーザーFactory;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.商品.オークション商品;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.service.オークション.オークションService;
import MultiThreadProgram.マルチスレッドテスト.オークション.Infrastructures.InMemory.ユーザー.ユーザーRepository;

public class Main{
    public static void main(String[] args){
    	// 各ユーザーの初期設定を暫定的に行う
    	ユーザー 太郎 = ユーザーFactory.新規ユーザー生成("太郎");
    	太郎.持ち金を加える(100000);
    	ユーザー 次郎 = ユーザーFactory.新規ユーザー生成("次郎");
    	次郎.持ち金を加える(200000);
    	ユーザー 三郎 = ユーザーFactory.新規ユーザー生成("三郎");
    	三郎.持ち金を加える(300000);

    	// DB接続はコストかかるためインメモリで代用
    	ユーザーアプリケーション ユーザーアプリ = new ユーザーアプリケーション(new ユーザーRepository());
    	ユーザーアプリ.ユーザー情報の保存(太郎);
    	ユーザーアプリ.ユーザー情報の保存(次郎);
    	ユーザーアプリ.ユーザー情報の保存(三郎);

    	// 今回の勉強用のメインアプリ生成
    	オークションアプリケーション アプリ = new オークションアプリケーション(new オークションService());
    	オークション 漫画オークション = アプリ.オークション開催(太郎, new オークション商品(太郎, "漫画"), 190000);
    	漫画オークション.入札開始();

    	// 各ユーザーは互いの同期をとらなくてよいため、並列実行させる
    	new Thread(new ユーザースレッド(アプリ, 漫画オークション, 太郎)).start();
    	new Thread(new ユーザースレッド(アプリ, 漫画オークション, 次郎)).start();
    	new Thread(new ユーザースレッド(アプリ, 漫画オークション, 三郎)).start();
    }
}
/**
 * ユーザーごとに入札操作を行うためのクラス
 */
class ユーザースレッド implements Runnable {
	private オークションアプリケーション アプリ;
	private オークション オークション;
	private ユーザー ユーザー;

	public ユーザースレッド(オークションアプリケーション アプリ, オークション オークション, ユーザー ユーザー) {
		this.アプリ = アプリ;
		this.オークション = オークション;
		this.ユーザー = ユーザー;
	}
	@Override
	public void run() {
		アプリ.入札(オークション, ユーザー, 30000);
    	アプリ.入札(オークション, ユーザー, 60000);
    	アプリ.入札(オークション, ユーザー, 90000);
    	アプリ.入札(オークション, ユーザー, 120000);
    	アプリ.入札(オークション, ユーザー, 150000);
    	アプリ.入札(オークション, ユーザー, 180000);
    	アプリ.入札(オークション, ユーザー, 210000);
    	アプリ.入札(オークション, ユーザー, 240000);
	}

}


