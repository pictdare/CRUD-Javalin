/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.barbaro.crudjavalin;

import com.barbaro.crudjavalin.controllers.UserController;
import io.javalin.ApiBuilder;
import io.javalin.Javalin;

/**
 *
 * @author leolopez94
 */
public class CRUDExample {
    
    public static void main(String[] args){
        Javalin app = Javalin.create()
                .port(7000)
                .start()
                .routes(() -> {
                    ApiBuilder.path("user", () -> {
                        ApiBuilder.post((req) -> req.json(UserController.create(req.formParam("email"), req.formParam("name"))));
                        ApiBuilder.get((ctx) -> ctx.json(UserController.list()));
                        ApiBuilder.path(":id", () -> {
                            ApiBuilder.get((ctx) -> ctx.json(UserController.get(ctx.param("id"))));
                            ApiBuilder.put((ctx) -> ctx.json(UserController.update(ctx.param("id"), ctx.formParam("name"))));
                            ApiBuilder.delete((ctx) -> ctx.json(UserController.delete(ctx.param("id"))));
                        });
                    });
                });
    }
}
