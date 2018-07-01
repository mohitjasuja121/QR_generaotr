package db;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import net.glxn.qrgen.image.ImageType;

public class Db {
	 ByteArrayOutputStream bout = null;
	public static ByteArrayOutputStream  Qr(String g){
		String s =g;
        ByteArrayOutputStream bout =
                net.glxn.qrgen.QRCode.from(s)
                        .withSize(250, 250)
                        .to(ImageType.PNG)
                        .stream();
        	return bout;
       



	}

}
