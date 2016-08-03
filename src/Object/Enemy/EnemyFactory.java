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

		if( mNeedLevel > Application.getObj().getCM().getLevel() ) return;

		mFactoryTime++;

		addNewEnemy();
	}

	// 新しい敵の追加
	private void addNewEnemy(){

		if( mFactoryTime < mNextTime )  return;

		// 敵リストに追加
		addEnemyList( mRnd.nextInt( Define.ENEMY_ID.WOLF.ordinal() ) + 1 );

		mNextTime = mRnd.nextInt( Define.FACTORY_RND_MAX - Define.FACTORY_RND_MIN ) + Define.FACTORY_RND_MIN;

		if( Application.getObj().getCM().nowIsBoss() ) mNextTime *= 3;

		mFactoryTime = 0;
	}

	// 敵をリストに追加
	public void addEnemyList( int id ){

		mStr = EnemyReader.returnEnemyFactoryStructure( id );

		if( mStr == null ) return;

		int direction = mRnd.nextInt(2) + 1;
		int posx = direction == Define.DIRECTION_LEFT ? -mStr.mScale : Define.WINDOW_X;

		Character e = new Enemy( mStr.mID, mStr.mHP, mStr.mWaitMax, mStr.mJumpPower, direction, mStr.mID >= Define.ENEMY_ID.HAMSTER.ordinal() );

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
