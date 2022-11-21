package pers.anofinda.anoblog.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.anofinda.anoblog.entity.Essay;
import pers.anofinda.anoblog.service.EssayService;

import java.util.List;

/**
 * @author dongyudeng
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class ApiController {
    private EssayService essayService;

    ApiController(EssayService essayService) {
        this.essayService = essayService;
    }

    @GetMapping("/essay")
    public List<Essay> getEssays() {
        return essayService.getAll();
    }

    @GetMapping("/essay/{id}")
    public Essay getEssay(@PathVariable Long id) {
        return essayService.getEssayById(id);
    }

    @GetMapping("/count")
    public long count() {
        return essayService.count();
    }
}
