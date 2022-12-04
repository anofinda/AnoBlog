package pers.anofinda.anoblog.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.PredicateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.anofinda.anoblog.dao.TagRepository;
import pers.anofinda.anoblog.entity.Tag;

import java.util.Iterator;
import java.util.List;

/**
 * @author dongyudeng
 */
@Slf4j
@Transactional(rollbackFor = RuntimeException.class)
@Service
public class TagService {
    private final TagRepository tagRepository;

    @Autowired
    TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getTags() {
        Iterable<Tag> tagIterable = tagRepository.findAll();
        return IterableUtils.toList(tagIterable);
    }

    public Tag getTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    public Tag getTagByTagName(String tagName) {
        return tagRepository.findByTagName(tagName).orElse(null);
    }

    public boolean exitsByTagName(String tagName) {
        return tagRepository.existsByTagName(tagName);
    }

    public long count() {
        return tagRepository.count();
    }
}
