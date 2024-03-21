package lab1;

import java.util.ArrayList;
import java.util.Scanner;
/** 
 * @author Khoroshko Ekaterina ZKI21-16B 21.03.2024
 * Класс Main содержит статические свойства shapes, scanner, MIN_INT, MAX_INT.
 * В классе реализовано пользовательское меню для работы с коллекцией объектов фигурв главном методе main(), 
 * а также методы добавления, удаления, просмотра элементов коллекции и сравнения двух элементов из коллекции.
 * 
 *	 
 *  * @exception NumberFormatException -  непроверяемое исключение. Вызывают конструкторы  Integer(), Double(), когда не могут преобразовать строку в числовй тип
 * с помощью методов parseInt() и parseDouble() соответственно.
 * */
 


public class Main {
	/** Минимальное значение целого числа для работы с меню*/
	private static final int MIN_INT = 0;
	/** Максимальное значение целого числа для работы с меню*/
    	private static final int MAX_INT = 6;
    
	/** Коллекция фигур - статическое свойство класса Main */
    	public static ArrayList<Shape> shapes = new ArrayList<>();
    
    	/**  Объект сканнера для чтения данных из консоли */
    	public static Scanner scanner = new Scanner(System.in);
    
    	/** Главный метод программы. Запускает цикл для работы в меню программы*/
	public static void main(String[] args) {
		
		String s= "";
		int answer = 0;

        while( !"5".equals(s)){
        	System.out.println("");
            System.out.println("Выберете действие:");
            System.out.println("1. Добавить новый элемент "); 
            System.out.println("2. Удалить элемент по индексу");
            System.out.println("3. Вывод всех элементов в консоль");
            System.out.println("4. Сравнение двух элементов на равенство (по индексам)");
            System.out.println("5. Завершение работы приложения.");
            
            s = scanner.next(); 
            
            try {
            	answer = Integer.parseInt(s);
            	
            	if(answer > MIN_INT && answer < MAX_INT){
                    switch (answer) {
                        case 1:
                            add();
                            break;
                        case 2:
                            remove();
                            break;
                        case 3:
                            show();
                            break;
                        case 4:
                            compare();
                            break;
                        case 5:
                        	System.out.println("Exit");
                            scanner.close();
                            return;
                        default:
                            break;
                    }
                } else {
                    System.out.println("Некорректный диапазон, попробуйте снова!");
                    answer = 0; // устанавливаем answer в 0 для повторного ввода
                }
            	
            }catch ( NumberFormatException e) {
            	System.out.println("Необходимо ввести число от 1 до 5.");
            };
            
        }
	}
       

	/** Статический метод класса Main, осуществляет создание выбранной пользователем фигуры производного класса 
	 * и добавление ее в коллекцию элементов типа базового класса.
	 * @exception NumberFormatException -  непроверяемое исключение, вызывается конструктором Double()
	 * при неудачной попытке преобразования стркового типа к числовому типу  методом parseDouble()
	 * */
	public static void add() {
		System.out.println("Выберете тип добавляемой фигуры (Triangle, Rectangle, Square)");
		scanner.skip(".*\n");
		String ans = scanner.nextLine();
		
		String s = "";		
		if(ans.equals("Triangle")) {
			System.out.println("Введите значения сторон треугольника:");
			
			try{
				System.out.println("a = ");
				s = scanner.next(); 
				double a = Double.parseDouble(s);
				
				System.out.println("b = ");
				s = scanner.next(); 
				double b = Double.parseDouble(s);
				
				System.out.println("c = ");
				s = scanner.next(); 
				double c = Double.parseDouble(s);
				
				if (a < Shape.MIN_DBL || a > Shape.MAX_DBL) {
					System.out.println("Длина стороны 'a' треугольника доолжна быть положительным числом от 0 о 99");
					return;
				}
				if (b < Shape.MIN_DBL || b > Shape.MAX_DBL) {
					System.out.println("Длина стороны 'b' треугольника доолжна быть положительным числом от 0 о 99");
					return;
				}
				if (c < Shape.MIN_DBL || c > Shape.MAX_DBL) {
					System.out.println("Длина стороны 'c' треугольника доолжна быть положительным числом от 0 о 99");
					return;
				}
				
				Shape triangle = new Triangle(a, b, c);
				shapes.add(triangle);
				
			}catch ( NumberFormatException e) {
            	System.out.println("Необходимо ввести число.");
            };
			
		} else if(ans.equals("Rectangle")) {
			System.out.println("Введите значения сторон прямоугольника:");
			
			try{
				System.out.println("a = ");
				s = scanner.next(); 
				double a = Double.parseDouble(s);
				
				System.out.println("b = ");
				s = scanner.next(); 
				double b = Double.parseDouble(s);
				
				if (a < Shape.MIN_DBL || a > Shape.MAX_DBL) {
					System.out.println("Длина стороны 'a' прямоугольника доолжна быть положительным числом от 0 о 99");
					return;
				}
				if (b < Shape.MIN_DBL || b > Shape.MAX_DBL) {
					System.out.println("Длина стороны 'b' прямоугольника доолжна быть положительным числом от 0 о 99");
					return;
				}
				
				Shape rectangle = new Rectangle(a, b);
				shapes.add(rectangle);
				
			}catch ( NumberFormatException e) {
            	System.out.println("Необходимо ввести число.");
            };
			
		} else if(ans.equals("Square")) {
			System.out.println("Введите значение стороны квадрата:");
			
			try{
				System.out.println("a = ");
				s = scanner.next(); 
				double a = Double.parseDouble(s);
				
				if (a < Shape.MIN_DBL || a > Shape.MAX_DBL) {
					System.out.println("Сторона квадрата доолжна быть положительным числом от 0 о 99");
					return;
				}
				
				Shape square = new Square(a);
				shapes.add(square);
				
			}catch ( NumberFormatException e) {
            	System.out.println("Необходимо ввести число.");
            }
			
		}else {
			System.out.println("Неизвестная фигура");
		}
		
		return;
	}
	
	
	/** Статический метод класса Main, выполняет удаление элемента из коллекции по заданному индексу */
	public static void remove() {
		if(shapes.size() == 0) {
			System.out.println("Коллекция пуста");
			return;
		}
	
		System.out.println("Введите индекс удаляемого элемента от 0 до " + (shapes.size()-1) );
		int ans = 0;
		while(true) {
			if(!scanner.hasNextInt()){
	            System.out.println("Некорректные данные, попробуйте снова.");
	            scanner.next(); 
	        } else {
	        	ans = scanner.nextInt();
	            if(ans >= 0 && ans < shapes.size()){
	            	shapes.remove(ans);
	            	break;
	            } else {
	            	System.out.println("Некорректный диапазон, попробуйте снова.");
	            	ans = 0; // устанавливаем ans в 0 для повторного ввода
	            }
	       }
		}
		
		return;
	}
	
	
	/**Статический метод класса Main, выполняет вывод в консоль всех элементов колекции, 
	 * если коллекция пуста, выводится информация об этом
	 * */
	public static void show() {
		if(shapes.size() == 0) {
			System.out.println("Коллекция пуста");
			return;
		} 
		
		for(int i = 0; i < shapes.size(); ++i ) {
			/** Метода get() класса ArrayList() осуществляет доступ к элементам коллкции по индексу*/
			System.out.println("[" + i + "] " + shapes.get(i).toString());
		}
	}
	
	/** Статический метод класса Main, в котором выполняется сравнение двух элементов класса на равенство, 
	 * если в кллекции меньше двух элементов, сравнение не проводится, пользователю выводится сообщаение 
	 * */
	public static void compare() {
		if(shapes.size() == 0) {
			System.out.println("Коллекция пуста");
			return;
		}
		if(shapes.size() == 1) {
			System.out.println("Недостаточно элементов для сравнения");
			return;
		} 
		/**Индексы элементов для сравнения */
		int index_1, index_2 = 0;
		
		System.out.println("Введите индекс первого элемента от 0 до " + (shapes.size()- 1));
		
		while(true) {
			if(!scanner.hasNextInt()){
	            System.out.println("Некорректные данные, попробуйте снова!");
	            scanner.next();
	        } else {
	        	index_1 = scanner.nextInt();
	            if(index_1 >= 0 && index_1 < shapes.size()){
	            	break;
	            } else {
	            	System.out.println("Некорректный диапазон, попробуйте снова!");
	            	index_1 = 0; // устанавливаем index_1 в 0 для повторного ввода
	            }
	        }
		}
		
		System.out.println("Введите индекс второго элемента от 0 до " + (shapes.size()- 1));
		
		while(true) {
			if(!scanner.hasNextInt()){
	            System.out.println("Некорректные данные, попробуйте снова!");
	            scanner.next(); 
	        } else {
	        	index_2 = scanner.nextInt();
	            if(index_2 >= 0 && index_2 < shapes.size()){
	            	break;
	            } else {
	            	System.out.println("Некорректный диапазон, попробуйте снова!");
	            	index_2 = 0; // устанавливаем index_2 в 0 для повторного ввода
	            }
	        }
		}
		
		boolean result = shapes.get(index_1).equals(shapes.get(index_2));
		
		System.out.println(result);
		return;
	}
}




