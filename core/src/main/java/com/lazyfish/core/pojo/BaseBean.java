package com.lazyfish.core.pojo;

import com.lazyfish.common.utils.LoggerUtil;
import com.lazyfish.common.utils.ObjectUtil;

import java.io.Serializable;

/**
 * @author cyk
 * @date 2018/9/4/004 15:06
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
public class BaseBean implements Serializable,Cloneable {

    private static final long serialVersionUID = 498226538729597654L;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /** 克隆自己 */
    @SuppressWarnings("unchecked")
    public <T extends BaseBean> T cloneSelf() {
        try {
            return (T) ObjectUtil.CloneObject(this);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                return (T) clone();
            } catch (CloneNotSupportedException e1) {
                LoggerUtil.error(this.getClass(), e1);
                return null;
            }
        }
    }

    public static void main(String[] args) {
//		String jsonStr = "{\"content\":\"6aqo54Gw55uS\",\"sender\":{\"address\":\"\",\"tel\":\"\",\"create_time_view\":\"\",\"description\":\"\",\"email\":\"\",\"filterWord\":false,\"id\":835,\"imei\":\"\",\"machinecode\":\"\",\"mobile\":\"13367253613\",\"nick\":\"沐沐鱼\",\"no\":\"\",\"password\":\"\",\"pic\":\"ftp://devRead:devRead123@122.225.222.181:21/woyao/resources/2015-1-15_14h/01a119bf-4578-4045-b0e5-1a3cd157f8eb.jpg\",\"qrcodestring\":\"\",\"sex\":\"\",\"shop_id\":0,\"update_time\":1,\"create_time\":0,\"status\":0},\"otherId\":696,\"time\":1421314038381,\"id\":0,\"otherType\":0,\"senderUserId\":835,\"functionNo\":101,\"type\":1}";
//		System.out.println(JsonUtil.jsonToBean(jsonStr, MsgBean.class).getSender().getFilterword());
    }
}
