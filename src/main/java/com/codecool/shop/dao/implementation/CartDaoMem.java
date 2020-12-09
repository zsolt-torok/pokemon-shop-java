package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.CartDao;
import com.codecool.shop.model.Cart;
import com.codecool.shop.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class CartDaoMem  implements CartDao {

    private Cart cart = new Cart();
    private static CartDaoMem instance = null;

    private CartDaoMem() {

    }

    public static CartDaoMem getInstance() {
        if (instance == null) {
            instance = new CartDaoMem();
        }
        return instance;
    }

    @Override
    public void add(Pokemon pokemon) {
        cart.addPokemonToCart(pokemon);
        System.out.println("pokemon added: " +pokemon.toString());
    }

    @Override
    public Pokemon findPokemon(int id) {
        return cart.getPokemons().stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void removePokemon(int id) {
        cart.removePokemon(id);
    }

    @Override
    public List<Pokemon> getAll() { return cart.getPokemons(); }
}
