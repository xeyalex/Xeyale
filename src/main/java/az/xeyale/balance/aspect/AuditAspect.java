package az.xeyale.balance.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditAspect {

    @Value("${balance.audit-log.enabled}")
    private boolean isAuditEnabled;

    @AfterReturning("execution(* az.xeyale.balance.service.*.*(..))")
    public void logAudit() {
        if (isAuditEnabled) {
            System.out.println("Audit log yazıldı: " + System.currentTimeMillis());
        }
    }
}
