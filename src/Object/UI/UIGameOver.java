package Object.UI;

import Application.Application;
import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class UIGameOver extends Character{

	// コンストラクタ
	public UIGameOver(){
		super();

		super.initialize("gameover",
				new GSvector2( Define.UI_GAME_POS.x, Define.UI_GAME_POS.y ),
				new GSvector2( 0, Define.UI_GAME_SCALE.y ),
				new GSvector2( Define.UI_GAME_RESIZE.x, Define.UI_GAME_RESIZE.y ),
				null, 0, 0, 0);
	}

	// 更新
	public void update(){

		if( !Application.getObj().getCM().getPlayer().getIsDead() ) return;

		mScale.x = Define.UI_GAME_SCALE.x;
	}

}
