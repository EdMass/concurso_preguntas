package vistas;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import clases.ControladorArchivos;
import java.util.Collections;
import java.util.Random;
import javax.swing.DefaultListModel;

public class Juego extends javax.swing.JFrame {

    int nronda = 1, nresp = 0, npreg = 0, index = 0;
    ControladorArchivos archivos = new ControladorArchivos();
    ArrayList<String> respuestas = archivos.Repuestas();
    ArrayList<String> preguntas = archivos.Preguntas();
    ArrayList<String> jugador = archivos.Preguntas();
    ArrayList<String> listaJugadores = new ArrayList<>();
    DefaultListModel modelo = new DefaultListModel();
    String[][] baseDePreguntas = new String [5][5];
    String correcta;
    ArrayList<String> opciones = new ArrayList<>();
    Random random = new Random();
    int Puntos = 0;
    
    public Juego() {
        initComponents();
        Jugando();
        jList1.setModel(modelo);
    }
    
    public void Jugando(){
        BaseDePreguntas ();
        DevuelvePregunta(nronda);
        nronda++;
        jLabelPuntuacion.setText("Puntuacion : "+Integer.toString(Puntos));
    }
    
    public String[][] BaseDePreguntas (){
        for (int i = 0; i < 25; i++) {
           String [] pre = preguntas.get(i).split(",");
           if("1".equals(pre[0]) && i<5){
               
               baseDePreguntas [0][i]= pre[1]; 
               
           }else if("2".equals(pre[0]) && 5<=i && i<10){
               
                baseDePreguntas [1][i-5]= pre[1];
                
           }else if("3".equals(pre[0]) && 10<=i && i<15){
               
                baseDePreguntas [2][i-10]= pre[1];
                
           }else if("4".equals(pre[0]) && 15<=i && i<20){
               
                baseDePreguntas [3][i-15]= pre[1];
                
           }else if("5".equals(pre[0]) && 20<=i && i<25){
               
                    baseDePreguntas [4][i-20]= pre[1];
           }
        }
        return baseDePreguntas;
    }
    
    public void DevuelvePregunta(int nronda){
        if(nronda==1){
            jLabelRonda.setText("Ronda "+Integer.toString(nronda));
            index = random.nextInt(5);
            jLabelPregunta.setText(baseDePreguntas[0][index]);
            
            ListarRespuestas( index);
            
        }
        else if(nronda==2){
            jLabelRonda.setText("Ronda "+Integer.toString(nronda));
            index = random.nextInt(5);
            jLabelPregunta.setText(baseDePreguntas[1][index]);
            
            ListarRespuestas( index);
            
        }
        else if(nronda==3){
            jLabelRonda.setText("Ronda "+Integer.toString(nronda));
            index = random.nextInt(5);
            jLabelPregunta.setText(baseDePreguntas[2][index]);
            
            ListarRespuestas( index);
            
        }
        else if(nronda==4){
            jLabelRonda.setText("Ronda "+Integer.toString(nronda));
            index = random.nextInt(5);
            jLabelPregunta.setText(baseDePreguntas[3][index]);
            
            ListarRespuestas( index);
            
        }
        else if(nronda==5){
            jLabelRonda.setText("Ronda "+Integer.toString(nronda));
            index = random.nextInt(5);
            jLabelPregunta.setText(baseDePreguntas[4][index]);
            
            ListarRespuestas( index);
            
        }
    
    }  
    
    public void LlenarPregunta (int npreg){
        String [] pre = preguntas.get(npreg).split(",");
        jLabelPregunta.setText(pre[1]);
    }
    
    public void ListarRespuestas(int nresp){
        String cadena = respuestas.get(nresp);
        String [] rta = cadena.split(",");
        correcta = rta[0];
        opciones.clear();
        for (int i = 0; i < rta.length; i++) {
            opciones.add(rta[i]);
        }
        for (int i = 0; i < 4; i++) {
          Collections.shuffle(opciones);  
        }
        MostrarOpciones();
        
    }
    
    public void MostrarOpciones(){
        jLabelRespuesta1.setText(opciones.get(0));
        jLabelRespuesta2.setText(opciones.get(1));
        jLabelRespuesta3.setText(opciones.get(2));
        jLabelRespuesta4.setText(opciones.get(3));
    }
    
    public void SumaPuntos(){
        if (nronda-1==1){
            Puntos+=100;
        }else if (nronda-1==2){
            Puntos+=200;
        }else if (nronda-1==3){
            Puntos+=300;
        }else if (nronda-1==4){
            Puntos+=400;
        }else if (nronda-1==5){
            Puntos+=500;
        }
    }
    
    public void EscogerRespuesta(){
        if(opcion1.isSelected() && jLabelRespuesta1.getText().equals(correcta)){
            SumaPuntos();
            JOptionPane.showMessageDialog(this, 
                    "Esta es la respuesta correcta, llegas a " +Integer.toString(Puntos) + " Puntos"
                    , "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
            
            jLabelPuntuacion.setText("Puntuacion : "+Integer.toString(Puntos));
            
        }else if(opcion2.isSelected() && jLabelRespuesta2.getText().equals(correcta)){
            SumaPuntos();
            JOptionPane.showMessageDialog(this, 
                    "Esta es la respuesta correcta, llegas a " +Integer.toString(Puntos) + " Puntos"
                    , "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
            
            jLabelPuntuacion.setText("Puntuacion : "+Integer.toString(Puntos));
            
        }else if(opcion3.isSelected() && jLabelRespuesta3.getText().equals(correcta)){
            SumaPuntos();
            JOptionPane.showMessageDialog(this, 
                    "Esta es la respuesta correcta, llegas a " +Integer.toString(Puntos) + " Puntos"
                    , "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
            
            jLabelPuntuacion.setText("Puntuacion : "+Integer.toString(Puntos));
            
        }else if(opcion4.isSelected() && jLabelRespuesta4.getText().equals(correcta)){
            SumaPuntos();
            JOptionPane.showMessageDialog(this, 
                    "Esta es la respuesta correcta, llegas a " +Integer.toString(Puntos) + " Puntos"
                    , "Felicitaciones", JOptionPane.INFORMATION_MESSAGE);
            
            jLabelPuntuacion.setText("Puntuacion : "+Integer.toString(Puntos));
        }else{
            JOptionPane.showMessageDialog(this, 
                    "No era la respuesta correcta, debes iniciar de nuevo"
                    , "Error", JOptionPane.ERROR_MESSAGE);
            Principal abrir = new Principal();
            abrir.setVisible(true);
            this.setVisible(false);
            Puntos=0;
        }
    }
      
   
    public void Terminar(){
        String botones []  = {"Si", "No"};
        int eleccion = JOptionPane.showOptionDialog(this, "¿Desea terminar?", 
                "Terminar", 0, 0, null, botones, this);
        if(eleccion == JOptionPane.YES_OPTION){
            Principal abrir = new Principal();
            abrir.setVisible(true);
            this.setVisible(false);
        }else if (eleccion == JOptionPane.NO_OPTION){
            
        }
    }
    
    public void EnviarPrincipal(){
        Principal abrir = new Principal();
        abrir.setVisible(true);
        this.setVisible(false);
    }
    
    public void Finalizar(){
        if(nronda == 7){
            jDialog1.setVisible(true);
            jDialog1.setSize(543, 333);
            jDialog1.setLocation(420,150);
            jLabelTotalesPuntos.setText("Has ganado el Juego, tus puntos totales son "
                    +Integer.toString(Puntos));
        }else if (Puntos !=1500){
            jDialog1.dispose();
        }
    }
    
    public void listarJugadores(){
        String dato = jTextJugador.getText();
        listaJugadores.add(dato+" -> "+ Integer.toString(Puntos));
    }
    
    public void AgregarJugador(ArrayList<String> jugador){
        archivos.AddJugadores(jugador);
    } 
    
    public void MostrarJugadores(){
        ArrayList<String> jugadores = archivos.Jugadores();
        modelo.removeAllElements();
        for(String item:jugadores){
            modelo.addElement(item);
        }
    }
    
    public void AbrirHistorial(){
        jFrameHistorico.setVisible(true);
        jFrameHistorico.setSize(543, 453);
        jFrameHistorico.setLocation(420,100);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabelFelicitacion = new javax.swing.JLabel();
        Continuar = new javax.swing.JButton();
        jLabelTotalesPuntos = new javax.swing.JLabel();
        jFrameHistorico = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jButtonAceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButtonMostar = new javax.swing.JButton();
        jTextJugador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonCerrar = new javax.swing.JButton();
        Grupo1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelRonda = new javax.swing.JLabel();
        jLabelPregunta = new javax.swing.JLabel();
        opcion1 = new javax.swing.JRadioButton();
        opcion2 = new javax.swing.JRadioButton();
        opcion4 = new javax.swing.JRadioButton();
        opcion3 = new javax.swing.JRadioButton();
        terminar = new javax.swing.JButton();
        validar = new javax.swing.JButton();
        jLabelPuntuacion = new javax.swing.JLabel();
        jLabelRespuesta1 = new javax.swing.JLabel();
        jLabelRespuesta2 = new javax.swing.JLabel();
        jLabelRespuesta3 = new javax.swing.JLabel();
        jLabelRespuesta4 = new javax.swing.JLabel();

        jDialog1.setSize(new java.awt.Dimension(100, 100));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ando Preguntando"));

        jLabelFelicitacion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelFelicitacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFelicitacion.setText("¡¡¡ Felicitaciones !!!");
        jLabelFelicitacion.setToolTipText("");
        jLabelFelicitacion.setVerifyInputWhenFocusTarget(false);

        Continuar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Continuar.setText("Continuar");
        Continuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinuarActionPerformed(evt);
            }
        });

        jLabelTotalesPuntos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelTotalesPuntos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalesPuntos.setText("Has ganado el Juego, tus puntos totales son # ");
        jLabelTotalesPuntos.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(Continuar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jLabelFelicitacion))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabelTotalesPuntos)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabelFelicitacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jLabelTotalesPuntos)
                .addGap(27, 27, 27)
                .addComponent(Continuar)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jFrameHistorico.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Ando Preguntando"));

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jList1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        jButtonMostar.setText("Mostrar");
        jButtonMostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Escribir el nombre del Jugador");

        jButtonCerrar.setText("Cerrar");
        jButtonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(137, 137, 137)
                                    .addComponent(jButtonMostar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextJugador))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jButtonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAceptar)
                    .addComponent(jButtonMostar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCerrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jFrameHistoricoLayout = new javax.swing.GroupLayout(jFrameHistorico.getContentPane());
        jFrameHistorico.getContentPane().setLayout(jFrameHistoricoLayout);
        jFrameHistoricoLayout.setHorizontalGroup(
            jFrameHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameHistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jFrameHistoricoLayout.setVerticalGroup(
            jFrameHistoricoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrameHistoricoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ando Preguntando"));

        jLabelRonda.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRonda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRonda.setText("Ronda 1");

        jLabelPregunta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPregunta.setText("Pregunta 1");

        Grupo1.add(opcion1);

        Grupo1.add(opcion2);

        Grupo1.add(opcion4);

        Grupo1.add(opcion3);

        terminar.setText("Terminar intento");
        terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarActionPerformed(evt);
            }
        });

        validar.setText("Validar respuesta");
        validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validarActionPerformed(evt);
            }
        });

        jLabelPuntuacion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelPuntuacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPuntuacion.setText("Puntuación");

        jLabelRespuesta1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRespuesta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRespuesta1.setText("Respuesta 1");

        jLabelRespuesta2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRespuesta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRespuesta2.setText("Respuesta 2");

        jLabelRespuesta3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRespuesta3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRespuesta3.setText("Respuesta 3");

        jLabelRespuesta4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelRespuesta4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRespuesta4.setText("Respuesta 4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(opcion2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRespuesta2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(opcion3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRespuesta3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(opcion4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelRespuesta4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(opcion1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelRespuesta1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(validar)
                        .addGap(44, 44, 44)
                        .addComponent(terminar)
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabelRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRonda)
                    .addComponent(jLabelPuntuacion))
                .addGap(41, 41, 41)
                .addComponent(jLabelPregunta)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcion1)
                    .addComponent(jLabelRespuesta1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcion2)
                    .addComponent(jLabelRespuesta2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcion3)
                    .addComponent(jLabelRespuesta3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcion4)
                    .addComponent(jLabelRespuesta4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(terminar)
                    .addComponent(validar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinuarActionPerformed
        AbrirHistorial();
        jDialog1.dispose();
    }//GEN-LAST:event_ContinuarActionPerformed

    private void validarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarActionPerformed

        BaseDePreguntas ();
        EscogerRespuesta();
        DevuelvePregunta(nronda);
        nronda++;
        Finalizar();
    }//GEN-LAST:event_validarActionPerformed

    private void terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarActionPerformed
        Terminar();
    }//GEN-LAST:event_terminarActionPerformed

    private void jButtonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarActionPerformed
        EnviarPrincipal();
        jFrameHistorico.dispose();
    }//GEN-LAST:event_jButtonCerrarActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed
        listarJugadores();
        AgregarJugador(listaJugadores);
        jTextJugador.removeAll();
        jButtonAceptar.setEnabled(false);
        jTextJugador.setEditable(false);
    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jButtonMostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostarActionPerformed
        MostrarJugadores();
    }//GEN-LAST:event_jButtonMostarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Continuar;
    private javax.swing.ButtonGroup Grupo1;
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonCerrar;
    private javax.swing.JButton jButtonMostar;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrameHistorico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelFelicitacion;
    private javax.swing.JLabel jLabelPregunta;
    private javax.swing.JLabel jLabelPuntuacion;
    private javax.swing.JLabel jLabelRespuesta1;
    private javax.swing.JLabel jLabelRespuesta2;
    private javax.swing.JLabel jLabelRespuesta3;
    private javax.swing.JLabel jLabelRespuesta4;
    private javax.swing.JLabel jLabelRonda;
    private javax.swing.JLabel jLabelTotalesPuntos;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextJugador;
    private javax.swing.JRadioButton opcion1;
    private javax.swing.JRadioButton opcion2;
    private javax.swing.JRadioButton opcion3;
    private javax.swing.JRadioButton opcion4;
    private javax.swing.JButton terminar;
    private javax.swing.JButton validar;
    // End of variables declaration//GEN-END:variables
}
