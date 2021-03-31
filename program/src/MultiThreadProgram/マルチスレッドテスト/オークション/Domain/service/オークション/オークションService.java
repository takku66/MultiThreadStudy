package MultiThreadProgram.マルチスレッドテスト.オークション.Domain.service.オークション;

import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.オークション.オークション;
import MultiThreadProgram.マルチスレッドテスト.オークション.Domain.models.ユーザー.ユーザー;

public class オークションService {


	synchronized public boolean 入札(オークション オークション, ユーザー 入札者, int 入札金額) {

		if(オークション.未開催かどうか()) {
			System.out.println("まだオークションが開催されていません。");
			System.out.println(String.format("オークション情報:[%s]", オークション.toString()));
			System.out.println(String.format("入札者情報:[%s]", 入札者.toString()));
			System.out.println(String.format("入札金額:[%s]", 入札金額));
			return false;
		}
		if(オークション.既に落札されてるか()) {
			System.out.println("このオークションは既に入札の上限額に達しています。");
			System.out.println(String.format("オークション情報:[%s]", オークション.toString()));
			System.out.println(String.format("入札者情報:[%s]", 入札者.toString()));
			System.out.println(String.format("入札金額:[%s]", 入札金額));
			return false;
		}
		if(!入札者.持ち金で足りるか判定(入札金額)) {
			System.out.println(入札者.getName() + "は持ち金が足りません。");
			System.out.println(String.format("オークション情報:[%s]", オークション.toString()));
			System.out.println(String.format("入札者情報:[%s]", 入札者.toString()));
			System.out.println(String.format("入札金額:[%s]", 入札金額));
			return false;
		}
		if(オークション.入札金額が累積額に満たないか(入札金額)) {
			System.out.println(入札者.getName() + "の入札は無効です。");
			System.out.println(String.format("オークション情報:[%s]", オークション.toString()));
			System.out.println(String.format("入札者情報:[%s]", 入札者.toString()));
			System.out.println(String.format("入札金額:[%s]", 入札金額));
			return false;
		}
		Thread th = new Thread(new 入札操作(オークション, 入札者, 入札金額));
		th.start();
		try {
			th.join();
			System.out.println(入札者.getName() + "が入札完了しました。");
			System.out.println(String.format("入札完了:[%s]", オークション.toString()));
			System.out.println(String.format("入札完了:[%s]", 入札者.toString()));
			System.out.println(String.format("入札完了:[%s]", 入札金額));
		}catch(Exception e) {
			e.printStackTrace();
		}

		return true;
	}
}

class 入札操作 implements Runnable{

	private オークション オークション;
	private ユーザー 入札者;
	private int 入札金額;

	public 入札操作(オークション オークション, ユーザー 入札者, int 入札金額) {
		this.オークション = オークション;
		this.入札者 = 入札者;
		this.入札金額 = 入札金額;
	}

	@Override
	public void run() {
		オークション.入札(入札者, 入札金額);
		if(オークション.既に落札されてるか()) {
			入札者.持ち金から払う(入札金額);
		}
	}
}
