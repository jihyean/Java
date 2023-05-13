package class06;

public class Test03 {

	public static void main(String[] args) {
		for(int a=0; a<3; a++) {//ÃÑ 3ÁÙÀÌ¹Ç·Î 3¹ø ¹Ýº¹ÇÑ´Ù
			
			for(int i=0; i<2-a; i++) {//°ø¹é Âï±â
				System.out.print(" ");
			}
			
			for(int b=0; b<a*2+1; b++) {//º° Âï±â ±Ùµ¥ È¦¼ö
				System.out.print("*");
				}
			System.out.println();
			}
		
		}	
	}

