package Object.UI;

import java.util.ArrayList;
import java.util.List;

import Object.Character.Character;

public class UIManager {

	private List<Character> mList;

	// コンストラクタ
	public UIManager(){

		mList = new ArrayList<Character>();

		// UI生成
		Character ground = new UIGround();
		Character maxHP = new UIMaxHP();
		Character hp = new UIHP();
		Character gameclear = new UIGameClear();
		Character gameover = new UIGameOver();

		// リストに追加
		mList.add( ground );
		mList.add( maxHP );
		mList.add( hp );
		mList.add( gameclear );
		mList.add( gameover );
	}

	// 更新
	public void update(){

		for( int i=0; i<mList.size(); i++ ){

			mList.get(i).update();
		}
	}

	// ゲッター
	public List<Character> getList(){ return mList; }
}
