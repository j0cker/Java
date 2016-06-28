package com.example.prueba;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main extends JFrame {
	public static void main(String[] args) {
		// get screen dimension sizes
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		JFrame frame = new JFrame("Ventanilla");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		// le damos el tamaño a la ventana
		frame.setSize((int) width, (int) height);
		JPanel panel = new JPanel();
		layout(panel, frame);
	}

	public static void layout(JPanel panel, JFrame frame) {
		// matriz perfecta
		// panel.setLayout(new GridLayout(3, 3));
		panel.setLayout(new GridBagLayout());
		GridBagConstraints position = new GridBagConstraints();
		// natural height, maximum width
		JButton boton = new JButton("Click");
		position.fill = GridBagConstraints.HORIZONTAL;
		position.gridx = 0;
		position.gridy = 0;
		panel.add(boton, position);

		JButton boton2 = new JButton("Click");
		position.fill = GridBagConstraints.HORIZONTAL;
		position.gridx = 2;
		position.gridy = 0;
		position.insets = new Insets(0, 200, 0, 0); // Padding
		// position.fill = GridBagConstraints.HORIZONTAL;
		// position.ipady = 0; //reset to default
		// position.weighty = 1.0; //request any extra vertical space
		// position.anchor = GridBagConstraints.PAGE_END; //bottom of space
		// position.gridwidth = 2; // 2 columns wide
		// position.gridx = 1; // aligned with button 2
		// position.gridy = 2; // third row
		// position.ipady = 40; //make this component tall
		// position.ipadx = 40; //make this component long
		panel.add(boton2, position);
		frame.getContentPane().add(panel);
	}
	/*
	 * Layout null
	 * 
	 * NO usar layout. Somos nosotros desde código los que decimos cada botón en
	 * qué posición va y qué tamaño ocupa
	 * 
	 * contenedor.setLayout(null); // Eliminamos el layout contenedor.add
	 * (boton); // Añadimos el botón boton.setBounds (10,10,40,20); // Botón en
	 * posicion 10,10 con ancho 40 pixels y alto 20
	 * 
	 * Esto, aunque sencillo, no es recomendable. Si estiramos la ventana los
	 * componentes seguirán en su sitio, no se estirarán con la ventana. Si
	 * cambiamos de sistema operativo, resolución de pantalla o fuente de letra,
	 * tenemos casi asegurado que no se vean bien las cosas: etiquetas cortadas,
	 * letras que no caben, etposition.
	 * 
	 * Además, al no haber layout, la ventana no tiene tamaño adecuado.
	 * Deberemos dárselo nosotros con un ventana.setSize(...). Y si hacemos que
	 * sea un JPanel el que no tiene layout, para que este tenga un tamaño puede
	 * que incluso haga falta llamar a panel.setPreferredSize(...) o incluso en
	 * algunos casos, sobreescrbiendo el método panel.getPreferredSize()
	 */

	/*
	 * FlowLayout
	 * 
	 * Nos coloca los componente en fila. Hace que todos quepan (si el tamaño de
	 * la ventana lo permite). Es adecuado para barras de herramientas, filas de
	 * botones, etposition.
	 * 
	 * contenedor.setLayout(new FlowLayout()); contenedor.add(boton);
	 * contenedor.add(textField); contenedor.add(checkBox);
	 */

	/*
	 * BoxLayout
	 * 
	 * Es como un FlowLayout, pero mucho más completo. Permite colocar los
	 * elementos en horizontal o vertical.
	 * 
	 * // Para poner en vertical contenedor.setLayout(new
	 * BoxLayout(contenedor,BoxLayout.Y_AXIS)); contenedor.add(unBoton);
	 * contenedor.add(unaEtiqueta);
	 */

	/*
	 * GridLayout
	 * 
	 * Este pone los componentes en forma de matriz (cuadrícula), estirándolos
	 * para que tengan todos el mismo tamaño.
	 * 
	 * El GridLayout es adecuado para hacer tableros, calculadoras en que todos
	 * los botones son iguales, etposition.
	 * 
	 * // Creación de los botones JButton boton[] = new JButton[9]; for (int
	 * i=0;i<9;i++) boton[i] = new JButton(Integer.toString(i));
	 * 
	 * // Colocación en el contenedor contenedor.setLayout (new GridLayout
	 * (3,3)); // 3 filas y 3 columnas for (int i=0;i<9;i++) contenedor.add
	 * (boton[i]); // Añade los botones de 1 en 1.
	 */

	/*
	 * BorderLayout
	 * 
	 * El BorderLayout divide la ventana en 5 partes: centro, arriba, abajo,
	 * derecha e izquierda.
	 * 
	 * Hará que los componentes que pongamos arriba y abajo ocupen el alto que
	 * necesiten, pero los estirará horizontalmente hasta ocupar toda la
	 * ventana.
	 * 
	 * Los componentes de derecha e izquierda ocuparán el ancho que necesiten,
	 * pero se les estirará en vertical hasta ocupar toda la ventana.
	 * 
	 * El componente central se estirará en ambos sentidos hasta ocupar toda la
	 * ventana.
	 * 
	 * El BorderLayout es adecuado para ventanas en las que hay un componente
	 * central importante (una tabla, una lista, etc) y tiene menús o barras de
	 * herramientas situados arriba, abajo, a la derecha o a la izquierda.
	 * 
	 * Este es el layout por defecto para los JFrame y JDialog.
	 * 
	 * contenedor.setLayout (new BorderLayout()); contenedor.add
	 * (componenteCentralImportante, BorderLayout.CENTER); contenedor.add
	 * (barraHerramientasSuperior, BordeLayout.NORTH); contenedor.add
	 * (botonesDeAbajo, BorderLayout.SOUTH); contenedor.add (IndiceIzquierdo,
	 * BorderLayout.WEST); contenedor.add (MenuDerecha, BorderLayout.EAST);
	 * 
	 * Por ejemplo, es bastante habitual usar un contenedor (JPanel por ejemplo)
	 * con un FlowLayout para hacer una fila de botones y luego colocar este
	 * JPanel en el NORTH de un BorderLayout de una ventana. De esta forma,
	 * tendremos en la parte de arriba de la ventana una fila de botones, como
	 * una barra de herramientas.
	 * 
	 * JPanel barraHerramientas = new JPanel(); barraHerrameientas.setLayout(new
	 * FlowLayout()); barraHerramientas.add(new JButton("boton 1")); ...
	 * barraHerramientas.add(new JButton("boton n"));
	 * 
	 * JFrame ventana = new JFrame(); ventana.getContentPane().setLayout(new
	 * BorderLayout()); // No hace falta, por defecto ya es BorderLayout
	 * ventana.getContentPane().add(barraHerramientas, BorderLayout.NORTH);
	 * ventana.getContentPane().add(componentePrincipalDeVentana,
	 * BorderLayout.CENTER);
	 * 
	 * ventana.pack(); ventana.setVisible(true);
	 */

	/*
	 * GridBagLayout
	 * 
	 * El GridBagLayout es de los layouts más versátiles y complejos de usar. Es
	 * como el GridLayout, pone los componentes en forma de matriz (cuadrícula),
	 * pero permite que las celdas y los componentes en ellas tengan tamaños
	 * variados.
	 * 
	 * Es posible hacer que un componente ocupe varias celdas Un componente
	 * puede estirarse o no con su celda Si no se estira, puede quedar en el
	 * centro de la celda o pegarse a sus bordes o esquinas. Las columnas pueden
	 * ensancharse o no al estirar la ventana y la proporición podemos decidirla
	 * Lo mismo con la filas.
	 * 
	 * Explicar todo esto aquí es algo largo. En
	 * http://www.chuidiang.com/java/layout/GridBagLayout/GridBagLayout.php
	 * tienes un tutorial más completo de cómo usar este layout.
	 */

	/*
	 * CardLayout
	 * 
	 * El CardLayout hace que los componente recibidos ocupen el máximo espacio
	 * posible, superponiendo unos a otros. Sólo es visible uno de los
	 * componentes, los otros quedan detrás. Tiene métodos para indicar cual de
	 * los componentes es el que debe quedar encima y verse.
	 * 
	 * El CardLayout es el que utiliza el JTabbedPane (el de las pestañas) de
	 * forma que en función de la pestaña que pinchemos, se ve uno u otro.
	 * SpringLayout
	 * 
	 * Para los nostálgicos que usaban motif, este layout es muy similar a los
	 * attachment de motif.
	 * 
	 * Se añaden los componentes y para cada uno de ellos tenemos que decir qué
	 * distancia en pixel queremos que tenga cada uno de sus bordes respecto al
	 * borde de otro componente. Por ejemplo, para decir que el borde izquierdo
	 * de una etiqueta está a 5 pixels del panel que la contiene ponemos
	 * 
	 * layout.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST,
	 * contentPane);
	 * 
	 * Para decir que el borde derecho de la etiqueta debe estar a 5 pixels del
	 * borde izquierdo de un JTextField, ponemos esto
	 * 
	 * layout.putConstraint(SpringLayout.WEST, textField, 5, SpringLayout.EAST,
	 * label);
	 * 
	 * Con este layout, cuando estiramos el panel, siempre ceden aquellos
	 * componentes más "flexibles". Entre una etiqueta y una caja de texto, la
	 * caja de texto es la que cambia su tamaño.
	 */
}
