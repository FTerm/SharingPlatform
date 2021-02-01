import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * order:Junsen
 *
 * @Date 2021/1/31 21:08
 * @Description
 */
@RestController
@RequestMapping("/user")

public class UserController {
    @ApiOperation(value = "查", httpMethod = "POST")
    @RequestMapping("/select")
    public String select() {
        return "todo";
    }
}

