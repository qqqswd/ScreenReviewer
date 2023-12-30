package screenreviewer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import screenreviewer.mapper.OperateLogMapper;
import screenreviewer.pojo.OperateLog;
import screenreviewer.service.OperateLogService;

import java.util.List;

@Service
public class OperateLogImpl implements OperateLogService {
    @Autowired
    private OperateLogMapper operateLogMapper;
    @Override
    public List<OperateLog> getLog() {
        return operateLogMapper.getLog();
    }
}
