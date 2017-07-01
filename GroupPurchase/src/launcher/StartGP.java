package launcher;

public class StartGP {

	public static void main(String[] args) {
		new ServerLauncher().launch();
		
		new ClientLauncher().launch();
	}
}
