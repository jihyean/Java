package model;

import java.util.ArrayList;

// DAO�� CRUD(����Ͻ� �޼���,�ٽ� ����)��
// � �߰� ��û���׿��� ����!
// "�޼��� �ñ״�ó"�� �������ʵ��� �ڵ带 �ۼ��ؾ���!!!!!

// "�޼��� �ñ״�ó"�� ����Ǹ� �ٸ� ��Ʈ�� ������ �����...
// '���' ������ ����

// ���) "�޼��� �ñ״�ó"�� ����ܰ迡�� ����� ����Ǹ� �ȵ�!!!!!!!!!!
public class DrinkDAO {

	private static int PK=1001;
	private ArrayList<DrinkVO> datas;
	public DrinkDAO() {
		datas=new ArrayList<DrinkVO>();
		datas.add(new DrinkVO(PK++,"�ݶ�",1200,3));
		datas.add(new DrinkVO(PK++,"���̴�",900,2));
		datas.add(new DrinkVO(PK++,"ȯŸ",1500,1));
	}

	public boolean insert(DrinkVO vo) {
		System.out.println("MODEL(DAO): vo: "+vo);
		datas.add(new DrinkVO(PK++,vo.getName(),vo.getPrice(),vo.getCnt()));
		return true;
	}

	public ArrayList<DrinkVO> selectAll(DrinkVO vo) {
		if(vo.getName()==null) {
			return datas;
		}
		else {
			ArrayList<DrinkVO> datas=new ArrayList<DrinkVO>();
			for(DrinkVO data:this.datas) {
				if(data.getName().contains(vo.getName())) {
					datas.add(data);
				}
			}				
			return datas;
		}
	}
	public DrinkVO selectOne(DrinkVO vo) { // PK
		for(DrinkVO data:datas) {
			if(data.getNum()==vo.getNum()) {
				DrinkVO dVO=new DrinkVO(data.getNum(),data.getName(),data.getPrice(),data.getCnt());				
				return dVO;
				// ���� DB ������(==datas)�� ���� xxxxx
				// ���� vo��ü�� new(��üȭ)�ؼ� ���� O
			}
		}
		System.out.println(" �α�: selectOne(): �ش��ǰ����");
		return null;
	}

	// �����ε��� �Ұ����� ����� ���,
	// ����� �ſ� ������ ���̱⶧���� ���� �������� �и��Ͽ� ����
	// -> ������ ��ɳ����� ��� �����ϴ� ���� �����ϱ� ����
	//    == �������� ���� -> ���������� ����
	public boolean update(DrinkVO vo) {
		for(DrinkVO data:datas) {
			if(data.getNum()==vo.getNum()) {
				// �����Ҷ����� ���밪�̶� �� ���� ��
				if(vo.getCnt()<0) { // �����Ҷ�
					int cnt=vo.getCnt()*(-1); // �����Ϸ��� ��
					if(cnt>data.getCnt()) {
						System.out.println(" �α�: update(): ������");
						return false;
					}
				}
				data.setCnt(data.getCnt()+vo.getCnt());
				System.out.println("data: "+data);
				return true;		
			}
		}
		System.out.println(" �α�: update(): �ش��ǰ����");
		return false;
	}

	public boolean delete(DrinkVO vo) {
		for(int i=0;i<datas.size();i++) {
			if(datas.get(i).getNum()==vo.getNum()) {
				datas.remove(i);
				return true;
			}
		}
		System.out.println(" �α�: delete(): �ش��ǰ����");
		return false;
	}














}
