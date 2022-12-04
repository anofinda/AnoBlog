package pers.anofinda.anoblog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.anofinda.anoblog.entity.Essay;
import pers.anofinda.anoblog.entity.Tag;
import pers.anofinda.anoblog.service.EssayService;
import pers.anofinda.anoblog.service.TagService;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * @author dongyudeng
 */
@Slf4j
@CrossOrigin(origins = "http://localhost:3333")
@RestController
@RequestMapping("/api")
public class ApiController {
    private final EssayService essayService;
    private final TagService tagService;

    @Autowired
    ApiController(EssayService essayService, TagService tagService) {
        this.essayService = essayService;
        this.tagService = tagService;
    }

    @GetMapping("/essays")
    public List<Essay> getEssays() {
        return essayService.getEssays();
    }

    @GetMapping("/essay/{id}")
    public Essay getEssay(@PathVariable("id") Long id) {
        return essayService.getEssayById(id);
    }

    @GetMapping("/essay/tag")
    public List<Essay> getEssaysByTag(@PathParam("tagName") String tagName) {
        return essayService.getEssaysByTagName(tagName);
    }

    @GetMapping("/essay/count")
    public long countEssays() {
        return essayService.count();
    }

    @GetMapping("/tags")
    public List<Tag> getTags() {
        return tagService.getTags();
    }

    @GetMapping("/tag/{id}")
    public Tag getTag(@PathVariable("id") Long id) {
        return tagService.getTagById(id);
    }

    @GetMapping("/tag/count")
    public long countTags() {
        return tagService.count();
    }
}
