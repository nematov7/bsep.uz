package uz.bsep.controllers;

import uz.bsep.services.base.BaseGenericService;

public abstract class AbstractController<S extends BaseGenericService> {

    protected final S service;
    public static final String API = "/api";
    public static final String VERSION = "/v1";
    public static final String PATH = API + VERSION;


    protected AbstractController(S service) {
        this.service = service;
    }
}
