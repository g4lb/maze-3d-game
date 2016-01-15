package view;

import java.net.Socket;
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

public class ServerGui extends CommonView {
	
	Table clientsTable;
	HashMap<Integer, TableItem> clientRows;
	private MenuItem exitMenuItem;
	private Text connectedClientsText;
	private Text statusText;
	private MenuItem editPropertiesMenuItem;
	private MenuItem importPropertiesMenuItem;
	private MenuItem exportPropertiesMenuItem;
	int numberOfClients;
	
	public ServerGui() {
	
	}
	
	@Override
	public void start() {
		new BasicWindow("Maze Server", 400, 200) {
			
			@Override
			void initWidgets() {
				
				
				
				
				clientRows = new HashMap<Integer, TableItem>();
				
				
				shell.setLayout(new GridLayout(2, false));
				
				clientsTable = new Table(shell, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);
				clientsTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
				clientsTable.setHeaderVisible(true);
				
				new TableColumn(clientsTable, SWT.CENTER).setText("Client #");
				new TableColumn(clientsTable, SWT.NONE).setText("IP");
				new TableColumn(clientsTable, SWT.NONE).setText("Port");
				for(TableColumn column : clientsTable.getColumns()){
					column.pack();
					column.setWidth(64);
				}

				
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

				
		}.run();
		
	}
	@Override
	public void stop() {
		
		
	}

	@Override
	public void addClient(final Socket socket) {
		clientsTable.getDisplay().syncExec(new Runnable() {
			@Override
			public void run() {
				TableItem clientRow = new TableItem(clientsTable, SWT.NONE);
				clientRows.put(socket.getPort(), clientsTable.getItem(numberOfClients));
				clientRow.setText(0, ""+numberOfClients);
				clientRow.setText(1, socket.getInetAddress().toString());
				Integer p = socket.getPort();
				clientRow.setText(2, p.toString());
			}
		});
	}
	public void countClient(int x) {
		this.numberOfClients = x;
		final Integer y = numberOfClients;
		statusText.getDisplay().syncExec(new Runnable() {
			
			@Override
			public void run() {
				connectedClientsText.setText(y.toString());
			}
		});
		
	}
	@Override
	public void removeClient(final Socket socket) {
	clientsTable.getDisplay().syncExec(new Runnable() {
			
			@Override
			public void run() {
				TableItem clientRow = clientRows.remove(socket.getPort());
				if(clientRow != null) {
					clientsTable.remove(clientsTable.indexOf(clientRow));
					for(TableColumn column : clientsTable.getColumns())
						column.pack();
					
				}
			}
		});
	}

}
