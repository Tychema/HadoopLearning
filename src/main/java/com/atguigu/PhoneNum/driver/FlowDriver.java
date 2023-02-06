package com.atguigu.PhoneNum.driver;


import com.atguigu.PhoneNum.Writable.FlowBean;
import com.atguigu.PhoneNum.mapper.FlowMapper;
import com.atguigu.PhoneNum.reducer.FlowReducer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class FlowDriver {
    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //1 获取Job
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf);
        //2、设置jar包路径
        job.setJarByClass(FlowDriver.class);
        //3、关联mapper和reducer
        job.setMapperClass(FlowMapper.class);
        job.setReducerClass(FlowReducer.class);
        //4、设置map输出KV类型
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(FlowBean.class);
        //5、设置最终输出KV类型
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(FlowBean.class);

        //设置分区个数（默认1）
        //job.setNumReduceTasks(2);
        //6、设置输入路径和输出路径
        FileInputFormat.setInputPaths(job,new Path("D:\\program\\testTXT\\inputFlow"));
        FileOutputFormat.setOutputPath(job,new Path("D:\\program\\testTXT\\outPutFlow"));
        //7、提交job
        boolean result=job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
