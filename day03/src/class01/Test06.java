package class01;

import java.util.Random;
//�ڵ�����Ʈ(ctrl+shift+o)

public class Test06 {

	public static void main(String[] args) {
		
		//�迭 ����
		int[] stu = new int[6];
		
		//���� ���� ������
		Random rand = new Random();
		
		for(int i=0; i<stu.length;i++) {
			stu[i]=rand.nextInt(101);//0~100
			System.out.print(stu[i]+ " ");
		}
		System.out.println();
		
		//�л����� ���� ������ �Է�
//		stu[0]=29;
//		stu[1]=99;
//		stu[2]=30;
//		stu[3]=22;
//		stu[4]=87;
//		stu[5]=57;
		
		
		//1. ���
		int sum = 0;
		for(int i=0; i<stu.length; i++) {
			//��ü �л����� ���� ����
			sum+=stu[i];
		}
		double avg =sum*1.0/stu.length;
		
		//2.��� �ѱ� �л� ��
		//5. ��� �� �ѱ� �л����� ��ȣ--->������ ���� ���ϴ� ����: ����� ���ѱ��� �𸣱� ����
		//	:���� ���� ũ�� �����ϴ¹� --->����ũ ����
		//	:���߿� �迭 ����
		int num=0;
		for(int i=0; i<stu.length; i++) {
			if(stu[i]>avg) {
				num++;
			}
			else {
				System.out.println((i+1)+"�� �л��� ����� �ѱ��� ���߽��ϴ�.");
			}
		}
		System.out.println("����� �ѱ� �л� ���� "+num+"���Դϴ�.");
		
		//3. 6���� ��ȣ(�ּҰ� ã��)
		int min=stu[0];
		int minIndex=0;
		for(int i=0; i<stu.length; i++) {
			if(min>stu[i]) {
				min=stu[i];
				minIndex=i;
			}
		}
		System.out.println("6���� ��ȣ�� "+(minIndex+1)+"���Դϴ�.");
		
		//4.¦����° �л����� ����
		int res=0;
		for(int i=0; i<stu.length; i++) {
			if(i%2!=0) {
				res+=stu[i];	
			}
		}
		System.out.println("¦����° �л����� ������ "+res+"���Դϴ�.");
	}

}
