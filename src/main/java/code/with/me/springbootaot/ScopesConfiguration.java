package code.with.me.springbootaot;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

/**
 * @author andong@xiaomalixing.com
 */
@Configuration
public class ScopesConfiguration {
}

@Component
@RequestScope
class RequestContext {
    private final String uuid = UUID.randomUUID().toString();

    public String getUuid() {
        return uuid;
    }

}

@RestController
class ContextHttpController {
    private final RequestContext requestContext;

    ContextHttpController(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @GetMapping("/scopes/context")
    String uuid() {
        return requestContext.getUuid();
    }
}