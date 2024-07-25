package sef.module4.activity;

import javax.swing.JOptionPane;

public class GeometriaMain {
	public static void main(String[] args) {
		//RETANGULOS
		
		Retangulo retangulo1 = new Retangulo(10, 5);
		retangulo1.calcularArea();
		retangulo1.calcularPerimetro();
		
		retangulo1.setBase(7);
		retangulo1.calcularArea();
		retangulo1.calcularPerimetro();
		
		// 5 instancias de retangulos
		
		for (int i = 1; i < 6; i++) {
			Retangulo retanguloLaco = new Retangulo();
			String baseString = JOptionPane.showInputDialog(null, "Informe qual a base do " + i + "º retangulo.");
			double base = Double.parseDouble(baseString);
			
			String alturaString = JOptionPane.showInputDialog(null, "Informe qual a altura do " + i + "º retangulo");
			double altura = Double.parseDouble(alturaString);
			
			retanguloLaco.setBase(base);
			retanguloLaco.setAltura(altura);
			retanguloLaco.calcularArea();
			retanguloLaco.calcularPerimetro();
		}
		
		// CIRCULOS
		
		Circulo circulo1 = new Circulo(10);
		circulo1.calcularArea();
		circulo1.calcularPerimetro();
		circulo1.setRaio(4);
		circulo1.calcularArea();
		circulo1.calcularPerimetro();
		
		// 5 instancias de circulos
		for (int i = 1; i < 6; i++) {
			Circulo circuloLaco = new Circulo();
			String raioString = JOptionPane.showInputDialog(null, "Informe o raio do "+ i +"º circulo.");
			double raio = Double.parseDouble(raioString);
			
			circuloLaco.setRaio(raio);
			circuloLaco.calcularArea();
			circuloLaco.calcularPerimetro();
		}
	}
}
