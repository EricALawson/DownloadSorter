/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package downloadsorter.view;

import downloadsorter.Factories.DestinationFactory;
import downloadsorter.Factories.FilterRuleFactory;
import downloadsorter.Factories.SourceFactory;
import downloadsorter.FileSorter;
import downloadsorter.model.DestinationRule;
import downloadsorter.model.FileOperation;
import downloadsorter.model.FilterRule;
import downloadsorter.model.SourceRule;
import downloadsorter.Settings;
import downloadsorter.SettingsManager;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

/**
 *
 * @author Eric
 */
public class MainGUI extends javax.swing.JFrame implements Runnable {
    SettingsManager settings;
    JFileChooser fileChooser;
    /**
     * Creates new form MainGUI
     */
    public MainGUI(SettingsManager s) {
        settings = s;
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        initComponents();
        
        JLabel extraFilterLabel = new JLabel("Second Filter Rule:");
        GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        selectedFilterPanel.add(extraFilterLabel, gridBagConstraints);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        startButton = new javax.swing.JButton();
        btnSaveAndExit = new javax.swing.JButton();
        selectedFilterPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();
        sourceLabel = new javax.swing.JLabel();
        sourceSelector = new javax.swing.JComboBox<>();
        sourceTextField = new javax.swing.JTextField();
        browseSourceButton = new javax.swing.JButton();
        filterLabel = new javax.swing.JLabel();
        filterSelector = new javax.swing.JComboBox<>();
        destinationLabel = new javax.swing.JLabel();
        destinationSelector = new javax.swing.JComboBox<>();
        destinationTextField = new javax.swing.JTextField();
        browseDestinationButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        filterList = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        saveFilterButton = new javax.swing.JButton();
        resetFilterButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        startButton.setText("Run");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        btnSaveAndExit.setText("Save & Exit");
        btnSaveAndExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAndExitActionPerformed(evt);
            }
        });

        selectedFilterPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        selectedFilterPanel.setLayout(new java.awt.GridBagLayout());

        nameLabel.setText("Filter Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        selectedFilterPanel.add(nameLabel, gridBagConstraints);

        nameTextField.setText("New filter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        selectedFilterPanel.add(nameTextField, gridBagConstraints);

        sourceLabel.setText("Select Source Rule:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        selectedFilterPanel.add(sourceLabel, gridBagConstraints);

        sourceSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select source", "Directory" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        selectedFilterPanel.add(sourceSelector, gridBagConstraints);

        sourceTextField.setText("select source directory");
        sourceTextField.setMinimumSize(new java.awt.Dimension(300, 20));
        sourceTextField.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        selectedFilterPanel.add(sourceTextField, gridBagConstraints);

        browseSourceButton.setText("Browse");
        browseSourceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseSourceButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        selectedFilterPanel.add(browseSourceButton, gridBagConstraints);

        filterLabel.setText("Select Filter Rule:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        selectedFilterPanel.add(filterLabel, gridBagConstraints);

        filterSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select filter rule", "Anime Fansub" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        selectedFilterPanel.add(filterSelector, gridBagConstraints);

        destinationLabel.setText("Select Destination Rule:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        selectedFilterPanel.add(destinationLabel, gridBagConstraints);

        destinationSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select destination", "Named Directories" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        selectedFilterPanel.add(destinationSelector, gridBagConstraints);

        destinationTextField.setText("select destination directory");
        destinationTextField.setMinimumSize(new java.awt.Dimension(300, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        selectedFilterPanel.add(destinationTextField, gridBagConstraints);

        browseDestinationButton.setText("Browse");
        browseDestinationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseDestinationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        selectedFilterPanel.add(browseDestinationButton, gridBagConstraints);

        filterList.setModel(getFilterModel());
        filterList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filterListMouseClicked(evt);
            }
        });
        filterList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                filterListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(filterList);

        saveFilterButton.setText("Save Filter");
        saveFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFilterButtonActionPerformed(evt);
            }
        });

        resetFilterButton.setText("Reset");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveFilterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetFilterButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveFilterButton)
                    .addComponent(resetFilterButton))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(startButton)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(btnSaveAndExit)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectedFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectedFilterPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startButton)
                    .addComponent(btnSaveAndExit))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        Settings inits = new Settings(settings);
        FileSorter sortingLoop = new FileSorter(inits);
        Thread sortLoop = new Thread(sortingLoop);
        sortLoop.start();
    }//GEN-LAST:event_startButtonActionPerformed

    private void btnSaveAndExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAndExitActionPerformed
        settings.writeSettingsFile();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnSaveAndExitActionPerformed

    private void browseSourceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseSourceButtonActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        String sourcePath = fileChooser.getSelectedFile().toString();
        sourceTextField.setText(sourcePath);
    }//GEN-LAST:event_browseSourceButtonActionPerformed

    private void filterListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_filterListValueChanged
        FileOperation selectedFilter = filterList.getSelectedValue();
        displayFilterInFields(selectedFilter);
    }//GEN-LAST:event_filterListValueChanged

    private void filterListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filterListMouseClicked
        
    }//GEN-LAST:event_filterListMouseClicked

    private void browseDestinationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseDestinationButtonActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        String destPath = fileChooser.getSelectedFile().toString();
        destinationTextField.setText(destPath);
    }//GEN-LAST:event_browseDestinationButtonActionPerformed

    private void saveFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFilterButtonActionPerformed
        FileOperation filter = readFilterFromFields();
        settings.getSettings().replaceFilter(filterList.getSelectedIndex(), filter);
    }//GEN-LAST:event_saveFilterButtonActionPerformed

    private FileOperation readFilterFromFields() {
        String srcString = ""; 
        String filtString = ""; 
        String destString = "";
        
        srcString += sourceSelector.getSelectedItem() + "," + sourceTextField.getText();
        filtString += filterSelector.getSelectedItem();
        destString += destinationSelector.getSelectedItem() + "," + destinationTextField.getText();
        
        SourceRule source = SourceFactory.createSourceRule(srcString);
        FilterRule filter = FilterRuleFactory.createFilterRule(filtString);
        DestinationRule destination = DestinationFactory.createDestinationRule(destString);
        
        List<SourceRule> sources = new ArrayList();
        sources.add(source);
        List<FilterRule> filters = new ArrayList();
        filters.add(filter);
        List<DestinationRule> destinations = new ArrayList();
        destinations.add(destination);
        
        return new FileOperation(sources, filters, destinations, nameTextField.getText());
    }
    
    private void displayFilterInFields(FileOperation filter) {
        nameTextField.setText(filter.toString());
        
        List sources = filter.getSources();
        String source[] = sources.get(0).toString().split(",");
        displaySourceRule(source);
        
        List filters = filter.getFilters();
        String filterRule[] = filters.get(0).toString().split(",");
        displayFilterRule(filterRule);
        
        List dests = filter.getDestinations();
        String dest[] = dests.get(0).toString().split(",");
        displayDestinationRule(dest);
    }
    
    private void displaySourceRule(String source[]) {
        if("DirectorySource".equals(source[0]))
            sourceSelector.setSelectedItem("Directory");
        
        if(source.length > 1) {
            String dirs ="";
            for(int i = 1; i < source.length; i++) {
                dirs += source[i];
                if (i < source.length-1)
                    dirs += ",";
            }
            sourceTextField.setText(dirs);
        }
    }
    private void displayFilterRule(String filter[]) {
        if("FansubFilter".equals(filter[0]))
            filterSelector.setSelectedItem("Anime Fansub");
        
        if(filter.length > 1) {
            String params = "";
            for (int i= 1; i > filter.length; i++) {
                params += filter[i];
                if (i < filter.length-1)
                    params += ",";
            }
            //filterTextField.setText(params);
        }
    }
    
    private void displayDestinationRule(String dest[]) {
        if("DestinationNamedDirectories".equals(dest[0]))
            destinationSelector.setSelectedItem("Named Directories");
        
        if(dest.length > 1) {
            String dirs ="";
            for(int i = 1; i < dest.length; i++) {
                dirs += dest[i];
                if (i < dest.length-1)
                    dirs += ",";
            }
            destinationTextField.setText(dirs);
        }
    }
    
    public DefaultListModel getFilterModel() {
        DefaultListModel dlm = new DefaultListModel();
        List<FileOperation> lf = settings.getSettings().getFilters(); 
        for (FileOperation f : lf)
            dlm.addElement(f);
        return dlm;
    }

//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

    @Override
    public void run() {
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseDestinationButton;
    private javax.swing.JButton browseSourceButton;
    private javax.swing.JButton btnSaveAndExit;
    private javax.swing.JLabel destinationLabel;
    private javax.swing.JComboBox<String> destinationSelector;
    private javax.swing.JTextField destinationTextField;
    private javax.swing.JLabel filterLabel;
    private javax.swing.JList<FileOperation> filterList;
    private javax.swing.JComboBox<String> filterSelector;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JButton resetFilterButton;
    private javax.swing.JButton saveFilterButton;
    private javax.swing.JPanel selectedFilterPanel;
    private javax.swing.JLabel sourceLabel;
    private javax.swing.JComboBox<String> sourceSelector;
    private javax.swing.JTextField sourceTextField;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}