package Object.Item;

import java.util.ArrayList;
import java.util.List;

import Object.Character.Character;

public class ItemManager {

	private ItemFactory mIF;
	private List<Character> mItemList;

	// コンストラクタ
	public ItemManager(){

		mIF = new ItemFactory( this );
		mItemList = new ArrayList<Character>();
	}

	// 更新
	public void update(){

		// 工場の更新
		mIF.update();

		// 各アイテムの更新
		for( int i=0; i<mItemList.size(); i++ ){

			mItemList.get(i).update();

			// 死亡処理
			if( !mItemList.get(i).getIsDead() ) continue;

			mItemList.remove(i);
		}

	}

	// リストに追加
	public void addItemList( Item it ){ mItemList.add( it ); }

	// ゲッター
	public List<Character> getItemList(){ return mItemList; }
}
