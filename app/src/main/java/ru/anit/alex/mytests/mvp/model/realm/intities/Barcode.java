package ru.anit.alex.mytests.mvp.model.realm.intities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Alex on 23.05.2017.
 */

public class Barcode extends RealmObject {
    @PrimaryKey
    long id;
    String barcode;
    int places;
    float weight;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Barcode{" +
                "id=" + id +
                ", barcode='" + barcode + '\'' +
                ", places=" + places +
                ", weight=" + weight +
                '}';
    }
}
