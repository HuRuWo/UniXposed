package com.huruwo.hposed.describe;


public class DescribeClsInfo {

    private String packageName;
    private String parent;
    private String method;
    private String field;
    private boolean isInterface;

    public static class DescribeClsInfoBuilder {

        private String packageName;
        private String parent;
        private String method;
        private String field;
        private boolean isInterface;

        public DescribeClsInfo build() {
            return new DescribeClsInfo(this);
        }


        public DescribeClsInfoBuilder packageName(String packageName) {
            this.packageName = packageName;
            return this;
        }


        public DescribeClsInfoBuilder parent(String parent) {
            this.parent = parent;
            return this;
        }


        public DescribeClsInfoBuilder method(String method) {
            this.method = method;
            return this;
        }


        public DescribeClsInfoBuilder field(String field) {
            this.field = field;
            return this;
        }


        public DescribeClsInfoBuilder isInterface(boolean anInterface) {
            isInterface = anInterface;
            return this;
        }
    }

    private DescribeClsInfo(DescribeClsInfoBuilder builder) {
        this.packageName = builder.packageName;
        this.parent = builder.parent;
        this.method = builder.method;
        this.field = builder.field;
        this.isInterface = builder.isInterface;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean isInterface() {
        return isInterface;
    }

    public void setInterface(boolean anInterface) {
        isInterface = anInterface;
    }

}
