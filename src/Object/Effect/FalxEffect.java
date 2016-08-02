package Object.Effect;

import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class FalxEffect extends Character{

	private int mTimer;

	// コンストラクタ
	public FalxEffect( GSvector2 pos, int direction ){

		super();

		mTimer = 0;
		mDirection = direction;

		super.initialize(
				"falxEffect",
				pos,
				new GSvector2( Define.FALX_EFFECT_SCALE.x, Define.FALX_EFFECT_SCALE.y ),
				new GSvector2( Define.FALX_EFFECT_RESIZE.x, Define.FALX_EFFECT_RESIZE.y ),
				null, 0, 0, 0);

	}

	// 更新
	public void update(){

		mTimer ++;

		if( mTimer < Define.FALX_EFFECT_TIME ) return;

		mTimer = 0;

		mReSize.x += Define.FALX_EFFECT_RESIZE.x;

		if( mReSize.x > Define.FALX_EFFECT_RESIZE.x * 10 ) mIsDead = true;;
	}
}
