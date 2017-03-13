package mySchedule;


/**
 * @author Li.QuanYu
 * @date 2012-8-3下午3:15:27
 * @Copyright(c) Chengdu Chant Software Technology Co.,LTD
 */
public interface ITrigger {

    /**
     * 下一次的执行时间
     * 单位是毫秒
     * @return 毫秒
     */
    long hasNext();

    /**
     * 刷新规则
     */
    void next();
}
