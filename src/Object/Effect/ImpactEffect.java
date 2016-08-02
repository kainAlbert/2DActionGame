package Object.Effect;
import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class ImpactEffect extends Character{

	private int mTimer;
	private boolean mIsDraw;

	// コンストラクタ
	public ImpactEffect( GSvector2 pos ){

		super();

		mTimer = 0;
		mIsDraw = false;

		super.initialize(
				"impact",
				pos,
				new GSvector2( 0, Define.IMPACT_EFFECT_SCALE ),
				new GSvector2( Define.IMPACT_EFFECT_RESIZE.x, Define.IMPACT_EFFECT_RESIZE.y ),
				null, 0, 0, 0);

	}

	// 更新
	public void update(){

		mTimer ++;

		if( mTimer < Define.WEAPON_SWING_TIME && !mIsDraw ){
			return;
		}else{

			mScale.x = Define.IMPACT_EFFECT_SCALE;
			mIsDraw = true;
		}

		if( mTimer < Define.IMPACT_EFFECT_TIME ) return;

		mTimer = 0;

		mReSize.x += Define.IMPACT_EFFECT_RESIZE.x;

		if( mReSize.x > Define.IMPACT_EFFECT_RESIZE.x * 7 ) mIsDead = true;
	}
}
