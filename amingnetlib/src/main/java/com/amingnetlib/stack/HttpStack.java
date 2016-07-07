package com.amingnetlib.stack;

import com.amingnetlib.base.ARequest;
import com.amingnetlib.base.AResponse;

/**
 * Created by wenming on 2016/6/21.
 */
public interface HttpStack {
    //执行HTTP请求
    public AResponse performRequest(ARequest<?> request);
}
