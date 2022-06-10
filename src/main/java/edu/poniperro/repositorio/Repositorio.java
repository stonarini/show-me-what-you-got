package edu.poniperro.repositorio;

import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

import edu.poniperro.domain.MagicalItem;

@ApplicationScoped
public class Repositorio {

    public Optional<MagicalItem> loadItem(String itemName) {
        return MagicalItem.find("item_name", itemName).firstResultOptional();
    }

}
