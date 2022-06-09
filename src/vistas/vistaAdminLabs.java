/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import Controladores.ControladorVistaAdminLabs;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import modelo.AdminLabs;
import modelo.Laboratorio;
import modelo.Universidad;

/**
 *
 * @author Pixels
 */
public class vistaAdminLabs extends javax.swing.JFrame implements ActionListener{

    private AdminLabs admin;
    private ControladorVistaAdminLabs controlador;
    private JButton[][] botones;
    /**
     * Creates new form vistaUniversidad
     * @param admin
     */
    public vistaAdminLabs(AdminLabs admin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.admin = admin;
        this.controlador = new ControladorVistaAdminLabs();
        botones = new JButton[3][];
        crearBotones();
        initBotones();
        validarPosiciones();
        llenarlblsCuenta();
    }
    
    private void crearBotones() {
        for (int i = 0; i < botones.length; i++) {
            if (i != 1) {
                botones[i] = new JButton[6];
            } else {
                botones[i] = new JButton[1];
            }
        }
    }

    private void initBotones(){
        int ancho = 105;
        int alto = 95;
        int separado1 = 35;
        int separado2 = 100;
        int texto = 1;
        
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                botones[i][j] = new JButton();
                if(j < 4){
                    botones[i][j].setBounds(j * ancho + separado1, i * alto + separado1, ancho, alto);
                }else{
                    botones[i][j].setBounds(j * ancho + separado2, i * alto + separado1, ancho, alto);
                }
                
                botones[i][j].setText(Integer.toString(texto));
                botones[i][j].addActionListener(this);
                panelLabs.add(botones[i][j]);
                texto++;
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                if(e.getSource().equals(botones[i][j])){
                    Laboratorio laboratorio = controlador.obtenerLab(i, j);
                    if(!laboratorio.isHabilitado()){
                        JOptionPane.showMessageDialog(this, "El laboratorio se encuentra deshabilitado debido a que: " + laboratorio.getRazonDeshabilitado());
                    }
                    new vistaGestionLab(laboratorio, controlador, this).setVisible(true);
                    this.dispose();
                }
            }
        }
    }
    
    public void validarPosiciones(){
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                Laboratorio lab = controlador.obtenerLab(i, j);
                if(lab.isHabilitado()){
                    botones[i][j].setBackground(Color.white);
                }else {
                    botones[i][j].setBackground(Color.gray);
                }
            }
        }
    }
    
    private boolean validLtrs(String datos){
        return datos.matches("[a-zA-Z]*");
    }
    
    private boolean validNums(String datos){
        return datos.matches("[0-9]*");
    }
    
    private void llenarlblsCuenta(){
        txtUsuarioCuenta.setText(admin.getUser());
        txtNombreCuenta.setText(admin.getNombre());
        txtApellidoCuenta.setText(admin.getApellido());
        txtDocumentoCuenta.setText(admin.getDocumento());
        txtPswCuenta.setText(admin.getPsw());
        txtPsw2Cuenta.setText(admin.getPsw());
        txtEdadCuenta.setText(Integer.toString(admin.getEdad()));
        txtTelefonoCuenta.setText(admin.getTelefono());
        txtCorreoCuenta.setText(admin.getCorreo());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelLabs = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtUsuarioCuenta = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        txtNombreCuenta = new javax.swing.JTextField();
        txtApellidoCuenta = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        txtDocumentoCuenta = new javax.swing.JTextField();
        txtPswCuenta = new javax.swing.JPasswordField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        txtPsw2Cuenta = new javax.swing.JPasswordField();
        txtEdadCuenta = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txtTelefonoCuenta = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        txtCorreoCuenta = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        btnEditarCuenta = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(802, 400));

        javax.swing.GroupLayout panelLabsLayout = new javax.swing.GroupLayout(panelLabs);
        panelLabs.setLayout(panelLabsLayout);
        panelLabsLayout.setHorizontalGroup(
            panelLabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        panelLabsLayout.setVerticalGroup(
            panelLabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Laboratorios", panelLabs);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuarioCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtUsuarioCuenta.setEnabled(false);
        jPanel1.add(txtUsuarioCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 100, -1));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel39.setText("Usuario");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel14.setText("¡Gestionar cuenta!");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel44.setText("Nombre");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        txtNombreCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtNombreCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 100, -1));

        txtApellidoCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtApellidoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 100, -1));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel45.setText("Apellido");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel46.setText("Documento");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        txtDocumentoCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtDocumentoCuenta.setEnabled(false);
        jPanel1.add(txtDocumentoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 100, -1));

        txtPswCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtPswCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 100, -1));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel47.setText("Contraseña");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel48.setText("Re.Contraseña");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 30));

        txtPsw2Cuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtPsw2Cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 100, -1));

        txtEdadCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtEdadCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 100, -1));

        jLabel50.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel50.setText("Edad");
        jPanel1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, 30));

        txtTelefonoCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtTelefonoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 100, -1));

        jLabel49.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel49.setText("Telefono");
        jPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, 30));

        txtCorreoCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtCorreoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 100, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel38.setText("Correo");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, 30));

        btnEditarCuenta.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnEditarCuenta.setText("Editar");
        btnEditarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        btnVolver.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnVolver.setText("Cerrar sesión");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 170, 50));

        jTabbedPane1.addTab("Cuenta", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCuentaActionPerformed
        // TODO add your handling code here:
        if(txtNombreCuenta.getText().isEmpty() || txtApellidoCuenta.getText().isEmpty() || txtPswCuenta.getText().isEmpty()
            || txtPsw2Cuenta.getText().isEmpty() || txtEdadCuenta.getText().isEmpty() || txtTelefonoCuenta.getText().isEmpty()
            || txtCorreoCuenta.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        }else{
            if(validLtrs(txtNombreCuenta.getText()) && validLtrs(txtApellidoCuenta.getText()) && validNums(txtEdadCuenta.getText())
                && validNums(txtTelefonoCuenta.getText())){
                if(txtPswCuenta.getText().equals(txtPsw2Cuenta.getText())){
                    admin.setNombre(txtNombreCuenta.getText());
                    admin.setApellido(txtApellidoCuenta.getText());
                    admin.setPsw(txtPswCuenta.getText());
                    admin.setEdad(Integer.parseInt(txtEdadCuenta.getText()));
                    admin.setTelefono(txtTelefonoCuenta.getText());
                    admin.setCorreo(txtCorreoCuenta.getText());
                    Universidad.serializarUsuarios();
                    JOptionPane.showMessageDialog(this, "Los datos de la cuenta han sido modificados");
                }else{
                    JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Por favor llene todos los campos con los caracteres correctos");
            }
        }
    }//GEN-LAST:event_btnEditarCuentaActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        new vistaLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarCuenta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelLabs;
    private javax.swing.JTextField txtApellidoCuenta;
    private javax.swing.JTextField txtCorreoCuenta;
    private javax.swing.JTextField txtDocumentoCuenta;
    private javax.swing.JTextField txtEdadCuenta;
    private javax.swing.JTextField txtNombreCuenta;
    private javax.swing.JPasswordField txtPsw2Cuenta;
    private javax.swing.JPasswordField txtPswCuenta;
    private javax.swing.JTextField txtTelefonoCuenta;
    private javax.swing.JTextField txtUsuarioCuenta;
    // End of variables declaration//GEN-END:variables
}
