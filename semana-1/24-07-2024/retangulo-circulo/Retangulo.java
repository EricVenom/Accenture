package sef.module4.activity;

import javax.swing.JOptionPane;

public class Retangulo {
	private double base;
	private double altura;
	private double area;
	private double perimetro;
	
	public Retangulo() {}
	
	public Retangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}
	
	public void calcularArea() {
		this.area = this.base * this.altura;
		String areaFormatada = String.format("%.1f", this.area);
		JOptionPane.showMessageDialog(null, "Area do Retangulo = " + areaFormatada);
	}
	
	public void calcularPerimetro() {
		this.perimetro = (2 * this.base) + (2 * this.altura);
		String perimetroFormatado = String.format("%.1f", this.perimetro);
		JOptionPane.showMessageDialog(null, "Perimetro do Retangulos = " + perimetroFormatado);
	}
	
	public void setBase(double base) {
		this.base = base;
	}
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
}
