
/*

SubneteoX 1.0

Copyright 2013 Oliver Soria Pelaez

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

*/


package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;




//import logic.Dir;
import logic.Prefix;
import logic.HosReq;
import logic.RedReq;


public class Window2 implements ActionListener {
	int numSub;
	int oct1, oct2, oct3, oct4;
	int psI;
	int hoI;
	int reI;
	
	JFrame ventana;
	JScrollPane js;
	JTable tabla;
	JButton cal;
	JButton limp;
	JButton sal;
	JButton ant;
	JButton sig;
	JButton ir;
	JTextField irS_C;
	
	JTextField dirIp_1_C = new JTextField();
    JTextField dirIp_2_C = new JTextField();
    JTextField dirIp_3_C = new JTextField();
    JTextField dirIp_4_C = new JTextField();
    JTextField prefix_C = new JTextField();
    JTextField numSu_C = new JTextField();
    JTextField numHo_C = new JTextField();
    
    JTextField clas_C = new JTextField();
    JTextField bitP_C = new JTextField();
    JTextField subT_C = new JTextField();
    JTextField subU_C = new JTextField();
    JTextField hosT_C = new JTextField();
    JTextField hosU_C = new JTextField();
    JTextField mPrd_C = new JTextField();
    JTextField mPer_C = new JTextField();
    
    List<JTextField> tfList = new ArrayList<JTextField>();
    List<JTextField> tfList2 = new ArrayList<JTextField>();
    
	Window2() {
		iniciaComponentes();
	}
	
	private void iniciaComponentes() {
		ventana = new JFrame("Subneteo IPv4");
		ventana.setLayout(null);
        ventana.setResizable(false);
        ventana.setSize(603, 355);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        numSub = 0;
        
        JLabel dirIp_E = new JLabel("Dirección IP:");
        JLabel numSu_E = new JLabel("Número de subredes:");
        JLabel numHo_E = new JLabel("Número de host:");
        JLabel clas_E = new JLabel("Clase:");
        JLabel bitP_E = new JLabel("Bits prestados:");
        JLabel mPrd_E = new JLabel("Predeterminada:");
        JLabel mPer_E = new JLabel("Personalizada:");
        JLabel subT_E = new JLabel("Totales:");
        JLabel subU_E = new JLabel("Usables:");
        JLabel hosT_E = new JLabel("Totales:");
        JLabel hosU_E = new JLabel("Usables:");
        JLabel irS_E = new JLabel("Ir a la subred:");
        JLabel p1_E = new JLabel(".");
        JLabel p2_E = new JLabel(".");
        JLabel p3_E = new JLabel(".");
        JLabel diag_E = new JLabel("/");
        
        JPanel inf = new JPanel();
        JPanel panel = new JPanel();
        JPanel masc = new JPanel();
        JPanel sub = new JPanel();
        JPanel host = new JPanel();
        
        irS_C = new JTextField();
        cal = new JButton("Calcular");
        limp = new JButton("Limpiar");
        sal = new JButton("Salir");
        ant = new JButton("<");
        sig = new JButton(">");
        ir = new JButton("Ir");
        
        cal.addActionListener(this);
        limp.addActionListener(this);
        ant.addActionListener(this);
        sig.addActionListener(this);
        ir.addActionListener(this);
        dirIp_1_C.addActionListener(this);
        dirIp_2_C.addActionListener(this);
        dirIp_3_C.addActionListener(this);
        dirIp_4_C.addActionListener(this);
        prefix_C.addActionListener(this);
        clas_C.setEditable(false);
        bitP_C.setEditable(false);
        mPrd_C.setEditable(false);
        mPer_C.setEditable(false);
        subT_C.setEditable(false);
        subU_C.setEditable(false);
        hosT_C.setEditable(false);
        hosU_C.setEditable(false);
        ant.setEnabled(false);
        sig.setEnabled(false);
        ir.setEnabled(false);
        irS_C.setEditable(false);
        
        inf.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
        masc.setBorder(new TitledBorder(null, "Máscaras", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sub.setBorder(new TitledBorder(null, "Subredes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		host.setBorder(new TitledBorder(null, "Host", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		panel.setBorder(new TitledBorder(null, "Direcciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
        String[] encabezado = {"Subred", "ID Subred", "Primera Dirección", "Ultima Direción", "Broadcast"};
               
        Object[][] data = {
        		{null, null, null, null, null},
        };
        
        
        
        tabla = new JTable(data, encabezado);
        
        tabla.getColumnModel().getColumn(0).setMaxWidth(80);
        
        tabla.setEnabled(false);
        
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        
        for(int x = 0; x < 5; x ++){
        	tabla.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
           }
        
        js = new JScrollPane(tabla);
        
        dirIp_E.setBounds(20, 20, 87, 15);
        numHo_E.setBounds(20, 70, 118, 15);
        numSu_E.setBounds(20, 45, 153, 15);
        clas_E.setBounds(194, 99, 44, 15);
        bitP_E.setBounds(264, 99, 109, 15);
        mPrd_E.setBounds(23, 140, 120, 15);
        mPer_E.setBounds(23, 164, 171, 15);
        subT_E.setBounds(285, 140, 58, 15);
        subU_E.setBounds(285, 164, 62, 15);
        
        hosT_E.setBounds(443, 140, 58, 15);
        hosU_E.setBounds(443, 164, 62, 15);
        irS_E.setBounds(354, 207, 99, 15);
        
        dirIp_1_C.setBounds(109, 19, 30, 19);
        dirIp_2_C.setBounds(146, 19, 30, 19);
        dirIp_3_C.setBounds(183, 19, 30, 19);
        dirIp_4_C.setBounds(220, 19, 30, 19);
        prefix_C.setBounds(257, 19, 20, 19);
        numHo_C.setBounds(140, 69, 104, 19);
        numSu_C.setBounds(175, 44, 69, 19);
        clas_C.setBounds(240, 97, 20, 19);        
        bitP_C.setBounds(374, 97, 26, 19);
        mPrd_C.setBounds(145, 138, 115, 19);
        mPer_C.setBounds(132, 162, 128, 19);
        subT_C.setBounds(345, 138, 73, 19);
        subU_C.setBounds(349, 162, 69, 19);
        
        hosT_C.setBounds(503, 138, 73, 19);
        hosU_C.setBounds(507, 162, 69, 19);
        irS_C.setBounds(455, 205, 69, 20);
        inf.setBounds(17, 92, 566, 30);
        panel.setBounds(15, 191, 570, 126);
        masc.setBounds(15, 123, 254, 68);
        sub.setBounds(277, 123, 150, 68);
        host.setBounds(435, 123, 150, 68);
        cal.setBounds(350, 20, 117, 25);
        limp.setBounds(350, 55, 117, 25);
        js.setBounds(25, 235, 551, 39);
        ir.setBounds(526, 205, 50, 20);
        ant.setBounds(241, 281, 50, 25);
        sig.setBounds(311, 281, 50, 25);
        
        p1_E.setBounds(140, 22, 87, 15);;
        p2_E.setBounds(177, 22, 87, 15); ;
        p3_E.setBounds(214, 22, 87, 15); ;
        diag_E.setBounds(251, 22, 87, 15) ;
        
              
        ventana.add(dirIp_E);
        ventana.add(numSu_E);
        ventana.add(dirIp_1_C);
        ventana.add(dirIp_2_C);
        ventana.add(dirIp_3_C);
        ventana.add(dirIp_4_C);
        ventana.add(prefix_C);
        ventana.add(p1_E);
        ventana.add(p2_E);
        ventana.add(p3_E);
        ventana.add(diag_E);
        ventana.add(numHo_E);
        ventana.add(numSu_C);
        ventana.add(numHo_C);
        ventana.add(clas_E);
        ventana.add(clas_C);
        ventana.add(bitP_E);
        ventana.add(bitP_C);
        ventana.add(mPrd_E);
        ventana.add(mPrd_C);
        ventana.add(mPer_E);
        ventana.add(mPer_C);
        ventana.add(subT_E);
        ventana.add(subT_C);
        ventana.add(subU_E);
        ventana.add(subU_C);
        ventana.add(hosT_E);
        ventana.add(hosT_C);
        ventana.add(hosU_E);
        ventana.add(hosU_C);
        ventana.add(cal);
        ventana.add(limp);
        ventana.add(irS_C);
        ventana.add(ir);
        ventana.add(irS_E);
        ventana.add(js);
        ventana.add(ant);
        ventana.add(sig);
                
        ventana.add(inf);
        ventana.add(masc);
        ventana.add(sub);
        ventana.add(host);
        ventana.add(panel);
        
        tfList.add(dirIp_1_C);
        tfList.add(dirIp_2_C);
        tfList.add(dirIp_3_C);
        tfList.add(dirIp_4_C);
        tfList.add(prefix_C);
        tfList.add(numSu_C);
        tfList.add(numHo_C);
        tfList.add(clas_C);
        tfList.add(bitP_C);
        tfList.add(subT_C);
        tfList.add(subU_C);
        tfList.add(hosT_C);
        tfList.add(hosU_C);
        tfList.add(mPer_C);
        tfList.add(mPrd_C);
        tfList.add(irS_C);
              
        tfList2.add(clas_C);
        tfList2.add(bitP_C);
        tfList2.add(subT_C);
        tfList2.add(subU_C);
        tfList2.add(hosT_C);
        tfList2.add(hosU_C);
        tfList2.add(mPer_C);
        tfList2.add(mPrd_C);
        tfList2.add(irS_C);
    }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Calcular")) {
			
			String a = prefix_C.getText();
			String b = numSu_C.getText(); 
			String c = numHo_C.getText();
					
			if(a.equals("")) {
				System.out.println("No hay prefijo");
				if(b.equals("")) {
					System.out.println("No hay subredes");
					if(c.equals("")) {
						System.out.println("No hay host");
						JOptionPane.showMessageDialog(new JFrame(), "¡Verifique los datos de entrada!");
						//Esto limpia todos los campos inabilitados
						for (JTextField tf : tfList2) {  
					        tf.setText("");  
					      }
						//Esto limpia la tabla
						tabla.getModel().setValueAt(null,0,0);
						tabla.getModel().setValueAt(null,0,1);
						tabla.getModel().setValueAt(null,0,2);
						tabla.getModel().setValueAt(null,0,3);
						tabla.getModel().setValueAt(null,0,4);
						//Esto deshabilita los botones y el campo inferiores
						ant.setEnabled(false);
				        sig.setEnabled(false);
				        ir.setEnabled(false);
				        irS_C.setEditable(false);
					} else {
						/**************************************************************/
						/*****Si hay host aqui va todo lo que tiene que hacer*****/
						//Primero que nada ponemos a cero el contador
						numSub = 0;
						System.out.println("Se detectaron host " + numHo_C.getText());
						//Extraemos el valor de los campos en los octetos
						String oct1S = dirIp_1_C.getText();
						String oct2S = dirIp_2_C.getText();
						String oct3S = dirIp_3_C.getText();
						String oct4S = dirIp_4_C.getText();
						//Verificamos que cada campo tenga enteros 
						try {
							oct1 = Integer.parseInt(oct1S);
							oct2 = Integer.parseInt(oct2S);
							oct3 = Integer.parseInt(oct3S);
							oct4 = Integer.parseInt(oct4S);
						} catch (NumberFormatException ex) {
							//Si no hay enteros da aviso y limpia parte inferior
							JOptionPane.showMessageDialog(new JFrame(), "¡Verifique los datos de entrada!");
							//Esto limpia todos los campos inabilitados
							for (JTextField tf : tfList2) {  
						        tf.setText("");  
						      }
							//Esto limpia la tabla
							tabla.getModel().setValueAt(null,0,0);
							tabla.getModel().setValueAt(null,0,1);
							tabla.getModel().setValueAt(null,0,2);
							tabla.getModel().setValueAt(null,0,3);
							tabla.getModel().setValueAt(null,0,4);
							//Esto deshabilita los botones y el campo inferiores
							ant.setEnabled(false);
					        sig.setEnabled(false);
					        ir.setEnabled(false);
					        irS_C.setEditable(false);
						}
						
						//Creamos el objeto para trbajar
						HosReq h = new HosReq(dirIp_1_C.getText(), dirIp_2_C.getText(), dirIp_3_C.getText(), dirIp_4_C.getText());
						System.out.println(h.dir);
						//Leemos el campo del host
						String hostRqS = numHo_C.getText();
						//Verificamos que tenga un entero
						try {
							hoI = Integer.parseInt(hostRqS);
						}catch (NumberFormatException ex) {
							//Si no es entero muestra mensaje 
							JOptionPane.showMessageDialog(new JFrame(), "¡Verifique los datos de entrada!");
							//Esto limpia todos los campos inabilitados
							for (JTextField tf : tfList2) {  
						        tf.setText("");  
						      }
							//Esto limpia la tabla
							tabla.getModel().setValueAt(null,0,0);
							tabla.getModel().setValueAt(null,0,1);
							tabla.getModel().setValueAt(null,0,2);
							tabla.getModel().setValueAt(null,0,3);
							tabla.getModel().setValueAt(null,0,4);
							//Esto deshabilita los botones y el campo inferiores
							ant.setEnabled(false);
					        sig.setEnabled(false);
					        ir.setEnabled(false);
					        irS_C.setEditable(false);
					        //Y evitamos que los calculos continuen
					        psI = Integer.parseInt(hostRqS);
						}
						//Calculamos m
						hoI += 2;
						int m = h.m(hoI);
						//Calculamos los bits prestados 
						String nS = h.n(h.dir, m);
						bitP_C.setText(nS);
						//Calculamos el total de las subredes
						subT_C.setText(h.total(nS));
						//Calculamos las subredes usables
						subU_C.setText(h.usable(nS));
						//calulamos la clase
						clas_C.setText(h.clas(h.dir));
						//Calculamos el numero total de host
						hosT_C.setText(h.totalH(m));
						//calculamos el numero total de host "usables"
						hosU_C.setText(h.usableH(m));
						//calculamos la Mascara de Subred predeterminada
						mPrd_C.setText(h.mPre(h.dir));
						//Calculamos la Mascara de Subred personalizada
						String myMask = h.mask(nS);
						mPer_C.setText(h.maskPerso(h.dir, myMask, nS));
						//Rellenamos el campo del prefijo
						prefix_C.setText(h.deCon(mPer_C.getText()));
						//calculamos el "numero" de la Subred
						tabla.getModel().setValueAt(numSub,0,0);
						//calculamos el id de "x" subred
						int totH = 0;
						totH = Integer.parseInt(h.totalH(m));
						System.out.println("host h=" + totH);
						long salto = h.salto(h.dir, totH, numSub);
						String salS = h.conversor(salto);
						tabla.getModel().setValueAt(salS,0,1);
						//calculamos la primera IP asignable
						long salto1 = h.salto(h.dir, totH, numSub) +1;
						String salS1 = h.conversor(salto1);
						tabla.getModel().setValueAt(salS1,0,2);
						//calculamos el Broadcast
						long salto4 = h.salto(h.dir, totH, numSub) + totH - 1;
						String salto4S = h.conversor(salto4);
						tabla.getModel().setValueAt(salto4S,0,4);
						//calculamos la ultima IP asignable
						long salto3 = h.salto(h.dir, totH, numSub) + totH - 2;
						String salto3S = h.conversor(salto3);
						tabla.getModel().setValueAt(salto3S,0,3);
						//Habilitamos la tabla para poder copiar datos
						tabla.setEnabled(true);
						//Habilitamos el boton ">"
						sig.setEnabled(true);
						ant.setEnabled(false);
						ir.setEnabled(true);
						irS_C.setEditable(true);
						irS_C.setText(null);
						
					}
				} else {
					/*********************************************************************/
					/*****Si hay REDES requeridas aqui va todo lo que tiene que hacer*****/
					//Primero que nada ponemos a cero el contador
					numSub = 0;
					System.out.println("Se detectaron subredes " + numSu_C.getText());
					//Extraemos el valor de los campos en los octetos
					String oct1S = dirIp_1_C.getText();
					String oct2S = dirIp_2_C.getText();
					String oct3S = dirIp_3_C.getText();
					String oct4S = dirIp_4_C.getText();
					//Verificamos que cada campo tenga enteros 
					try {
						oct1 = Integer.parseInt(oct1S);
						oct2 = Integer.parseInt(oct2S);
						oct3 = Integer.parseInt(oct3S);
						oct4 = Integer.parseInt(oct4S);
					} catch (NumberFormatException ex) {
						//Si no hay enteros da aviso y limpia parte inferior
						JOptionPane.showMessageDialog(new JFrame(), "¡Verifique los datos de entrada!");
						//Esto limpia todos los campos inabilitados
						for (JTextField tf : tfList2) {  
					        tf.setText("");  
					      }
						//Esto limpia la tabla
						tabla.getModel().setValueAt(null,0,0);
						tabla.getModel().setValueAt(null,0,1);
						tabla.getModel().setValueAt(null,0,2);
						tabla.getModel().setValueAt(null,0,3);
						tabla.getModel().setValueAt(null,0,4);
						//Esto deshabilita los botones y el campo inferiores
						ant.setEnabled(false);
				        sig.setEnabled(false);
				        ir.setEnabled(false);
				        irS_C.setEditable(false);
					}
					
					//Creamos el objeto para trbajar
					RedReq r = new  RedReq(dirIp_1_C.getText(), dirIp_2_C.getText(), dirIp_3_C.getText(), dirIp_4_C.getText());
					System.out.println(r.dir);
					//Leemos el campo de las redes
					String redRqS = numSu_C.getText();
					//Verificamos que tenga un entero
					try {
						reI = Integer.parseInt(redRqS);
					}catch (NumberFormatException ex) {
						//Si no es entero muestra mensaje 
						JOptionPane.showMessageDialog(new JFrame(), "¡Verifique los datos de entrada!");
						//Esto limpia todos los campos inabilitados
						for (JTextField tf : tfList2) {  
					        tf.setText("");  
					      }
						//Esto limpia la tabla
						tabla.getModel().setValueAt(null,0,0);
						tabla.getModel().setValueAt(null,0,1);
						tabla.getModel().setValueAt(null,0,2);
						tabla.getModel().setValueAt(null,0,3);
						tabla.getModel().setValueAt(null,0,4);
						//Esto deshabilita los botones y el campo inferiores
						ant.setEnabled(false);
				        sig.setEnabled(false);
				        ir.setEnabled(false);
				        irS_C.setEditable(false);
				        //Y evitamos que los calculos continuen
				        psI = Integer.parseInt(redRqS);
					}
					//Calculamos n (bits prestados)
					reI += 2;
					r.n = r.n(reI);
					String nS = String.valueOf(r.n);
					bitP_C.setText(nS);
					//Calculamos el total de subredes
					subT_C.setText(r.total(nS));
					//Calculamos las subredes usables
					subU_C.setText(r.usable(nS));
					//calulamos la clase
					clas_C.setText(r.clas(r.dir));
					//calulamos m (necesario para obtener host totales)
					int m = Integer.parseInt(r.m(r.dir, r.n));
					//Obtenemos los host totales
					hosT_C.setText(r.totalH(m));
					//Obtenemos los host usables
					hosU_C.setText(r.usableH(m));
					//calculamos la Mascara de Subred predeterminada
					mPrd_C.setText(r.mPre(r.dir));
					String myMask = r.mask(nS);
					mPer_C.setText(r.maskPerso(r.dir, myMask, nS));
					//Rellenamos el campo del prefijo
					prefix_C.setText(r.deCon(mPer_C.getText()));
					//calculamos el "numero" de la Subred
					tabla.getModel().setValueAt(numSub,0,0);
					//calculamos el id de "x" subred
					int totH = 0;
					totH = Integer.parseInt(r.totalH(m));
					System.out.println("host h=" + totH);
					long salto = r.salto(r.dir, totH, numSub);
					String salS = r.conversor(salto);
					tabla.getModel().setValueAt(salS,0,1);
					//calculamos la primera IP asignable
					long salto1 = r.salto(r.dir, totH, numSub) +1;
					String salS1 = r.conversor(salto1);
					tabla.getModel().setValueAt(salS1,0,2);
					//calculamos el Broadcast
					long salto4 = r.salto(r.dir, totH, numSub) + totH - 1;
					String salto4S = r.conversor(salto4);
					tabla.getModel().setValueAt(salto4S,0,4);
					//calculamos la ultima IP asignable
					long salto3 = r.salto(r.dir, totH, numSub) + totH - 2;
					String salto3S = r.conversor(salto3);
					tabla.getModel().setValueAt(salto3S,0,3);
					//Habilitamos la tabla para poder copiar datos
					tabla.setEnabled(true);
					//Habilitamos el boton ">"
					sig.setEnabled(true);
					ant.setEnabled(false);
					ir.setEnabled(true);
					irS_C.setEditable(true);
					irS_C.setText(null);
				}
			} else {
				/**************************************************************/
				/*****Si hay prefijo aqui va todo lo que tiene que hacer*****/
				//Primero que nada ponemos a cero el contador
				numSub = 0;
				System.out.println("Se detecto prefijo " + prefix_C.getText());
				//Extraemos el valor de los campos en los octetos
				String oct1S = dirIp_1_C.getText();
				String oct2S = dirIp_2_C.getText();
				String oct3S = dirIp_3_C.getText();
				String oct4S = dirIp_4_C.getText();
				//Verificamos que cada campo tenga enteros 
				try {
					oct1 = Integer.parseInt(oct1S);
					oct2 = Integer.parseInt(oct2S);
					oct3 = Integer.parseInt(oct3S);
					oct4 = Integer.parseInt(oct4S);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(new JFrame(), "¡Verifique los datos de entrada!");
					//Esto limpia todos los campos inabilitados
					for (JTextField tf : tfList2) {  
				        tf.setText("");  
				      }
					//Esto limpia la tabla
					tabla.getModel().setValueAt(null,0,0);
					tabla.getModel().setValueAt(null,0,1);
					tabla.getModel().setValueAt(null,0,2);
					tabla.getModel().setValueAt(null,0,3);
					tabla.getModel().setValueAt(null,0,4);
					//Esto deshabilita los botones y el campo inferiores
					ant.setEnabled(false);
			        sig.setEnabled(false);
			        ir.setEnabled(false);
			        irS_C.setEditable(false);
				}
				
				//Creamos el objeto para trbajar
				Prefix p = new Prefix(dirIp_1_C.getText(), dirIp_2_C.getText(), dirIp_3_C.getText(), dirIp_4_C.getText());
				System.out.println(p.dir);
				//Leemos el camo del prefijo
				String pxS = prefix_C.getText();
				//Verificamos que tenga un entero
				try {
					psI = Integer.parseInt(pxS);
				}catch (NumberFormatException ex) {
					//Si no es entero muestra mensaje 
					JOptionPane.showMessageDialog(new JFrame(), "¡Verifique los datos de entrada!");
					//Esto limpia todos los campos inabilitados
					for (JTextField tf : tfList2) {  
				        tf.setText("");  
				      }
					//Esto limpia la tabla
					tabla.getModel().setValueAt(null,0,0);
					tabla.getModel().setValueAt(null,0,1);
					tabla.getModel().setValueAt(null,0,2);
					tabla.getModel().setValueAt(null,0,3);
					tabla.getModel().setValueAt(null,0,4);
					//Esto deshabilita los botones y el campo inferiores
					ant.setEnabled(false);
			        sig.setEnabled(false);
			        ir.setEnabled(false);
			        irS_C.setEditable(false);
			        //Y evitamos que los calculos continuen
			        psI = Integer.parseInt(pxS);
				}
				p.prefix = psI;
				System.out.println("m = " + p.m(p.prefix));
				//calculamos los bits prestados
				bitP_C.setText(p.n(p.dir, p.m(p.prefix)));		
				//calulamos la clase
				clas_C.setText(p.clas(p.dir));
				//calculamos el numero total de subredes
				subT_C.setText(p.total(p.n(p.dir, p.m(p.prefix))));
				//calculamos el numero de subredes "usables"
				subU_C.setText(p.usable(p.n(p.dir, p.m(p.prefix))));
				//calculamos el numero total de host
				hosT_C.setText(p.totalH(p.m));
				//calculamos el numero total de host "usables"
				hosU_C.setText(p.usableH(p.m));
				//calculamos la Mascara de Subred predeterminada
				mPrd_C.setText(p.mPre(p.dir));
				//calculamos la Mascara de Subred personalizada
				String myMask = p.mask(p.n(p.dir, p.m(p.prefix)));
				p.mask = Integer.parseInt(myMask);
				mPer_C.setText(p.maskPerso(p.dir, myMask, p.n(p.dir, p.m(p.prefix))));
				//calculamos el "numero" de la Subred
				tabla.getModel().setValueAt(numSub,0,0);
				//calculamos el id de "x" subred
				int totH = 0;
				totH = Integer.parseInt(p.totalH(p.m));
				long salto = p.salto(p.dir, totH, numSub);
				String salS = p.conversor(salto);
				tabla.getModel().setValueAt(salS,0,1);
				//calculamos la primera IP asignable
				long salto1 = p.salto(p.dir, totH, numSub) +1;
				String salS1 = p.conversor(salto1);
				tabla.getModel().setValueAt(salS1,0,2);
				//calculamos el Broadcast
				long salto4 = p.salto(p.dir, totH, numSub) + totH - 1;
				String salto4S = p.conversor(salto4);
				tabla.getModel().setValueAt(salto4S,0,4);
				//calculamos la ultima IP asignable
				long salto3 = p.salto(p.dir, totH, numSub) + totH - 2;
				String salto3S = p.conversor(salto3);
				tabla.getModel().setValueAt(salto3S,0,3);
				//Habilitamos la tabla para poder copiar datos
				tabla.setEnabled(true);
				//Habilitamos el boton ">"
				sig.setEnabled(true);
				ant.setEnabled(false);
				ir.setEnabled(true);
				irS_C.setEditable(true);
				irS_C.setText(null);
			}
		
			
		} else if (e.getActionCommand().equals("Limpiar")) {
			//Esto limpia todos los campos y pone a cero el contador
			numSub = 0;
			for (JTextField tf : tfList) {  
		        tf.setText("");  
		      }
			//Esto limpia la tabla
			tabla.getModel().setValueAt(null,0,0);
			tabla.getModel().setValueAt(null,0,1);
			tabla.getModel().setValueAt(null,0,2);
			tabla.getModel().setValueAt(null,0,3);
			tabla.getModel().setValueAt(null,0,4);
			//Esto deshabilita los botones y el campo inferiores
			ant.setEnabled(false);
	        sig.setEnabled(false);
	        ir.setEnabled(false);
	        irS_C.setEditable(false);
	        
			
		} else if (e.getActionCommand().equals(">")) {
			//Primero agregamos uno al contados
			numSub++;
			System.out.println(numSub);
			//Creamos el objeto para trabajar
			Prefix p = new Prefix(dirIp_1_C.getText(), dirIp_2_C.getText(), dirIp_3_C.getText(), dirIp_4_C.getText());
			//calculamos el "numero" de la Subred
			tabla.getModel().setValueAt(numSub,0,0);
			//calculamos el id de "x" subred
			int totH = Integer.parseInt(hosT_C.getText());
			System.out.println(totH);
			long salto = p.salto(p.dir, totH, numSub);
			String salS = p.conversor(salto);
			tabla.getModel().setValueAt(salS,0,1);
			//calculamos la primera IP asignable
			long salto1 = p.salto(p.dir, totH, numSub) +1;
			String salS1 = p.conversor(salto1);
			tabla.getModel().setValueAt(salS1,0,2);
			//calculamos el Broadcast
			long salto4 = p.salto(p.dir, totH, numSub) + totH - 1;
			String salto4S = p.conversor(salto4);
			tabla.getModel().setValueAt(salto4S,0,4);
			//calculamos la ultima IP asignable
			long salto3 = p.salto(p.dir, totH, numSub) + totH - 2;
			String salto3S = p.conversor(salto3);
			tabla.getModel().setValueAt(salto3S,0,3);
			//Si el contador es mayor a cero activamos el boton "<"
			String totSub = subT_C.getText();
			int totS_Int = Integer.parseInt(totSub);
			System.out.println(totS_Int);
			if (numSub >= 0) {
				ant.setEnabled(true);
			} 
			if (numSub == totS_Int - 1) {
				sig.setEnabled(false);
			}
		} else if (e.getActionCommand().equals("<")) {
			//Primero restamos uno al contador
			numSub--;
			System.out.println(numSub);
			//Creamos el objeto para trabajar
			Prefix p = new Prefix(dirIp_1_C.getText(), dirIp_2_C.getText(), dirIp_3_C.getText(), dirIp_4_C.getText());
			//calculamos el "numero" de la Subred
			tabla.getModel().setValueAt(numSub,0,0);
			//calculamos el id de "x" subred
			int totH = Integer.parseInt(hosT_C.getText());
			System.out.println(totH);
			long salto = p.salto(p.dir, totH, numSub);
			String salS = p.conversor(salto);
			tabla.getModel().setValueAt(salS,0,1);
			//calculamos la primera IP asignable
			long salto1 = p.salto(p.dir, totH, numSub) +1;
			String salS1 = p.conversor(salto1);
			tabla.getModel().setValueAt(salS1,0,2);
			//calculamos el Broadcast
			long salto4 = p.salto(p.dir, totH, numSub) + totH - 1;
			String salto4S = p.conversor(salto4);
			tabla.getModel().setValueAt(salto4S,0,4);
			//calculamos la ultima IP asignable
			long salto3 = p.salto(p.dir, totH, numSub) + totH - 2;
			String salto3S = p.conversor(salto3);
			tabla.getModel().setValueAt(salto3S,0,3);
			//Calculamos el total de subredes
			int totS_Int = Integer.parseInt(subT_C.getText());
			System.out.println(totS_Int);
			//Si el contador es mayor a cero activamos el boton "<"
			if (numSub == 0) {
				ant.setEnabled(false);
			}
			//Si el contador llega al limite edesactivamos ">"
			if (numSub < totS_Int) {
				sig.setEnabled(true);
			} else {
				sig.setEnabled(false);
			}
			
		} else if (e.getActionCommand().equals("Ir")) {
			//Primero obtenemos la info del campo
			String numS_Ir = irS_C.getText();
			//Filtro para que solo lea numeros enteros
			try {
				numSub = Integer.parseInt(numS_Ir);
				System.out.println(numSub);
			} catch (NumberFormatException  ex) {
				JOptionPane.showMessageDialog(new JFrame(), "¡Introduzca números enteros!");
				irS_C.setText(null);
			}
			//Creamos el objeto para trabajar
			Prefix p = new Prefix(dirIp_1_C.getText(), dirIp_2_C.getText(), dirIp_3_C.getText(), dirIp_4_C.getText());
			
			/*String pxS = prefix_C.getText();
			int psI = Integer.parseInt(pxS); 
			p.prefix = psI;
			//La siguiente linea es necesaria
			p.m(p.prefix);*/
			//Calculamos el total de subredes
			//String totSub = p.total(p.n(p.dir, p.m(p.prefix)));
			int totS_Int = Integer.parseInt(subT_C.getText());
			System.out.println(totS_Int);
			//Verificamos que el entero este dentro del rango
			int tsm = totS_Int - 1;
			if(numSub < 0) {
				JOptionPane.showMessageDialog(new JFrame(), "La subred debe ser de 0 a " + tsm);
				irS_C.setText(null);
			} else if (numSub > tsm) {
				JOptionPane.showMessageDialog(new JFrame(), "La subred debe ser de 0 a " + tsm);
				irS_C.setText(null);
				//Aqui debe tomar el valor de la tabla (# de subred)
				numSub =  (int) tabla.getValueAt(0, 0);
				
			} else {//Si esta dentro del rango procedemos con lo siguiente
				//calculamos el "numero" de la Subred
				tabla.getModel().setValueAt(numSub,0,0);
				//calculamos el id de "x" subred
				int totH = Integer.parseInt(hosT_C.getText());
				System.out.println("host=" + totH);
				long salto = p.salto(p.dir, totH, numSub);
				String salS = p.conversor(salto);
				tabla.getModel().setValueAt(salS,0,1);
				//calculamos la primera IP asignable
				long salto1 = p.salto(p.dir, totH, numSub) +1;
				String salS1 = p.conversor(salto1);
				tabla.getModel().setValueAt(salS1,0,2);
				//calculamos el Broadcast
				long salto4 = p.salto(p.dir, totH, numSub) + totH - 1;
				String salto4S = p.conversor(salto4);
				tabla.getModel().setValueAt(salto4S,0,4);
				//calculamos la ultima IP asignable
				long salto3 = p.salto(p.dir, totH, numSub) + totH - 2;
				String salto3S = p.conversor(salto3);
				tabla.getModel().setValueAt(salto3S,0,3);
				
				if (numSub == 0) {
					ant.setEnabled(false);
					sig.setEnabled(true);
				}else if (numSub == tsm) {
					sig.setEnabled(false);
					ant.setEnabled(true);
				}else {
					sig.setEnabled(true);
					ant.setEnabled(true);
				}
			}
		}
	}
	
	public static void main (String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Window2();
			}
		
		});
	}

	

}


