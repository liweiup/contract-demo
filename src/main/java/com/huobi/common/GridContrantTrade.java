package com.huobi.common;

import com.huobi.common.api.HbdmRestApiV1;
import com.huobi.common.api.IHbdmRestApi;
import org.apache.http.HttpException;

import java.io.IOException;

public class GridContrantTrade {
    public static void main(String[] args) throws IOException, HttpException,NullPointerException {
        try {
            //获取行情
            IHbdmRestApi futureGetV1 = new HbdmRestApiV1(HbdmRestApiV1.HUOBI_API_URL);
            // 获取合约信息
//            String contractInfo = futureGetV1.futureContractHisbasisAll("BTC", "1min","open","20");
            String contractInfo = futureGetV1.futureMarketDetailTrade("BTC_CQ","");
        System.out.println(contractInfo);
        }catch (NullPointerException e) {
            String msg = e.getMessage();
            System.out.println("空指针异常");
        }


    }
}
