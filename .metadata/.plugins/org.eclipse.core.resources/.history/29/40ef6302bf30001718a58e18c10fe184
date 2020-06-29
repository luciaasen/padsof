package p5.test;

import p5.*;
import p5.exc.IllegalArgumentException;

public class Apartado2 {
	public static void main(String[] args){
		System.out.println("Creamos 5 tareas, imprimimos en orden t1,t2,t3,t4,t5\n");
		
		Task t1, t2, t3, t4, t5;
		t1 = new Task("Ir a la feria");
		t1.getEstimated().incrementTime(1);
		t1.getDedicated().incrementTime(10);
		t2 = new Task("Beber rebujito");
		t2.getDedicated().incrementTime(20);
		t2.getEstimated().incrementTime(2);
		t3 = new Task("Bailar muchas sevillanas");
		t3.getEstimated().incrementTime(3);
		t3.getDedicated().incrementTime(30);
		t4 = new Task("Bailar con mi amiga");
		t4.getEstimated().incrementTime(4);
		t4.getDedicated().incrementTime(40);
		t5 = new Task("Bailar con un tio guapo");
		t5.getEstimated().incrementTime(5);
		t5.getDedicated().incrementTime(50);

		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
		System.out.println(t5);
		
		System.out.println("\nY las conectamos:\nAniadimos t4 y t5 a t3, y t3 y t2 a t1\nY reimprimimos:\n");
		
		t3.addTask(t4);
		t3.addTask(t5);
		t1.addTask(t2);
		t1.addTask(t3);
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
		System.out.println(t5);
		
		System.out.println("\nt1 contiene a t2? " + t1.containsTask(t2));
		System.out.println("t1 contiene a t4? " + t1.containsTask(t4));
		System.out.println("t4 contiene a t3? " + t4.containsTask(t3));
		
		System.out.println("\nCon esto quedan testeados los casos favorables de addTask, setParent, containsTask");
		System.out.println("Ahora aniadimos todas al singleton Tasks e intentamos hacer setters 'ilegales'\n");
	
		Tasks.newTask(t1);
		Tasks.newTask(t2);
		Tasks.newTask(t3);
		Tasks.newTask(t4);
		Tasks.newTask(t5);
		
		Task t6 = new Task("Ir a la feria");
		System.out.println("Creamos t6 con mismo nombre que t1, e intentamos aniadirla a tasks");
		
		try{
			Tasks.newTask(t6);
		}catch(p5.exc.IllegalArgumentException e){
			System.out.println("No se pudo aniadir t6 a tasks\n");
		}
		
		
		System.out.println("Intentamos hacer setParent: primero invalido, luego valido ");
		try{
			t1.setParent(t5);
		}catch(p5.exc.IllegalArgumentException e){
			System.out.println("No podemos hacer que el padre de t1 sea t5: bucle");
		}
		System.out.println("\nSetParent valido: hacemos que el padre de t2 sea t5, los tiempos deberian cambiar en el antiguo y nuevo padre (y sus predecesores)");
		t2.setParent(t5);
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		System.out.println(t4);
		System.out.println(t5);
	}
}
