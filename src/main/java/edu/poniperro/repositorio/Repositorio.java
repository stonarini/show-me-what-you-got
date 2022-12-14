package edu.poniperro.repositorio;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import edu.poniperro.domain.MagicalItem;

@ApplicationScoped
public class Repositorio {

    public Optional<MagicalItem> loadItem(String itemName) {
        return MagicalItem.find("item_name", itemName).firstResultOptional();
    }

    public Optional<MagicalItem> loadItem(MagicalItem item) {
        return MagicalItem
                .find("name = ?1 and quality = ?2 and type = ?3", item.getName(), item.getQuality(), item.getType())
                .firstResultOptional();
    }

    public List<MagicalItem> loadItems(String itemName) {
        return MagicalItem.find("item_name", itemName).list();
    }

    @Transactional
    public void createItem(String name, Integer quality, String type) {
        MagicalItem item = new MagicalItem(name, quality, type);
        item.persist();
    }

    @Transactional
    public void createItems(List<MagicalItem> itemList) {
        for (MagicalItem item : itemList) {
            this.createItem(item.getName(), item.getQuality(), item.getType());
        }
    }

    @Transactional
    public void deleteItem(MagicalItem item) {
        Optional<MagicalItem> itemOptional = loadItem(item);
        itemOptional.ifPresent(i -> i.delete());
    }
}
