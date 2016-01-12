package view;

public class ServerGui extends CommonView {
	
	serverWindow serverWindow;
	
	public ServerGui() {
		serverWindow = new serverWindow();
	}

	@Override
	public void start() {
		serverWindow.run();
		
	}

	@Override
	public void stop() {
		
		
	}

	@Override
	public void addClient() {
		// TODO Auto-generated method stub
		
	}

}
