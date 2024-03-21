package lab1;

import java.util.Objects;

/** 
 * @author Khoroshko Ekaterina ZKI21-16B 21.03.2024
 * Класс Rectangle наследует абстрактный класс Shape, служит для хранения объектов-прямоугольников
 * Содержит поля параметров создаваемых фигур (cтороны side_a, side_b).
 * 
 * */
public class Rectangle extends Shape{
	/** Стороны прямоугольника */
	private double side_a, side_b;
	
	/** Конструктор класса по-умолчанию
	 * Поля сторон прямоугольника инициализируются нулевыми значениями
	 * Поле color инициализируется в базовом классе, 
	 * задается случайным образом из трех вариантов
	 *   */
	public Rectangle() {
		super();
		System.out.println("Создан прямоугольник по-умолчанию");
	}
		
	/** Конструктор класса с параметрами
	 *  @param double a новое значение свойства side_a
	 *  @param double b новое значение свойства side_b
	 *  
	 * Поле color инициализируется в базовом классе, 
	 * задается случайным образом из трех вариантов
	 * */
	public Rectangle(double a, double b) {
		super();

		side_a = a;
		side_b = b;
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
			System.out.println("Длина стороны 'a' прямоугольника доолжна быть положительным числом от 0 о 99");
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
		if (side_b < MIN_DBL || side_b > MAX_DBL) {
			System.out.println("Длина стороны 'b' прямоугольника доолжна быть положительным числом от 0 о 99");
			return;
		}
		this.side_b = side_b;
	}
		
	/** Переопределен абстрактный метод базового класса Shape
	 * Вычисляет площадь прямоугольника по формуле S = а * b
	 *  
	 *  @return площадь прямоугольника - число double
	 * */
	@Override
	public double area() {
		return side_a * side_b;
	}
	
	/** Переопределен метод Object.hashCode()  */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(side_a, side_b);
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
		Rectangle other = (Rectangle) obj;
		return Double.doubleToLongBits(side_a) == Double.doubleToLongBits(other.side_a)
				&& Double.doubleToLongBits(side_b) == Double.doubleToLongBits(other.side_b);
	}
	
	/** Переопределен метод Object.toString()  */
	@Override
	public String toString() {
		return "Rectangle [side_a=" + side_a + ", side_b=" + side_b  + ", color=" + color + ", area=" + area() + "]";
	}

}
