/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadsorter;

import downloadsorter.GUI.MainGUI;

/**
 *
 * @author Eric
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SettingsManager settings = new SettingsManager();
        MainGUI mainWindow = settings.getGUI();
        Thread GUI = new Thread(mainWindow);
        GUI.start();
    }
}
