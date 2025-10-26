package com.example.godown_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Save or add a new item
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    // Get item by ID
    public Item getItemById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id: " + id));
    }

    // Search items by category, name, or locationCode
    public List<Item> searchItems(String category, String name, String locationCode) {
        List<Item> result = new ArrayList<>();

        if(category != null && !category.isEmpty()) {
            result.addAll(itemRepository.findByCategory(category));
        }
        if(name != null && !name.isEmpty()) {
            result.addAll(itemRepository.findByNameContainingIgnoreCase(name));
        }
        if(locationCode != null && !locationCode.isEmpty()) {
            result.addAll(itemRepository.findByLocationCode(locationCode));
        }

        // If none of the filters provided, return all
        if(category == null && name == null && locationCode == null) {
            return itemRepository.findAll();
        }

        return result;
    }

    // Update existing item
    public Item updateItem(Long id, Item updatedItem) {
        Item existingItem = getItemById(id);

        existingItem.setName(updatedItem.getName());
        existingItem.setCategory(updatedItem.getCategory());
        existingItem.setQuantity(updatedItem.getQuantity());
        existingItem.setDescription(updatedItem.getDescription());
        existingItem.setWeight(updatedItem.getWeight());
        existingItem.setArrivalDate(updatedItem.getArrivalDate());
        existingItem.setExpiryDate(updatedItem.getExpiryDate());
        existingItem.setLocationCode(updatedItem.getLocationCode());
        existingItem.setPriority(updatedItem.getPriority());
        existingItem.setStatus(updatedItem.getStatus());

        return itemRepository.save(existingItem);
    }

    // Delete an item
    public void deleteItem(Long id) {
        Item existingItem = getItemById(id);
        itemRepository.delete(existingItem);
    }
}


