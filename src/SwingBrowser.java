import com.sun.javafx.application.PlatformImpl;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SwingBrowser extends JFXPanel
{
    public static void main (String[] args)
    {
        JFXPanel jfxPanel = new JFXPanel(); // Scrollable JCompenent
        PlatformImpl.runLater(() ->
        { // FX components need to be managed by JavaFX
            WebView webView = new WebView();
            //webView.getEngine().loadContent("<html> Hello World!");
            try
            {
                URL u = new File("site/testfile.xhtml").toURI().toURL();
                webView.getEngine().load(u.toString());
                jfxPanel.setScene(new Scene(webView));
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
        });

        JScrollPane scroll = new JScrollPane(jfxPanel);
        JFrame frame = new JFrame("Demo");
        frame.getContentPane().add(scroll);
        frame.pack();
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
}