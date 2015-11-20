package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final String template = "Rezultatul este, %d!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/test")
    public Test test(@RequestParam(value="x", defaultValue="3") long x) {
        return new Test(counter.incrementAndGet(),3,
                            "ceva");
    }
}
