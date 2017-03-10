package oberservers;

public class ObserverImpl implements Observer{

	@Override
	public void doSth() {
		System.out.println("dosth....................");
	}

	@Override
	public void systemOut(String content) {
		System.out.println(content);
	}

}
