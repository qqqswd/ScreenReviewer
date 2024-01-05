package screenreviewer.controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import screenreviewer.pojo.Result;
import screenreviewer.utils.JwtUtils;


@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class IdController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/getUserId")
    public Result getUserId() {
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        String operateUser = (String) claims.get("id");
        return Result.success(operateUser);
    }
}