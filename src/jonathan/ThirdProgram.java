package jonathan;

public class ThirdProgram {
	public static void main(String[] args) {
		String[] s = {" India  is  our         country"};
		for (String x : s) {
			System.out.println(x.replaceAll("\\s+", " "));
		}
	}
}
