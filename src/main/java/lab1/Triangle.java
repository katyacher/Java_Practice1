package lab1;

import java.util.Objects;

/** 
 * @author Khoroshko Ekaterina ZKI21-16B 21.03.2024
 * Класс Triangle наследует абстрактный класс Shape служит для хранения объектов-треугольников
 * Содержит поля параметров создаваемых фигур (cтороны side_a, side_b, side_c).
 * 
 * */

public class Triangle extends Shape {
	/** Стороны треугольника */
	private double side_a, side_b, side_c; 
	
	/** Конструктор класса по-умолчанию
	 * Поля сторон треугольника инициализируются нулевыми значениями
	 * Поле color инициализируется в базовом классе, 
	 * задается случайным образом из трех вариантов
	 *   */
	public Triangle() {
		super();
		System.out.println("Создан треугольник по-умолчанию");
	}
	
	/** Конструктор класса с параметрами
	 *  @param double a новое значение свойства side_a
	 *  @param double b новое значение свойства side_b
	 *  @param double c новое значение свойства side_c
	 *  
	 * Поле color инициализируется в базовом классе, 
	 * задается случайным образом из трех вариантов
	 * */
	public Triangle(double a, double b, double c) {
		super();
		
		side_a = a;
		side_b = b;
		side_c = c;
		
	} 
	
	/** Получает значение поля  side_a, которое можно задать с помощью метода {@link #setSide_a(double)}
    @return Значение свойства side_a
    */
	public double getSide_a() {
		return side_a;
	}
	
	/** Задает значение поля side_a, которое можно получить при помощи метода {@link #setSide_a()}
    @param double side_a Новое значение свойства side_a
    */
	public void setSide_a(double side_a) {
		if (side_a < MIN_DBL || side_a > MAX_DBL) {
			System.out.println("Длина стороны 'a' треугольника доолжна быть положительным числом от 0 о 99");
			return;
		}
		this.side_a = side_a;
	}
	
	/** Получает значение поля  side_b, которое можно задать с помощью метода {@link #getSide_b(double)}
    @return Значение свойства side_b
    */
	public double getSide_b() {
		return side_b;
	}
	
	/** Задает значение поля side_b, которое можно получить при помощи метода {@link #getSide_b()}
    @param double side_b Новое значение свойства side_b
    */
	public void setSide_b(double side_b) {
		if (side_b < MIN_DBL || side_b > MIN_DBL) {
			System.out.println("Длина стороны 'b' треугольника доолжна быть положительным числом от 0 о 99");
			return;
		}
		this.side_b = side_b;
	}
	
	/** Получает значение поля  side_c, которое можно задать с помощью метода {@link #getSide_c(double)}
    @return Значение свойства side_c
    */
	public double getSide_c() {
		return side_c;
	}
	
	/** Задает значение поля side_c, которое можно получить при помощи метода {@link #setSide_c()}
    @param double side_c Новое значение свойства side_c
    */
	public void setSide_c(double side_c) {
		if (side_c < MIN_DBL || side_c > MIN_DBL) {
			System.out.println("Длина стороны 'c' треугольника доолжна быть положительным числом от 0 о 99");
			return;
		}
		this.side_c = side_c;
	}
	
	/** Переопределен абстрактный метод базового класса Shape
	 * Вычисляет площадь треугольника по трем сторонам (формула Герона):
	 *  p = (a + b + c) : 2 – полупериметр 
	 *  S=√(p⋅(p−a)⋅(p−b)⋅(p−c))
	 *  @return площадь треугольника - число double
	 * */
	@Override
	public double area() {
		double p = (side_a + side_b + side_c)/2; 
		
		return Math.sqrt(p * (p - side_a) * (p - side_b) * (p - side_c)); 
	}
	
	/** Переопределен метод Object.hashCode()  */
	@Override
	public int hashCode() {
		final int prime = 31; // простое число
		int result = super.hashCode();
		result = prime * result + Objects.hash(side_a, side_b, side_c);
		return result;
	}
	
	/** Переопределен метод Object.equals()  */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		return Double.doubleToLongBits(side_a) == Double.doubleToLongBits(other.side_a)
				&& Double.doubleToLongBits(side_b) == Double.doubleToLongBits(other.side_b)
				&& Double.doubleToLongBits(side_c) == Double.doubleToLongBits(other.side_c);
	}
	
	/** Переопределен метод Object.toString()  */
	@Override
	public String toString() {
		return "Triangle [side_a=" + side_a + ", side_b=" + side_b + ", side_c=" + side_c +  ", color=" + color + ", area="  + area() + "]";
	}

}
