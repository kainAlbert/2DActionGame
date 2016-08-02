package Object.Effect;

import java.util.ArrayList;
import java.util.List;

import Object.Character.Character;

public class EffectManager {

	private List<Character> mEffectList;

	// コンストラクタ
	public EffectManager(){

		mEffectList = new ArrayList<Character>();
	}

	// 更新
	public void update(){

		for( int i=0; i<mEffectList.size(); i++ ){

			mEffectList.get(i).update();

			// 死亡処理
			if( !mEffectList.get(i).getIsDead() ) continue;

			mEffectList.remove(i);
		}
	}

	// リストに追加
	public void addEffectList( Character e ){ mEffectList.add( e ); }

	// ゲッター
	public List<Character> getEffectList(){ return mEffectList; }
}
