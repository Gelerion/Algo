package com.denis.shuvalov.designPatterns.ChainOfResponsibility;

class BillingSupportHandler extends AbstractSupportHandler {

    BillingSupportHandler(int level) {
        this.level = level;
    }

    @Override
    protected void handleRequest(String message) {
        System.out.println("BillingSupportHandler: Processing request. " + message);
    }
}
