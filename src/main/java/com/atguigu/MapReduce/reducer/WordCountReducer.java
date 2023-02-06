package com.atguigu.MapReduce.reducer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * KEYIN:map阶段输入的key类型：Text
 * VALUEIN:map阶段输入的value的类型:IntWritable
 * KEYOUT:map阶段输出的key的类型:Text
 * VALUEOUT:map阶段输入的value的类型:IntWritable
 */

/**
 * 数据格式变化
 * <atguigu,1><atguigu,1><atguigu,1> -> <atguigu,3>
 */

/**
 * Iterable<IntWritable> values并不是一个迭代器
 * 而是一个集合的祖宗类似一个集合，直接当集合进行遍历
 */

public class WordCountReducer extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable outK=new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        int sum =0;
        for (IntWritable value:values){
            sum+=value.get();
        }
        outK.set(sum);
        context.write(key,outK);
    }
}
