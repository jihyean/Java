package class04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {

	public static void main(String[] args) {
		// 1. 파일 생성
		File file = new File("D:\\JHyun\\resource\\test.txt");
		try {
			file.createNewFile();
		} catch (IOException e) { // 외부요인 에러 때문에 강제
			e.printStackTrace();
		} finally {
			System.out.println("파일객체 생성 완료");
		}
		
		// 2. 파일 읽어오기
		try {
			FileInputStream fis = new FileInputStream("D:\\JHyun\\resource\\test.txt");
		
			int data; // 글자를 읽을때 char 가 아닌 int로 읽음
			try {
				while((data=fis.read())!=-1) { // 읽어 온 데이터가 -1일시 파일 끝(EOF)
					System.out.print((char)data);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println();
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			System.out.println("fis객체로 파일 읽어오기 완료");
		}
//		FileInputStream fis = new FileInputStream(file); //오버로딩

		// 3. 파일 작성하기
		try {
			FileOutputStream fos = new FileOutputStream("D:\\JHyun\\resource\\test.txt",true);
			
			fos.write(65);
			fos.write(97);
			
			fos.flush();
			fos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("fos 객체로 파일 작성하기 작업 완료");
		}
	}

}


































