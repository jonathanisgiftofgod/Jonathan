package smalltask;

public class SecondClass extends FirstClass {
	public void secondClass1Method() {
		System.out.println("Second Class 1 Method");
	}
	public void secondClass2Method() {
		System.out.println("Second Class 2 Method");
	}
	public void secondClass3Method() {
		System.out.println("Second Class 3 Method");
	}
	@Override
	public void firstClass1Method() {
		System.out.println("override from first class");
	}
	public static void main(String[] args) {
		FirstClass f = new FirstClass();
		f.firstClass1Method();
		f.firstClass2Method();
		f.firstClass3Method();
		
		SecondClass s = new SecondClass();
		s.secondClass1Method();
		s.secondClass2Method();
		s.secondClass3Method();
		
		//when we use extends
		FirstClass f1 = new SecondClass();
		f1.firstClass1Method();
		f1.firstClass2Method();
		f1.firstClass3Method();
		
		SecondClass s1 = (SecondClass) new FirstClass();
		s1.firstClass1Method();
		s1.firstClass2Method();
		s1.firstClass3Method();
		s1.secondClass1Method();
		s1.secondClass2Method();
		s1.secondClass3Method();
	}
}
