package pers.anofinda.anoblog.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.anofinda.anoblog.dao.EssayRepository;
import pers.anofinda.anoblog.entity.Essay;

/**
 * @author dongyudeng
 */
@Slf4j
@Transactional(rollbackFor = RuntimeException.class)
@Service
public class EssayService {
    private final EssayRepository essayRepository;

    @Autowired
    EssayService(EssayRepository essayRepository) {
        this.essayRepository = essayRepository;
    }

    public List<Essay> getEssays() {
        Iterable<Essay> essayIterable = essayRepository.findAll();
        return IterableUtils.toList(essayIterable);
    }

    public Essay getEssayById(Long id) {
        return essayRepository.findById(id).orElse(null);
    }

    public Essay getEssayByTittle(String tittle) {
        return essayRepository.findByTittle(tittle).orElse(null);
    }

    public List<Essay> getEssaysByTagName(String tagName) {
        return essayRepository.findAllByTagName(tagName);
    }

    public long count() {
        return essayRepository.count();
    }

    /**
     * 更新文章内容
     *
     * @param id      文章编号
     * @param content 修改内容
     */
    public void update(Long id, String content) {
        Optional<Essay> optionalEssay = essayRepository.findById(id);
        if (optionalEssay.isEmpty()) return;
        Essay essay = optionalEssay.get();
        essay.setContent(content);
        essay.setLastUpdate(LocalDateTime.now());
        essayRepository.save(essay);
    }
}
