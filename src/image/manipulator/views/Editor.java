/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package image.manipulator.views;

import image.manipulator.controller.ImageController;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dell
 */
public class Editor extends javax.swing.JFrame {
    
    private BufferedImage originalImg;
    private ImageController editor;
    
    private String selectedImagePath = "";
    
    private double sx;
    private double sy;
    
    private double tx;
    private double ty;
    
    private double rotDeg;

    /**
     * Creates new form Editor
     */
    public Editor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editorContainer = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        imgContainer = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        controlsContainer = new javax.swing.JPanel();
        rotationContainer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rotationDegree = new javax.swing.JSlider();
        scaleContainer = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        scaleX = new javax.swing.JTextField();
        scaleY = new javax.swing.JTextField();
        applyScale = new javax.swing.JButton();
        effectContainer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        greyScaleEff = new javax.swing.JButton();
        darkEffe = new javax.swing.JButton();
        negativeColor = new javax.swing.JButton();
        mirror = new javax.swing.JButton();
        translationContainer = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        applyTranslate = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        translateX = new javax.swing.JTextField();
        translateY = new javax.swing.JTextField();
        clippingContainer = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        clipFieldsContainer = new javax.swing.JPanel();
        clipWidth = new javax.swing.JTextField();
        clipHeight = new javax.swing.JTextField();
        clipX = new javax.swing.JTextField();
        clipY = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        saveChanges = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuOptions = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        openFile = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);

        editorContainer.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        imgContainer.setBackground(new java.awt.Color(255, 255, 255));
        imgContainer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgContainer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(imgContainer, java.awt.BorderLayout.CENTER);

        jScrollPane1.setViewportView(jPanel1);

        editorContainer.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(editorContainer, java.awt.BorderLayout.CENTER);

        rotationContainer.setMinimumSize(new java.awt.Dimension(190, 120));
        rotationContainer.setPreferredSize(new java.awt.Dimension(190, 120));
        rotationContainer.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ROTATION");
        jLabel1.setAlignmentY(1.0F);
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rotationContainer.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        rotationDegree.setMajorTickSpacing(90);
        rotationDegree.setMaximum(360);
        rotationDegree.setMinorTickSpacing(45);
        rotationDegree.setPaintLabels(true);
        rotationDegree.setPaintTicks(true);
        rotationDegree.setValue(0);
        rotationDegree.setDoubleBuffered(true);
        rotationDegree.setValueIsAdjusting(true);
        rotationDegree.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rotationDegreeStateChanged(evt);
            }
        });
        rotationContainer.add(rotationDegree, java.awt.BorderLayout.CENTER);

        scaleContainer.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SCALE");
        jLabel2.setAlignmentY(1.0F);
        scaleContainer.add(jLabel2, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        scaleX.setMinimumSize(new java.awt.Dimension(90, 30));
        scaleX.setPreferredSize(new java.awt.Dimension(95, 30));
        scaleX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleXActionPerformed(evt);
            }
        });
        jPanel5.add(scaleX);

        scaleY.setMinimumSize(new java.awt.Dimension(90, 30));
        scaleY.setPreferredSize(new java.awt.Dimension(95, 30));
        scaleY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scaleYActionPerformed(evt);
            }
        });
        jPanel5.add(scaleY);

        scaleContainer.add(jPanel5, java.awt.BorderLayout.CENTER);

        applyScale.setText("Apply");
        applyScale.setPreferredSize(new java.awt.Dimension(72, 30));
        applyScale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyScaleActionPerformed(evt);
            }
        });
        scaleContainer.add(applyScale, java.awt.BorderLayout.PAGE_END);

        effectContainer.setLayout(new java.awt.BorderLayout(10, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("EFFECTS");
        jLabel5.setAlignmentY(1.0F);
        effectContainer.add(jLabel5, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.GridLayout(2, 0, 10, 10));

        greyScaleEff.setText("Grayscale");
        greyScaleEff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greyScaleEffActionPerformed(evt);
            }
        });
        jPanel4.add(greyScaleEff);

        darkEffe.setText("Dark effect");
        darkEffe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darkEffeActionPerformed(evt);
            }
        });
        jPanel4.add(darkEffe);

        negativeColor.setText("Negative color");
        negativeColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negativeColorActionPerformed(evt);
            }
        });
        jPanel4.add(negativeColor);

        mirror.setText("Mirror");
        mirror.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mirrorActionPerformed(evt);
            }
        });
        jPanel4.add(mirror);

        effectContainer.add(jPanel4, java.awt.BorderLayout.CENTER);

        translationContainer.setLayout(new java.awt.BorderLayout(10, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TRANSLATE");
        jLabel6.setAlignmentY(1.0F);
        translationContainer.add(jLabel6, java.awt.BorderLayout.PAGE_START);

        applyTranslate.setText("Apply");
        applyTranslate.setMinimumSize(new java.awt.Dimension(72, 30));
        applyTranslate.setPreferredSize(new java.awt.Dimension(72, 30));
        applyTranslate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyTranslateActionPerformed(evt);
            }
        });
        translationContainer.add(applyTranslate, java.awt.BorderLayout.PAGE_END);

        translateX.setMinimumSize(new java.awt.Dimension(90, 30));
        translateX.setPreferredSize(new java.awt.Dimension(95, 30));
        translateX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateXActionPerformed(evt);
            }
        });
        jPanel6.add(translateX);

        translateY.setMinimumSize(new java.awt.Dimension(90, 30));
        translateY.setPreferredSize(new java.awt.Dimension(95, 30));
        translateY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                translateYActionPerformed(evt);
            }
        });
        jPanel6.add(translateY);

        translationContainer.add(jPanel6, java.awt.BorderLayout.CENTER);

        clippingContainer.setLayout(new java.awt.BorderLayout(10, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("CLIP");
        jLabel3.setAlignmentY(1.0F);
        clippingContainer.add(jLabel3, java.awt.BorderLayout.NORTH);

        clipFieldsContainer.setLayout(new java.awt.GridLayout(2, 0, 10, 10));

        clipWidth.setPreferredSize(new java.awt.Dimension(70, 30));
        clipWidth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clipWidthActionPerformed(evt);
            }
        });
        clipFieldsContainer.add(clipWidth);

        clipHeight.setPreferredSize(new java.awt.Dimension(70, 30));
        clipFieldsContainer.add(clipHeight);

        clipX.setPreferredSize(new java.awt.Dimension(70, 30));
        clipFieldsContainer.add(clipX);

        clipY.setPreferredSize(new java.awt.Dimension(70, 30));
        clipFieldsContainer.add(clipY);

        clippingContainer.add(clipFieldsContainer, java.awt.BorderLayout.CENTER);

        jButton1.setText("Crop");
        jButton1.setPreferredSize(new java.awt.Dimension(72, 30));
        clippingContainer.add(jButton1, java.awt.BorderLayout.SOUTH);

        saveChanges.setText("Save changes");
        saveChanges.setPreferredSize(new java.awt.Dimension(75, 30));
        saveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout controlsContainerLayout = new javax.swing.GroupLayout(controlsContainer);
        controlsContainer.setLayout(controlsContainerLayout);
        controlsContainerLayout.setHorizontalGroup(
            controlsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsContainerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(controlsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rotationContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scaleContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(translationContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clippingContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(effectContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        controlsContainerLayout.setVerticalGroup(
            controlsContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlsContainerLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(rotationContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(scaleContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(translationContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clippingContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(effectContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(saveChanges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setViewportView(controlsContainer);

        getContentPane().add(jScrollPane2, java.awt.BorderLayout.EAST);

        menuOptions.setText("File");

        newFile.setText("New");
        menuOptions.add(newFile);

        openFile.setText("Open");
        openFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileActionPerformed(evt);
            }
        });
        menuOptions.add(openFile);

        jMenuBar1.add(menuOptions);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void scaleYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleYActionPerformed
        
    }//GEN-LAST:event_scaleYActionPerformed

    private void negativeColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negativeColorActionPerformed
        originalImg = editor.setImgToNegative(originalImg);
        imgContainer.setIcon(new ImageIcon(originalImg));
    }//GEN-LAST:event_negativeColorActionPerformed

    private void translateYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateYActionPerformed
        ty = Double.parseDouble(translateY.getText());
    }//GEN-LAST:event_translateYActionPerformed

    private void greyScaleEffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greyScaleEffActionPerformed
       originalImg = editor.setImgToGrayScale(originalImg);
       imgContainer.setIcon(new ImageIcon(originalImg));
    }//GEN-LAST:event_greyScaleEffActionPerformed

    private void mirrorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mirrorActionPerformed
       originalImg = editor.imageTranslation(originalImg);
       imgContainer.setIcon(new ImageIcon(originalImg));
    }//GEN-LAST:event_mirrorActionPerformed

    private void rotationDegreeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rotationDegreeStateChanged
        rotDeg = Double.parseDouble(rotationDegree.getValue()+"");
        System.out.println(rotDeg);
        originalImg = editor.rotateImage(originalImg, rotDeg, imgContainer.getSize().width, imgContainer.getSize().height);
        imgContainer.setIcon(new ImageIcon(originalImg));
    }//GEN-LAST:event_rotationDegreeStateChanged

    private void scaleXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scaleXActionPerformed

    }//GEN-LAST:event_scaleXActionPerformed

    private void applyScaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyScaleActionPerformed
        sx = Double.parseDouble(scaleX.getText());
        sy = Double.parseDouble(scaleY.getText());
        
        originalImg = editor.scaleImage(originalImg, sx, sy);
        imgContainer.setIcon(new ImageIcon(originalImg));
    }//GEN-LAST:event_applyScaleActionPerformed

    private void darkEffeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darkEffeActionPerformed
        originalImg = editor.setImageDarker(originalImg);
       imgContainer.setIcon(new ImageIcon(originalImg));
    }//GEN-LAST:event_darkEffeActionPerformed

    private void translateXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_translateXActionPerformed
        tx = Double.parseDouble(translateX.getText());
    }//GEN-LAST:event_translateXActionPerformed

    private void applyTranslateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyTranslateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_applyTranslateActionPerformed

    private void clipWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clipWidthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clipWidthActionPerformed

    private void openFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileActionPerformed
        JFileChooser selectedImage = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        selectedImage.addChoosableFileFilter(fnef);
        int showOpenDialogue = selectedImage.showOpenDialog(null);

        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = selectedImage.getSelectedFile();
            selectedImagePath = selectedImageFile.getAbsolutePath();
            
            try {
                originalImg = ImageIO.read(new File(selectedImagePath));
                editor = new ImageController();

                ImageIcon ii = new ImageIcon(selectedImagePath);
                imgContainer.setIcon(ii);
            } catch (IOException ex) {
                Logger.getLogger(EditorView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_openFileActionPerformed

    private void saveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesActionPerformed
        try {
            editor.saveImg(originalImg, selectedImagePath);
        } catch (IOException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveChangesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Editor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyScale;
    private javax.swing.JButton applyTranslate;
    private javax.swing.JPanel clipFieldsContainer;
    private javax.swing.JTextField clipHeight;
    private javax.swing.JTextField clipWidth;
    private javax.swing.JTextField clipX;
    private javax.swing.JTextField clipY;
    private javax.swing.JPanel clippingContainer;
    private javax.swing.JPanel controlsContainer;
    private javax.swing.JButton darkEffe;
    private javax.swing.JPanel editorContainer;
    private javax.swing.JPanel effectContainer;
    private javax.swing.JButton greyScaleEff;
    private javax.swing.JLabel imgContainer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuOptions;
    private javax.swing.JButton mirror;
    private javax.swing.JButton negativeColor;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem openFile;
    private javax.swing.JPanel rotationContainer;
    private javax.swing.JSlider rotationDegree;
    private javax.swing.JButton saveChanges;
    private javax.swing.JPanel scaleContainer;
    private javax.swing.JTextField scaleX;
    private javax.swing.JTextField scaleY;
    private javax.swing.JTextField translateX;
    private javax.swing.JTextField translateY;
    private javax.swing.JPanel translationContainer;
    // End of variables declaration//GEN-END:variables
}
