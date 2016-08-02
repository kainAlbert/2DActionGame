package Object.Player;

import Application.Application;
import Application.Define;
import Application.GSvector2;
import Object.Character.Character;
import Object.Effect.BigEffect;
import Object.Effect.FalxEffect;
import Object.Effect.ImpactEffect;
import Object.Effect.SlashEffect;

public class Weapon extends Character{

	private int mID;
	private GSvector2 mRange;
	private Character mPlayer;
	private int mTimer;
	private boolean mIsSwing;

	public Weapon( Character player, int id ){

		super();

		// テキストファイルから取得
		WeaponStructure str = WeaponReader.returnWeapon(id);

		mPlayer = player;
		mID = id;
		mRange = str.mRange;
		mTimer = 0;
		mIsSwing = false;

		super.initialize(
				str.mFileName,
				new GSvector2( ),
				new GSvector2( str.mScale, str.mScale ),
				new GSvector2( Define.WEAPON_RESIZE.x, Define.WEAPON_RESIZE.y ),
				new GSvector2(),
				0, 0, str.mPower );
	}

	// 更新
	public void update(){

		double revisionX = 0;
		double revisionY = 0;

		// プレイヤーの座標と向きを取得
		GSvector2 pos = mPlayer.getPos();
		mDirection = mPlayer.getDirection();

		// 向きによって位置を変える
		if( mDirection == Define.DIRECTION_LEFT ){

			revisionX = Define.WEAPON_LEFT_HAND.x - mScale.x;
			revisionY = Define.WEAPON_LEFT_HAND.y;
		}
		if( mDirection == Define.DIRECTION_RIGHT ){

			revisionX =  Define.WEAPON_RIGHT_HAND.x;
			revisionY =  Define.WEAPON_RIGHT_HAND.y;
		}

		mPos.x = pos.x + revisionX;
		mPos.y = pos.y + revisionY - mScale.y + mTimer * mScale.y / Define.WEAPON_SWING_TIME;

		if( !mIsSwing ) return;

		mTimer++;
		mRotate += mDirection == Define.DIRECTION_LEFT ? -Define.WEAPON_ROTATE : Define.WEAPON_ROTATE;

		if( mTimer < Define.WEAPON_SWING_TIME ) return;

		mIsDead = true;
	}

	// 攻撃
	public void attack(){

		if( mIsSwing ) return;

		// エフェクト生成
		createEffect();

		mIsSwing = true;
	}

	// エフェクト生成
	private void createEffect(){

		// プレイヤーの位置と向きを取得
		GSvector2 pPos = mPlayer.getPos();
		int direction = mPlayer.getDirection();

		// ハンマーのエフェクト生成
		if( mID == Define.WEAPON_ID.HAMMER.ordinal() ){

			createImpactEffect( pPos, direction );
			return;
		}

		// 鎌のエフェクト生成
		if( mID == Define.WEAPON_ID.FALX.ordinal() ){

			createFalxEffect( pPos, direction );
			return;
		}

		// 大剣エフェクト生成
		if( mID == Define.WEAPON_ID.BIGSWORD.ordinal() ){

			createBigEffect( pPos, direction );
			return;
		}

		// 斬るエフェクト生成
		createSlashEffect( pPos, direction );
	}

	// 斬るエフェクト生成
	private void createSlashEffect( GSvector2 pPos, int direction ){

		GSvector2 scale = new GSvector2( mRange.x, mRange.y );
		GSvector2 ePos = new GSvector2( 0, pPos.y - scale.y + mPlayer.getScale().y );

		// 向きによって位置を決める
		if( direction == Define.DIRECTION_LEFT ){ ePos.x = pPos.x - scale.x; }
		if( direction == Define.DIRECTION_RIGHT ){ ePos.x = pPos.x + mPlayer.getScale().x; }

		// エフェクト生成
		Character effect = new SlashEffect(ePos, direction, scale);

		Application.getObj().getEM().addEffectList( effect );
	}

	// 衝撃エフェクト生成
	private void createImpactEffect( GSvector2 pPos, int direction ){

		GSvector2 ePos = new GSvector2( 0, pPos.y - Define.IMPACT_EFFECT_SCALE + mPlayer.getScale().y );

		// 向きによって位置を決める
		if( direction == Define.DIRECTION_LEFT ){ ePos.x = pPos.x - mRange.x; }
		if( direction == Define.DIRECTION_RIGHT ){ ePos.x = pPos.x + mPlayer.getScale().x; }

		// エフェクト生成
		Character effect = new ImpactEffect( ePos );

		Application.getObj().getEM().addEffectList( effect );
	}

	// 鎌エフェクト生成
	private void createFalxEffect( GSvector2 pPos, int direction ){

		GSvector2 ePos = new GSvector2( 0, pPos.y - Define.FALX_EFFECT_SCALE.y + mPlayer.getScale().y );

		// 向きによって位置を決める
		if( direction == Define.DIRECTION_LEFT ){ ePos.x = pPos.x - Define.FALX_EFFECT_SCALE.x; }
		if( direction == Define.DIRECTION_RIGHT ){ ePos.x = pPos.x + mPlayer.getScale().x; }

		// エフェクト生成
		Character effect = new FalxEffect( ePos, direction );

		Application.getObj().getEM().addEffectList( effect );
	}

	// 大剣エフェクト生成
	private void createBigEffect( GSvector2 pPos, int direction ){

		GSvector2 ePos = new GSvector2( 0, pPos.y - Define.BIG_EFFECT_SCALE + mPlayer.getScale().y + 30 );

		// 向きによって位置を決める
		if( direction == Define.DIRECTION_LEFT ){ ePos.x = pPos.x - mRange.x; }
		if( direction == Define.DIRECTION_RIGHT ){ ePos.x = pPos.x + mPlayer.getScale().x; }

		// エフェクト生成
		Character effect = new BigEffect( ePos, direction );

		Application.getObj().getEM().addEffectList( effect );
	}

	// ゲッター
	public int getID(){ return mID; }
	public int getPower(){ return mPower; }
	public GSvector2 getRange(){ return mRange; }
	public boolean getIsSwing(){ return mIsSwing; }
}
