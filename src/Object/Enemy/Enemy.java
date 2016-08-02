package Object.Enemy;

import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class Enemy extends Character{

	private int mWait;
	private int mWaitMax;
	private int mID;
	private double mJumpPower;
	private int mJumpTimer;

	// コンストラクタ
	public Enemy( int id, int waitMax, double jumpPower, int direction ){

		super();

		mWait = 0;
		mWaitMax = waitMax;
		mID = id;
		mJumpPower = jumpPower;
		mJumpTimer = 0;

		mDirection = direction;
		mVelocity = new GSvector2();
		mVelocity.x = mDirection == Define.DIRECTION_LEFT ? -1 : 1;
	}

	// 更新
	public void update(){

		// 端にいったときにターンする
		if( mPos.x < -mScale.x ){ mVelocity.x = 1; }
		if( mPos.x > Define.WINDOW_X ){ mVelocity.x = -1; }

		// 親クラスの更新
		super.update();

		jump();
	}

	// ジャンプ
	private void jump(){

		if( mID != Define.ENEMY_ID.FROG.ordinal() &&
				mID != Define.ENEMY_ID.RABBIT.ordinal() &&
				mID != Define.ENEMY_ID.DRAGON.ordinal() ){
			return;
		}

		if( mPos.y < Define.GROUND_LINE - mScale.y ) return;

		mJumpTimer++;

		mVelocity.x = 0;

		if( mJumpTimer < Define.ENEMY_JUMP_TIME ) return;

		mJumpTimer = 0;

		mVelocity.x = mDirection == Define.DIRECTION_LEFT ? -1 : 1;
		mVelocity.y = -mJumpPower;
	}
}
