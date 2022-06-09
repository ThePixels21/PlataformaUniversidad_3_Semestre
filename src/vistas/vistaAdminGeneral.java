/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import Controladores.ControladorVistaAdminGeneral;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.AdminGeneral;
import modelo.Asignatura;
import modelo.Curso;
import modelo.Docente;
import modelo.Estudiante;
import modelo.Herramienta;
import modelo.Salon;
import modelo.Universidad;

/**
 *
 * @author Pixels
 */
public class vistaAdminGeneral extends javax.swing.JFrame {

    private AdminGeneral admin;
    private ControladorVistaAdminGeneral controlador;
    /**
     * Creates new form vistaAdminGeneral
     * @param admin
     */
    public vistaAdminGeneral(AdminGeneral admin) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.admin = admin;
        this.controlador = new ControladorVistaAdminGeneral();
        crearTablaEstudiantes();
        visualizarBotonesEstudiante();
        crearTablaDocentes();
        visualizarBotonesDocentes();
        crearTablaSalones();
        visualizarBotonesSalones();
        llenarComboBoxsCursos();
        crearTablaAsignaturas();
        visualizarBotonesAsignatura();
        crearTablaCursos();
        visualizarBotonesCurso();
        crearTablaHerramientas();
        btnCambiarEstado.setVisible(false);
        llenarlblsCuenta();
    }
    
    private boolean validLtrs(String datos){
        return datos.matches("[a-zA-Z]*");
    }
    
    private boolean validNums(String datos){
        return datos.matches("[0-9]*");
    }

    private void limpiarCamposEstudiante() {
        txtUsuario.setText("");
        txtPsw.setText("");
        txtConfirmPsw.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        txtDocumento.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
        txtPuntaje.setText("");

        txtUsuario.setEnabled(true);
        txtDocumento.setEnabled(true);
        
        visualizarBotonesEstudiante();
    }
    
    private void limpiarCamposDocente() {
        txtUsuarioDoc.setText("");
        txtPswDoc.setText("");
        txtConfirmPswDoc.setText("");
        txtNombreDoc.setText("");
        txtApellidoDoc.setText("");
        txtEdadDoc.setText("");
        txtDocumentoDoc.setText("");
        txtTelefonoDoc.setText("");
        txtCorreoDoc.setText("");
        txtEstudiosDoc.setText("");
        txtNivEstudiosDoc.setText("");
        txtExpLabDoc.setText("");

        txtUsuarioDoc.setEnabled(true);
        txtDocumentoDoc.setEnabled(true);
        
        visualizarBotonesDocentes();
    }
    
    private void limpiarCamposSalon(){
        txtNumSalon.setText("");
        txtNumSalon.setEnabled(true);
        
        visualizarBotonesSalones();
    }
    
    private void visualizarBotonesSalones(){
        btnRegistrarSalon.setVisible(true);
        btnEliminarSalones.setVisible(false);
        btnCancelarSalones.setVisible(false);
    }
    
    private void limpiarCamposAsignatura(){
        txtNombreAsignatura.setText("");
        txtDescAsignatura.setText("");
        
        visualizarBotonesAsignatura();
    }
    
    private void visualizarBotonesAsignatura(){
        btnRegistrarAsignatura.setVisible(true);
        btnEditarAsignatura.setVisible(false);
        btnEliminarAsignatura.setVisible(false);
        btnCancelarAsignatura.setVisible(false);
        txtIdAsignatura.setVisible(false);
        lblIdAsignatura.setVisible(false);
    }
    
    private void limpiarCamposCurso(){
        txtDocenteCurso.setText("");
        llenarComboBoxsCursos();
        cboxBloqueHrs.setSelectedIndex(0);
        cboxDia.setSelectedIndex(0);
        String[] array = new String[1];
        array[0] = "Selec día";
        cboxHoras.setModel(new DefaultComboBoxModel(array));
        
        visualizarBotonesCurso();
    }
    
    private void visualizarBotonesCurso(){
        btnRegistrarCurso.setVisible(true);
        btnEditarCurso.setVisible(false);
        btnEliminarCurso.setVisible(false);
        btnCancelarCurso.setVisible(false);
        btnEstudiantesCurso.setVisible(false);
        lblIdCurso.setVisible(false);
        txtIdCurso.setVisible(false);
    }
    
    private void crearTablaEstudiantes(){
        DefaultTableModel model = new DefaultTableModel();
        String[] columnas = new String[]{
            "Usuario", "Nombre","Apellido", "Edad","Documento", "Telefono", "Correo"
        };
        model.setColumnIdentifiers(columnas);
        for (int i = 0; i < controlador.obtenerCantidadEstudiantes(); i++) {
            Estudiante estudiante = controlador.buscarEstudianteIndex(i);
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
    
    private void crearTablaDocentes(){
        DefaultTableModel model = new DefaultTableModel();
        String[] columnas = new String[]{
            "Usuario", "Nombre","Apellido", "Edad","Documento", "Telefono", "Correo", "Cursos"
        };
        model.setColumnIdentifiers(columnas);
        for (int i = 0; i < controlador.obtenerCantidadDocentes(); i++) {
            Docente docente = controlador.buscarDocenteIndex(i);
            model.addRow(new Object[]{
                docente.getUser(),
                docente.getNombre(),
                docente.getApellido(),
                Integer.toString(docente.getEdad()),
                docente.getDocumento(),
                docente.getTelefono(),
                docente.getCorreo(),
                controlador.obtenerCantidadCursosDocente(docente.getUser())
            });
        }
        tableDocentes.setModel(model);
    }
    
    private void crearTablaSalones(){
        DefaultTableModel model = new DefaultTableModel();
        String[] columnas = new String[]{
            "Salón", "nCursos"
        };
        model.setColumnIdentifiers(columnas);
        for (int i = 0; i < controlador.obtenerCantidadSalones(); i++) {
            Salon salon = controlador.obtenerSalonIndex(i);
            model.addRow(new Object[]{
                salon.getNumero(),
                controlador.obtenerCantidadCursosSalon(salon.getNumero())
            });
        }
        tableSalones.setModel(model);
    }
    
    private void crearTablaAsignaturas(){
        DefaultTableModel model = new DefaultTableModel();
        String[] columnas = new String[]{
            "Id Asignatura", "Nombre", "Descripción"
        };
        model.setColumnIdentifiers(columnas);
        for (int i = 0; i < controlador.obtenerCantidadAsignaturas(); i++) {
            Asignatura asignatura = controlador.obtenerAsignaturaIndex(i);
            model.addRow(new Object[]{
                asignatura.getId(),
                asignatura.getNombre(),
                asignatura.getDesc()
            });
        }
        tableAsignaturas.setModel(model);
    }
    
    private void crearTablaCursos(){
        DefaultTableModel model = new DefaultTableModel();
        String[] columnas = new String[]{
            "Id Curso", "Docente", "Asignatura", "Bloque hrs", "Salón", "Día", "Hrs"
        };
        model.setColumnIdentifiers(columnas);
        for (int i = 0; i < controlador.obtenerCantidadCursos(); i++) {
            Curso curso = controlador.obtenerCursoIndex(i);
            model.addRow(new Object[]{
                curso.getId(),
                curso.getDocente().getNombre(),
                curso.getAsignatura().getNombre(),
                curso.getBloqueHoras(),
                curso.getSalon().getNumero(),
                curso.getDia(),
                consultarHrsCurso(curso)
            });
        }
        tableCursos.setModel(model);
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
    
    private void crearTablaHerramientas(){
        DefaultTableModel model = new DefaultTableModel();
        String[] columnas = new String[]{
            "Id", "Nombre","Tipo", "Estado"
        };
        model.setColumnIdentifiers(columnas);
        for (int i = 0; i < controlador.obtenerCantidadHerramientas(); i++) {
            Herramienta herramienta = controlador.obtenerHerramientaIndex(i);
            model.addRow(new Object[]{
                Integer.toString(herramienta.getId()),
                herramienta.getNombre(),
                herramienta.getTipo(),
                obtenerEstadoHerramienta(herramienta)
                
            });
        }
        tableHerramientas.setModel(model);
    }
    
    private String obtenerEstadoHerramienta(Herramienta herramienta){
        String estado = "Prestada";
        if(herramienta.isDisponible()){
            estado = "Disponible";
        }
        return estado;
    }
    
    private void visualizarBotonesEstudiante() {
        btnRegistrar.setVisible(true);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(false);
    }
    
    private void visualizarBotonesDocentes() {
        btnRegistrarDoc.setVisible(true);
        btnEditarDoc.setVisible(false);
        btnEliminarDoc.setVisible(false);
        btnCancelarDoc.setVisible(false);
    }
    
    private void llenarComboBoxsCursos(){
        cboxAsignatura.setModel(new DefaultComboBoxModel(controlador.crearArregloIdAsignaturas()));
        cboxSalon.setModel(new DefaultComboBoxModel(controlador.crearArregloSalones()));
    }
    
    public void pressBtnCancelarCurso(){
        btnCancelarCurso.doClick();
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
    
    private int idHerramienta;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel22 = new javax.swing.JLabel();
        Gestion = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        txtPuntaje = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        panelEstudiantes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEstudiantes = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtPsw = new javax.swing.JPasswordField();
        btnCancelar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtConfirmPsw = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtExpLabDoc = new javax.swing.JTextField();
        txtCorreoDoc = new javax.swing.JTextField();
        txtTelefonoDoc = new javax.swing.JTextField();
        txtDocumentoDoc = new javax.swing.JTextField();
        txtEdadDoc = new javax.swing.JTextField();
        txtApellidoDoc = new javax.swing.JTextField();
        txtNombreDoc = new javax.swing.JTextField();
        txtPswDoc = new javax.swing.JPasswordField();
        txtUsuarioDoc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtEstudiosDoc = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        panelDocentes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableDocentes = new javax.swing.JTable();
        txtBuscarDoc = new javax.swing.JTextField();
        btnBuscarDoc = new javax.swing.JButton();
        btnEditarDoc = new javax.swing.JButton();
        btnRegistrarDoc = new javax.swing.JButton();
        btnEliminarDoc = new javax.swing.JButton();
        btnCancelarDoc = new javax.swing.JButton();
        txtConfirmPswDoc = new javax.swing.JPasswordField();
        jLabel18 = new javax.swing.JLabel();
        txtNivEstudiosDoc = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtNumSalon = new javax.swing.JTextField();
        panelDocentes1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableSalones = new javax.swing.JTable();
        txtBuscarSalon = new javax.swing.JTextField();
        btnBuscarSalones = new javax.swing.JButton();
        btnEliminarSalones = new javax.swing.JButton();
        btnRegistrarSalon = new javax.swing.JButton();
        btnCancelarSalones = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lblIdAsignatura = new javax.swing.JLabel();
        txtIdAsignatura = new javax.swing.JTextField();
        txtNombreAsignatura = new javax.swing.JTextField();
        btnCancelarAsignatura = new javax.swing.JButton();
        panelDocentes3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableAsignaturas = new javax.swing.JTable();
        txtBuscarAsignatura = new javax.swing.JTextField();
        btnBuscarAsignatura = new javax.swing.JButton();
        btnRegistrarAsignatura = new javax.swing.JButton();
        btnEditarAsignatura = new javax.swing.JButton();
        btnEliminarAsignatura = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        txtDescAsignatura = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtDocenteCurso = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        panelDocentes2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableCursos = new javax.swing.JTable();
        txtBuscarCurso = new javax.swing.JTextField();
        btnBuscarCurso = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        cboxAsignatura = new javax.swing.JComboBox<>();
        cboxBloqueHrs = new javax.swing.JComboBox<>();
        cboxSalon = new javax.swing.JComboBox<>();
        cboxDia = new javax.swing.JComboBox<>();
        cboxHoras = new javax.swing.JComboBox<>();
        btnRegistrarCurso = new javax.swing.JButton();
        txtIdCurso = new javax.swing.JTextField();
        lblIdCurso = new javax.swing.JLabel();
        btnEditarCurso = new javax.swing.JButton();
        btnEliminarCurso = new javax.swing.JButton();
        btnCancelarCurso = new javax.swing.JButton();
        btnEstudiantesCurso = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        txtNombreHerramienta = new javax.swing.JTextField();
        comboBoxTipoHerramienta = new javax.swing.JComboBox<>();
        btnRegistrarHerramienta = new javax.swing.JButton();
        panelDocentes4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableHerramientas = new javax.swing.JTable();
        btnEliminarHerramienta = new javax.swing.JButton();
        btnCambiarEstado = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        txtUsuarioCuenta = new javax.swing.JTextField();
        txtNombreCuenta = new javax.swing.JTextField();
        txtApellidoCuenta = new javax.swing.JTextField();
        txtDocumentoCuenta = new javax.swing.JTextField();
        txtEdadCuenta = new javax.swing.JTextField();
        txtTelefonoCuenta = new javax.swing.JTextField();
        txtPsw2Cuenta = new javax.swing.JPasswordField();
        txtCorreoCuenta = new javax.swing.JTextField();
        txtPswCuenta = new javax.swing.JPasswordField();
        btnEditarCuenta = new javax.swing.JButton();

        jLabel22.setText("jLabel22");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setText("¡Gestionar estudiantes!");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel2.setText("Usuario");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 39, -1, 30));

        jLabel3.setText("Re.Contraseña");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        jLabel4.setText("Nombre");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        jLabel5.setText("Apellido");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));

        jLabel6.setText("Edad");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 30));

        jLabel7.setText("Documento");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 20));

        jLabel8.setText("Telefono");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));
        jPanel2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 80, -1));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 80, -1));
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 80, -1));
        jPanel2.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 80, -1));
        jPanel2.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 80, -1));
        jPanel2.add(txtPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 80, -1));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        panelEstudiantes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Estudiantes Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 2, 14))); // NOI18N

        tableEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Nombre", "Apellido", "Edad", "Documento", "Telefono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEstudiantesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEstudiantes);
        if (tableEstudiantes.getColumnModel().getColumnCount() > 0) {
            tableEstudiantes.getColumnModel().getColumn(0).setResizable(false);
            tableEstudiantes.getColumnModel().getColumn(1).setResizable(false);
            tableEstudiantes.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            tableEstudiantes.getColumnModel().getColumn(2).setResizable(false);
            tableEstudiantes.getColumnModel().getColumn(2).setHeaderValue("Apellido");
            tableEstudiantes.getColumnModel().getColumn(3).setResizable(false);
            tableEstudiantes.getColumnModel().getColumn(3).setHeaderValue("Edad");
            tableEstudiantes.getColumnModel().getColumn(4).setResizable(false);
            tableEstudiantes.getColumnModel().getColumn(4).setHeaderValue("Documento");
            tableEstudiantes.getColumnModel().getColumn(5).setResizable(false);
            tableEstudiantes.getColumnModel().getColumn(5).setHeaderValue("Telefono");
            tableEstudiantes.getColumnModel().getColumn(6).setResizable(false);
            tableEstudiantes.getColumnModel().getColumn(6).setHeaderValue("Correo");
        }

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEstudiantesLayout = new javax.swing.GroupLayout(panelEstudiantes);
        panelEstudiantes.setLayout(panelEstudiantesLayout);
        panelEstudiantesLayout.setHorizontalGroup(
            panelEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstudiantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelEstudiantesLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        panelEstudiantesLayout.setVerticalGroup(
            panelEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEstudiantesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEstudiantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addContainerGap())
        );

        jPanel2.add(panelEstudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 500, 360));
        jPanel2.add(txtPsw, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 80, -1));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel9.setText("Correo");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 30));

        jLabel10.setText("Puntaje Icfes");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, 30));
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 80, -1));
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 80, -1));
        jPanel2.add(txtConfirmPsw, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 80, -1));

        jLabel16.setText("Contraseña");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 67, -1, 30));

        Gestion.addTab("Estudiantes", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel11.setText("¡Gestionar docentes!");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel24.setText("Usuario");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 39, -1, 30));

        jLabel25.setText("Contraseña");
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 67, -1, 30));

        jLabel26.setText("Nombre");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 20));

        jLabel27.setText("Apellido");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));

        jLabel28.setText("Edad");
        jPanel3.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 30));

        jLabel29.setText("Documento");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 20));

        jLabel30.setText("Telefono");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        jLabel31.setText("Correo");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 30));

        jLabel32.setText("Niv.Estudiio");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, -1, 30));
        jPanel3.add(txtExpLabDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 190, 80, -1));
        jPanel3.add(txtCorreoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 80, -1));
        jPanel3.add(txtTelefonoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 250, 80, -1));
        jPanel3.add(txtDocumentoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 80, -1));
        jPanel3.add(txtEdadDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 80, -1));
        jPanel3.add(txtApellidoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 80, -1));
        jPanel3.add(txtNombreDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 80, -1));
        jPanel3.add(txtPswDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 80, -1));
        jPanel3.add(txtUsuarioDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 80, -1));

        jLabel15.setText("Estudios");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));
        jPanel3.add(txtEstudiosDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 80, -1));

        jLabel17.setText("Re.Contraseña");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 20));

        panelDocentes.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Docentes Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 2, 14))); // NOI18N

        tableDocentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Nombre", "Apellido", "Edad", "Documento", "Telefono", "Correo", "Cursos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableDocentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDocentesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableDocentes);
        if (tableDocentes.getColumnModel().getColumnCount() > 0) {
            tableDocentes.getColumnModel().getColumn(0).setResizable(false);
            tableDocentes.getColumnModel().getColumn(1).setResizable(false);
            tableDocentes.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            tableDocentes.getColumnModel().getColumn(2).setResizable(false);
            tableDocentes.getColumnModel().getColumn(2).setHeaderValue("Apellido");
            tableDocentes.getColumnModel().getColumn(3).setResizable(false);
            tableDocentes.getColumnModel().getColumn(3).setHeaderValue("Edad");
            tableDocentes.getColumnModel().getColumn(4).setResizable(false);
            tableDocentes.getColumnModel().getColumn(4).setHeaderValue("Documento");
            tableDocentes.getColumnModel().getColumn(5).setResizable(false);
            tableDocentes.getColumnModel().getColumn(5).setHeaderValue("Telefono");
            tableDocentes.getColumnModel().getColumn(6).setResizable(false);
            tableDocentes.getColumnModel().getColumn(6).setHeaderValue("Correo");
            tableDocentes.getColumnModel().getColumn(7).setResizable(false);
            tableDocentes.getColumnModel().getColumn(7).setHeaderValue("Cursos");
        }

        btnBuscarDoc.setText("Buscar");
        btnBuscarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDocentesLayout = new javax.swing.GroupLayout(panelDocentes);
        panelDocentes.setLayout(panelDocentesLayout);
        panelDocentesLayout.setHorizontalGroup(
            panelDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelDocentesLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(txtBuscarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarDoc)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        panelDocentesLayout.setVerticalGroup(
            panelDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDoc))
                .addContainerGap())
        );

        jPanel3.add(panelDocentes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 500, 360));

        btnEditarDoc.setText("Editar");
        btnEditarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDocActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditarDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        btnRegistrarDoc.setText("Registrar");
        btnRegistrarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDocActionPerformed(evt);
            }
        });
        jPanel3.add(btnRegistrarDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, -1, -1));

        btnEliminarDoc.setText("Eliminar");
        btnEliminarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarDocActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminarDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));

        btnCancelarDoc.setText("Cancelar");
        btnCancelarDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarDocActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelarDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));
        jPanel3.add(txtConfirmPswDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 80, -1));

        jLabel18.setText("Exp. Laboral (años)");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));
        jPanel3.add(txtNivEstudiosDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 80, -1));

        Gestion.addTab("Docentes", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel13.setText("¡Gestionar salones!");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel20.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel20.setText("Número de salón");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 124, -1, -1));

        txtNumSalon.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jPanel4.add(txtNumSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 159, 123, -1));

        panelDocentes1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Salones Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 2, 14))); // NOI18N

        tableSalones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Salon", "Cursos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSalones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSalonesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableSalones);
        if (tableSalones.getColumnModel().getColumnCount() > 0) {
            tableSalones.getColumnModel().getColumn(0).setResizable(false);
            tableSalones.getColumnModel().getColumn(1).setResizable(false);
        }

        btnBuscarSalones.setText("Buscar");
        btnBuscarSalones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSalonesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDocentes1Layout = new javax.swing.GroupLayout(panelDocentes1);
        panelDocentes1.setLayout(panelDocentes1Layout);
        panelDocentes1Layout.setHorizontalGroup(
            panelDocentes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocentes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelDocentes1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(txtBuscarSalon, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarSalones)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        panelDocentes1Layout.setVerticalGroup(
            panelDocentes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocentes1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDocentes1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarSalon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarSalones))
                .addContainerGap())
        );

        jPanel4.add(panelDocentes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 500, 360));

        btnEliminarSalones.setText("Eliminar");
        btnEliminarSalones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarSalonesActionPerformed(evt);
            }
        });
        jPanel4.add(btnEliminarSalones, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        btnRegistrarSalon.setText("Registrar");
        btnRegistrarSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarSalonActionPerformed(evt);
            }
        });
        jPanel4.add(btnRegistrarSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, -1));

        btnCancelarSalones.setText("Cancelar");
        btnCancelarSalones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarSalonesActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelarSalones, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        Gestion.addTab("Salones", jPanel4);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel19.setText("¡Gestionar asignaturas!");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel40.setText("Nombre");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, 40));

        lblIdAsignatura.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        lblIdAsignatura.setText("Id");
        jPanel6.add(lblIdAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        txtIdAsignatura.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        txtIdAsignatura.setEnabled(false);
        jPanel6.add(txtIdAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 180, -1));

        txtNombreAsignatura.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jPanel6.add(txtNombreAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 180, -1));

        btnCancelarAsignatura.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnCancelarAsignatura.setText("Cancelar");
        btnCancelarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarAsignaturaActionPerformed(evt);
            }
        });
        jPanel6.add(btnCancelarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        panelDocentes3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Asignaturas Registradas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 2, 14))); // NOI18N

        tableAsignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id Asignatura", "Nombre", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAsignaturasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tableAsignaturas);
        if (tableAsignaturas.getColumnModel().getColumnCount() > 0) {
            tableAsignaturas.getColumnModel().getColumn(0).setResizable(false);
            tableAsignaturas.getColumnModel().getColumn(1).setResizable(false);
            tableAsignaturas.getColumnModel().getColumn(2).setResizable(false);
        }

        btnBuscarAsignatura.setText("Buscar");
        btnBuscarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAsignaturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDocentes3Layout = new javax.swing.GroupLayout(panelDocentes3);
        panelDocentes3.setLayout(panelDocentes3Layout);
        panelDocentes3Layout.setHorizontalGroup(
            panelDocentes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocentes3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelDocentes3Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(txtBuscarAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarAsignatura)
                .addContainerGap(153, Short.MAX_VALUE))
        );
        panelDocentes3Layout.setVerticalGroup(
            panelDocentes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocentes3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDocentes3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAsignatura))
                .addContainerGap())
        );

        jPanel6.add(panelDocentes3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 440, 360));

        btnRegistrarAsignatura.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnRegistrarAsignatura.setText("Registrar asignatura");
        btnRegistrarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarAsignaturaActionPerformed(evt);
            }
        });
        jPanel6.add(btnRegistrarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, -1, -1));

        btnEditarAsignatura.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnEditarAsignatura.setText("Editar");
        btnEditarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAsignaturaActionPerformed(evt);
            }
        });
        jPanel6.add(btnEditarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        btnEliminarAsignatura.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnEliminarAsignatura.setText("Eliminar");
        btnEliminarAsignatura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAsignaturaActionPerformed(evt);
            }
        });
        jPanel6.add(btnEliminarAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel42.setText("Descripción");
        jPanel6.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 139, -1, -1));

        txtDescAsignatura.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jPanel6.add(txtDescAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 180, -1));

        Gestion.addTab("Asignaturas", jPanel6);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel12.setText("¡Gestionar cursos!");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel21.setText("Usuario Docente");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 39, -1, -1));

        jLabel23.setText("Id Asignatura");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        jPanel5.add(txtDocenteCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 80, -1));

        jLabel33.setText("Bloque horas");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel34.setText("Numero salon");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel35.setText("Día");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        panelDocentes2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos Registrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 2, 14))); // NOI18N

        tableCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id curso", "Docente", "Asignatura", "Bloque hrs", "Salón", "Día", "Hrs"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCursosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tableCursos);
        if (tableCursos.getColumnModel().getColumnCount() > 0) {
            tableCursos.getColumnModel().getColumn(0).setResizable(false);
            tableCursos.getColumnModel().getColumn(1).setResizable(false);
            tableCursos.getColumnModel().getColumn(2).setResizable(false);
            tableCursos.getColumnModel().getColumn(3).setResizable(false);
            tableCursos.getColumnModel().getColumn(4).setResizable(false);
            tableCursos.getColumnModel().getColumn(5).setResizable(false);
            tableCursos.getColumnModel().getColumn(6).setResizable(false);
        }

        btnBuscarCurso.setText("Gestionar curso");
        btnBuscarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCursoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDocentes2Layout = new javax.swing.GroupLayout(panelDocentes2);
        panelDocentes2.setLayout(panelDocentes2Layout);
        panelDocentes2Layout.setHorizontalGroup(
            panelDocentes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocentes2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelDocentes2Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(txtBuscarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscarCurso)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        panelDocentes2Layout.setVerticalGroup(
            panelDocentes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDocentes2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDocentes2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCurso))
                .addContainerGap())
        );

        jPanel5.add(panelDocentes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 500, 360));

        jLabel36.setText("Hora inicio");
        jPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        cboxAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        jPanel5.add(cboxAsignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 100, -1));

        cboxBloqueHrs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "1", "2", "3", "4" }));
        cboxBloqueHrs.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxBloqueHrsItemStateChanged(evt);
            }
        });
        jPanel5.add(cboxBloqueHrs, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 100, -1));

        cboxSalon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        cboxSalon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxSalonItemStateChanged(evt);
            }
        });
        jPanel5.add(cboxSalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 100, -1));

        cboxDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes" }));
        cboxDia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxDiaItemStateChanged(evt);
            }
        });
        jPanel5.add(cboxDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 100, -1));

        cboxHoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selec día" }));
        cboxHoras.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboxHorasItemStateChanged(evt);
            }
        });
        jPanel5.add(cboxHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 100, -1));

        btnRegistrarCurso.setText("Registrar curso");
        btnRegistrarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarCursoActionPerformed(evt);
            }
        });
        jPanel5.add(btnRegistrarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        txtIdCurso.setEnabled(false);
        jPanel5.add(txtIdCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 80, -1));

        lblIdCurso.setText("Id");
        jPanel5.add(lblIdCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 216, -1, 30));

        btnEditarCurso.setText("Editar");
        btnEditarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCursoActionPerformed(evt);
            }
        });
        jPanel5.add(btnEditarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, -1, -1));

        btnEliminarCurso.setText("Eliminar");
        btnEliminarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarCursoActionPerformed(evt);
            }
        });
        jPanel5.add(btnEliminarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, -1, -1));

        btnCancelarCurso.setText("Cancelar");
        btnCancelarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCursoActionPerformed(evt);
            }
        });
        jPanel5.add(btnCancelarCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        btnEstudiantesCurso.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnEstudiantesCurso.setText("Gestionar estudiantes");
        btnEstudiantesCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstudiantesCursoActionPerformed(evt);
            }
        });
        jPanel5.add(btnEstudiantesCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        Gestion.addTab("Cursos", jPanel5);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel37.setText("¡Gestionar herramientas!");
        jPanel7.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel41.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel41.setText("Tipo");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel43.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel43.setText("Nombre");
        jPanel7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 59, -1, 40));

        txtNombreHerramienta.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jPanel7.add(txtNombreHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 180, -1));

        comboBoxTipoHerramienta.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        comboBoxTipoHerramienta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Microscopio", "TuboEnsayo", "Espatula", "Mechero", "Termometro", "Bascula", "Pipeta", "Pinza" }));
        jPanel7.add(comboBoxTipoHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 180, -1));

        btnRegistrarHerramienta.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnRegistrarHerramienta.setText("Registrar herramienta");
        btnRegistrarHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarHerramientaActionPerformed(evt);
            }
        });
        jPanel7.add(btnRegistrarHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        panelDocentes4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Herramientas Registradas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 2, 14))); // NOI18N
        panelDocentes4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableHerramientas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableHerramientas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableHerramientasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableHerramientas);
        if (tableHerramientas.getColumnModel().getColumnCount() > 0) {
            tableHerramientas.getColumnModel().getColumn(0).setResizable(false);
            tableHerramientas.getColumnModel().getColumn(1).setResizable(false);
            tableHerramientas.getColumnModel().getColumn(2).setResizable(false);
        }

        panelDocentes4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 25, 418, 290));

        btnEliminarHerramienta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnEliminarHerramienta.setText("Eliminar");
        btnEliminarHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHerramientaActionPerformed(evt);
            }
        });
        panelDocentes4.add(btnEliminarHerramienta, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, -1, -1));

        btnCambiarEstado.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        btnCambiarEstado.setText("Cambiar estado");
        btnCambiarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarEstadoActionPerformed(evt);
            }
        });
        panelDocentes4.add(btnCambiarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, -1, -1));

        jPanel7.add(panelDocentes4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 440, 360));

        Gestion.addTab("Herramientas", jPanel7);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jButton1.setText("Cerrar sesión");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 170, 50));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel14.setText("¡Gestionar cuenta!");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel38.setText("Correo");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, -1, 30));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel39.setText("Usuario");
        jPanel1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, 30));

        jLabel44.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel44.setText("Nombre");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        jLabel45.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel45.setText("Apellido");
        jPanel1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 30));

        jLabel46.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel46.setText("Documento");
        jPanel1.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, 30));

        jLabel47.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel47.setText("Contraseña");
        jPanel1.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, 30));

        jLabel48.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel48.setText("Re.Contraseña");
        jPanel1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, 30));

        jLabel49.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel49.setText("Telefono");
        jPanel1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, 30));

        jLabel50.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel50.setText("Edad");
        jPanel1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, 30));

        txtUsuarioCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtUsuarioCuenta.setEnabled(false);
        jPanel1.add(txtUsuarioCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 100, -1));

        txtNombreCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtNombreCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 100, -1));

        txtApellidoCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtApellidoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 100, -1));

        txtDocumentoCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        txtDocumentoCuenta.setEnabled(false);
        jPanel1.add(txtDocumentoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 100, -1));

        txtEdadCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtEdadCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 100, -1));

        txtTelefonoCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtTelefonoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 100, -1));

        txtPsw2Cuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtPsw2Cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 100, -1));

        txtCorreoCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtCorreoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 100, -1));

        txtPswCuenta.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jPanel1.add(txtPswCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 100, -1));

        btnEditarCuenta.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        btnEditarCuenta.setText("Editar");
        btnEditarCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, -1));

        Gestion.addTab("Cuenta", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Gestion)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Gestion)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        if (txtUsuario.getText().isEmpty() || txtPsw.getText().isEmpty() || txtNombre.getText().isEmpty()
                || txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty() || txtDocumento.getText().isEmpty()
                || txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtPuntaje.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        } else {
            if (validLtrs(txtNombre.getText()) && validLtrs(txtApellido.getText())
                    && validNums(txtEdad.getText()) && validNums(txtDocumento.getText()) && validNums(txtTelefono.getText())
                    && validNums(txtPuntaje.getText())) {
                if (txtPsw.getText().equals(txtConfirmPsw.getText())) {
                    String user = txtUsuario.getText();
                    String psw = txtPsw.getText();
                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    int edad = Integer.parseInt(txtEdad.getText());
                    String documento = txtDocumento.getText();
                    String telefono = txtTelefono.getText();
                    String correo = txtCorreo.getText();
                    int puntaje = Integer.parseInt(txtPuntaje.getText());

                    boolean aux = controlador.registrarEstudiante(new Estudiante(puntaje, user, psw, nombre, apellido, edad, documento, telefono, correo));
                    if (aux) {
                        JOptionPane.showMessageDialog(this, "El estudiante ha ido registrado");
                        limpiarCamposEstudiante();
                        crearTablaEstudiantes();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo registrar");
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "Las contraseñas ingresadas no coinciden");
                }
            }else {
                JOptionPane.showMessageDialog(this, "Por favor ingrese caracteres correctos en cada campo");
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        if (txtUsuario.getText().isEmpty() || txtPsw.getText().isEmpty() || txtNombre.getText().isEmpty()
                || txtApellido.getText().isEmpty() || txtEdad.getText().isEmpty() || txtDocumento.getText().isEmpty()
                || txtTelefono.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtPuntaje.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        } else {
            if (validLtrs(txtNombre.getText()) && validLtrs(txtApellido.getText())
                    && validNums(txtEdad.getText()) && validNums(txtTelefono.getText())
                    && validNums(txtPuntaje.getText())) {
                if (txtPsw.getText().equals(txtConfirmPsw.getText())) {
                    String psw = txtPsw.getText();
                    String nombre = txtNombre.getText();
                    String apellido = txtApellido.getText();
                    int edad = Integer.parseInt(txtEdad.getText());
                    String telefono = txtTelefono.getText();
                    String correo = txtCorreo.getText();
                    int puntaje = Integer.parseInt(txtPuntaje.getText());

                    Estudiante aux = controlador.buscarEstudiante(txtUsuario.getText());

                    if (aux != null) {
                        aux.setPsw(psw);
                        aux.setNombre(nombre);
                        aux.setApellido(apellido);
                        aux.setEdad(edad);
                        aux.setTelefono(telefono);
                        aux.setCorreo(correo);
                        aux.setPuntajePruebasSaber(puntaje);

                        Universidad.serializarUsuarios();

                        JOptionPane.showMessageDialog(this, "El estudiante ha sido modificado");
                        limpiarCamposEstudiante();
                        crearTablaEstudiantes();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo modificar");
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "Las contraseñas ingresadas no coinciden");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor ingrese caracteres correctos en cada campo");
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        Estudiante aux = controlador.buscarEstudiante(txtUsuario.getText());
        if(aux != null){
            int i = JOptionPane.showConfirmDialog(this, "Está seguro de retirar a " + aux.getNombre() + " " + aux.getApellido()
            + " de la insitución?");
            
            if(i == 0){
                boolean eliminado = controlador.eliminarEstudiante(aux.getUser());
                if(eliminado){
                    JOptionPane.showMessageDialog(this, "El estudiante ha sido retirado de la institución");
                    limpiarCamposEstudiante();
                    crearTablaEstudiantes();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        Estudiante aux = controlador.buscarEstudiante(txtBuscar.getText());
        if(aux != null){
            txtUsuario.setText(aux.getUser());
            txtPsw.setText(aux.getPsw());
            txtConfirmPsw.setText(aux.getPsw());
            txtNombre.setText(aux.getNombre());
            txtApellido.setText(aux.getApellido());
            txtEdad.setText(Integer.toString(aux.getEdad()));
            txtDocumento.setText(aux.getDocumento());
            txtTelefono.setText(aux.getTelefono());
            txtCorreo.setText(aux.getCorreo());
            txtPuntaje.setText(Integer.toString(aux.getPuntajePruebasSaber()));
            
            txtUsuario.setEnabled(false);
            txtDocumento.setEnabled(false);
            
            btnRegistrar.setVisible(false);
            btnEditar.setVisible(true);
            btnEliminar.setVisible(true);
            btnCancelar.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(this, "No se encontró");
        }
        txtBuscar.setText("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new vistaLogin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tableEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEstudiantesMouseClicked
        // TODO add your handling code here:
        int seleccion = tableEstudiantes.rowAtPoint(evt.getPoint());
        String user = tableEstudiantes.getValueAt(seleccion, 0).toString();
        txtBuscar.setText(user);
    }//GEN-LAST:event_tableEstudiantesMouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        limpiarCamposEstudiante();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tableDocentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDocentesMouseClicked
        // TODO add your handling code here:
        int seleccion = tableDocentes.rowAtPoint(evt.getPoint());
        String user = tableDocentes.getValueAt(seleccion, 0).toString();
        txtBuscarDoc.setText(user);
    }//GEN-LAST:event_tableDocentesMouseClicked

    private void btnBuscarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDocActionPerformed
        // TODO add your handling code here:
        Docente aux = controlador.buscarDocente(txtBuscarDoc.getText());
        if(aux != null){
            txtUsuarioDoc.setText(aux.getUser());
            txtPswDoc.setText(aux.getPsw());
            txtConfirmPswDoc.setText(aux.getPsw());
            txtNombreDoc.setText(aux.getNombre());
            txtApellidoDoc.setText(aux.getApellido());
            txtEdadDoc.setText(Integer.toString(aux.getEdad()));
            txtDocumentoDoc.setText(aux.getDocumento());
            txtTelefonoDoc.setText(aux.getTelefono());
            txtCorreoDoc.setText(aux.getCorreo());
            txtEstudiosDoc.setText(aux.getEstudios());
            txtNivEstudiosDoc.setText(aux.getNivelAcademico());
            txtExpLabDoc.setText(Integer.toString(aux.getExpLaboral()));
            
            txtUsuarioDoc.setEnabled(false);
            txtDocumentoDoc.setEnabled(false);
            
            btnRegistrarDoc.setVisible(false);
            btnEditarDoc.setVisible(true);
            btnEliminarDoc.setVisible(true);
            btnCancelarDoc.setVisible(true);
        }else {
            JOptionPane.showMessageDialog(this, "No se encontró");
        }
        txtBuscarDoc.setText("");
    }//GEN-LAST:event_btnBuscarDocActionPerformed

    private void btnEditarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDocActionPerformed
        // TODO add your handling code here:
        if (txtUsuarioDoc.getText().isEmpty() || txtPswDoc.getText().isEmpty() || txtNombreDoc.getText().isEmpty()
                || txtApellidoDoc.getText().isEmpty() || txtEdadDoc.getText().isEmpty() || txtDocumentoDoc.getText().isEmpty()
                || txtTelefonoDoc.getText().isEmpty() || txtCorreoDoc.getText().isEmpty() || txtEstudiosDoc.getText().isEmpty()
                || txtNivEstudiosDoc.getText().isEmpty() || txtExpLabDoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        }else{
            if (validLtrs(txtNombreDoc.getText()) && validLtrs(txtApellidoDoc.getText())
                    && validNums(txtEdadDoc.getText()) && validNums(txtTelefonoDoc.getText())
                    && validLtrs(txtNivEstudiosDoc.getText()) && validNums(txtExpLabDoc.getText())) {
                if (txtPswDoc.getText().equals(txtConfirmPswDoc.getText())) {
                    String psw = txtPswDoc.getText();
                    String nombre = txtNombreDoc.getText();
                    String apellido = txtApellidoDoc.getText();
                    int edad = Integer.parseInt(txtEdadDoc.getText());
                    String telefono = txtTelefonoDoc.getText();
                    String correo = txtCorreoDoc.getText();
                    String estudios = txtEstudiosDoc.getText();
                    String nivEstudio = txtNivEstudiosDoc.getText();
                    int expLab = Integer.parseInt(txtExpLabDoc.getText());
                    
                    Docente aux = controlador.buscarDocente(txtUsuarioDoc.getText());
                    
                    if(aux != null){
                        aux.setPsw(psw);
                        aux.setNombre(nombre);
                        aux.setApellido(apellido);
                        aux.setEdad(edad);
                        aux.setTelefono(telefono);
                        aux.setCorreo(correo);
                        aux.setEstudios(estudios);
                        aux.setNivelAcademico(nivEstudio);
                        aux.setExpLaboral(expLab);

                        Universidad.serializarUsuarios();

                        JOptionPane.showMessageDialog(this, "El docente ha sido modificado");
                        limpiarCamposDocente();
                        crearTablaDocentes();
                    }else {
                        JOptionPane.showMessageDialog(this, "No se pudo modificar");
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "Las contraseñas ingresadas no coinciden");
                }
            }else {
                JOptionPane.showMessageDialog(this, "Por favor ingrese caracteres correctos en cada campo");
            }
        }
    }//GEN-LAST:event_btnEditarDocActionPerformed

    private void btnRegistrarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDocActionPerformed
        // TODO add your handling code here:
        if (txtUsuarioDoc.getText().isEmpty() || txtPswDoc.getText().isEmpty() || txtNombreDoc.getText().isEmpty()
                || txtApellidoDoc.getText().isEmpty() || txtEdadDoc.getText().isEmpty() || txtDocumentoDoc.getText().isEmpty()
                || txtTelefonoDoc.getText().isEmpty() || txtCorreoDoc.getText().isEmpty() || txtEstudiosDoc.getText().isEmpty()
                || txtNivEstudiosDoc.getText().isEmpty() || txtExpLabDoc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        } else {
            if (validLtrs(txtNombreDoc.getText()) && validLtrs(txtApellidoDoc.getText())
                    && validNums(txtEdadDoc.getText()) && validNums(txtDocumentoDoc.getText()) && validNums(txtTelefonoDoc.getText())
                    && validLtrs(txtNivEstudiosDoc.getText()) && validNums(txtExpLabDoc.getText())) {
                if (txtPswDoc.getText().equals(txtConfirmPswDoc.getText())) {
                    String user = txtUsuarioDoc.getText();
                    String psw = txtPswDoc.getText();
                    String nombre = txtNombreDoc.getText();
                    String apellido = txtApellidoDoc.getText();
                    int edad = Integer.parseInt(txtEdadDoc.getText());
                    String documento = txtDocumentoDoc.getText();
                    String telefono = txtTelefonoDoc.getText();
                    String correo = txtCorreoDoc.getText();
                    String estudios = txtEstudiosDoc.getText();
                    String nivEstudio = txtNivEstudiosDoc.getText();
                    int expLab = Integer.parseInt(txtExpLabDoc.getText());

                    boolean aux = controlador.registrarDocente(new Docente(nivEstudio, estudios, expLab,user, psw, nombre, apellido, edad, documento, telefono, correo));
                    if (aux) {
                        JOptionPane.showMessageDialog(this, "El docente ha ido registrado");
                        limpiarCamposDocente();
                        crearTablaDocentes();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo registrar");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Las contraseñas ingresadas no coinciden");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor ingrese caracteres correctos en cada campo");
            }
        }
    }//GEN-LAST:event_btnRegistrarDocActionPerformed

    private void btnEliminarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarDocActionPerformed
        // TODO add your handling code here:
        Docente aux = controlador.buscarDocente(txtUsuarioDoc.getText());
        if(aux != null){
            int i = JOptionPane.showConfirmDialog(this, "Está seguro de despedir al docente " + aux.getNombre() + " " + aux.getApellido()
            + " de la insitución?");
            
            if(i == 0){
                boolean eliminado = controlador.eliminarDocente(aux.getUser());
                if(eliminado){
                    JOptionPane.showMessageDialog(this, "El docente ha sido retirado de la institución");
                    limpiarCamposDocente();
                    crearTablaDocentes();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarDocActionPerformed

    private void btnCancelarDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarDocActionPerformed
        // TODO add your handling code here:
        limpiarCamposDocente();
    }//GEN-LAST:event_btnCancelarDocActionPerformed

    private void tableSalonesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSalonesMouseClicked
        // TODO add your handling code here:
        int seleccion = tableSalones.rowAtPoint(evt.getPoint());
        String numero = tableSalones.getValueAt(seleccion, 0).toString();
        txtBuscarSalon.setText(numero);
    }//GEN-LAST:event_tableSalonesMouseClicked

    private void btnBuscarSalonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSalonesActionPerformed
        // TODO add your handling code here:
        if (validNums(txtBuscarSalon.getText())) {
            int numero = Integer.parseInt(txtBuscarSalon.getText());
            Salon aux = controlador.buscarSalon(numero);
            if (aux != null) {
                txtNumSalon.setText(Integer.toString(aux.getNumero()));
                btnRegistrarSalon.setVisible(false);
                btnEliminarSalones.setVisible(true);
                btnCancelarSalones.setVisible(true);
                txtNumSalon.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese caracteres correctos");
        }
        txtBuscarSalon.setText("");
    }//GEN-LAST:event_btnBuscarSalonesActionPerformed

    private void btnRegistrarSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarSalonActionPerformed
        // TODO add your handling code here:
        if (txtNumSalon.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        } else {
            if (validNums(txtNumSalon.getText())) {
                int numero = Integer.parseInt(txtNumSalon.getText());
                Salon aux = controlador.buscarSalon(numero);
                if (aux == null) {
                    boolean registrado = controlador.registrarSalon(new Salon(numero));
                    if (registrado) {
                        JOptionPane.showMessageDialog(this, "El salón ha sido registrado");
                        limpiarCamposSalon();
                        crearTablaSalones();

                        llenarComboBoxsCursos();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El salón a registrar ya existe");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor llene los campos con los caracteres correctos");
            }
        }
    }//GEN-LAST:event_btnRegistrarSalonActionPerformed

    private void btnEliminarSalonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarSalonesActionPerformed
        // TODO add your handling code here:
        Salon aux = controlador.buscarSalon(Integer.parseInt(txtNumSalon.getText()));
        if(aux != null){
            int i = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar el salón " + aux.getNumero() + " de la insitución?");
            if(i == 0){
                boolean eliminado = controlador.eliminarSalon(aux.getNumero());
                if(eliminado){
                    JOptionPane.showMessageDialog(this, "El salón ha sido retirado de la institución");
                    limpiarCamposSalon();
                    crearTablaSalones();
                    
                    llenarComboBoxsCursos();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarSalonesActionPerformed

    private void btnCancelarSalonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarSalonesActionPerformed
        // TODO add your handling code here:
        limpiarCamposSalon();
    }//GEN-LAST:event_btnCancelarSalonesActionPerformed

    private void tableCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCursosMouseClicked
        // TODO add your handling code here:
        int seleccion = tableCursos.rowAtPoint(evt.getPoint());
        String idCurso = tableCursos.getValueAt(seleccion, 0).toString();
        txtBuscarCurso.setText(idCurso);
    }//GEN-LAST:event_tableCursosMouseClicked

    private void btnBuscarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCursoActionPerformed
        // TODO add your handling code here:
        if(validNums(txtBuscarCurso.getText())){
            int id = Integer.parseInt(txtBuscarCurso.getText());
            Curso aux = controlador.buscarCurso(id);
            if(aux != null){
                txtDocenteCurso.setText(aux.getDocente().getUser());
                cboxAsignatura.setSelectedItem(Integer.toString(aux.getAsignatura().getId()));
                cboxBloqueHrs.setSelectedItem(Integer.toString(aux.getBloqueHoras()));
                cboxSalon.setSelectedItem(Integer.toString(aux.getSalon().getNumero()));
                cboxDia.setSelectedItem(aux.getDia());
                cboxHoras.setSelectedItem(Integer.toString(aux.getHoras()[0]));
                lblIdCurso.setVisible(true);
                txtIdCurso.setVisible(true);
                txtIdCurso.setText(Integer.toString(id));
                btnRegistrarCurso.setVisible(false);
                btnEditarCurso.setVisible(true);
                btnEliminarCurso.setVisible(true);
                btnCancelarCurso.setVisible(true);
                btnEstudiantesCurso.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "No se encontró");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Por favor ingrese un id de curso válido");
        }
        txtBuscarCurso.setText("");
    }//GEN-LAST:event_btnBuscarCursoActionPerformed

    private void btnRegistrarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarCursoActionPerformed
        // TODO add your handling code here:
        if (txtDocenteCurso.getText().isEmpty() || cboxAsignatura.getSelectedItem().toString().equals("Seleccionar")
                || cboxBloqueHrs.getSelectedItem().toString().equals("Seleccionar") || cboxSalon.getSelectedItem().toString().equals("Seleccionar")
                || cboxDia.getSelectedItem().toString().equals("Seleccionar") || cboxHoras.getSelectedItem().toString().equals("Seleccionar")
                || cboxHoras.getSelectedItem().toString().equals("Selec día")) {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        } else {
                String docDocente = txtDocenteCurso.getText();
                Docente docente = controlador.buscarDocente(docDocente);
                if (docente != null) {
                    Asignatura asignatura = controlador.buscarAsignatura(Integer.parseInt(cboxAsignatura.getSelectedItem().toString()));
                    byte bloqueHoras = Byte.parseByte(cboxBloqueHrs.getSelectedItem().toString());
                    Salon salon = controlador.buscarSalon(Integer.parseInt(cboxSalon.getSelectedItem().toString()));
                    String dia = cboxDia.getSelectedItem().toString();
                    int horaInicio = Integer.parseInt(cboxHoras.getSelectedItem().toString());

                    boolean aux = controlador.registrarCurso(new Curso(docente, asignatura, bloqueHoras, salon, dia, horaInicio));

                    if (aux) {
                        JOptionPane.showMessageDialog(this, "El curso ha sido registrado");
                        limpiarCamposCurso();
                        crearTablaCursos();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo registrar");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario de docente no encontrado");
                }
        }
    }//GEN-LAST:event_btnRegistrarCursoActionPerformed

    private void tableAsignaturasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAsignaturasMouseClicked
        // TODO add your handling code here:
        int seleccion = tableAsignaturas.rowAtPoint(evt.getPoint());
        String id = tableAsignaturas.getValueAt(seleccion, 0).toString();
        txtBuscarAsignatura.setText(id);
    }//GEN-LAST:event_tableAsignaturasMouseClicked

    private void btnBuscarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAsignaturaActionPerformed
        // TODO add your handling code here:
        if (validNums(txtBuscarAsignatura.getText())) {
            Asignatura aux = controlador.buscarAsignatura(Integer.parseInt(txtBuscarAsignatura.getText()));
            if (aux != null) {
                txtNombreAsignatura.setText(aux.getNombre());
                txtDescAsignatura.setText(aux.getDesc());
                txtIdAsignatura.setText(Integer.toString(aux.getId()));
                btnRegistrarAsignatura.setVisible(false);
                btnEditarAsignatura.setVisible(true);
                btnEliminarAsignatura.setVisible(true);
                btnCancelarAsignatura.setVisible(true);
                txtIdAsignatura.setVisible(true);
                lblIdAsignatura.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor ingrese caracteres correctos");
        }
        txtBuscarAsignatura.setText("");
    }//GEN-LAST:event_btnBuscarAsignaturaActionPerformed

    private void btnRegistrarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarAsignaturaActionPerformed
        // TODO add your handling code here:
        if (txtNombreAsignatura.getText().isEmpty() || txtDescAsignatura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        } else {
            String nombre = txtNombreAsignatura.getText();
            String desc = txtDescAsignatura.getText();
            
            boolean aux = controlador.registrarAsignatura(new Asignatura(nombre, desc));
            
            if(aux){
                JOptionPane.showMessageDialog(this, "Asignatura registrada con éxito");
                limpiarCamposAsignatura();
                crearTablaAsignaturas();
                
                llenarComboBoxsCursos();
            }else{
                JOptionPane.showMessageDialog(this, "No se pudo registrar");
            }
        }
        
        
    }//GEN-LAST:event_btnRegistrarAsignaturaActionPerformed

    private void btnEditarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAsignaturaActionPerformed
        // TODO add your handling code here:
        if (txtNombreAsignatura.getText().isEmpty() || txtDescAsignatura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        } else {
            String nombre = txtNombreAsignatura.getText();
            String desc = txtDescAsignatura.getText();
            
            Asignatura aux = controlador.buscarAsignatura(Integer.parseInt(txtIdAsignatura.getText()));
            
            if(aux != null){
                aux.setNombre(nombre);
                aux.setDes(desc);
                
                limpiarCamposAsignatura();
                crearTablaAsignaturas();
                
                llenarComboBoxsCursos();
            }else{
                JOptionPane.showMessageDialog(this, "No se pudo modificar");
            }
        }
    }//GEN-LAST:event_btnEditarAsignaturaActionPerformed

    private void btnEliminarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAsignaturaActionPerformed
        // TODO add your handling code here:
        Asignatura aux = controlador.buscarAsignatura(Integer.parseInt(txtIdAsignatura.getText()));
        if(aux != null){
            int i = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar la asignatura " + aux.getNombre() + " de la insitución?");
            if(i == 0){
                boolean eliminado = controlador.eliminarAsignatura(aux.getId());
                if(eliminado){
                    JOptionPane.showMessageDialog(this, "La asignatura ha sido retirada de la institución");
                    limpiarCamposAsignatura();
                    crearTablaAsignaturas();
                    
                    llenarComboBoxsCursos();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarAsignaturaActionPerformed

    private void btnCancelarAsignaturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarAsignaturaActionPerformed
        // TODO add your handling code here:
        limpiarCamposAsignatura();
    }//GEN-LAST:event_btnCancelarAsignaturaActionPerformed

    private void cboxDiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxDiaItemStateChanged
        // TODO add your handling code here:
        String dia = cboxDia.getSelectedItem().toString();
        if(!dia.equals("Seleccionar") && !cboxSalon.getSelectedItem().toString().equals("Seleccionar")){
        int salon = Integer.parseInt(cboxSalon.getSelectedItem().toString());  
        cboxHoras.setModel(new DefaultComboBoxModel(controlador.crearArregloHoras(dia, salon)));
        }else{
            String[] array = new String[1];
            array[0] = "Selec día";
            cboxHoras.setModel(new DefaultComboBoxModel(array));
        }
    }//GEN-LAST:event_cboxDiaItemStateChanged

    private void cboxHorasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxHorasItemStateChanged
        // TODO add your handling code here:
        if (!cboxHoras.getSelectedItem().toString().equals("Selec día") && !cboxHoras.getSelectedItem().toString().equals("Seleccionar")) {
            if (!cboxBloqueHrs.getSelectedItem().toString().equals("Seleccionar")) {
                int numero = Integer.parseInt(cboxHoras.getSelectedItem().toString()) + Integer.parseInt(cboxBloqueHrs.getSelectedItem().toString()) - 1;
                int index = cboxHoras.getSelectedIndex() + Integer.parseInt(cboxBloqueHrs.getSelectedItem().toString()) - 1;
                if (index < cboxHoras.getItemCount()) {
                    int n2 = Integer.parseInt(cboxHoras.getItemAt(index));

                    if (numero != n2) {
                        JOptionPane.showMessageDialog(this, "La hora seleccionada no se encuentra disponible para el bloque de horas seleccionado");
                        cboxHoras.setSelectedIndex(0);
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "La hora seleccionada no se encuentra disponible para el bloque de horas seleccionado");
                    cboxHoras.setSelectedIndex(0);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un bloque de horas");
                cboxHoras.setSelectedIndex(0);
            }
        }
    }//GEN-LAST:event_cboxHorasItemStateChanged

    private void cboxBloqueHrsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxBloqueHrsItemStateChanged
        // TODO add your handling code here:
        String bloqueHrs = cboxBloqueHrs.getSelectedItem().toString();
        String dia = cboxDia.getSelectedItem().toString();
        
        if(!dia.equals("Seleccionar") && !bloqueHrs.equals("Seleccionar") && !cboxSalon.getSelectedItem().toString().equals("Seleccionar")){
        int salon = Integer.parseInt(cboxSalon.getSelectedItem().toString());
        cboxHoras.setModel(new DefaultComboBoxModel(controlador.crearArregloHoras(dia, salon)));
        }else{
            String[] array = new String[1];
            array[0] = "Selec día";
            cboxHoras.setModel(new DefaultComboBoxModel(array));
        }
    }//GEN-LAST:event_cboxBloqueHrsItemStateChanged

    private void cboxSalonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboxSalonItemStateChanged
        // TODO add your handling code here:
        String bloqueHrs = cboxBloqueHrs.getSelectedItem().toString();
        String dia = cboxDia.getSelectedItem().toString();
        
        if(!dia.equals("Seleccionar") && !bloqueHrs.equals("Seleccionar") && !cboxSalon.getSelectedItem().toString().equals("Seleccionar")){
        int salon = Integer.parseInt(cboxSalon.getSelectedItem().toString());
        cboxHoras.setModel(new DefaultComboBoxModel(controlador.crearArregloHoras(dia, salon)));
        }else{
            String[] array = new String[1];
            array[0] = "Selec día";
            cboxHoras.setModel(new DefaultComboBoxModel(array));
        }
    }//GEN-LAST:event_cboxSalonItemStateChanged

    private void btnEditarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCursoActionPerformed
        // TODO add your handling code here:
        if (txtDocenteCurso.getText().isEmpty() || cboxAsignatura.getSelectedItem().toString().equals("Seleccionar")
                || cboxBloqueHrs.getSelectedItem().toString().equals("Seleccionar") || cboxSalon.getSelectedItem().toString().equals("Seleccionar")
                || cboxDia.getSelectedItem().toString().equals("Seleccionar")) {
            JOptionPane.showMessageDialog(this, "Por favor llene todos los campos");
        } else {
                String userDocente = txtDocenteCurso.getText();
                Docente aux = controlador.buscarDocente(userDocente);
                if (aux != null) {
                    Asignatura asignatura = controlador.buscarAsignatura(Integer.parseInt(cboxAsignatura.getSelectedItem().toString()));
                    byte bloqueHoras = Byte.parseByte(cboxBloqueHrs.getSelectedItem().toString());
                    Salon salon = controlador.buscarSalon(Integer.parseInt(cboxSalon.getSelectedItem().toString()));
                    String dia = cboxDia.getSelectedItem().toString();

                    Curso curso = controlador.buscarCurso(Integer.parseInt(txtIdCurso.getText()));
                    
                    if(curso != null){
                        if(!curso.getSalon().equals(salon) || !curso.getDia().equals(dia) || curso.getBloqueHoras() != bloqueHoras){
                            if(!cboxHoras.getSelectedItem().toString().equals("Seleccionar")){
                                int horaInicio = Integer.parseInt(cboxHoras.getSelectedItem().toString());
                                curso.asignarHoras(horaInicio);
                                curso.setSalon(salon);
                                curso.setDia(dia);
                            }else{
                                JOptionPane.showMessageDialog(this, "No se pudieron modificar los siguientes datos: horas, día, salón");
                            }
                        }
                        curso.setAsignatura(asignatura);
                        curso.setDocente(aux);
                        JOptionPane.showMessageDialog(this, "Datos modificados");
                        
                        limpiarCamposCurso();
                        crearTablaCursos();
                    }else{
                        JOptionPane.showMessageDialog(this, "No se pudo modificar");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Usuario de docente no encontrado");
                }
        }
    }//GEN-LAST:event_btnEditarCursoActionPerformed

    private void btnEliminarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCursoActionPerformed
        // TODO add your handling code here:
        Curso aux = controlador.buscarCurso(Integer.parseInt(txtIdCurso.getText()));
        if(aux != null){
            int i = JOptionPane.showConfirmDialog(this, "Está seguro de eliminar el curso " + aux.getId() + " de la insitución?");
            if(i == 0){
                boolean eliminado = controlador.eliminarCurso(aux.getId());
                if(eliminado){
                    JOptionPane.showMessageDialog(this, "El curso ha sido retirada de la institución");
                    limpiarCamposCurso();
                    crearTablaCursos();
                }
            }
        }
    }//GEN-LAST:event_btnEliminarCursoActionPerformed

    private void btnCancelarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCursoActionPerformed
        // TODO add your handling code here:
        limpiarCamposCurso();
    }//GEN-LAST:event_btnCancelarCursoActionPerformed

    private void btnEstudiantesCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstudiantesCursoActionPerformed
        // TODO add your handling code here:
        Curso curso = controlador.buscarCurso(Integer.parseInt(txtIdCurso.getText()));
        if(curso != null){
            new vistaAdminGeneralEstudiantesCurso(curso, controlador, this).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnEstudiantesCursoActionPerformed

    private void tableHerramientasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableHerramientasMouseClicked
        // TODO add your handling code here:
        int seleccion = tableHerramientas.rowAtPoint(evt.getPoint());
        idHerramienta = Integer.parseInt(tableHerramientas.getValueAt(seleccion, 0).toString());
        
        Herramienta herramienta = controlador.buscarHerramienta(idHerramienta);
        if(herramienta != null && !herramienta.isDisponible()){
            btnCambiarEstado.setVisible(true);
        }else{
            btnCambiarEstado.setVisible(false);
        }
    }//GEN-LAST:event_tableHerramientasMouseClicked

    private void btnRegistrarHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarHerramientaActionPerformed
        // TODO add your handling code here:
        if (txtNombreHerramienta.getText().isEmpty() || comboBoxTipoHerramienta.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor llene correctamente los campos para registrar la herramienta");
        } else {
            boolean aux = controlador.registrarHerramienta(new Herramienta(txtNombreHerramienta.getText(), comboBoxTipoHerramienta.getSelectedItem().toString()));
            if (aux) {
                JOptionPane.showMessageDialog(this, "La herramienta se registró");
                crearTablaHerramientas();
                txtNombreHerramienta.setText("");
                comboBoxTipoHerramienta.setSelectedIndex(0);
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo registrar");
            }
        }
    }//GEN-LAST:event_btnRegistrarHerramientaActionPerformed

    private void btnEliminarHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHerramientaActionPerformed
        // TODO add your handling code here:
        Herramienta herramienta = controlador.buscarHerramienta(idHerramienta);
        if (herramienta != null) {
            if (herramienta.isDisponible()) {
                int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar la herramienta " + herramienta.getNombre() + "?");
                if (i == 0) {
                    boolean aux = controlador.eliminarHerramienta(herramienta.getId());
                    if (aux) {
                        JOptionPane.showMessageDialog(this, "La herramienta se eliminó");
                        crearTablaHerramientas();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo eliminar");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor cambie el estado de la herramienta para que esta pueda ser eliminada");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor seleccione una herramienta de la tabla");
        }
    }//GEN-LAST:event_btnEliminarHerramientaActionPerformed

    private void btnCambiarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarEstadoActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "¿Está seguro de devolver la herramienta?");
        if(i == 0){
            Herramienta herramienta = controlador.buscarHerramienta(idHerramienta);
            if(herramienta != null){
                herramienta.setDisponible(true);
                controlador.validarHerramientasPrestadas();
                Universidad.serializarHerramientas();
                Universidad.serializarLaboratorios();
                crearTablaHerramientas();
                JOptionPane.showMessageDialog(this, "La herramienta ahora se encuentra disponible");
            }else{
                JOptionPane.showMessageDialog(this, "No se pudo cambiar el estado de la herramienta");
            }
        }
    }//GEN-LAST:event_btnCambiarEstadoActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Gestion;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarAsignatura;
    private javax.swing.JButton btnBuscarCurso;
    private javax.swing.JButton btnBuscarDoc;
    private javax.swing.JButton btnBuscarSalones;
    private javax.swing.JButton btnCambiarEstado;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarAsignatura;
    private javax.swing.JButton btnCancelarCurso;
    private javax.swing.JButton btnCancelarDoc;
    private javax.swing.JButton btnCancelarSalones;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarAsignatura;
    private javax.swing.JButton btnEditarCuenta;
    private javax.swing.JButton btnEditarCurso;
    private javax.swing.JButton btnEditarDoc;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarAsignatura;
    private javax.swing.JButton btnEliminarCurso;
    private javax.swing.JButton btnEliminarDoc;
    private javax.swing.JButton btnEliminarHerramienta;
    private javax.swing.JButton btnEliminarSalones;
    private javax.swing.JButton btnEstudiantesCurso;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrarAsignatura;
    private javax.swing.JButton btnRegistrarCurso;
    private javax.swing.JButton btnRegistrarDoc;
    private javax.swing.JButton btnRegistrarHerramienta;
    private javax.swing.JButton btnRegistrarSalon;
    private javax.swing.JComboBox<String> cboxAsignatura;
    private javax.swing.JComboBox<String> cboxBloqueHrs;
    private javax.swing.JComboBox<String> cboxDia;
    private javax.swing.JComboBox<String> cboxHoras;
    private javax.swing.JComboBox<String> cboxSalon;
    private javax.swing.JComboBox<String> comboBoxTipoHerramienta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblIdAsignatura;
    private javax.swing.JLabel lblIdCurso;
    private javax.swing.JPanel panelDocentes;
    private javax.swing.JPanel panelDocentes1;
    private javax.swing.JPanel panelDocentes2;
    private javax.swing.JPanel panelDocentes3;
    private javax.swing.JPanel panelDocentes4;
    private javax.swing.JPanel panelEstudiantes;
    private javax.swing.JTable tableAsignaturas;
    private javax.swing.JTable tableCursos;
    private javax.swing.JTable tableDocentes;
    private javax.swing.JTable tableEstudiantes;
    private javax.swing.JTable tableHerramientas;
    private javax.swing.JTable tableSalones;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtApellidoCuenta;
    private javax.swing.JTextField txtApellidoDoc;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtBuscarAsignatura;
    private javax.swing.JTextField txtBuscarCurso;
    private javax.swing.JTextField txtBuscarDoc;
    private javax.swing.JTextField txtBuscarSalon;
    private javax.swing.JPasswordField txtConfirmPsw;
    private javax.swing.JPasswordField txtConfirmPswDoc;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCorreoCuenta;
    private javax.swing.JTextField txtCorreoDoc;
    private javax.swing.JTextField txtDescAsignatura;
    private javax.swing.JTextField txtDocenteCurso;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtDocumentoCuenta;
    private javax.swing.JTextField txtDocumentoDoc;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEdadCuenta;
    private javax.swing.JTextField txtEdadDoc;
    private javax.swing.JTextField txtEstudiosDoc;
    private javax.swing.JTextField txtExpLabDoc;
    private javax.swing.JTextField txtIdAsignatura;
    private javax.swing.JTextField txtIdCurso;
    private javax.swing.JTextField txtNivEstudiosDoc;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreAsignatura;
    private javax.swing.JTextField txtNombreCuenta;
    private javax.swing.JTextField txtNombreDoc;
    private javax.swing.JTextField txtNombreHerramienta;
    private javax.swing.JTextField txtNumSalon;
    private javax.swing.JPasswordField txtPsw;
    private javax.swing.JPasswordField txtPsw2Cuenta;
    private javax.swing.JPasswordField txtPswCuenta;
    private javax.swing.JPasswordField txtPswDoc;
    private javax.swing.JTextField txtPuntaje;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtTelefonoCuenta;
    private javax.swing.JTextField txtTelefonoDoc;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtUsuarioCuenta;
    private javax.swing.JTextField txtUsuarioDoc;
    // End of variables declaration//GEN-END:variables
}
