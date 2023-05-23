package class04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test02 {

	public static void main(String[] args) {
		// 파일 생성
		File file = new File("D:\\JHyun\\resource\\test01.txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 파일 읽기
		try {
			FileInputStream fis = new FileInputStream("D:\\JHyun\\resource\\test01.txt");
			int data;
			int even = 0;
			while ((data = fis.read()) != -1) {
				if (data % 2 == 0) {
					even = 1;
				}
				else {
					even = 0;
				}
			}
			if(even==1) {
				System.out.println("입력되어있는 정수는 짝수입니다.");
			}
			else {
				System.out.println("입력되어있는 정수는 홀수입니다.");
			}
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("fis객체로 파일 읽어오기 완료");
		}
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("D:\\JHyun\\resource\\test02.txt");
			for(int i = 97; i<123; i++) {
				fos.write(i);
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
			System.out.println("fos 객체로 파일 작성하기 작업 완료");
		}
		
		
		

	}

}




















