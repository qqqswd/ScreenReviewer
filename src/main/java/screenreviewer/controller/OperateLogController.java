package screenreviewer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import screenreviewer.pojo.Comment;
import screenreviewer.pojo.OperateLog;
import screenreviewer.pojo.Result;
import screenreviewer.service.OperateLogService;

import java.util.List;

@Slf4j
@RestController
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    @GetMapping("getLog")
    public Result getLog() {
        List<OperateLog> list = operateLogService.getLog();
        return Result.success(list);
    }
}
