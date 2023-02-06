package com.atguigu.PhoneNum.reducer;

import com.atguigu.PhoneNum.Writable.FlowBean;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import java.io.IOException;

public class FlowReducer extends Reducer<Text, FlowBean, Text, FlowBean> {
//    private FlowBean outV = new FlowBean();
//    @Override
//    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {
//
//        long totalUp = 0;
//        long totalDown = 0;
//
//        //1 遍历values,将其中的上行流量,下行流量分别累加
//        for (FlowBean flowBean : values) {
//            totalUp += flowBean.getUpFlow();
//            totalDown += flowBean.getDownFlow();
//        }
//
//        //2 封装outKV
//        outV.setUpFlow(totalUp);
//        outV.setDownFlow(totalDown);
//        outV.setSumFlow();
//
//        //3 写出outK outV
//        context.write(key,outV);
//    }
    private FlowBean outV=new FlowBean();
    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Reducer<Text, FlowBean, Text, FlowBean>.Context context) throws IOException, InterruptedException {
        //1、遍历集合累加值
        long totalUpFlow=0;
        long totalDownFlow=0;
        for (FlowBean value : values) {
            totalUpFlow+=value.getUpFlow();
            totalDownFlow+=value.getDownFlow();
        }
        //2、封装
        this.outV.setUpFlow(totalUpFlow);
        this.outV.setDownFlow(totalDownFlow);
        this.outV.setSumFlow();
        //3、写出outK、outV
        context.write(key,outV);
    }
}
