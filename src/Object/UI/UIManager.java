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

		// リストに追加
		mList.add( ground );
		mList.add( maxHP );
		mList.add( hp );
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
