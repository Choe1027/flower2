package com.lazyfish.core.pojo;

import com.lazyfish.core.other.IBizBeanAction;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * @author cyk
 * @date 2018/9/4/004 16:43
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@MappedSuperclass // 用来标志子对象可以继承
public class BizBean extends BaseBean implements IBizBeanAction {

    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
    /**
     * 创建时间
     */
    protected Long create_time;

    @Transient //与数据库不对应的字段
    protected Long start_time;
    @Transient
    protected Long end_time;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }

    public Long getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Long end_time) {
        this.end_time = end_time;
    }

    @Override
    public void cleanSensitiveInfo() {

    }
}
