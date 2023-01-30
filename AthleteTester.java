public class AthleteTester {
	public static void main(String[] args) {

		Athlete one = new Wrestler("Bob", "Janek", "Wrestler");
		one.train(10);
		one.race(200);
		System.out.println(one);
		System.out.println();

		Athlete two = new Runner("Ted", "Collins", "Runner");
		two.train(5);
		two.race(12);
		two.race(5);
		System.out.println(two);
		System.out.println();

		Athlete three = new Marathoner("Edith", "Quinby", "Marathoner");
		three.train(15);
		three.race(26);
		three.race(20);
		three.race(2);
		three.race(8);
		System.out.println(three);
		System.out.println();
		}
}