/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.Optional;
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
    
    public void navigatePage(Component component, Optional<Integer> width, Optional<Integer> height) {
        component.setSize(width.orElse(680), height.orElse(240));
        component.setLocation(0, 0);
        pContent.removeAll();
        pContent.add(component, BorderLayout.CENTER);
        pContent.revalidate();
        pContent.repaint();
    }
}
