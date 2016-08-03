package Object.Character;

import java.util.ArrayList;
import java.util.List;

import Application.Application;
import Application.Define;
import Object.Enemy.Enemy;
import Object.Player.Player;

public class CharacterManager {

	private Character mPlayer;
	private List<Character> mEnemyList;
	private int mLevel;
	private int mScore;
	private int mDeadBoss;

	// コンストラクタ
	public CharacterManager(){

		// プレイヤーを生成
		mPlayer = new Player();

		// リスト生成
		mEnemyList = new ArrayList<Character>();

		mLevel = 1;
		mScore = 0;
		mDeadBoss = 0;
	}

	// 更新
	public void update(){

		mPlayer.update();

		// リスト更新
		for( int i=0; i<mEnemyList.size(); i++ ){

			Character e = mEnemyList.get(i);

			e.update();

			// 死亡処理
			if( !e.getIsDead() ) continue;

			addScore( (Enemy)e );

			mEnemyList.remove(i);
		}

		if( mLevel > 3 ) return;

		if( mScore < Define.NEED_SCORE[ mLevel - 1 ] ) return;

		// ボスの追加
		Application.getObj().getEF( 0 ).addEnemyList( Define.BOSS_OF_LEVEL[ mLevel - 1 ] );

		mScore = 0;
		mLevel++;
	}

	// スコア追加
	private void addScore( Enemy e ){

		if( ((Enemy)e).getIsBoss() ){

			mDeadBoss++;
			return;
		}

		if( nowIsBoss() ) return;

		mScore += ((Enemy)e).getFirstHP();
	}

	// ボスが出現しているかどうか
	public boolean nowIsBoss(){

		for( int i=0; i<mEnemyList.size(); i++ ){

			if( ((Enemy)mEnemyList.get(i)).getIsBoss() ) return true;
		}
		return false;
	}

	// リストに追加
	public void addEnemy( Character enemy ){ mEnemyList.add( enemy ); }

	// ゲッター
	public Character getPlayer(){ return mPlayer; }
	public List<Character> getEnemyList(){ return mEnemyList; }
	public int getLevel(){ return mLevel; }
}
