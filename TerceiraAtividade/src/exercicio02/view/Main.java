package exercicio02.view;
import exercicio02.controller.ThreadId;

public class Main {
	public static void main(String[] args) {

		for (int id =0; id < 5; id ++) {
			Thread getThreadID = new ThreadId(id);
			getThreadID.start();
		}
	}
}