package fokeJoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FockJoinTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FockJoinTest test = new FockJoinTest();
		ForkJoinPool pool = new ForkJoinPool();
		A a = test.new A(1, 10);
		ForkJoinTask<List<Person>> result = pool.submit(a);
		while(!result.isDone()){
			Thread.currentThread().sleep(1);
		}
		List<Person> list = result.get();
		for (Person person : list) {
			System.out.println(person.getName());
			System.out.println(person.getAge());
		}
	}
	
	class A extends RecursiveTask<List<Person>>{
		private int start;
		private int end;
		private int fazhi = 2;//分割任务阈值
		
		public A(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public A() {
		}

		//并行计算
		@Override
		protected List<Person> compute() {
			List<Person> list = new ArrayList<Person>();
			if ((end-start)<=fazhi) {//如果小于等于两个列表就不分cpu
				for (int i = start; i <= end; i++) {
					list.add(getPerson("name"+i, i));
				}
			}
			if ((end-start)>=fazhi) {//分割cpu
				int middle = (end+start)/2;
				A left = new A(start,middle);
				A right = new A(middle+1,end);
				
				left.fork();
				right.fork();
				
				List<Person> leftResult = left.join();
				List<Person> rightResult = right.join();
				
				list.addAll(leftResult);
				list.addAll(rightResult);
				return list;
			}
			return list;
		}
	}
	
	/**
	 * 模拟业务场景
	 * @param name
	 * @param age
	 * @return
	 */
	public Person getPerson(String name,Integer age) {
		try {
			Thread.currentThread().sleep(1000);
			Person p = new Person();
			p.setAge(age);
			p.setName(name);
			return p;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	class Person {
		private String name;
		private Integer age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
	}
}
