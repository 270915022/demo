package mySchedule;

import java.io.Serializable;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class TimeTriggerImpl implements ITrigger,Serializable{

    /**  */
    private static final long serialVersionUID = 6914135251096001677L;

    /** 时间单位 */
    private int timeUnit;

    /** 执行次数 */
    private int frequency;
    
    /** 间隔差 */
    private int period;

    /** 执行时间 */
    private Calendar etime;

    /** 是否是循环事项 */
    private boolean isCon;
    
    public TimeTriggerImpl(Calendar etime) {
        this(Calendar.YEAR, 1, etime);
    }
    
    public TimeTriggerImpl(int timeUnit,int frequency,Calendar etime) {
        this(timeUnit,1,frequency,etime);
    }
    
    public TimeTriggerImpl(int timeUnit,int period,int frequency,Calendar etime) {
        this.timeUnit = timeUnit;
        this.period = period;
        this.etime = etime;
        this.setFrequency(frequency);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long hasNext() {
        if(this.frequency > 0) {
            Calendar now = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
            long t = this.etime.getTimeInMillis() - now.getTimeInMillis();
            return t >= 0?t:0;
        } else {
            return -1;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void next() {
        // 本次已经执行完成，执行一次减操作
        this.frequency--;
        // 如果发现还需要执行,则变动执行时间点
        if(this.frequency > 0) {
            this.etime.add(this.timeUnit, this.period);
        }
        // 如果发现是循环事项,则补充一条数据,然后变动执行时间点
        if(this.isCon) {
            this.frequency += 1;
            this.etime.add(this.timeUnit, this.period);
        }
    }
    
    /**
     * 获取period
     * @return period
     */
    public int getPeriod() {
        return period;
    }

    
    /**
     * 设置period
     * @param period period
     */
    public void setPeriod(int period) {
        this.period = period;
    }

    
    /**
     * 获取frequency
     * @return frequency
     */
    public int getFrequency() {
        return frequency;
    }

    
    /**
     * 设置frequency
     * @param frequency frequency
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency <= 0 ? 1:frequency;
        this.isCon = frequency <= 0 ? true : false;
    }

    
    /**
     * 获取etime
     * @return etime
     */
    public Calendar getEtime() {
        return etime;
    }

    
    /**
     * 设置etime
     * @param etime etime
     */
    public void setEtime(Calendar etime) {
        this.etime = etime;
    }

	public int getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(int timeUnit) {
		this.timeUnit = timeUnit;
	}

	public boolean isCon() {
		return isCon;
	}

	public void setCon(boolean isCon) {
		this.isCon = isCon;
	}
    
}
