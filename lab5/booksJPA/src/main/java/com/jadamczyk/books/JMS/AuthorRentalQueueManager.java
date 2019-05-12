package com.jadamczyk.books.JMS;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;

public class AuthorRentalQueueManager {
    public AuthorRentalQueueManager() {
        Context context = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) context.lookup("jms/SampleConnectionFactory");
        Destination queue = (Destination) context.lookup("jms/SampleQueue");
        JMSContext jmsContext = cf.createContext();
    }

    private JMSContext ctx;

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
