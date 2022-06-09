/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import Controladores.ControladorVistaAdminGeneral;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.Estudiante;

/**
 *
 * @author Pixels
 */
public class vistaAdminGeneralEstudiantesCurso extends javax.swing.JFrame {

    private Curso curso;
    private ControladorVistaAdminGeneral controlador;
    private vistaAdminGeneral vistaAnterior;
    private String user;
    /**
     * Creates new form vistaAdminGeneralEstudiantesCurso
     */
    public vistaAdminGeneralEstudiantesCurso(Curso curso, ControladorVistaAdminGeneral controlador,vistaAdminGeneral vistaAnterior) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.curso = curso;
        this.controlador = controlador;
        this.vistaAnterior = vistaAnterior;
        crearTablaEstudiantes();
        setLabels();
    }
    
    private void crearTablaEstudiantes(){
        DefaultTableModel model = new DefaultTableModel();
        String[] columnas = new String[]{
            "Usuario", "Nombre","Apellido", "Edad","Documento", "Telefono", "Correo"
        };
        model.setColumnIdentifiers(columnas);
        for (int i = 0; i < curso.getNotas().getSize(); i++) {
            Estudiante estudiante = curso.getNotas().get(i).getEstudiante();
            model.addRow(new Object[]{
                estudiante.getUser(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                Integer.toString(estudiante.getEdad()),
                estudiante.getDocumento(),
                estudiante.getTelefono(),
                estudiante.getCorreo()
            });
        }
        tableEstudiantes.setModel(model);
    }
    
    private void setLabels(){
        lblIdCurso.setText("Curso: " + curso.getId());
        lblDocente.setText("Docente: " + curso.getDocente().getNombre());
        lblAsignatura.setText("Asignatura: " + curso.getAsignatura().getNombre());
        lblSalon.setText("Salón: " + curso.getSalon().getNumero());
        lblDia.setText("Día: " + curso.getDia());
        lblHora.setText("Hora: " + consultarHrsCurso(curso));
    }
    
    private String consultarHrsCurso(Curso curso){
        String hrs = "";
        for (int i = 0; i < curso.getHoras().length; i++) {
            hrs += curso.getHoras()[i];
            if(i < curso.getHoras().length-1){
                hrs += ", ";
            }
        }
        return hrs;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblIdCurso = new javax.swing.JLabel();
        lblDocente = new javax.swing.JLabel();
        lblAsignatura = new javax.swing.JLabel();
        lblSalon = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEstudiantes = new javax.swing.JTable();
        btnRemoverEstudiante = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnRegistrarEstudianteCurso = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("Registrar estudiante al curso");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel2.setText("Documento");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        lblIdCurso.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblIdCurso.setText("Id Curso:");
        jPanel1.add(lblIdCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        lblDocente.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblDocente.setText("Docente:");
        jPanel1.add(lblDocente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        lblAsignatura.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblAsignatura.setText("Asignatura:");
        jPanel1.add(lblAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        lblSalon.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblSalon.setText("Salón:");
        jPanel1.add(lblSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        lblDia.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblDia.setText("Día:");
        jPanel1.add(lblDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Gestionar estudiantes del curso");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblHora.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        lblHora.setText("Hora:");
        jPanel1.add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        txtDocumento.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jPanel1.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 100, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Estudiantes registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 3, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEstudiantes);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 23, 488, 220));

        btnRemoverEstudiante.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnRemoverEstudiante.setText("Remover estudiante");
        btnRemoverEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverEstudianteActionPerformed(evt);
            }
        });
        jPanel2.add(btnRemoverEstudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 510, 290));

        btnVolver.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));

        btnRegistrarEstudianteCurso.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        btnRegistrarEstudianteCurso.setText("Registrar");
        btnRegistrarEstudianteCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEstudianteCursoActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarEstudianteCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        vistaAnterior.pressBtnCancelarCurso();
        vistaAnterior.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnRemoverEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverEstudianteActionPerformed
        // TODO add your handling code here:
        Estudiante estudiante = curso.buscarRegistro(user).getEstudiante();
        if(estudiante != null){
            int i = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar al estudiante " + estudiante.getNombre() + " del curso?");
            if(i == 0){
                boolean aux = curso.eliminarEstudiante(estudiante.getUser());
                if(aux){
                    JOptionPane.showMessageDialog(this, "El estudiante ha sido removido del curso");
                    crearTablaEstudiantes();
                }else{
                    JOptionPane.showMessageDialog(this, "No se pudo eliminar");
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor seleccione un estudiante en la tabla");
        }
    }//GEN-LAST:event_btnRemoverEstudianteActionPerformed

    private void tableEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEstudiantesMouseClicked
        // TODO add your handling code here:
        int seleccion = tableEstudiantes.rowAtPoint(evt.getPoint());
        user = tableEstudiantes.getValueAt(seleccion, 0).toString();
    }//GEN-LAST:event_tableEstudiantesMouseClicked

    private void btnRegistrarEstudianteCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEstudianteCursoActionPerformed
        // TODO add your handling code here:
        Estudiante estudiante = controlador.buscarEstudianteDoc(txtDocumento.getText());
        if(estudiante != null){
            boolean aux = curso.registrarEstudiante(estudiante);
            if(aux){
                JOptionPane.showMessageDialog(this, "El estudiante ha sido registrado al curso");
                txtDocumento.setText("");
                crearTablaEstudiantes();
            }else{
                JOptionPane.showMessageDialog(this, "No se pudo registrar");
            }
        }else {
            JOptionPane.showMessageDialog(this, "Estudiante no encontrado");
        }
    }//GEN-LAST:event_btnRegistrarEstudianteCursoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarEstudianteCurso;
    private javax.swing.JButton btnRemoverEstudiante;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAsignatura;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblDocente;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblIdCurso;
    private javax.swing.JLabel lblSalon;
    private javax.swing.JTable tableEstudiantes;
    private javax.swing.JTextField txtDocumento;
    // End of variables declaration//GEN-END:variables
}
