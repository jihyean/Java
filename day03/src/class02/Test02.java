package class02;

import java.util.Random;

public class Test02 {
	public static void main(String[] args) {
		Random rand = new Random();			//���� ������
		int N = rand.nextInt(3)+3;			//3~5 ���� �� ����
		
		int[] data = new int[N];			//������ ���� �迭 ����
		int[] data2 = new int[N];

		//data �迭�� �ϼ��ɶ����� ����ϴ� ���
		int index = 0;	//������ġ�� ��Ÿ���� ����
		while(index<data.length) {
			data[index] = rand.nextInt(6)+100;	//���� �� ����
			
			//[ flag ] �˰���
			boolean flag =false; //�ʱ����
			
			//Ư���� ��(=������ �ߺ�)�� �߻��ϸ�
			for(int i=0; i<index; i++) {
				if(data[i]==data[index]) {
					flag = true;
				}
			}
			//�ߺ� ����
			if(flag) {
				continue;
			}
			index++;
		}
		
		//


		/*
		for(int i =0; i<data.length; i++) {
			
			data[i]=rand.nextInt(6)+100;	//100~105 ���� �� ����
			for(int k=0; k<i; k++) {		//�̹� ������ ��ŭ �� �ؾߵǼ� k<i�̴�
				if(data[i]==data[k]) {		//�ߺ� �˻� ����
					i--;					//�ߺ��� i--�ؼ� �ٽ� �����ϵ��� ��
				}
			}
		}
		*/
		
		int sum=0;	//Ȧ�� ����
		int sum2=0;	//¦�� ����
		int num=0;	//¦���� �ε��� ����
		for(int i=0; i<data.length; i++) {
			if(data[i]%2!=0) {		//Ȧ������ ��
				sum+=data[i];
			}
			else {					//¦������ ��
				sum2+=data[i];
				num++;
			}
		}
		
		double avg = sum2*1.0/num;	//¦���� ������ ���
		
		System.out.print("[");
		for(int v : data) { 		//���� for�� �������� ���
			System.out.print(" "+v+" ");
		}
		System.out.print("]");
		System.out.println();

		System.out.println("Ȧ�� ���� : "+sum);
		if(!(avg>0)) {				//��ȿ�� �˻�
			System.out.println("¦�� ��� : ¦���� �������� �ʾҽ��ϴ�");
		}
		else {
			System.out.println("¦�� ��� : "+avg);
		}

	}

}
