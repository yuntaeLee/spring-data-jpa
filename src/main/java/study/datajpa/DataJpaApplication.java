package study.datajpa;

import com.p6spy.engine.spy.P6SpyOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import study.datajpa.p6spy.P6SpyPrettySqlFormatter;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DataJpaApplication.class, args);
    }

    @PostConstruct
    public void setLogMessageFormat() {
        P6SpyOptions.getActiveInstance().
                setLogMessageFormat(P6SpyPrettySqlFormatter.class.getName());
    }

}
