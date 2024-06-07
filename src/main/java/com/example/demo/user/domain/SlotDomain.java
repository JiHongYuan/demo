package com.example.demo.user.domain;

import com.example.demo.user.model.entity.Slot;
import com.example.demo.user.repository.SlotRepository;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SlotDomain {

    private final SlotRepository slotRepository;

    public void add(@Nullable String slotId) {
        Slot slot = new Slot();
        if (slotId != null) {
            slot.setId(UUID.randomUUID().toString());
        }
        slotRepository.save(slot);
    }

    public SlotDomain(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

}
