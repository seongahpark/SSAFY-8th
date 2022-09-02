package exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest2 {

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.m();
	}

}

class Controller{
	public void m() {
		Service service = new Service();
		service.m();
		System.out.println("Controller - last");
	}
}

// Exception - IOException - FileNotFoundException
class Service{
	public void m() {
		Dao dao = new Dao();

		try {
			Class.forName("Hello");
			dao.m();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Dao{
	public void m() throws FileNotFoundException {
	}
}