package gui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class StatisticsPanel extends JPanel {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatisticsPanel() {
	        // This method is invoked on the EDT thread
	       
	        final JFXPanel fxPanel = new JFXPanel();
	        
	        

	        add(fxPanel);
	        setVisible(true);
	        initFX(fxPanel);
	         
	    }

	    private static void initFX(JFXPanel fxPanel) {
	        // This method is invoked on the JavaFX thread
	        Scene scene = createScene();
	        fxPanel.setScene(scene);
	    }

	    private static Scene createScene() {
	       
	    	  Group  root  =  new  Group();
	          Scene  scene  =  new  Scene(root, Color.ALICEBLUE);
	          Text  text  =  new  Text();
	          
	          text.setX(100);
	          text.setY(100);
	          text.setFont(new Font(25));
	          text.setText("Welcome JavaFX!");
	          text.setVisible(true);

	          root.getChildren().add(text);

	          
	          return (scene);
	      
	    }
	    
}
