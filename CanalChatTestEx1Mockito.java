package camix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.mockito.Mockito;

public class CanalChatTestEx1Mockito {

//	@Test
//	public void testAjouteClientNonPresent() throws IOException{
//		CanalChat canalChat = new CanalChat("Canal sous test");
//		
//		String id_test = "id_non_present";
//		
//		ClientChat clientChat = new ClientChat(null, null, id_test, canalChat);
//		
//		canalChat.ajouteClient(clientChat);
//		
//		assertEquals(1, (int)canalChat.donneNombreClients(), "Nombre de clients incorrect");
//		assertTrue(canalChat.estPresent(clientChat), "Client non présent");
//	}
	
	@Test
	public void testAjouteClientNonPresentMock() throws IOException {
		CanalChat canalChat = new CanalChat("Canal de test");
		
		String id = "id test";
		
		ClientChat clientMock = Mockito.mock(ClientChat.class);
		Mockito.when(clientMock.donneId()).thenReturn(id);
		
		canalChat.ajouteClient(clientMock);

		assertEquals(1, (int)canalChat.donneNombreClients(), "Nombre de clients incorrect");
		assertTrue(canalChat.estPresent(clientMock), "Client non présent");
		
		Mockito.verify(clientMock, Mockito.times(3)).donneId();
		Mockito.verifyNoMoreInteractions(clientMock);
	}
	
}
