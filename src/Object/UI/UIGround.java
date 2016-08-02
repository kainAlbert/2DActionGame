package Object.UI;

import Application.Define;
import Application.GSvector2;
import Object.Character.Character;

public class UIGround extends Character{

	// コンストラクタ
	public UIGround(){
		super();

		super.initialize("ground",
				new GSvector2( 0, Define.GROUND_LINE ),
				new GSvector2( Define.UI_GROUND_SCALE.x, Define.UI_GROUND_SCALE.y ),
				new GSvector2( Define.UI_GROUND_RESIZE.x, Define.UI_GROUND_RESIZE.y ),
				null, 0, 0, 0);
	}

	// 更新
	public void update(){}
}
