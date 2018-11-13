package com.cfun.website.controller;

import com.cfun.website.bean.StripeBean;
import com.stripe.Stripe;
import com.stripe.exception.*;
import com.stripe.model.Charge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/stripe")
public class StripeController {
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(StripeController.class);

    /**
     * 接收充值请求
     * @param stripeBean 接收参数可自定义
     * @return 返回值可自定义
     */
    @RequestMapping("/charge")
    public synchronized Map setCharge(@RequestBody StripeBean stripeBean) {
        //返回结构体，请自定义，这里用Map代替
        HashMap<String,String> resultMap=new HashMap<>();
        LOGGER.info("接收到请求");
         // Set your secret key: remember to change this to your live secret key in production
        // See your keys here: https://dashboard.stripe.com/account/apikeys
        // Stripe.apiKey = "sk_test_YJ765BHAvCbg16HqGhlURHZe";
          Stripe.apiKey = "sk_test_8ube4zvWNY0VvrTjxzbAyL8t";  // 测试key
      //  Stripe.apiKey = "sk_live_N3yqWqplIdJyi3F5Y071WSvt";
        // Token is created using Checkout or Elements!
        // Get the payment token ID submitted by the form:
        String token = stripeBean.getToken();

        LOGGER.info("获取到token："+token);
        LOGGER.info("获取到description："+stripeBean.getDescription());
        Map<String, Object> params = new HashMap<>();
        params.put("amount", stripeBean.getAmount());         //充值金额，单位分
        params.put("currency", "cad");   //货币类型   加币
        params.put("description", stripeBean.getDescription());  //充值描述
        params.put("source", token);
        try {
            Charge charge = Charge.create(params);
            //充值成功，处理业务逻辑
            long amount=charge.getAmount();
            LOGGER.info("支付数目:"+amount);
            String orderNum=charge.getId();
            LOGGER.info("订单编号："+orderNum);

            resultMap.put("errorCode","0");

        } catch (AuthenticationException e) {
            e.printStackTrace();
            LOGGER.error("支付发生错误:"+e.getMessage());
            resultMap.put("errorCode","1");
            resultMap.put("errorMessage",e.getMessage());
        } catch (InvalidRequestException e) {
            e.printStackTrace();
            LOGGER.error("支付发生错误:"+e.getMessage());
            resultMap.put("errorCode","2");
            resultMap.put("errorMessage",e.getMessage());
        } catch (APIConnectionException e) {
            e.printStackTrace();
            LOGGER.error("支付发生错误:"+e.getMessage());
            resultMap.put("errorCode","3");
            resultMap.put("errorMessage",e.getMessage());
        } catch (CardException e) {
            e.printStackTrace();
            LOGGER.error("支付发生错误:"+e.getMessage());
            resultMap.put("errorCode","4");
            resultMap.put("errorMessage",e.getMessage());
        } catch (APIException e) {
            e.printStackTrace();
            LOGGER.error("支付发生错误:"+e.getMessage());
            resultMap.put("errorCode","5");
            resultMap.put("errorMessage",e.getMessage());
        }
        return resultMap;
    }

}
