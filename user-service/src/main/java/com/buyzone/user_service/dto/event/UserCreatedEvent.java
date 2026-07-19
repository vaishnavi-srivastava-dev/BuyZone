package com.buyzone.user_service.dto.event;

import lombok.Data;

@Data
public class UserCreatedEvent {

    private Long id;
    private String name;
    private String email;

    public UserCreatedEvent() {
    }

    public UserCreatedEvent(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


}
