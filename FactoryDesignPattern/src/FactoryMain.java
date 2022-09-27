import com.phone.Android;
import com.phone.OS;
import com.phone.OperationgSystemFactory;
import com.phone.Windows;

public class FactoryMain {
	public static void main(String[] args) {
		OperationgSystemFactory factory = new OperationgSystemFactory();
		OS obj=factory.getInstance("dafd");
		obj.spec();

	}
}
