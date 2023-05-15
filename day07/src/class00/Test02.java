package class00;

import java.util.Random;

class Student {
	Random rand = new Random();

	String name;
	int[] score;
	double avg;
	char grade;

	Student(String name) {
		this(name, 2);
	}

	Student(String name, int N) {
		this.score = new int[N];
		this.name = name;

		int sum = 0;
		for (int i = 0; i < N; i++) {
			this.score[i] = rand.nextInt(101);
			sum += this.score[i];
		}
		this.avg = (sum * 1.0) / this.score.length;

		if (this.avg >= 80) {
			this.grade = 'A';
		} else if (this.avg >= 60 && this.avg < 80) {
			this.grade = 'B';
		} else {
			this.grade = 'C';
		}

		System.out.println(name + "는 시험을 " + N + "번 봅니다");

	}

	void printInfo() {
		System.out.println(name);
		for (int i = 0; i < this.score.length; i++) {
			System.out.println((i + 1) + "번 시험 " + this.score[i] + "점");
		}
		System.out.println("평균 " + avg + "점 [" + this.grade + "]");
	}

	void test() {
		int sum = 0;
		for (int i = 0; i < this.score.length; i++) {
			this.score[i] = rand.nextInt(101);
			sum += this.score[i];
		}
		this.avg = (sum * 1.0) / this.score.length;

		if (this.avg >= 80) {
			this.grade = 'A';
		} else if (avg >= 60 && avg < 80) {
			this.grade = 'B';
		} else {
			this.grade = 'C';
		}

		// this(name, score.length);
		System.out.println(this.name + "가 재시험을 봅니다");
	}
}

public class Test02 {

	public static void main(String[] args) {

		Student student1 = new Student("럭스");
		Student student2 = new Student("유미", 4);

		student1.printInfo();
		student2.printInfo();

		student1.test();
		student1.printInfo();

	}

}