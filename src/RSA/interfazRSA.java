/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RSA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author GildoAlejandro
 */
public class interfazRSA extends javax.swing.JFrame {
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private RSA rsa;
    private ArrayList<String> textoEntrada,textoSalida;
    public String clavePublica= ""; 
    public int [][] matrizIntensidadEntrada,matrizIntensidadSalida;
    public clsImage1 imagenEntrada,imagenSalida;
    public boolean band=false;
    public int longitud=1024, precision=1000000;

    /**
     * Creates new form NewApplication
     */
    public interfazRSA() {
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        menuCopiar = new javax.swing.JMenuItem();
        tabImagen = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cajaTextoEntrada = new javax.swing.JTextArea();
        cajaClavePrivada = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cajaClavePublica = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        barraDeEspera = new javax.swing.JProgressBar();
        jScrollPane3 = new javax.swing.JScrollPane();
        cajaTextoSalida = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        botonCargaImagen = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        botonAbrir = new javax.swing.JButton();
        botonGuadar = new javax.swing.JButton();
        botonEjecutar = new javax.swing.JButton();
        comboOpciones = new javax.swing.JComboBox();
        jTextField3 = new javax.swing.JTextField();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        menuConfigurar = new javax.swing.JMenu();
        longitudClave = new javax.swing.JMenuItem();
        precisionClave = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        itemAyuda = new javax.swing.JMenuItem();
        itemNosotros = new javax.swing.JMenuItem();

        menuCopiar.setText("Copiar");
        jPopupMenu1.add(menuCopiar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Encriptado RSA");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        cajaTextoEntrada.setColumns(20);
        cajaTextoEntrada.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        cajaTextoEntrada.setLineWrap(true);
        cajaTextoEntrada.setRows(5);
        cajaTextoEntrada.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(cajaTextoEntrada);

        cajaClavePrivada.setColumns(1);
        cajaClavePrivada.setAutoscrolls(false);
        cajaClavePrivada.setMaximumSize(new java.awt.Dimension(214748, 214748));
        cajaClavePrivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaClavePrivadaActionPerformed(evt);
            }
        });

        jLabel2.setText("Clave Privada");

        cajaClavePublica.setAutoscrolls(false);
        cajaClavePublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaClavePublicaActionPerformed(evt);
            }
        });

        jLabel3.setText("Clave Publica");

        cajaTextoSalida.setEditable(false);
        cajaTextoSalida.setColumns(20);
        cajaTextoSalida.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        cajaTextoSalida.setLineWrap(true);
        cajaTextoSalida.setRows(5);
        jScrollPane3.setViewportView(cajaTextoSalida);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cajaClavePublica, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cajaClavePrivada, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(barraDeEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cajaClavePrivada, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cajaClavePublica, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraDeEspera, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabImagen.addTab("Texto", jPanel1);

        jDesktopPane1.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jDesktopPane1ComponentAdded(evt);
            }
        });

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );

        botonCargaImagen.setText("Cargar Imagen");
        botonCargaImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCargaImagenActionPerformed(evt);
            }
        });

        jButton2.setText("GO!");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Clave Publica");

        jLabel4.setText("Clave Privada");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jDesktopPane1)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(botonCargaImagen)
                        .addGap(77, 77, 77)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(23, 23, 23))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jButton2))
                    .addComponent(botonCargaImagen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabImagen.addTab("Imagen", jPanel2);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        botonAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RSA/abrir-el-archivo-icono-5096-32.png"))); // NOI18N
        botonAbrir.setFocusable(false);
        botonAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(botonAbrir);

        botonGuadar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RSA/disk.png"))); // NOI18N
        botonGuadar.setEnabled(false);
        botonGuadar.setFocusable(false);
        botonGuadar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuadarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonGuadar);

        botonEjecutar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/RSA/arrow-jugar-luego-a-la-derecha-icono-8834-32 - copia.png"))); // NOI18N
        botonEjecutar.setFocusable(false);
        botonEjecutar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                botonEjecutarItemStateChanged(evt);
            }
        });
        botonEjecutar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonEjecutarMouseExited(evt);
            }
        });
        botonEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEjecutarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonEjecutar);

        comboOpciones.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Encriptar", "Desencriptar" }));
        comboOpciones.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        comboOpciones.setFocusable(false);
        comboOpciones.setMaximumSize(new java.awt.Dimension(3276, 3276));
        comboOpciones.setOpaque(false);
        comboOpciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOpcionesActionPerformed(evt);
            }
        });
        jToolBar1.add(comboOpciones);

        jTextField3.setEditable(false);
        jTextField3.setForeground(new java.awt.Color(204, 204, 204));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField3.setBorder(null);
        jTextField3.setEnabled(false);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jTextField3);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Archivo");

        openMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Abrir");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Guardar");
        saveMenuItem.setEnabled(false);
        fileMenu.add(saveMenuItem);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText("Opciones");

        menuConfigurar.setText("Configurar");

        longitudClave.setText("Longitud de Clave");
        longitudClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                longitudClaveActionPerformed(evt);
            }
        });
        menuConfigurar.add(longitudClave);

        precisionClave.setText("Precision de Clave");
        precisionClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precisionClaveActionPerformed(evt);
            }
        });
        menuConfigurar.add(precisionClave);

        jMenu1.add(menuConfigurar);

        menuBar.add(jMenu1);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Ayuda");

        itemAyuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        itemAyuda.setMnemonic('c');
        itemAyuda.setText("Ayuda");
        itemAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAyudaActionPerformed(evt);
            }
        });
        helpMenu.add(itemAyuda);

        itemNosotros.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        itemNosotros.setMnemonic('a');
        itemNosotros.setText("Nosotros");
        itemNosotros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNosotrosActionPerformed(evt);
            }
        });
        helpMenu.add(itemNosotros);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabImagen)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
         botonAbrirActionPerformed( evt);
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void botonEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEjecutarActionPerformed
        if(band==false){
            textoEntrada = new ArrayList<String>();
            String texto = cajaTextoEntrada.getText() ;
            StringTokenizer st = new StringTokenizer(texto,"\n") ;
            while (st.hasMoreTokens()) {
                        String line = st.nextToken();
                        textoEntrada.add(line);
            }
        }
        if(cajaTextoEntrada.getText().compareTo("")!=0){
        barraDeEspera.setStringPainted(true);
        barraDeEspera.setValue(5);
            if(comboOpciones.getSelectedItem().toString().compareTo("Encriptar")== 0){
                rsa=new RSA(longitud,precision);
                textoSalida = new ArrayList<String>();
                for(int i=0; i< textoEntrada.size();i++){
                clsBigInteger textoplano = new clsBigInteger(textoEntrada.get(i).getBytes());
                clsBigInteger textocifrado = rsa.encriptar(textoplano);
                textoSalida.add(textocifrado.toString());
                }
                for(int i = 0 ; i < textoEntrada.size(); i++){
                cajaTextoSalida.setText(cajaTextoSalida.getText() + textoSalida.get(i)+"\n" );
                }
                cajaClavePublica.setText(rsa.getN().toString());
                cajaClavePrivada.setText(rsa.getD().toString());
                clavePublica = rsa.getN().toString();
                botonGuadar.setEnabled(true);
                saveMenuItem.setEnabled(true);
            }
            else{
               if(cajaClavePrivada.getText().compareTo("")!=0){
                cajaTextoSalida.setText("");
                rsa= new RSA(new clsBigInteger(cajaClavePrivada.getText()),new clsBigInteger(cajaClavePublica.getText()));
                textoSalida = new ArrayList<String>();
                for(int i=0; i < textoEntrada.size() ; i++){
                clsBigInteger textocifrado = rsa.desencriptar(new clsBigInteger(textoEntrada.get(i)));
                String salida =  new String(textocifrado.toByteArray());
                textoSalida.add(salida);
                }
                for(int i = 0 ; i < textoEntrada.size(); i++){
                cajaTextoSalida.setText(cajaTextoSalida.getText() + textoSalida.get(i)+"\n" );
                 System.out.println(textoSalida.get(i));
                }
                barraDeEspera.setValue(100);
                botonGuadar.setEnabled(true);
                saveMenuItem.setEnabled(true);
               }
               else error101();
            }
        
        }
       
        
        else error100();
            
        

    }//GEN-LAST:event_botonEjecutarActionPerformed

    private void comboOpcionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOpcionesActionPerformed
      limpiar();
    }//GEN-LAST:event_comboOpcionesActionPerformed

    private void botonEjecutarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonEjecutarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEjecutarMouseExited

    private void botonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAbrirActionPerformed
       textoEntrada= new ArrayList<String>();
       cajaTextoEntrada.setText("");
       cajaTextoSalida.setText("");
        
        
       if(comboOpciones.getSelectedItem().toString().compareTo("Encriptar")== 0){  
        String ruta = this.returnRuta();
        abrirTxt(ruta);
            for(int i = 0 ; i < textoEntrada.size(); i++){
                cajaTextoEntrada.setText(cajaTextoEntrada.getText() + textoEntrada.get(i)+"\n" );
            }
            band=true;
       }
            else{
            String ruta = this.returnRuta();
            abrirTxt(ruta);
            
            for(int i = 0 ; i < textoEntrada.size()-1; i++){
                cajaTextoEntrada.setText(cajaTextoEntrada.getText() + textoEntrada.get(i)+"\n" );
            }
            cajaClavePublica.setText(clavePublica=textoEntrada.get(textoEntrada.size()-1));
            band= true;
       }
       
     
        
    }//GEN-LAST:event_botonAbrirActionPerformed

    private void cajaClavePrivadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaClavePrivadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaClavePrivadaActionPerformed

    private void cajaClavePublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaClavePublicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cajaClavePublicaActionPerformed

    private void botonGuadarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuadarActionPerformed

    
        //Creamos el objeto JFileChooser
    JFileChooser fc=new JFileChooser();
 
    //Abrimos la ventana, guardamos la opcion seleccionada por el usuario
    int seleccion=fc.showSaveDialog(fc);
 
    //Si el usuario, pincha en aceptar
    if(seleccion==JFileChooser.APPROVE_OPTION){
 
        //Seleccionamos el fichero
        File fichero=fc.getSelectedFile();
        crearTxt(fichero.getPath());
      
        limpiar();

        }
        
        
        
    }//GEN-LAST:event_botonGuadarActionPerformed

    private void itemNosotrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNosotrosActionPerformed
        // TODO add your handling code here:
        mostrarMensaje("Encriptacion RSA\n Version 0.1.3 \n *Para Algoritmos y estructura de datos 2015*\n Programadores\n-Gildo Diaz\n-Facundo Gonzalez\nContacto:alemagno92@gmail.com");
    }//GEN-LAST:event_itemNosotrosActionPerformed

    private void itemAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAyudaActionPerformed
        // TODO add your handling code here:
        mostrarMensaje("Para Encriptar un texto hacer lo siguiente:\n1)carge un fichero txt\n2)Pulse ok\nLuego de unos minutos esto genera 2 claves");
        mostrarMensaje("Una publica y otra privada , presionando en guardar\nse guardara el texto encriptado y la clave publica\nPor razones de seguridad no se guardara la clave privada");
        mostrarMensaje("Para desencriptar solo necesita el texto encriptado junto con\n La clave publica y la privada que genero el programa ");
    }//GEN-LAST:event_itemAyudaActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void botonCargaImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCargaImagenActionPerformed

       String ruta = returnRuta();
       imagenEntrada = new clsImage1(ruta);
       imagenEntrada.generateIntensityM();
       matrizIntensidadEntrada = imagenEntrada.getIntensityM();
       imagenEntrada.displayImage();

    }//GEN-LAST:event_botonCargaImagenActionPerformed

    private void jDesktopPane1ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jDesktopPane1ComponentAdded
        
        
    }//GEN-LAST:event_jDesktopPane1ComponentAdded

    private void botonEjecutarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_botonEjecutarItemStateChanged
        
    }//GEN-LAST:event_botonEjecutarItemStateChanged

    private void longitudClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_longitudClaveActionPerformed
        int numero = ventanaCarga("Ingrese la longitud de la clave","La longitud de la clave ahora es: ",0,2048);
        if (numero != 0) this.longitud = numero;
        
    }//GEN-LAST:event_longitudClaveActionPerformed

    private void precisionClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precisionClaveActionPerformed
        int numero = ventanaCarga("Ingrese la Precision de la clave","La precision de la clave ahora es: ",0,1000000);
        if (numero != 0) this.precision = numero;
        
    }//GEN-LAST:event_precisionClaveActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    
     private String returnRuta(){
		javax.swing.JFileChooser explorador = new javax.swing.JFileChooser();
		int seleccion = explorador.showOpenDialog(explorador);
		explorador.setFileFilter(new FileNameExtensionFilter("txt && tif && TIF && TXT ","tif" ,"txt"));
		File archivo = explorador.getSelectedFile();
		String ruta = archivo.getPath();
		return ruta;
    }
    
     private void limpiar(){
      textoEntrada.clear();
      textoSalida.clear();
      clavePublica="";
      cajaTextoEntrada.setText("");
      cajaTextoSalida.setText("");
      cajaClavePrivada.setText("");
      cajaClavePublica.setText("");
      clavePublica = "";
      botonGuadar.setEnabled(false);
      saveMenuItem.setEnabled(false);
      barraDeEspera.setValue(0);
     }
     
    protected void error100(){
        advertencia("No se ha detectado ningun texto","Error 100");
    }
     protected void error101(){
        advertencia("No se ha ingresado Ninguna clave privada \n Recuerde que es una clave numerica","Error 101");
    }
    protected void error103(int min, int max){
        advertencia("Ingrese un numero  mayor a "+min+  "\n y menor a " + max,"Error 103");
    }
     
    
    
    
    
    protected void mostrarMensaje(String mensaje) {
                JOptionPane.showMessageDialog(this, mensaje, "Info",
                JOptionPane.INFORMATION_MESSAGE);
   }
   protected void advertencia(String mensaje,String titulo){
            JOptionPane.showMessageDialog(this, mensaje, titulo,
                                JOptionPane.ERROR_MESSAGE);
    }
   
   public void abrirTxt(String ruta) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File(ruta);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
               
			String linea;
			while ((linea = br.readLine()) != null){
                             if(linea.compareTo("")==0) linea =" ";
                                textoEntrada.add(linea);
                        }
				//this.textoEntrada =this.textoEntrada+ linea+"\n";
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}
   
   public void crearTxt(String ruta){
		
	FileWriter fichero = null;
        PrintWriter pw = null;
        try{
           fichero = new FileWriter(ruta);
           pw = new PrintWriter(fichero);
           //pw.println(info);
            for(int i=0;i < textoSalida.size();i++){
                 pw.println(textoSalida.get(i));
            }
            if(comboOpciones.getSelectedItem().toString().compareTo("Encriptar")== 0)pw.println(clavePublica);
           
 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
   }
   public int ventanaCarga(String mensaje, String mensaje2,int min,int max){
        int numero =0;
       String miValorIngresado = "";
        do{
        miValorIngresado=JOptionPane.showInputDialog(mensaje); 
        numero = Integer.parseInt(miValorIngresado);
        if(numero <min || numero >max ) error103(min,max);
        }while( numero <min || numero > max );
        JOptionPane.showMessageDialog(this,mensaje2 +" "+ miValorIngresado);
        return numero;
   }
   
   public String convertString(int fila){
       String aux ="";
       for(int i= 0; i < imagenEntrada.getWidth();i++){
           aux = aux + matrizIntensidadEntrada[fila][i];
       }
       return aux;
   }
   
   
    
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
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){
            e.printStackTrace();
        }
    	/*try{
    
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(interfazRSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(interfazRSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(interfazRSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(interfazRSA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfazRSA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraDeEspera;
    private javax.swing.JButton botonAbrir;
    private javax.swing.JButton botonCargaImagen;
    private javax.swing.JButton botonEjecutar;
    private javax.swing.JButton botonGuadar;
    private javax.swing.JTextField cajaClavePrivada;
    private javax.swing.JTextField cajaClavePublica;
    private javax.swing.JTextArea cajaTextoEntrada;
    private javax.swing.JTextArea cajaTextoSalida;
    private javax.swing.JComboBox comboOpciones;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuItem itemAyuda;
    private javax.swing.JMenuItem itemNosotros;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem longitudClave;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuConfigurar;
    private javax.swing.JMenuItem menuCopiar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem precisionClave;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JTabbedPane tabImagen;
    // End of variables declaration//GEN-END:variables

   
}
