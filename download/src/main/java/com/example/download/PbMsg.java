package com.example.download;

public class PbMsg {
    private int i; //表示什么操作  失败，设置最大值，设置进度，下载完成
    private int progress;
    private long max;

    public PbMsg(int i, int progress, long max) {
        this.i = i;
        this.progress = progress;
        this.max = max;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }
}
