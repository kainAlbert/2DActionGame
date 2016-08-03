package Object;

import Object.Character.CharacterManager;
import Object.Effect.EffectManager;
import Object.Enemy.EnemyFactory;
import Object.Item.ItemManager;
import Object.UI.UIManager;

public class ObjectManager {

	private CharacterManager mCM;
	private EnemyFactory[] mEF;
	private ItemManager mIM;
	private UIManager mUM;
	private Collision mCollision;
	private EffectManager mEM;

	// コンストラクタ
	public ObjectManager(){

		// 各インスタンス化
		mCM = new CharacterManager();
		mEF = new EnemyFactory[3];
		mIM = new ItemManager();
		mUM = new UIManager();
		mCollision = new Collision();
		mEM = new EffectManager();

		for( int i=0; i<mEF.length; i++ ){
			mEF[i] = new EnemyFactory( i + 1 );
		}
	}

	// 更新
	public void update(){

		// 各インスタンス更新
		mCM.update();
		mIM.update();
		mUM.update();
		mCollision.update();
		mEM.update();

		for( int i=0; i<mEF.length; i++ ){
			mEF[i].update();
		}
	}

	// ゲッター
	public CharacterManager getCM(){ return mCM; }
	public EnemyFactory getEF( int i ){ return mEF[i]; }
	public ItemManager getIM(){ return mIM; }
	public UIManager getUM(){ return mUM; }
	public Collision getCollision(){ return mCollision; }
	public EffectManager getEM(){ return mEM; }
}
