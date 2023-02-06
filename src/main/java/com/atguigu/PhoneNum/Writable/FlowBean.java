package com.atguigu.PhoneNum.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;

/**
 * 1、定义Writable接口
 * 2、重写序列化和反序列化方法
 * 3、重写空参构造
 * 4、写toString方法
 */
public class FlowBean implements Writable {
    private long upFlow;
    private long downFlow;
    private long sumFlow;

    public long getUpFlow() {
        return upFlow;
    }

    public void setUpFlow(long upFlow) {
        this.upFlow = upFlow;
    }

    public long getDownFlow() {
        return downFlow;
    }

    public void setDownFlow(long downFlow) {
        this.downFlow = downFlow;
    }

    public long getSumFlow() {
        return sumFlow;
    }

    public void setSumFlow() {
        this.sumFlow = this.downFlow+this.upFlow;
    }

    //序列化
    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(upFlow);
        dataOutput.writeLong(downFlow);
        dataOutput.writeLong(sumFlow);
    }
    //反序列化
    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.sumFlow=dataInput.readLong();
        this.downFlow=dataInput.readLong();
        this.upFlow=dataInput.readLong();
    }

    @Override
    public String toString() {
        return  upFlow +"    "+ downFlow + "    "+ sumFlow;
    }
}
