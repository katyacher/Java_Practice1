package lab1;

import java.util.Objects;

/** 
* @author Khoroshko Ekaterina ZKI21-16B 21.03.2024
* Класс Square наследует абстрактный класс Shape служит для хранения объектов-квадратов
* Содержит поле параметров создаваемых фигур (cторона side_a).
* 
* */
public class Square extends Shape {
	/** Cторона квадрата */
	private double side_a; 
		
	/** Конструктор класса по-умолчанию
	 * Поле стороны квадрата инициализируется нулевыми значениями
	 * Поле color инициализируется в базовом классе, 
	 * задается случайным образом из трех вариантов
	 *   */
	public Square() {
		super();
		System.out.println("Создан квадрат по-умолчанию");
	}
	
	/** Конструктор класса с параметрами
	 *  @param double a новое значение свойства side_a
	 *  
	 * Поле color инициализируется в базовом классе, 
	 * задается случайным образом из трех вариантов
	 * */
	public Square(double a) {
		super();
		side_a = a;
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
			System.out.println("Сторона квадрата доолжна быть положительным числом от 0 о 99");
			return;
		}
		
		this.side_a = side_a;
	}

	/** Переопределен абстрактный метод базового класса Shape
	 * Вычисляет площадь квадрата по формуле S = а^2
	 *  
	 *  @return площадь квадрата - число double
	 * */
	@Override
	public double area() {
		return Math.pow(side_a, 2); // находим площадь квадрата по формуле S = а^2
	}

	/** Переопределен метод Object.hashCode()  */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(side_a);
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
		Square other = (Square) obj;
		return Double.doubleToLongBits(side_a) == Double.doubleToLongBits(other.side_a);
	}
	
	/** Переопределен метод Object.toString()  */
	@Override
	public String toString() {
		return "Square [side_a=" + side_a + ", color=" + color + ", area=" + area() + "]";
	}
}
