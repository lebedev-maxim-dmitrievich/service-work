package ru.lebedev.servicework.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.lebedev.servicework.engine.Producer;

import java.util.concurrent.ExecutionException;

@Component
public class SendMessageTask {

    private final Producer producer;

    public SendMessageTask(Producer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRateString = "3000")
    public void send() throws ExecutionException, InterruptedException {
        producer.sendMessage("INPUT_DATA", "IN_KEY", "Сообщение");
    }
}