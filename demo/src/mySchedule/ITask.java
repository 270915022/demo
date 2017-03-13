package mySchedule;

public interface ITask{

    /**
     * 事项执行
     */
    void taskContent() throws InterruptedException;

    /**
     * @return 触发器
     */
    ITrigger getTrigger();

    /**
     * @return 事项名称
     */
    String getTaskName();
}
