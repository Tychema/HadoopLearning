package com.atguigu.PhoneNum.mapper;

import com.atguigu.PhoneNum.Writable.FlowBean;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    Text outK=new Text();
    FlowBean flowBean = new FlowBean();
    @Override
    protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, FlowBean>.Context context) throws IOException, InterruptedException {
        //1 获取一行数据,转成字符串
        //1   13736230513 192.169.100.1 www.atguigu.com 2481 24681 200
        String line = value.toString();
        //2 切割数据
        String[] split = line.split(" ");
        //3 抓取我们需要的数据:手机号,上行流量,下行流量
        String phone = split[1];
        String upFlow = split[split.length-3];
        String downFlow = split[split.length-2];
        //4 封装outK outV
        outK.set(phone);
        flowBean.setUpFlow(Long.parseLong(upFlow));
        flowBean.setDownFlow(Long.parseLong(downFlow));
        flowBean.setSumFlow();
        //5 写出outK outV
        context.write(outK,flowBean);
    }
}