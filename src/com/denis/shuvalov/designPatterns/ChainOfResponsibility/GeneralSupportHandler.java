package com.denis.shuvalov.designPatterns.ChainOfResponsibility;

class GeneralSupportHandler extends AbstractSupportHandler {

    GeneralSupportHandler(int level) {
        this.level = level;
    }

    @Override
    protected void handleRequest(String message) {
        System.out.println("GeneralSupportHandler: Processing request. " + message);

    }
}
