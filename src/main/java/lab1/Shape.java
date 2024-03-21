package lab1;

import java.util.Objects;
import java.util.Random;

/** 
 * @author Khoroshko Ekaterina ZKI21-16B 21.03.2024
 * Класс Shape - абстрактный класс.
 * Содержит статические свойства MIN_DBL и MAX_DBL  - разрешенный диапазон значений параметров создаваемых фигур.
 * имеют модификатор доступа protected, что делает доступными эти поля для дочерних классов
 * */

public abstract class Shape { 
	/**Свойство color  - цвет фигуры */
	protected String color;
	
	 /** Минимальное значение дробного числа для задания параметров создаваемой фигуры*/
	protected static double MIN_DBL = 0;
	/** Максимальное значение дробного числа для задания параметров создаваемой фигуры*/
	protected static double MAX_DBL = 100;
	

	public Shape() {
		/** Поле color задается случайным образом из трех вариантов
		 * */
		String[] colors = {"RED", "GREEN", "BLUE"};
		Random random = new Random();
		int pos = random.nextInt(colors.length);
		color = colors[pos];
	}

	/** Абстрактный метод класса*/
	public abstract double area();
	
	/** Получает значение свойства color, которое можно задать с помощью метода {@link #setColor(String)}
    @return Значение свойства color
    */
	public String getColor() {
		return color;
	}
	

	 /** Задает значение свойства color, которое можно получить при помощи метода {@link #getColor()}
    @param color Новое значение свойства color
    */
	public void setColor(String color) {
		this.color = color;
	}
	
	/** Переопределен метод Object.hashCode()  */
	@Override
	public int hashCode() {
		return Objects.hash(color);
	}
	
	/** Переопределен метод Object.equals()  */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		return Objects.equals(color, other.color);
	}
	
	/** Переопределен метод Object.toString()  */
	@Override
	public String toString() {
		return "Shape [color=" + color + "]";
	}
	
	
}
