package mySchedule;

public interface ITaskSchedulManager {

	/**
	 * 取消任务
	 * @param taskName
	 */
	void cancelTask(String taskName);
	
    /**
     * 添加事项
     * @param task 任務實體
     */
    void addTask(ITask task);
    
}
