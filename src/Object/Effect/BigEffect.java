package Object.Effect;
import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class BigEffect extends Character{

	private int mTimer;

	// コンストラクタ
	public BigEffect( GSvector2 pos, int direction ){

		super();

		mTimer = 0;
		mDirection = direction;

		super.initialize(
				"bigEffect",
				pos,
				new GSvector2( Define.BIG_EFFECT_SCALE, Define.BIG_EFFECT_SCALE ),
				new GSvector2( Define.BIG_EFFECT_RESIZE.x, Define.BIG_EFFECT_RESIZE.y ),
				null, 0, 0, 0);

	}

	// 更新
	public void update(){

		mTimer ++;

		if( mTimer < Define.BIG_EFFECT_TIME ) return;

		mTimer = 0;

		mReSize.x += Define.BIG_EFFECT_RESIZE.x;

		if( mReSize.x > Define.BIG_EFFECT_RESIZE.x * 5 ) mIsDead = true;
	}
}
