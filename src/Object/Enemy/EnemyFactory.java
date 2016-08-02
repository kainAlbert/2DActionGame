package Object.Enemy;

import java.util.Random;

import Application.Application;
import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class EnemyFactory {

	private int mNeedLevel;
	private int mFactoryTime;
	private int mNextTime;
	private Random mRnd;
	private EnemyFactoryStructure mStr;

	// コンストラクタ
	public EnemyFactory( int needLevel ){

		mNeedLevel = needLevel;
		mFactoryTime = 0;
		mNextTime = 0;

		mRnd = new Random();
		mStr = null;
	}

	// 更新
	public void update(){

		mFactoryTime++;

		addNewEnemy();
	}

	// 新しい敵の追加
	private void addNewEnemy(){

		if( mFactoryTime < mNextTime )  return;

		// mRnd.nextInt( Define.ENEMY_TYPE_NUM ) + 1
		mStr = EnemyReader.returnEnemyFactoryStructure( mRnd.nextInt( Define.ENEMY_TYPE_NUM ) + 1 );

		if( mStr == null ) return;

		mNextTime = mRnd.nextInt( Define.FACTORY_RND_MAX - Define.FACTORY_RND_MIN ) + Define.FACTORY_RND_MIN;

		mFactoryTime = 0;

		int direction = mRnd.nextInt(1) + 1;
		int posx = direction == Define.DIRECTION_LEFT ? -mStr.mScale : Define.WINDOW_X;

		Character e = new Enemy( mStr.mID, mStr.mWaitMax, mStr.mJumpPower, direction );

		e.initialize(
				mStr.mFileName,
				new GSvector2( posx, Define.GROUND_LINE - mStr.mScale ),
				new GSvector2( mStr.mScale, mStr.mScale ),
				new GSvector2( mStr.mReSize.x, mStr.mReSize.y ),
				e.getVelocity(),
				mStr.mSpeed, mStr.mHP, Define.ENEMY_POWER);

		Application.getObj().getCM().addEnemy( e );
	}
}
