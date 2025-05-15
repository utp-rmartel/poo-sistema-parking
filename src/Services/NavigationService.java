/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;

/**
 *
 * @author Royss
 */
public class NavigationService {

    private JPanel pContent;
    
    public NavigationService() {     
    }
    
    public NavigationService(JPanel pContent) {
        this.pContent = pContent;
    }
    
    public void navigatePage(Component component) {       
        pContent.removeAll();
        pContent.add(component, BorderLayout.CENTER);
        pContent.revalidate();
        pContent.repaint();
    }
}
