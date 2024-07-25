package sef.module4.activity;

import javax.swing.JOptionPane;

public class Circulo {
	private double raio;
	private double area;
	private double perimetro;
	
	public Circulo() {}
	public Circulo(double raio) {
		this.raio = raio;
	}
	
	public void setRaio(double raio) {
		this.raio = raio;
	}
	
	public void calcularArea() {
		this.area = (this.raio * this.raio) * Math.PI;
		String areaFormatada = String.format("%.1f", this.area);
		JOptionPane.showMessageDialog(null, "Area do Circulo = " + areaFormatada);
	}
	
	public void calcularPerimetro() {
		this.perimetro = (2 * Math.PI) * this.raio;
		String perimetroFormatado = String.format("%.1f", this.perimetro);
		JOptionPane.showMessageDialog(null, "Perimetro do Circulo = " + perimetroFormatado);
	}
}
