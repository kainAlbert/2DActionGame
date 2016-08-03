package Object.UI;

import Application.Application;
import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class UIHP extends Character{

	public UIHP(){

		super();

		super.initialize(
				"hp",
				new GSvector2( Define.UI_HP_POS.x, Define.UI_HP_POS.y ),
				new GSvector2( Define.UI_HP_SCALE.x , Define.UI_HP_SCALE.y ),
				new GSvector2( Define.UI_ALPHA_RESIZE.x, Define.UI_ALPHA_RESIZE.y ),
				null, 0, 0, 0);
	}

	// 更新
	public void update(){

		double hp = (double)Application.getObj().getCM().getPlayer().getHP();
		double maxHP = (double)Define.PLAYER_INIT_HP;
		double length = hp / maxHP;

		mScale.x = Define.UI_HP_SCALE.x * length;
	}
}
