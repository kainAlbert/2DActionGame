package Application;
import javax.swing.JFrame;

import Object.ObjectManager;

public class Application extends JFrame{

	private static ObjectManager mObj;

	// コンストラクタ
	public Application(){

		// パネルの生成と追加
		Panel pan = new Panel( this );
		this.add(pan);

		// フレーム作成
		this.setVisible(true);

		// 位置と大きさ
		this.setSize( Define.WINDOW_X, Define.WINDOW_Y );
		this.setLocationRelativeTo(null);

		// ✕を押したらプログラム終了
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// キーボード入力の許可
		this.addKeyListener( new InputKey() );

		// 管理者生成
		mObj = new ObjectManager();
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Application app = new Application();

		while( true ){

			// FPS
			setFPS();

			// 更新
			mObj.update();

			// 再描画
			app.repaint();
		}
	}

	// fps処理
		private static void setFPS(){

			long error = 0;
			int fps = 60;
			long idealSleep = (1000 << 16) / fps;
			long oldTime;
			long newTime = System.currentTimeMillis() << 16;

			oldTime = newTime;
			newTime = System.currentTimeMillis() << 16;
			long sleepTime = idealSleep - (newTime - oldTime) - error; // 休止できる時間
			if (sleepTime < 0x20000) sleepTime = 0x20000; // 最低でも2msは休止
			oldTime = newTime;

			try{
				Thread.sleep(sleepTime >> 16); // 休止
			}catch( Exception e ){
				e.printStackTrace();
			}

			newTime = System.currentTimeMillis() << 16;
			error = newTime - oldTime - sleepTime; // 休止時間の誤差
		}

		// ゲッター
		public static ObjectManager getObj(){ return mObj; }
}
