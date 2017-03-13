package mySchedule;

import java.util.Calendar;

public class TestDemo {
	public static void main(String[] args) {
		TestDemo td = new TestDemo();
		TaskSchedulManagerImpl manager = new TaskSchedulManagerImpl();
		manager.addTask(td.new TestTask());
	}
	
	class TestTask implements ITask{
		private  TimeTriggerImpl trigger;
		@Override
		public void taskContent() throws InterruptedException {
			System.out.println("任务执行啦！");
		}

		@Override
		public ITrigger getTrigger() {
			if (trigger == null) {
				trigger = new TimeTriggerImpl(Calendar.getInstance());
				trigger.setFrequency(10);
				trigger.setPeriod(1);
				trigger.setTimeUnit(Calendar.DAY_OF_WEEK);
			}
			return trigger;
		}

		@Override
		public String getTaskName() {
			return "test-demo-task";
		}
		
	}
}
