/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import javax.swing.JOptionPane;
import modelo.Curso;
import modelo.RegistroNotasEstudiante;
import modelo.Universidad;

/**
 *
 * @author Pixels
 */
public class vistaCursoEstudiante extends javax.swing.JFrame {

    private Curso curso;
    private RegistroNotasEstudiante notasEstudiante;
    private vistaEstudiante vistaAnterior;
    /**
     * Creates new form vistaCursoEstudiante
     * @param curso
     * @param notasEstudiante
     * @param vistaAnterior
     */
    public vistaCursoEstudiante(Curso curso, RegistroNotasEstudiante notasEstudiante, vistaEstudiante vistaAnterior) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.curso = curso;
        this.notasEstudiante = notasEstudiante;
        this.vistaAnterior = vistaAnterior;
        activarBtnCancelarCurso();
        llenarLbls();
    }
    
    private void activarBtnCancelarCurso(){
        if(notasEstudiante.isAnulable()){
            btnCancelarCurso.setVisible(true);
        }else {
            btnCancelarCurso.setVisible(false);
        }
    }
    
    private void llenarLbls(){
        lblNombreCurso.setText(curso.getAsignatura().getNombre());
        lblN1.setText("Nota 1: " + notasEstudiante.getNota1());
        lblN2.setText("Nota 2: " + notasEstudiante.getNota2());
        lblN3.setText("Nota 3: " + notasEstudiante.getNota3());
        lblAcumulado.setText("Acumulado: " + String.format("%.3f", notasEstudiante.getAcumulado()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombreCurso = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblAcumulado = new javax.swing.JLabel();
        lblN1 = new javax.swing.JLabel();
        lblN2 = new javax.swing.JLabel();
        lblN3 = new javax.swing.JLabel();
        btnCancelarCurso = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombreCurso.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lblNombreCurso.setText("Nombre");
        jPanel1.add(lblNombreCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel2.setText("Datos del curso");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblAcumulado.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lblAcumulado.setText("Acumulado:");
        jPanel1.add(lblAcumulado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        lblN1.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lblN1.setText("Nota 1:");
        jPanel1.add(lblN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        lblN2.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lblN2.setText("Nota 2:");
        jPanel1.add(lblN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        lblN3.setFont(new java.awt.Font("Times New Roman", 3, 20)); // NOI18N
        lblN3.setText("Nota 3:");
        jPanel1.add(lblN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        btnCancelarCurso.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnCancelarCurso.setText("Cancelar Curso");
        btnCancelarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCursoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        btnVolver.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        vistaAnterior.crearTablaCursos();
        vistaAnterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCancelarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCursoActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de cancelar el curso " + curso.getAsignatura().getNombre().toUpperCase());
        if(i == 0){
            boolean eliminado = curso.eliminarEstudiante(notasEstudiante.getEstudiante().getUser());
            if(eliminado){
                JOptionPane.showMessageDialog(this, "El curso ha sido cancelado");
                Universidad.serializarCursos();
                btnVolver.doClick();
            }else{
                JOptionPane.showMessageDialog(this, "No se puede cancelar el curso");
            }
        }
    }//GEN-LAST:event_btnCancelarCursoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarCurso;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAcumulado;
    private javax.swing.JLabel lblN1;
    private javax.swing.JLabel lblN2;
    private javax.swing.JLabel lblN3;
    private javax.swing.JLabel lblNombreCurso;
    // End of variables declaration//GEN-END:variables
}
