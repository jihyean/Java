package class01;

public class Test05 {
	public static void main(String[] args) {
		//�迭 ����
		int [] stu = new int[6];
		//�л����� ���� ������ �Է�
		stu[0]=29;
		stu[1]=99;
		stu[2]=30;
		stu[3]=22;
		stu[4]=87;
		stu[5]=57;
		
		int sum=0;
		int sum2=0;
		int min=stu[0];
		int minIndex=0;
		int count=0;
		double avg;
		for(int i=0; i<stu.length; i++) {
			//��ü �л����� ���� ����
			sum+=stu[i];
			
			//¦����° �л����� ���� ����
			if(i%2!=0) {
				sum2+=stu[i];	
			}
			
			//�õ� ���ϱ�
			if(min>stu[i]) {
				min=stu[i];
				minIndex=i;
			}
			
		}
		//���
		avg =sum*1.0/stu.length;
		
		//����� �Ѱ���� �� �л����� üũ
		for(int i =0; i<stu.length; i++) {
			if(avg<stu[i]) {
				count+=1;
			}
			else {
				System.out.println((i+1)+"�� �л��� ����� �ѱ��� ���߽��ϴ�.");
			}
		}
		
		System.out.println("�л����� ����� "+avg+"���Դϴ�.");
		System.out.println("����� �ѱ� �л� ���� "+count+"���Դϴ�.");
		System.out.println("6���� ��ȣ�� "+(minIndex+1)+"���Դϴ�.");
		System.out.println("¦����° �л����� ������ "+sum2+"���Դϴ�.");		
	}
	
 
}
