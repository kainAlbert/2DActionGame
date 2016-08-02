package Application;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.JPanel;

import Object.Character.Character;
import Object.Player.Player;

public class Panel extends JPanel{

	private Application mApp;

	public Panel( Application app ){

		mApp = app;
	}

	protected void paintComponent( Graphics g ){

		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		List<Character> iList = null;
		List<Character> uiList = null;
		List<Character> eList = null;
		List<Character> efList = null;
		Character player = null;

		try{
			iList = Application.getObj().getIM().getItemList();
			uiList = Application.getObj().getUM().getList();
			eList = Application.getObj().getCM().getEnemyList();
			efList = Application.getObj().getEM().getEffectList();
			player = Application.getObj().getCM().getPlayer();
		}catch( Exception e ){
			return;
		}

		// 背景描画
		drawBack( g2 );

		// アイテム描画
		for( int i=0; i<iList.size(); i++ ){

			draw( g2, iList.get(i) );
		}

		// 敵の描画
		for( int i=0; i<eList.size(); i++ ){

			draw( g2, eList.get(i) );
		}

		// 武器
		Character weapon = ((Player)player).getWeapon();
		if( weapon != null ){ draw( g2, weapon ); }

		// プレイヤーの描画
		draw( g2, player );

		// エフェクト描画
		for( int i=0; i<efList.size(); i++ ){

			draw( g2, efList.get(i) );
		}

		// UI描画
		for( int i=0; i<uiList.size(); i++ ){

			draw( g2, uiList.get(i) );
		}
	}

	private void draw( Graphics2D g2, Character c ){

		BufferedImage readImage = null;

		try{

			readImage = c.getImage();
		}catch( Exception e ){
			e.printStackTrace();
		}

		if( readImage == null )return;

		AffineTransform af = new AffineTransform();

		af.rotate(c.getRotate() * Math.PI / 180, c.getPos().x + c.getScale().x / 2, c.getPos().y + c.getScale().y / 2);
		g2.setTransform(af);

		int posx = (int)c.getPos().x;
		int posy = (int)c.getPos().y;
		int scalex = (int)c.getScale().x + posx;
		int scaley = (int)c.getScale().y + posy;
		int resizex1 = (int)c.getReSize().x - (int)c.getFirstReSize().x;
		int resizey1 = (int)c.getReSize().y - (int)c.getFirstReSize().y;
		int resizex2 = (int)c.getReSize().x;
		int resizey2 = (int)c.getReSize().y;

		if( c.getDirection() == Define.DIRECTION_RIGHT ){

			posx += (int)c.getScale().x;
			scalex = (int)c.getPos().x;
		}

		if( c.getInvinciblyTimer() > 0 && c.getInvinciblyTimer() % 2 == 0 ){
			posx =0;
			scalex = 0;
		}

		g2.drawImage(
				readImage,
				posx, posy,
				scalex, scaley,
				resizex1, resizey1,
				resizex2, resizey2,
				mApp );
	}

	// 背景描画
	private void drawBack( Graphics g ){

		Graphics2D g2 = (Graphics2D)g;

		g2.setBackground(Color.DARK_GRAY);
		g2.clearRect(0, 0, Define.WINDOW_X, Define.WINDOW_Y);

	}
}
