package com.denis.shuvalov.designPatterns.ChainOfResponsibility;

class RequestorClient {

    static AbstractSupportHandler getHandlerChain() {
        AbstractSupportHandler technicalSupportHandler = new TechnicalSupportHandler(AbstractSupportHandler.TECHNICAL);
        AbstractSupportHandler billingSupportHandler = new BillingSupportHandler(AbstractSupportHandler.BILLING);
        AbstractSupportHandler generalSupportHandler = new GeneralSupportHandler(AbstractSupportHandler.GENERAL);

        technicalSupportHandler.setNextHandler(billingSupportHandler);
        billingSupportHandler.setNextHandler(generalSupportHandler);

        return technicalSupportHandler;
    }

}
