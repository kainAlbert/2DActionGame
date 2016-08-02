package Object.Item;

import java.util.Random;

import Application.Define;
import Application.GSvector2;

public class ItemFactory {

	private ItemManager mIM;
	private int mTimer;
	private Random mRnd;

	// コンストラクタ
	public ItemFactory( ItemManager im ){

		mIM = im;
		mTimer = 0;
		mRnd = new Random();
	}

	// 更新
	public void update(){

		mTimer++;

		if( mTimer < Define.ITEM_TIMER ) return;

		mTimer = 0;

		for( int i=0; i<3; i++ ){

			createItem();
		}
	}

	// アイテムを生成
	public void createItem(){

		if( mRnd.nextInt( Define.ITEM_RANDOM ) != 0 ) return;

		double posx = mRnd.nextDouble() * ( Define.WINDOW_X - Define.ITEM_SCALE.x );
		int itemID = mRnd.nextInt( Define.ITEM_TYPE_NUM );

		// アイテムを生成
		Item it = new Item( itemID, itemID == Define.ITEM_TYPE_NUM - 1, new GSvector2( posx, 0 ) );

		// リストに追加
		mIM.addItemList( it );
	}
}
