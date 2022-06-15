package study.datajpa.repositroy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.datajpa.entity.Item;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ItemRepositoryTest {

    @Autowired ItemRepository itemRepository;

    @Test
    void save() {
        /**
         * JPA 식별자 생성 전략이 @GenerateValue면 save() 호출 시점에
         * 식별자가 없으므로 새로운 엔티티로 인식해서 정상작동 한다.
         * 그런데, JPA 식별자 생성 전략이 @Id만 사용해서 직접 할당이면 이미 식별자 값이 있는 상태로
         * save()를 호출한다. 따라서 이 경우 merge()가 호출된다.
         * merge()는 우선 DB를 호출해서 값을 확인하고, DB에 값이 없으면 새로운 엔티티로 인지하므로 매우 비효율적
         * 따라서 Persistable를 사용해 isNew() 메서드 오버라이딩 해서 해결
         */
        Item item = new Item("A");
        itemRepository.save(item);

    }
}