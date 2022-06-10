package edu.poniperro.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import edu.poniperro.domain.MagicalItem;
import edu.poniperro.repositorio.Repositorio;

@ApplicationScoped
public class ServiceItem {

    @Inject
    Repositorio repositorio;

    public Optional<MagicalItem> getOneItemByName(String itemName) {
        return repositorio.loadItem(itemName);
    }

    public Optional<MagicalItem> getOneItem(MagicalItem item) {
        return repositorio.loadItem(item);
    }

    public List<MagicalItem> getAllItemsByName(String itemName) {
        return repositorio.loadItems(itemName);
    }

    @Transactional
    public void createOneItem(String name, Integer quality, String type) {
        repositorio.createItem(name, quality, type);
    }

    @Transactional
    public void createItems(List<MagicalItem> itemList) {
        repositorio.createItems(itemList);
    }

    @Transactional
    public void deleteItem(MagicalItem item) {
        repositorio.deleteItem(item);
    }
}
