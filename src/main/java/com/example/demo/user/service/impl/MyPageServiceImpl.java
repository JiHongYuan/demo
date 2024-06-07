package com.example.demo.user.service.impl;

import com.example.demo.cache.TokenCache;
import com.example.demo.user.mapper.PageMapper;
import com.example.demo.user.model.PageDo;
import com.example.demo.user.model.SlotDo;
import com.example.demo.user.model.entity.Page;
import com.example.demo.user.model.entity.Slot;
import com.example.demo.user.repository.PageRepository;
import com.example.demo.user.repository.SlotRepository;
import com.example.demo.user.service.MyPageService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class MyPageServiceImpl implements MyPageService {

    private final PageMapper pageMapper;
    private final SlotRepository slotRepository;
    private final PageRepository pageRepository;

    private final TokenCache cache = new TokenCache();

    @Override
    public String checkSlotId(@NotNull String slotId) {
        return cache.supplier(slotId, () -> slotRepository.existsById(slotId));
    }

    @Override
    public boolean checkSlotIdAndPath(@NotNull String slotId, @NotNull String path) {
        return pageRepository.existsBySlotIdAndPath(slotId, path);
    }

    public void add(SlotDo slotDo) {
        String token = slotDo.getUuid();

        String slotId = cache.get(token);
        if (slotId == null) {
            throw new IllegalArgumentException();
        }
        Slot slot = new Slot();
        slot.setId(slotId);
        slotRepository.save(slot);
    }

    public void add(PageDo pageDo) {
        Page page = pageMapper.toEntity(pageDo);
        pageRepository.save(page);
    }

    @Override
    public String getIndexPageBySlotId(@NotNull String slotId) {
        return this.getPathPageBySlotId(slotId, "index");
    }

    @Override
    public String getPathPageBySlotId(@NotNull String slotId, @NotNull String path) {
        Page page = pageRepository.findBySlotIdAndPath(slotId, path);
        return page.getHtml();
    }

    public MyPageServiceImpl(SlotRepository slotRepository, PageRepository pageRepository) {
        this.slotRepository = slotRepository;
        this.pageRepository = pageRepository;
        this.pageMapper = PageMapper.INSTANCE;
    }

}