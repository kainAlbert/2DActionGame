package Object.Character;

import java.util.ArrayList;
import java.util.List;

import Object.Player.Player;

public class CharacterManager {

	private Character mPlayer;
	private List<Character> mEnemyList;

	// コンストラクタ
	public CharacterManager(){

		// プレイヤーを生成
		mPlayer = new Player();

		// リスト生成
		mEnemyList = new ArrayList<Character>();
	}

	// 更新
	public void update(){

		mPlayer.update();

		// リスト更新
		for( int i=0; i<mEnemyList.size(); i++ ){

			mEnemyList.get(i).update();

			// 死亡処理
			if( !mEnemyList.get(i).getIsDead() ) continue;

			mEnemyList.remove(i);
		}
	}

	// リストに追加
	public void addEnemy( Character enemy ){ mEnemyList.add( enemy ); }

	// ゲッター
	public Character getPlayer(){ return mPlayer; }
	public List<Character> getEnemyList(){ return mEnemyList; }
}
