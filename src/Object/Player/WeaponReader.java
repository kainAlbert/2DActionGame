package Object.Player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import Application.GSvector2;

public class WeaponReader {

	// 武器構造体を作成して返す
	public static WeaponStructure returnWeapon( int id ){

		BufferedReader br = null;

		try{
			File file = new File( "txt/weapon.txt" );
			br = new BufferedReader(new FileReader(file));

		}catch( FileNotFoundException e ){
			e.printStackTrace();
		}

		// 読み込んで返す
		return readText( br, id );
	}

	// テキストファイルの読み込み
	private static WeaponStructure readText( BufferedReader br, int id ){
		if( br == null ) return null;

		String str = "";
		String[] item = null;
		WeaponStructure weapon = null;

		// 同じIDが見つかるまで
		while( str != null ){

			try{
				str = br.readLine();

				item = str.split("\t");

				if( Integer.parseInt(item[0]) == id ) break;

				if( Integer.parseInt(item[0]) == -1 ) return null;

			}catch( Exception e ){}

		}

		weapon = new WeaponStructure(
				item[1],
				Integer.parseInt(item[2]),
				new GSvector2( Double.parseDouble(item[3]), Double.parseDouble(item[4]) ),
				Double.parseDouble( item[5] )
				);

		return weapon;
	}
}
