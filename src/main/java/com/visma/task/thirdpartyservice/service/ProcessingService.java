package com.visma.task.thirdpartyservice.service;

import com.visma.task.thirdpartyservice.exception.ItemNotFoundException;
import com.visma.task.thirdpartyservice.model.Item;
import com.visma.task.thirdpartyservice.model.StatusType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static com.visma.task.thirdpartyservice.utils.RandomUtils.getRandomNumber;

@Service
public class ProcessingService {

    private final Map<String, Item> dataStorageQueue = new ConcurrentHashMap<>();

    @Scheduled(fixedRateString = "${scheduler.processing.fixed.rate}")
    public void process() {
        dataStorageQueue.forEach((s, item) -> {
            if (getRandomNumber(1, 20) == 10) {
                dataStorageQueue.computeIfPresent(s, (x, y) -> updateItem(item, StatusType.FAILED));
            } else {
                dataStorageQueue.computeIfPresent(s, (x, y) -> updateItem(item, StatusType.OK));
            }
        });
    }

    public String addNewItemToStorage() throws InterruptedException {
        imitateLongTakingQuery();
        String uuid = UUID.randomUUID().toString();
        dataStorageQueue.put(uuid, new Item(uuid, StatusType.IN_PROGRESS));
        return uuid;
    }

    public StatusType getStatus(String uuid) {
        return Optional.ofNullable(dataStorageQueue.get(uuid)).orElseThrow(ItemNotFoundException::new).getStatus();
    }

    private Item updateItem(Item item, StatusType type) {
        item.setStatus(type);
        return item;
    }

    private void imitateLongTakingQuery() throws InterruptedException {
        Thread.sleep(getRandomNumber(1000, 5000));
    }

}
