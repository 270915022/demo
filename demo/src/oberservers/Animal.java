package oberservers;

import java.util.ArrayList;
import java.util.List;

public class Animal implements Observered{
	List<Observer> observers = null;
	private String name;
	
	public Animal() {
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void remove(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifiObservers() {
		for (Observer observer : observers) {
			//做事情
			observer.doSth();
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.notifiObserversContent(this.getClass()+" 类改变了属性 name 值为："+name);
		this.name = name;
	}

	@Override
	public void notifiObserversContent(String content) {
		for (Observer observer : observers) {
			observer.systemOut(content);
		}
	}
}
