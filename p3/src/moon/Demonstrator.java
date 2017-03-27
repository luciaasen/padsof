
package moon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import moon.*;


/**
 * @author Lucia Asencio and Juan Riera
 *
 */
public class Demonstrator {
	public static void main(){
		Academy moon = Academy.getMoonApp();
		try { moon.loadUsers("StudentData.txt"); }
		catch (NumberFormatException | IOException e){
			e.printStackTrace();
		}
		
		serialize(moon);
		
		moon = deserialize();
		
		Academy.setMoon(moon);
		
	}
	/**
	 * Auxiliar method to serialize moon.
	 * @param moon
	 * @throws IOException
	 */
	public static void serialize(Academy moon) {
		try {
		FileOutputStream fileOut =
				new FileOutputStream("moon.ser");
		ObjectOutputStream out = 
				new ObjectOutputStream(fileOut);
		out.writeObject(moon);
		out.close();
		fileOut.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Auxiliar method to deserialize moon.
	 * @return
	 */
	public static Academy deserialize(){
		Academy moon;
		try{
			FileInputStream fileIn =
					new FileInputStream("moon.ser");
			ObjectInputStream in =
					new ObjectInputStream(fileIn);
			moon = (Academy) in.readObject();
			in.close();
			fileIn.close();
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
		return moon;
	}

	

}
