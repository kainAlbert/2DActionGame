package Object.Item;

import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class Item extends Character{

	private int mID;
	private boolean mIsWeapon;
	private int mAnimationTimer;
	private int mReSizeAdd;
	private boolean mIsAnimationEnd;

	private final int mMaxAnimationTimer = 10;
	private final int mMaxEndTimer = 20;

	// コンストラクタ
	public Item( int id, boolean isWeapon, GSvector2 pos ){

		super();

		super.initialize(
				isWeapon ? "item" : "item2",
				pos,
				new GSvector2( Define.ITEM_SCALE.x, Define.ITEM_SCALE.y ),
				new GSvector2( Define.ITEM_RESIZE.x, Define.ITEM_RESIZE.y ),
				new GSvector2( 0, Define.ITEM_VELOCITY_Y ),
				Define.ITEM_SPEED, 0, 0 );

		mID = id;
		mIsWeapon = isWeapon;
		mAnimationTimer = 0;
		mReSizeAdd = 1;
		mIsAnimationEnd = true;

	}

	// 更新
	public void update(){

		mPos.y += mVelocity.y * mSpeed;

		// 死亡フラグ
		if( mPos.y > Define.GROUND_LINE ) mIsDead = true;

		mAnimationTimer++;

		// 振り子の最後の部分
		if( mIsAnimationEnd ){

			if( mAnimationTimer < mMaxEndTimer ) return;

			mAnimationTimer = 0;
			mIsAnimationEnd = false;
			return;
		}

		// リサイズ
		if( mAnimationTimer < mMaxAnimationTimer ) return;

		mAnimationTimer = 0;

		mReSize.x += mFirstReSize.x * mReSizeAdd;

		// リサイズ範囲から抜けたら
		if( mReSize.x > 0 && mReSize.x <= mFirstReSize.x * 5 ) return;

		mReSizeAdd *= -1;

		mIsAnimationEnd = true;

		mReSize.x = mReSize.x <= 0 ? mFirstReSize.x : mFirstReSize.x * 5;
	}

	// ゲッター
	public int getID(){ return mID; }
	public boolean getIsWeapon(){ return mIsWeapon; }
}
