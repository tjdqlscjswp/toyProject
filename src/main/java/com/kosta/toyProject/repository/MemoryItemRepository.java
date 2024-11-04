package com.kosta.toyProject.repository;

import com.kosta.toyProject.domain.Item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryItemRepository implements ItemRepository{

    private static Map<Long, Item> store = new HashMap<Long, Item>();
    private static Long sequence = 0L;

    @Override
    public void save(Item item) {
        item.initId(++sequence); // id를 생성하고 item에 저장
        store.put(item.getId(), item); // store에 저장
    }

    @Override
    public Item findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Item> findAll() {
        return store.values().stream().toList();
    }

    @Override
    public void updateById(Long id, Item item) {
        store.put(id, item);
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
