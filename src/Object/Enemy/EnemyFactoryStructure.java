package Object.Enemy;

import Application.GSvector2;

public class EnemyFactoryStructure {

	public int mID;
	public String mFileName;
	public int mScale;
	public GSvector2 mReSize;
	public boolean mIsHoming;
	public int mSpeed;
	public int mHP;
	public int mWaitMax;
	public double mJumpPower;

	// コンストラクタ
	public EnemyFactoryStructure( int id, String fileName, int scale, GSvector2 resize, boolean isHoming, int speed, int hp, int waitMax, double jumpPower ){

		mID = id;
		mFileName = fileName;
		mScale = scale;
		mReSize = resize;
		mIsHoming = isHoming;
		mSpeed = speed;
		mHP = hp;
		mWaitMax = waitMax;
		mJumpPower = jumpPower;
	}

}
