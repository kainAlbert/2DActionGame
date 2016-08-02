package Object.Effect;
import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class SlashEffect extends Character{

	private GSvector2 mLastScale;
	private double mTimer;

	// コンストラクタ
	public SlashEffect( GSvector2 pos, int direction, GSvector2 scale ){

		super();

		mTimer = 0;
		mLastScale = new GSvector2( scale.x, scale.y );

		super.initialize(
				"slash",
				pos,
				new GSvector2( scale.x, scale.y ),
				new GSvector2( Define.SLASH_EFFECT_RESIZE.x, Define.SLASH_EFFECT_RESIZE.y ),
				null, 0, 0, 0);

		mDirection = direction;
		mReSize.x = 0;
		mFirstReSize.x =Define.SLASH_EFFECT_RESIZE.x;
		mScale.x = 0;
	}

	// 更新
	public void update(){

		mTimer += Define.SLASH_EFFECT_TIMER;

		if( mTimer >= Define.SLASH_EFFECT_TIMER * 7.5 ) mIsDead = true;

		if( mTimer >= 1 ) return;

		mReSize.x = Define.SLASH_EFFECT_RESIZE.x * mTimer;
		mFirstReSize.x = mReSize.x;
		mScale.x = mLastScale.x * mTimer;
	}
}
