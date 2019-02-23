package br.raphael.app.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

    private int id;
    private int cod;
    private String name;
    private float value;
    private float promotion;

    private Product(Parcel in) {
        this.id = in.readInt();
        this.cod = in.readInt();
        this.name = in.readString();
        this.value = in.readFloat();
        this.promotion = in.readFloat();
    }

    public Product(){}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.cod);
        dest.writeString(this.name);
        dest.writeFloat(this.value);
        dest.writeFloat(this.promotion);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<Product> CREATOR
            = new Parcelable.Creator<Product>() {

        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPromotion() {
        return promotion;
    }

    public void setPromotion(float promotion) {
        this.promotion = promotion;
    }
}
