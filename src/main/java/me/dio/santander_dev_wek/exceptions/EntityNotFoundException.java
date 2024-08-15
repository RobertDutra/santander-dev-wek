package me.dio.santander_dev_wek.exceptions;

public class EntityNotFoundException extends Exception{
    String msg;

    public EntityNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
