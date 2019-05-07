package com.jadamczyk.books.JMS;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

public class AuthorRentalQueueManager {
    @Inject
    private JMSContext context;

    @Resource(mappedName = "java:jboss/exported/jms/queue/AuthorRental")
    private Queue queue;

    public void sendMessage(String txt) {
        try {
            context.createProducer().send(queue, txt);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
