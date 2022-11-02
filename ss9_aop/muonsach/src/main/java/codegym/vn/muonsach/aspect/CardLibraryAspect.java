package codegym.vn.muonsach.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Aspect
@Component
public class CardLibraryAspect {
        private Logger logger = Logger.getLogger(CardLibraryAspect.class.getName());
        private static int count = 0;

        @Pointcut("execution(* codegym.vn.muonsach.service.CardServiceImpl.*(..))")
            public  void cardService(){};

//        @Before("cardService()")
//        public void getLog(JoinPoint joinPoint) {
//            String nameMethod = joinPoint.getSignature().getName();
//            logger.info(" before : Call" + nameMethod);
//        }
//
//        @After("cardService()")
//        public void getLogEnd(JoinPoint joinPoint) {
//        String nameMethod = joinPoint.getSignature().getName();
//        logger.info(" End : Call" + nameMethod);
//        }

        @Around("cardService()")
        public Object getLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Around: Begin call " + methodName);
        Object result = joinPoint.proceed(); //getList()
        logger.info("Around: End call " + methodName);
        return result;
    }


        @After("execution(* codegym.vn.muonsach.controller.CardController.formReturn(..))")
         public void affterReturnBook( JoinPoint joinPoint) throws Throwable{

            logger.info("So luong sach da cong them 1");

        }

    @AfterReturning("execution(* codegym.vn.muonsach.controller.BookController.showList(..))")
    public void getLogAfterRunning(JoinPoint joinPoint) throws Throwable {
//        String methodName = joinPoint.getSignature().getName();
//        int method = joinPoint.getSignature()
          count = count + 1;
        logger.info( "So lan truy cap trang sach: " + count);
    }








}
