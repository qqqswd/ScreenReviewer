package screenreviewer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import screenreviewer.mapper.AdminMapper;
import screenreviewer.pojo.Admin;
import screenreviewer.service.AdminService;

@Service
public class AdminImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin adminLogin(Admin admin) {
        return adminMapper.getByAdminIdAndPassword(admin);
    }
}
