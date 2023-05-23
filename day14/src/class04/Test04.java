package class04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test04 {

	public static void main(String[] args) {
		final String path = "D:\\JHyun\\resource\\";
		final String fileName = "test.jpg";
		
		final String fileCopy = "test - 복사본.jpg";
		
		try {
			FileInputStream fis = new FileInputStream(path+fileName);
			FileOutputStream fos = new FileOutputStream(path+fileCopy);

			int data;
			byte[] buff = new byte[1000];
			while ((data = fis.read(buff)) != -1) {
				//System.out.println("확인");
				fos.write(buff,0,data);
			}
			
			fos.flush();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("사진 복사 완료");
		}

	}

}































