package team.devs.devhubio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import team.devs.devhubio.model.PrivateMessage;
import team.devs.devhubio.repository.PrivateMessageRepository;
import team.devs.devhubio.service.PrivateMessageService;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class DevhubioApplicationTests {

	@Autowired PrivateMessageService privateMessageService;
	@Autowired PrivateMessageRepository privateMessageRepository;

	@Test
	public void 쪽지보내기() throws Exception{

		//Given
		PrivateMessage privateMessage = new PrivateMessage();
		privateMessage.setId(1L);
		privateMessage.setName("이름");
		privateMessage.setTitle("제목");
		privateMessage.setMessage("안녕하세요 테스트예요.");
		privateMessage.setSendid("1");
		privateMessage.setReceiveid("2");
		privateMessage.setDate("2024-07-05");

		//When
		Long saveId = privateMessageService.sendMessage(privateMessage);

		//than
		PrivateMessage findMessage = privateMessageRepository.findById(saveId).get();
		assertEquals(privateMessage.getName(), findMessage.getName());
	}

}
