package study.datajpa.repositroy;

import org.springframework.beans.factory.annotation.Value;

public interface UsernameOnly {

    @Value("#{target.username + ' ' + target.age}") // open projection
    String getUsername();
}
