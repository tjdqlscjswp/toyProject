package com.kosta.toyProject.service;

import com.kosta.toyProject.domain.Item;
import com.kosta.toyProject.dto.ItemDto;
import com.kosta.toyProject.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;


    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

/*    public void saveItem (ItemDto itemDto){
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setCount(itemDto.getCount());

        itemRepository.save(item);
    }*/

    public void saveItem (ItemDto itemDto){
        Item item = Item.builder()
                .count(itemDto.getCount())
                .name(itemDto.getName())
                .build();

        itemRepository.save(item);
    }

    public ItemDto findItemById(Long id) {
        Item item = itemRepository.findById(id); // itemRepository를 통해 id에 해당하는 item을 찾아서 반환

        return ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .count(item.getCount())
                .build(); // itemDto 반환
    }

/*    public List<ItemDto> findAllItem(){
        return itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemDto itemDto = new ItemDto(); // itemDto 객체 생성 후 item의 내용을 itemDto에 저장
                    itemDto.setId(item.getId());
                    itemDto.setName(item.getName());
                    itemDto.setCount(item.getCount());
                    return itemDto;  //itemDto 반환
                })
                .toList(); // itemRepository를 통해 모든 item을 찾아서 반환
    }*/

    public List<ItemDto> findAllItem() {
        return itemRepository.findAll()
                .stream()
                .map(item -> ItemDto.builder()
                        .id(item.getId())
                        .name(item.getName())
                        .count(item.getCount())
                        .build())
                .toList(); // itemRepository를 통해 모든 item을 찾아서 반환
    }

/*
    public void updateItemById(Long id, ItemDto itemDto) {
        Item findItem = itemRepository.findById(id);
        findItem.setName(itemDto.getName());
        findItem.setCount(itemDto.getCount());

        itemRepository.updateById(id, findItem);
    }
*/

    public void updateItemById(Long id, ItemDto itemDto) {
        Item findItem = itemRepository.findById(id); // itemRepository를 통해 id에 해당하는 item을 찾아서 반환
        findItem.updateItem(itemDto.getName(), itemDto.getCount()); // item의 내용을 수정

        itemRepository.updateById(id, findItem); // itemRepository를 통해 id에 해당하는 item을 찾아서 내용을 수정
    }


    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
