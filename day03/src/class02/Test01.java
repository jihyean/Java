package class02;

import java.util.Random;

public class Test01 {
	public static void main(String[] args) {
		//N���� ������
		//�������� 1~10 ����
		//������ ��� ���
		//��պ��� ���� �� ����, ���Ŀ� ���
		
		//Random ����
		//N����
		//N����ŭ ������
		//����--->���
		//��պ��� ���� �� ���� ���� ����
		//������ �� ����
		//���
		
		Random rand = new Random();
		int N = rand.nextInt(10)+1;
		System.out.println("N: "+N);
		//rand.nextInt(101) --->>0~100
		//rand.nextInt(10) --->>1~10
		
		//[3]
		//�迭�� ���� �ʹ�
		// : �迭�� 3��Ҹ� ���� ��밡��
		
		int[] data = new int[N];
		for(int i =0; i<data.length; i++) {
			data[i]=rand.nextInt(10)+1;
		}
		
		int sum =0;
		for(int i=0; i<data.length; i++) {
			//��ü �л����� ���� ����
			sum+=data[i];
		}
		for(int v : data) { //���� for��
			System.out.println("������: "+v);
		}
		System.out.println("����: "+sum);
		
		double avg =sum*1.0/data.length;
		System.out.println("���: "+avg);
		
		//[5]��պ��� ������
		//a����, bȮ�� �� �迭 ����--->>��պ��� ���� ���� ��ϱ�
		
		int num=0;
		for(int v : data) { //���� for��
			if(v>avg) {//��պ��� ���� ������ �?
				num++;
			}
		}
		System.out.println("��պ��� ���� ������ : "+num+"��");//b�Ϸ�
		
		int[] data2= new int[num]; //��պ��� ���� ���� ������ ���� ���� �Ϸ�
		
		int j =0;//data2 �迭�� ���� �ε���
		for(int i=0; i<data.length; i++) {
			if(data[i]>avg) {
				data2[j++]=data[i];
				//-->data[i]�� data2[j]�� �Է��ϰ� j�� ��ĭ �̵�(�� ����)
			}
		}
		//[7]
		System.out.print("��պ��� ū ����");
		for(int v:data2) {
			System.out.print(v+" ");
		}
		System.out.print("�Դϴ�.");
	}
}
