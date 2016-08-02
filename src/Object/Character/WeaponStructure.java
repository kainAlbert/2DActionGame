package Object.Character;

import Application.GSvector2;

public class WeaponStructure {

	public String mFileName;
	public int mPower;
	public GSvector2 mRange;
	public double mScale;

	public WeaponStructure( String fileName, int power, GSvector2 range, double scale ){

		mFileName = fileName;
		mPower = power;
		mRange = range;
		mScale = scale;
	}
}
