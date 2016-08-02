package Object.Player;

import Application.Define;
import Application.GSvector2;
import Application.InputKey;
import Object.Character.Character;

public class Player extends Character{

	private int mJumpNum;
	private Character mWeapon;
	private int mTimer;

	// コンストラクタ
	public Player(){

		super();

		super.initialize("player",
				new GSvector2( Define.PLAYER_INIT_POS.x, Define.PLAYER_INIT_POS.y ),
				new GSvector2( Define.PLAYER_INIT_SCALE.x, Define.PLAYER_INIT_SCALE.y ),
				new GSvector2( Define.PLAYER_INIT_RESIZE.x, Define.PLAYER_INIT_RESIZE.y ),
				new GSvector2( Define.PLAYER_INIT_VEL.x, Define.PLAYER_INIT_VEL.y ),
				Define.PLAYER_INIT_SPEED, Define.PLAYER_INIT_HP, Define.PLAYER_INIT_POWER);

		mWeapon = null;
		mInvinciblyTimer = 0;
	}

	// 更新
	public void update(){

		// 親クラスの更新
		super.update();

		// 移動
		move();

		// 攻撃
		attack();

		// 横画面制限
		mPos.x = Math.min( Math.max( mPos.x, 0 ), Define.WINDOW_X - mScale.x );

		// 武器更新
		try{
			mWeapon.update();
		}catch( Exception e ){}
	}

	// 移動
	private void move(){

		// 横方向は常に初期化
		mVelocity.x = 0;

		// 左右の移動
		if( InputKey.mRightKey ){ mVelocity.x = 1; }
		if( InputKey.mLeftKey ){ mVelocity.x = -1; }

		// ジャンプ回数初期化
		if( mPos.y >= Define.GROUND_LINE - mScale.y ){ mJumpNum = 0; }

		// ジャンプ
		if( mJumpNum < Define.PLAYER_JUMP_NUM && mVelocity.y >= 0 && InputKey.mUpKey ){

			mVelocity.y = -Define.PLAYER_JUMP_POWER;
			mJumpNum++;
		}
	}

	// 攻撃
	private void attack(){

		if( mWeapon == null ){

			mReSize.x = Define.PLAYER_INIT_RESIZE.x;
			mTimer = 0;
			return;
		}

		if( mWeapon.getIsDead() ){

			mWeapon = null;
			return;
		}

		swing();

		if( !InputKey.mZKey ) return;

		((Weapon)mWeapon).attack();
	}

	// スウィング
	private void swing(){

		if( !((Weapon)mWeapon).getIsSwing() ) return;

		mTimer++;
		mReSize.x += Define.PLAYER_INIT_RESIZE.x;
	}

	// アイテム取得
	public boolean addItem( int id ){

		// 回復
		if( id == Define.ITEM_TYPE_NUM -1 ){

			mHP += Define.ITEM_CARE_UP;
			return true;
		}

		return addWeapon( id );
	}

	// 武器を追加
	private boolean addWeapon( int id ){

		// すでに武器を持っていたら終了
		if( mWeapon != null ) return false;

		// 武器を生成
		Character weapon = new Weapon( this, id );

		// 追加
		mWeapon = weapon;

		return true;
	}

	// ダメージ
	public void damage( int d ){

		if( mInvinciblyTimer > 0 ) return;

		super.damage(d);

		mInvinciblyTimer = Define.PLAYER_INVINCIBLY_TIME;

	}

	// ゲッター
	public Character getWeapon(){ return mWeapon; }
}
