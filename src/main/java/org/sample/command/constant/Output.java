package org.sample.command.constant;

public enum Output {
    NULL("NULL"),
    NO_TRANSACTION("NO TRANSACTION");

    String printVal;

    Output(String printVal) {
        this.printVal = printVal;
    }

    public String getPrintVal() {
        return printVal;
    }
}
