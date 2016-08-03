package Object.Character;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Application.Define;
import Application.GSvector2;

public class Character {

	protected BufferedImage mImage;
	protected GSvector2 mPos;
	protected GSvector2 mScale;
	protected GSvector2 mFirstReSize;
	protected GSvector2 mReSize;
	protected GSvector2 mVelocity;
	protected double mSpeed;
	protected int mHP;
	protected int mPower;
	protected boolean mIsDead;
	protected int mDirection;
	protected double mRotate;
	protected int mInvinciblyTimer;

	// コンストラクタ
	public Character(){


		mRotate = 0;
		mIsDead = false;
		mDirection = 0;
		mHP = 1;
	}

	// 初期化
	public void initialize( String fileName, GSvector2 pos, GSvector2 scale, GSvector2 resize, GSvector2 vel, double speed, int hp, int power ){

		try{
			mImage = ImageIO.read(new File( "img/" + fileName + ".png" ));

		}catch( IOException e ){
			e.printStackTrace();
		}

		mPos = pos;
		mScale = scale;
		mFirstReSize = resize;
		mReSize = new GSvector2( resize.x, resize.y );
		mVelocity = vel;
		mSpeed = speed;
		mHP = hp;
		mPower = power;
	}

	// 更新
	public void update(){

		// 移動量によって向きを変える
		if( mVelocity.x < 0 ){ mDirection = Define.DIRECTION_LEFT; }
		if( mVelocity.x > 0 ){ mDirection = Define.DIRECTION_RIGHT; }

		// 重力処理
		mVelocity.y += Define.GRAVITY;

		// 移動
		mPos.x += mVelocity.x * mSpeed;
		mPos.y += mVelocity.y * mSpeed;

		// 地面との判定
		mPos.y = Math.min( mPos.y, Define.GROUND_LINE - mScale.y );

		// 無敵時間更新
		if( mInvinciblyTimer > 0 ) mInvinciblyTimer--;

		// 死亡フラグ
		mIsDead = mHP <= 0;
	}

	// 死亡フラグ
	public void doDead(){ mIsDead = true; }

	// ダメージ
	public void damage( int d ){ mHP -= d; }

	// ゲッター
	public BufferedImage getImage() { return mImage; }
	public GSvector2 getPos() { return mPos; }
	public GSvector2 getScale() { return mScale; }
	public GSvector2 getFirstReSize(){ return mFirstReSize; }
	public GSvector2 getReSize() { return mReSize; }
	public GSvector2 getVelocity() { return mVelocity; }
	public double getSpeed() { return mSpeed; }
	public int getHP(){ return mHP; }
	public int getPower(){ return mPower; }
	public boolean getIsDead(){ return mIsDead; }
	public int getDirection(){ return mDirection; }
	public double getRotate(){ return mRotate; }
	public int getInvinciblyTimer(){ return mInvinciblyTimer; }

}
