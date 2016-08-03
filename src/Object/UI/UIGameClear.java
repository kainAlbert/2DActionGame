package Object.UI;

import Application.Application;
import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class UIGameClear extends Character{

	// コンストラクタ
	public UIGameClear(){
		super();

		super.initialize("gameclear",
				new GSvector2( Define.UI_GAME_POS.x, Define.UI_GAME_POS.y ),
				new GSvector2( 0, Define.UI_GAME_SCALE.y ),
				new GSvector2( Define.UI_GAME_RESIZE.x, Define.UI_GAME_RESIZE.y ),
				null, 0, 0, 0);
	}

	// 更新
	public void update(){

		if( Application.getObj().getCM().getDeadBoss() < 3 ) return;

		mScale.x = Define.UI_GAME_SCALE.x;
	}

}
