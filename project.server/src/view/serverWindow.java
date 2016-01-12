package view;
import java.util.HashMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class serverWindow extends BasicWindow {
		
	public serverWindow(String title, int width, int height) {
		super(title, width, height);
		
	}

	Table clientsTable;
	HashMap<Integer, TableItem> clientRows;
	private MenuItem exitMenuItem;
	private Text connectedClientsText;
	private Text statusText;
	private MenuItem editPropertiesMenuItem;
	private MenuItem importPropertiesMenuItem;
	private MenuItem exportPropertiesMenuItem;
	
	/**
	 * Initialize the server window
	 */
	public serverWindow() {
		super("Maze Server", 400, 200);
		clientRows = new HashMap<Integer, TableItem>();
	}

	@Override
	void initWidgets() {
		initMenu();
		
		shell.setLayout(new GridLayout(2, false));
		
		clientsTable = new Table(shell, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
		clientsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		clientsTable.setHeaderVisible(true);
		
		new TableColumn(clientsTable, SWT.CENTER).setText("Client #");
		new TableColumn(clientsTable, SWT.NONE).setText("IP");
		new TableColumn(clientsTable, SWT.NONE).setText("Port");
		for(TableColumn column : clientsTable.getColumns())
			column.pack();
		

		
		Group statsGroup = new Group(shell, SWT.NONE);
		statsGroup.setText("Stats");
		statsGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true));
		statsGroup.setLayout(new GridLayout(2, false));
		
		new Label(statsGroup, SWT.NONE).setText("Status: ");
		statusText = new Text(statsGroup, SWT.READ_ONLY);
		statusText.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false));
		statusText.setText("Running");
		
		new Label(statsGroup, SWT.NONE).setText("Connected clients: ");
		connectedClientsText = new Text(statsGroup, SWT.READ_ONLY);
		connectedClientsText.setLayoutData(new GridData(SWT.FILL, SWT.NONE, false, false));
		connectedClientsText.setText("0");
		

		

	
		

		
	
	}
	
	private void initMenu() {
		Menu menu = new Menu(shell, SWT.BAR);
		
		MenuItem fileMenuItem = new MenuItem(menu, SWT.CASCADE);
		fileMenuItem.setText("File");
		
		Menu fileMenu = new Menu(shell, SWT.DROP_DOWN);
		fileMenuItem.setMenu(fileMenu);
		
		editPropertiesMenuItem = new MenuItem(fileMenu, SWT.PUSH);
		editPropertiesMenuItem.setText("Properties");
		
		importPropertiesMenuItem = new MenuItem(fileMenu, SWT.PUSH);
		importPropertiesMenuItem.setText("Import properties");
		
		exportPropertiesMenuItem = new MenuItem(fileMenu, SWT.PUSH);
		exportPropertiesMenuItem.setText("Export properties");
		
		new MenuItem(fileMenu, SWT.SEPARATOR);
		
		exitMenuItem = new MenuItem(fileMenu, SWT.PUSH);
		exitMenuItem.setText("Exit");
		
		shell.setMenuBar(menu);
	}

	/**
	 * Add a listener to handle user requests to close the server
	 * @param listener Listener
	 */
	public void addExitListener(Listener listener) {
		shell.addListener(SWT.Close, listener);
		exitMenuItem.addListener(SWT.Selection, listener);
	}
	
	/**
	 * Add a listener to handle user requests to edit the game properties
	 * @param listener Listener
	 */
	public void addEditPropertiesListener(SelectionListener listener) {
		editPropertiesMenuItem.addSelectionListener(listener);
	}
	
	/**
	 * Add a listener to handle user requests to import game properties
	 * @param listener Listener
	 */
	public void addImportPropertiesListener(SelectionListener listener) {
		importPropertiesMenuItem.addSelectionListener(listener);
	}
	
	/**
	 * Add a listener to handle user requests to export the current game properties
	 * @param listener Listener
	 */
	public void addExportPropertiesListener(SelectionListener listener) {
		exportPropertiesMenuItem.addSelectionListener(listener);
	}
	
//	public void addDisconnectSelectionListener(SelectionListener listener) {
//		disconnectMenuItem.addSelectionListener(listener);
//	}
	
	/**
	 * Add a new client to the clients list
	 * @param client Client data
	 */
//	public void addClient(Client client) {
//		display.syncExec(new Runnable() {
//			@Override
//			public void run() {
//				TableItem clientRow = new TableItem(clientsTable, SWT.NONE);
//				clientRow.setText(0, ""+client.getId());
//				setClientRow(clientRow, client);
//				clientRows.put(client.getId(), clientRow);
//			}
//		});
//	}
	
	/**
	 * Remove a client ftom the clents list
	 * @param clientId Client id
	 */
//	public void removeClient(int clientId) {
//		display.syncExec(new Runnable() {
//			@Override
//			public void run() {
//				TableItem clientRow = clientRows.remove(clientId);
//				if(clientRow != null) {
//					clientsTable.remove(clientsTable.indexOf(clientRow));
//					for(TableColumn column : clientsTable.getColumns())
//						column.pack();
//				}
//			}
//		});
//	}

	/**
	 * Update an existing client from the clients list
	 * @param client Updated client data
	 */
//	public void updateClient(Client client) {
//		setClientRow(clientRows.get(client.getId()), client);
//	}
//	
//	private void setClientRow(TableItem clientRow, Client client) {
//		display.syncExec(new Runnable() {
//			@Override
//			public void run() {
//				clientRow.setText(1, ""+client.getPending());
//				clientRow.setText(2, ""+client.getSolving());
//				clientRow.setText(3, ""+client.getNoSolution());
//				clientRow.setText(4, ""+client.getSolved());
//				for(TableColumn column : clientsTable.getColumns())
//					column.pack();
//			}
//		});
//	}
//
//	/**
//	 * Inform the user that the server is shutting down
//	 */
//	public void displayShuttingDown() {
//		display.syncExec(new Runnable() {
//			@Override
//			public void run() {
//				statusText.setText("Shutting Down...");
//			}
//		});
//	}
//
//	/**
//	 * Update server statistics
//	 * @param serverStats Updated server statistics
//	 */
//	public void updateServerStats(ServerStats serverStats) {
//		display.syncExec(new Runnable() {
//			@Override
//			public void run() {
//				connectedClientsText.setText(""+serverStats.getConnected());
//				pendingRequestsText.setText(""+serverStats.getPending());
//				solvingText.setText(""+serverStats.getSolving());
//				NoSolutionText.setText(""+serverStats.getNoSolution());
//				solvedText.setText(""+serverStats.getSolved());
//				cachedText.setText(""+serverStats.getCached());
//			}
//		});
//	}
	public static void main(String[] args) {
		serverWindow sw = new serverWindow();
		sw.run();
	}


}
