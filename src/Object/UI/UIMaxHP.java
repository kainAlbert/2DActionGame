package Object.UI;

import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class UIMaxHP extends Character{

	public UIMaxHP(){

		super();

		super.initialize(
				"hpmax",
				new GSvector2( Define.UI_HP_POS.x, Define.UI_HP_POS.y ),
				new GSvector2( Define.UI_HP_SCALE.x , Define.UI_HP_SCALE.y ),
				new GSvector2( Define.UI_ALPHA_RESIZE.x, Define.UI_ALPHA_RESIZE.y ),
				null, 0, 0, 0);
	}

	// 更新
	public void update(){}
}
