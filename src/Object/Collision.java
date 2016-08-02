package Object;

import java.util.List;

import Application.Application;
import Application.GSvector2;
import Object.Character.Character;
import Object.Item.Item;
import Object.Player.Player;

public class Collision {

	// 更新
	public void update(){

		Character player = Application.getObj().getCM().getPlayer();
		List<Character> enemyList = Application.getObj().getCM().getEnemyList();

		// プレイヤーとアイテムの当たり判定
		collisionPlayerItem( player );

		// プレイヤーと敵の当たり判定
		collisionPlayerEnemy( player, enemyList );
	}

	// プレイヤーとアイテムの当たり判定
	private void collisionPlayerItem( Character player ){

		List<Character> iList = Application.getObj().getIM().getItemList();

		for( int i=0; i<iList.size(); i++ ){

			Character item = iList.get(i);

			// 円と正方形の当たり判定
			if( !isCollisionSquareCircle( player.getPos(), player.getScale(), item.getPos(), item.getScale().x / 2 ) ) continue;

			boolean isGet = ((Player)player).addItem( ((Item)item).getID() );

			if( isGet ){ item.doDead(); }
		}
	}

	// プレイヤーと敵の当たり判定
	private void collisionPlayerEnemy( Character player, List<Character> enemyList ){

		for( int i=0; i<enemyList.size(); i++ ){

			Character enemy = enemyList.get(i);

			// 正方形と正方形の当たり判定
			if( !isCollisionSquare( enemy.getPos(), enemy.getScale(), player.getPos(), player.getScale() ) ) continue;

			player.damage( enemy.getPower() );
			return;
		}
	}

	// 武器と敵の当たり判定
	public void collisionWeaponEnemy( int weaponPower, GSvector2 pos, GSvector2 range ){

		List<Character> enemyList = Application.getObj().getCM().getEnemyList();

		for( int i=0; i<enemyList.size(); i++ ){

			Character enemy = enemyList.get(i);

			if( !isCollisionSquare(enemy.getPos(), enemy.getScale(), pos, range ) ) continue;

			enemy.damage( weaponPower );
		}
	}

	// 正方形同士の判定
		private boolean isCollisionSquare( GSvector2 pos1, GSvector2 scale1, GSvector2 pos2, GSvector2 scale2 ){

			boolean cx =
					( pos1.x <= pos2.x && pos1.x + scale1.x >= pos2.x ) ||
					( pos1.x <= pos2.x + scale2.x && pos1.x + scale1.x >= pos2.x + scale2.x );

			boolean cy =
					( pos1.y <= pos2.y && pos1.y + scale1.y >= pos2.y ) ||
					( pos1.y <= pos2.y + scale2.y && pos1.y + scale1.y >= pos2.y + scale2.y );

			return cx && cy;
		}

		// 点と円の判定
		private boolean isCollisionPointCircle( GSvector2 pos1, GSvector2 pos2, double radius ){

			return Math.pow( pos1.x - pos2.x, 2 ) + Math.pow( pos1.y - pos2.y, 2 ) < Math.pow( radius, 2 );
		}

		// 正方形と円の判定
		private boolean isCollisionSquareCircle( GSvector2 pos1, GSvector2 scale1, GSvector2 pos2, double radius2 ){

			GSvector2 pos2_r = new GSvector2( pos2.x + radius2, pos2.y + radius2 );

			GSvector2[] pos = {
					new GSvector2( pos1.x, pos1.y ), new GSvector2( pos1.x + scale1.x, pos1.y ),
					new GSvector2( pos1.x, pos1.y + scale1.y ), new GSvector2( pos1.x + scale1.x, pos1.y + scale1.y )
			};

			for( int i=0; i<4; i++ ){

				if( isCollisionPointCircle( pos[i], pos2_r, radius2 ) ) return true;
			}

			if( pos1.x < pos2_r.x - radius2 &&
				pos1.x + scale1.x > pos2_r.x + radius2 &&
				pos1.y < pos2_r.y - radius2 &&
				pos1.y + scale1.y > pos2_r.y + radius2 ) return true;

			return false;
		}

		// 円と円の判定
		private boolean isCollisionCircle( GSvector2 pos1, double radius1, GSvector2 pos2, double radius2 ){

			return Math.pow( pos1.x - pos2.x, 2 ) + Math.pow( pos1.y - pos2.y, 2 ) < Math.pow( radius1 + radius2, 2 );
		}
}
