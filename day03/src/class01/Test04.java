package class01;

public class Test04 {

	public static void main(String[] args) {
		// �л� n��
		// �� ���� ��
		// �������
		// 1���� ���?
		
		int [] stu = new int[5];
		
		stu[0]=10;
		stu[1]=70;
		stu[2]=52;
		stu[3]=80;
		stu[4]=100;
		
		//
		System.out.println("====== �л� ��� ======");
		for(int i=0; i<stu.length; i++){
			System.out.println("�л�"+(i+1)+"���� "+stu[i]+"���Դϴ�.");
		}
		System.out.println("�л� ���");
		
		//����
		int sum=0;
		for(int i=0; i<stu.length; i++){
			sum+=stu[i];
		}
		System.out.println("������"+sum+"���Դϴ�.");
		
		//���
		double avg=sum*1.0/stu.length;	//sum�� int���� double Ÿ������ ����ȯ(casting)
		System.out.println("�����"+avg+"���Դϴ�.");
		
		//�ִ밪
		int max=stu[0];
		int maxIdex=0;
		for(int i=0; i<stu.length; i++){
			max = max<stu[i] ? stu[i] : max;
			maxIdex = max<stu[i] ? i : maxIdex;
			
//			if(max<stu[i]) {
//				max=stu[i]
//				maxIdex = i
//			}
		}
		System.out.println("1���� �л��� "+maxIdex+"�� �л��̸� 1���� ������ "+max+"���Դϴ�.");
	}
}
