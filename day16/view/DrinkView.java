package view;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import model.DrinkVO;

public class DrinkView {

	private static Scanner sc=new Scanner(System.in);

	public int tryCatch() {
		while(true) {
			try {
				System.out.print("�Է�) ");
				int action=sc.nextInt();

				return action;
			}
			catch(Exception e) {
				sc.nextLine();
				System.out.println("������ �Է����ּ���!");
			}
		}
	}

	public int printMenu() {
		System.out.println("=== �� �� �� ===");
		System.out.println("1. �����߰�");
		System.out.println("2. ���������");
		System.out.println("3. ���ᱸ��");
		System.out.println("4. ��������");
		System.out.println("5. ��������߰�");
		System.out.println("6. ����˻�"); // selectAll(2���̻�)
		System.out.println("7. ���α׷� ����");
		while(true) {
			int action=tryCatch();
			if(1<=action && action<=7) {
				return action; // "��ȿ�� �˻�" == ������� �Է°� �˻�
				// : ������� �Է°��� ���Ͽ� �ڷ���(Ÿ��),���� ���� Ȯ���ϴ� ��
			}
		}
	}

	public String getDrinkName() {
		System.out.print("�����̸� ");
		String name=sc.next();
		return name;
	}
	public int getDrinkCnt() {
		System.out.print("��������Է�) ");
		int cnt=sc.nextInt();
		return cnt;
	}
	public int getDrinkPrice() {
		System.out.print("���ᰡ���Է�) ");
		int price=sc.nextInt();
		return price;
	}

	public void printDrinkList(ArrayList<DrinkVO> datas) {
		if(datas.isEmpty()) {
			System.out.println("����� ���ᰡ �����ϴ�...");
			return;
		}
		
		for(DrinkVO v:datas) {
			System.out.println(v);
		}
	}

	public int getDrinkNum() {
		System.out.print("�����ȣ�Է�) ");
		int num=sc.nextInt();
		return num;
	}

	public void printTrue() {
		System.out.println("��û�Ͻ� ���񽺸� �Ϸ��߽��ϴ�.");
	}
	public void printFalse() {
		System.out.println("��û�Ͻ� ���񽺴� ���� �̿��� ��ƽ��ϴ�.");
		System.out.println("������ �ٽ� �̿����ֽñ� �ٶ��ϴ�.");
	}

	public void printEnd() {
		System.out.println("���α׷� ����...");
	}

}
