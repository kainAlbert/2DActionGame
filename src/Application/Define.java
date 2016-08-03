package Application;

public interface Define{

	// ウィンドウ関連
	int WINDOW_X = 800;
	int WINDOW_Y = 600;

	// プレイヤー関連
	GSvector2 PLAYER_INIT_POS = new GSvector2( 400, 500 );
	GSvector2 PLAYER_INIT_SCALE = new GSvector2( 65, 65 );
	GSvector2 PLAYER_INIT_RESIZE = new GSvector2( 64, 64 );
	GSvector2 PLAYER_INIT_VEL = new GSvector2( 0, 0 );
	double PLAYER_INIT_SPEED = 5;
	int PLAYER_INIT_HP = 100;
	int PLAYER_INIT_POWER = 10;
	int PLAYER_JUMP_NUM = 3;
	double PLAYER_JUMP_POWER = 2;
	int PLAYER_INVINCIBLY_TIME = 30;
	int NEED_SCORE[] = { 1000, 1500, 2000 };

	// 武器関連
	GSvector2 WEAPON_LEFT_HAND = new GSvector2( 12, 48 );
	GSvector2 WEAPON_RIGHT_HAND = new GSvector2( 52, 48 );
	GSvector2 WEAPON_SCALE = new GSvector2( 64, 64 );
	GSvector2 WEAPON_RESIZE = new GSvector2( 128, 128 );
	double WEAPON_ROTATE = 20;
	double WEAPON_SWING_TIME = 5;
	enum WEAPON_ID{
		HAMMER, AXE, SWORD, BIGSWORD, FALX, SPEAR
	}

	// アイテム関連
	int ITEM_TIMER = 60;
	int ITEM_RANDOM = 4;
	GSvector2 ITEM_SCALE = new GSvector2( 64, 64 );
	GSvector2 ITEM_RESIZE = new GSvector2( 64, 64 );
	double ITEM_VELOCITY_Y = 1;
	double ITEM_SPEED = 1;
	int ITEM_TYPE_NUM = 7;
	int ITEM_CARE_UP = 10;

	// 全キャラ関連
	double GRAVITY = 0.1;
	double GROUND_LINE = 500;
	int DIRECTION_LEFT = 1;
	int DIRECTION_RIGHT = 2;

	// UI関連
	GSvector2 UI_ALPHA_RESIZE = new GSvector2( 1, 1 );
	GSvector2 UI_GROUND_SCALE = new GSvector2( WINDOW_X, WINDOW_Y - GROUND_LINE );
	GSvector2 UI_HP_SCALE = new GSvector2(  WINDOW_X* 0.8, UI_GROUND_SCALE.y * 0.2 );
	GSvector2 UI_HP_POS = new GSvector2(  WINDOW_X * 0.1, GROUND_LINE + 10 );
	GSvector2 UI_GAME_SCALE = new GSvector2( WINDOW_X * 0.8, WINDOW_Y * 0.5 );
	GSvector2 UI_GAME_RESIZE = new GSvector2( 256, 128 );
	GSvector2 UI_GAME_POS = new GSvector2( ( WINDOW_X - UI_GAME_SCALE.x ) / 2, ( WINDOW_Y - UI_GAME_SCALE.y ) / 2 );

	// 敵関連
	int ENEMY_POWER = 5;
	int FACTORY_RND_MIN = 120;
	int FACTORY_RND_MAX = 300;
	int ENEMY_JUMP_TIME = 50;
	int ENEMY_TYPE_NUM = 7;
	int ENEMY_INVINCIBLY_TIME = 15;
	int ENEMY_MAX_NUM = 10;
	enum ENEMY_ID{
		NONE, PURINE, FROG, DRAGON, WOLF, HAMSTER, SQUIRREL, RABBIT
	}
	int[] BOSS_OF_LEVEL = { ENEMY_ID.HAMSTER.ordinal(), ENEMY_ID.SQUIRREL.ordinal(), ENEMY_ID.RABBIT.ordinal() };


	// エフェクト関連
	GSvector2 SLASH_EFFECT_RESIZE = new GSvector2( 256, 256 );
	double SLASH_EFFECT_TIMER = 0.2;
	GSvector2 IMPACT_EFFECT_RESIZE = new GSvector2( 240, 240 );
	double IMPACT_EFFECT_SCALE = 150;
	double IMPACT_EFFECT_TIME = 5;
	GSvector2 FALX_EFFECT_RESIZE = new GSvector2( 640, 480 );
	GSvector2 FALX_EFFECT_SCALE = new GSvector2( 360, 240 );
	double FALX_EFFECT_TIME = 5;
	GSvector2 BIG_EFFECT_RESIZE = new GSvector2( 240, 240 );
	double BIG_EFFECT_SCALE = 300;
	double BIG_EFFECT_TIME = 4;
}