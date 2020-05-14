package ui;

import java.io.File;
import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.AlgorithmsRace;
import thread.AlgorithmsThread;
import thread.ChronometerThread;
import thread.PrepareRaceThread;
import thread.ProgressRaceThread;

public class AlgorithmsRaceGUI {
	
	private AlgorithmsThread arrayListThread;
	private AlgorithmsThread linkedListThread;
	private AlgorithmsThread binaryTreeThread;
	
	private Stage window;
	private String time;
	private String timeAL;
	private String timeLE;
	private String timeAbb;
	private AlgorithmsRace algorithmsRace;
	
	private boolean isRunning;
	private boolean move;
	private boolean arrayListRunning,linkedListRunning,binaryTreeRunning;
	
	private Image imageAL;
	private Image imageLE;
	private Image imageAbb;
	private Image waiting;
	
	public final static File ARRAY_LIST = new File("data/imgs/NARUTO.gif");
	public final static File LINKED_LIST = new File("data/imgs/JOJOS.gif");
	public final static File ABB = new File("data/imgs/DBZ.gif");
	public final static File WAITING = new File("data/imgs/WAITING.gif");
	
	public final static String GOKU_WIN = "Tus niveles de energía disminuyen con cada golpe, de hecho, ya no eres un reto para mí";
	public final static String GOKU_LOSE="Ok, ahora al plan B, sea lo que sea";
	public final static String GOKU_SURRENDER="Esto es mi culpa, ¡maldición! Freezer tenía razón sobre mí. Debí acabarlo cuando tuve la oportunidad";
	
	public final static String NARUTO_WIN="El trabajo duro es inútil para aquellos que no creen en sí mismos";
	public final static String NARUTO_LOSE="Un verdadero héroe siempre llega tarde";
	public final static String NARUTO_SURRENDER="Fracasar no te da una razón para renunciar mientras tengas fe";
	
	public final static String DIO_WIN="El tiempo no espera a nadie";
	public final static String DIO_LOSE="Algún día no perderé contra nadie";
	public final static String DIO_SURRENDER="Si algo he aprendido en mi corta vida, es que mientras más planes haces, más posibilidades hay de que fallen";
	
	public AlgorithmsRaceGUI(AlgorithmsRace ar,Stage win) {
		window = win;
		algorithmsRace =ar;
		time = "";
		timeAL="";
		timeLE="";
		timeAbb="";
		
		isRunning = false;
		move = true;
		arrayListRunning=false;
		linkedListRunning=false;
		binaryTreeRunning=false;
		
		imageAL = new Image(ARRAY_LIST.toURI().toString());
		imageLE = new Image(LINKED_LIST.toURI().toString());
		imageAbb = new Image(ABB.toURI().toString());
		waiting = new Image(WAITING.toURI().toString());
	}
	
	public void initialize() throws IOException {
		if(arrayListImage!=null) {
			arrayListImage.setImage(imageAL);
			linkedListImage.setImage(imageLE);
			abbImage.setImage(imageAbb);
			waitingGIF.setImage(waiting);
			arrayListTime.setText(timeAL);
			linkedListTime.setText(timeLE);
			abbTime.setText(timeAbb);
		}else {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartFX.fxml"));
			fxmlLoader.setController(this);
			Pane pane = fxmlLoader.load();
			
			mainPane.getChildren().clear();
			mainPane.setCenter(pane);
		}
		
		window.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				isRunning = false; 
				algorithmsRace.setOn(false);
				System.out.println("Closing the window!");
			}
		});
	}
	
	//Main
	@FXML
	private BorderPane mainPane;
	
	//Start
    @FXML
    private Button btnViewRace;

    @FXML
    private ImageView waitingGIF;
    
    @FXML
    private TextField textN;

    @FXML
    private CheckBox addSelect;

    @FXML
    private CheckBox searchSelect;

    @FXML
    private CheckBox delateSelect;

    @FXML
    private CheckBox iterativeSelect;

    @FXML
    private CheckBox recursiveSelect;

    @FXML
    private Button btnRun;
    
    @FXML
    private Button btnPrepare;

    @FXML
    private Label arrayListTime;

    @FXML
    private Label linkedListTime;

    @FXML
    private Label abbTime;

    @FXML
    private Label timer;

    @FXML
    private Circle bigCircule;

    @FXML
    private Circle littleCircule;

    @FXML
    private ProgressBar loadingProgress;

    @FXML
    private Label labelLoading;

    @FXML
    private ImageView arrayListImage;

    @FXML
    private ImageView linkedListImage;

    @FXML
    private ImageView abbImage;
    
    //ViewRace.fxml
    @FXML
    private ProgressBar arrayListProgress;

    @FXML
    private ProgressBar linkedListProgress;

    @FXML
    private ProgressBar abbProgress;

    @FXML
    private Button btnBack;

    @FXML
    private Label arrayListText;

    @FXML
    private Label linkedListText;

    @FXML
    private Label abbText;

    
    ///////////////////////////////////////////////////////////////////////////////
    //StartFX.fxml
    ///////////////////////////////////////////////////////////////////////////////
    @FXML
    void btnViewRace(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewRaceFX.fxml"));
    	fxmlLoader.setController(this);
    	Pane pane = fxmlLoader.load();
    	
    	mainPane.getChildren().clear();
    	mainPane.setCenter(pane);
    }

    @FXML
    void iterativeSelect(ActionEvent event) {
    	if(iterativeSelect.isSelected()) {
    		recursiveSelect.setSelected(false);
    	}
    	buttons();
    }

    @FXML
    void recursiveSelect(ActionEvent event) {
    	if(recursiveSelect.isSelected()) {
    		iterativeSelect.setSelected(false);
    	}
    	buttons();
    }

    @FXML
    void addSelect(ActionEvent event) {
    	if(addSelect.isSelected()) {
    		searchSelect.setSelected(false);
    		delateSelect.setSelected(false);
    	}
    	buttons();
    }

    @FXML
    void delateSelect(ActionEvent event) {
    	if(delateSelect.isSelected()) {
    		searchSelect.setSelected(false);
    		addSelect.setSelected(false);
    	}
    	buttons();
    }

    @FXML
    void searchSelect(ActionEvent event) {
    	if(searchSelect.isSelected()) {
    		delateSelect.setSelected(false);
    		addSelect.setSelected(false);
    	}
    	buttons();
    }
    
    @FXML
    void btnPrepare(ActionEvent event) throws InterruptedException {
    	try {
        	PrepareRaceThread preparing = new PrepareRaceThread(this,algorithmsRace,Long.parseLong(textN.getText()));
        	
        	/////////////////////////////////////////////////////////////////////////////////////////////////////
        	isRunning=true;
        	waitingGIF.setVisible(true);
        	btnPrepare.setDisable(true);
        	addSelect.setDisable(true);
        	searchSelect.setDisable(true);
        	delateSelect.setDisable(true);
        	iterativeSelect.setDisable(true);
        	recursiveSelect.setDisable(true);
        	loadingProgress.setVisible(true);
        	labelLoading.setVisible(true);
        	time = "00:00:00";
        	timeAL =time;
        	timeLE =time;
        	timeAbb=time;
        	updateTimerAL();
        	updateTimerLE();
        	updateTimerAbb();
        	//////////////////////////////////////////////////////////
        	if(!addSelect.isSelected()) {
        		preparing.start();
        		new Thread() {
        			public void run() {
        				while(isRunning) {
        					Platform.runLater(new Thread() {
            					public void run() {
            						updateProgress();
            					}
            				});
        					try {
    							Thread.sleep(10);
    						} catch (InterruptedException e) {
    							e.printStackTrace();
    						}
        				}
        				
        			}
        		}.start();
        	}else {
        		eneableStart();
        	}
        	
        	
    	}catch(NumberFormatException e) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Error in format");
    		alert.setHeaderText("Please type only numbers");
    		alert.showAndWait();
    	}
    	
    }
    
    @FXML
    void btnRun(ActionEvent event) throws InterruptedException {
    	
    	btnViewRace.setVisible(true);
    	btnRun.setDisable(true);
    	btnRun.setVisible(false);
    	arrayListRunning =true;
    	linkedListRunning = true;
    	binaryTreeRunning = true;
    	
    	int algorithm = addSelect.isSelected()?1:searchSelect.isSelected()?2:3;
    	int mode = iterativeSelect.isSelected()?1:2;
    	long n = Long.parseLong(textN.getText());
    	ChronometerThread timer = new ChronometerThread(this);
    	arrayListThread = new AlgorithmsThread(this,algorithmsRace,algorithm,mode,1,n);
    	linkedListThread = new AlgorithmsThread(this,algorithmsRace,algorithm,mode,2,n);
    	binaryTreeThread = new AlgorithmsThread(this,algorithmsRace,algorithm,mode,3,n);
    	ProgressRaceThread progresALThread = new ProgressRaceThread(this,1);
    	ProgressRaceThread progresLEThread = new ProgressRaceThread(this,2);
    	ProgressRaceThread progresAbbThread = new ProgressRaceThread(this,3);
    	
    	isRunning = true;
    	/////////////////////////////////////////////////////////////
    	timer.start();
  
    	arrayListThread.start();
    	linkedListThread.start();
    	binaryTreeThread.start();
    	
    	progresALThread.start();
    	progresLEThread.start();
    	progresAbbThread.start();
    	////////////////////////////////////////////////////////////
    	new Thread() {
    		public void run() {
    			while(isRunning) {
    				
    				Platform.runLater(new Thread() {
    					public void run() {
    						if(!arrayListThread.isAlive()) {
            	    			if(arrayListRunning) {
            	    				surrenderAL();
            	    			}
            	    		}
            	    		if(!linkedListThread.isAlive()) {
            	    			if(linkedListRunning) {
            	    				surrenderLE();
            	    			}
            	    		}
            	    		if(!binaryTreeThread.isAlive()) {
            	    			if(binaryTreeRunning) {
            	    				surrenderAbb();
            	    			}
            	    		}
            	    		finishRun();
    					}
    					
    				});
    				try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
    	    		
    	    	}
    		}
    	}.start();
    }
    
    //////////////////////////////////////////////////////////////////////
    //ViewRace.fxml
    //////////////////////////////////////////////////////////////////////
    @FXML
    void btnBack(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartFX.fxml"));
    	fxmlLoader.setController(this);
    	Pane pane = fxmlLoader.load();
    	
    	mainPane.getChildren().clear();
    	mainPane.setCenter(pane);
    	if(isRunning) {
    		btnViewRace.setVisible(true);
    		btnPrepare.setDisable(true);
        	addSelect.setDisable(true);
        	searchSelect.setDisable(true);
        	delateSelect.setDisable(true);
        	iterativeSelect.setDisable(true);
        	recursiveSelect.setDisable(true);
        	loadingProgress.setVisible(true);
    	}
    }
    
    public void  eneableStart() {
    	loadingProgress.setVisible(false);
    	labelLoading.setVisible(false);
    	isRunning=false;
    	waitingGIF.setVisible(false);
    	btnRun.setVisible(true);
    }
    
    public void finishRun() {
    	if(!arrayListRunning&&!linkedListRunning&!binaryTreeRunning) {
    		isRunning = false;
    		btnRun.setDisable(false);
    		btnViewRace.setVisible(false);
        	btnPrepare.setDisable(false);
        	addSelect.setDisable(false);
        	searchSelect.setDisable(false);
        	delateSelect.setDisable(false);
        	iterativeSelect.setDisable(false);
        	recursiveSelect.setDisable(false);
        	if(arrayListText!=null) {
        		arrayListText.setText("");;
        		linkedListText.setText("");
        		abbText.setText("");
        	}
    	}else {
    		if(!arrayListRunning&&linkedListRunning&&binaryTreeRunning) {
    			if(arrayListText!=null) {
    				arrayListText.setText(NARUTO_WIN);
    				linkedListText.setText(DIO_LOSE);
    				abbText.setText(GOKU_LOSE);
    			}
    		}else if(arrayListRunning&&!linkedListRunning&&binaryTreeRunning) {
    			if(linkedListText!=null) {
    				linkedListText.setText(DIO_WIN);
    				arrayListText.setText(NARUTO_LOSE);
    				abbText.setText(GOKU_LOSE);;
    			}
    			
    		}else if(arrayListRunning&&linkedListRunning&&!binaryTreeRunning) {
    			if(abbText!=null) {
    				abbText.setText(GOKU_WIN);
    				arrayListText.setText(NARUTO_LOSE);
    				linkedListText.setText(DIO_LOSE);
    			}
    		}
    	}
    	
    }
    
    
    
    public void setArrayListRunning(boolean arrayListRunning) {
		this.arrayListRunning = arrayListRunning;
	}

	public void setLinkedListRunning(boolean linkedListRunning) {
		this.linkedListRunning = linkedListRunning;
	}

	public void setBinaryTreeRunning(boolean binaryTreeRunning) {
		this.binaryTreeRunning = binaryTreeRunning;
	}

	public void buttons() {
  
    	if(iterativeSelect.isSelected() || recursiveSelect.isSelected()) {
    		if(addSelect.isSelected()||searchSelect.isSelected()||delateSelect.isSelected()) {
    			btnPrepare.setDisable(false);
    		}else {
    			btnPrepare.setDisable(true);
    		}
    	}else {
    		btnPrepare.setDisable(true);
    	}
    }
    
    public void updateTime(int m,int s,int cs) {
    	String time="";
    	if(cs<10) {
    		time = "0"+ Integer.toString(cs);
    	}else {
    		time = Integer.toString(cs);
    	}
    	if(s<10) {
    		time = "0"+ Integer.toString(s)+":"+time;
    	}else {
    		time = Integer.toString(s)+":"+time;
    	}
    	if(m<10) {
    		time = "0"+ Integer.toString(m)+":"+time;
    	}else {
    		time = Integer.toString(m)+":"+time;
    	}
    	this.time=time;
    }
    
    public void updateCircule() {
    	if(move) {
    		bigCircule.setRadius(bigCircule.getRadius()-1);
    		littleCircule.setRadius(littleCircule.getRadius()+1);
    	}else {
    		bigCircule.setRadius(bigCircule.getRadius()+1);
    		littleCircule.setRadius(littleCircule.getRadius()-1);
    	}
    	
    	if(littleCircule.getRadius()<bigCircule.getRadius()) {
    		littleCircule.toFront();
    	}else bigCircule.toFront();
    	
    	if(bigCircule.getRadius()>=45) {
    		move =true;
    	}else if(bigCircule.getRadius()<=5) {
    		move = false;
    	}
    }
    
    public void updateTimer() {
    	timer.setText(time);
    }
    
    public void updateTimerAL() {
    	timeAL = time;
    	arrayListTime.setText(time);
	}
    
    public void updateTimerLE() {
    	timeLE =time;
    	linkedListTime.setText(time);
    }
    
    public void updateTimerAbb() {
    	timeAbb = time;
    	abbTime.setText(time);
    }
    
    public void updateProgress() {
    	loadingProgress.setProgress(algorithmsRace.getProgress());
    }
    
    public void updateProgressAL() {
    	if(arrayListProgress!=null) {
    		arrayListProgress.setProgress(algorithmsRace.getArrayListProgress());
    	}
    	
    }
    
    public void updateProgressLE() {
    	if(linkedListProgress!=null){
    		linkedListProgress.setProgress(algorithmsRace.getLinkedListProgress());
    	}
    }
    
    public void updateProgressAbb() {
    	if(abbProgress!=null) {
    		abbProgress.setProgress(algorithmsRace.getBinaryTreeProgress());
    	}
    }
    
    public void surrenderAL() {
    	arrayListRunning = false;
    	arrayListTime.setText("SURRENDER");
    	if(arrayListText!=null) {
    		arrayListText.setText(NARUTO_SURRENDER);
    	}
    }
    
    public void surrenderLE() {
    	linkedListRunning = false;
    	linkedListTime.setText("SURRENDER");
    	if(linkedListText!=null) {
    		linkedListText.setText(DIO_SURRENDER);
    	}
    }
    
    public void surrenderAbb() {
    	binaryTreeRunning=false;
    	abbTime.setText("SURRENDER");
    	if(abbText!=null) {
    		abbText.setText(GOKU_SURRENDER);
    	}
    }

	public boolean isRunning() {
		return isRunning;
	}
    
}
