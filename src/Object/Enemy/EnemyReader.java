package Object.Enemy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import Application.GSvector2;

public class EnemyReader {

	// 敵構造体を作成して返す
	public static EnemyFactoryStructure returnEnemyFactoryStructure( int id ){

		BufferedReader br = null;

		try{
			File file = new File( "txt/enemy.txt" );
			br = new BufferedReader(new FileReader(file));

		}catch( FileNotFoundException e ){
			e.printStackTrace();
		}

		// 読み込んで返す
		return readText( br, id );
	}

	// テキストファイルの読み込み
	private static EnemyFactoryStructure readText( BufferedReader br, int id ){

		if( br == null ) return null;

		String str = "";
		String[] item = null;
		EnemyFactoryStructure eStr = null;

		// 同じIDが見つかるまで
		while( str != null ){

			try{
				str = br.readLine();

				item = str.split("\t");

				if( Integer.parseInt(item[0]) == id ) break;

				if( Integer.parseInt(item[0]) == -1 ) return null;

			}catch( Exception e ){}

		}

		eStr = new EnemyFactoryStructure(
				Integer.parseInt(item[0]),
				item[1],
				Integer.parseInt(item[2]),
				new GSvector2( Double.parseDouble(item[3]), Double.parseDouble(item[4]) ),
				item[5] == "1",
				Integer.parseInt(item[6]),
				Integer.parseInt(item[7]),
				Integer.parseInt(item[8]),
				Double.parseDouble(item[9])
				);

		return eStr;
	}
}
