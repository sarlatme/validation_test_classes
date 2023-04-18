package camix.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Hashtable;

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
	
//	@Test
//	public void testAjouteClientNonPresentMock() throws IOException {
//		CanalChat canalChat = new CanalChat("Canal de test");
//		
//		String id = "id test";
//		
//		ClientChat clientMock = Mockito.mock(ClientChat.class);
//		Mockito.when(clientMock.donneId()).thenReturn(id);
//		
//		canalChat.ajouteClient(clientMock);
//
//		assertEquals(1, (int)canalChat.donneNombreClients(), "Nombre de clients incorrect");
//		assertTrue(canalChat.estPresent(clientMock), "Client non présent");
//		
//		Mockito.verify(clientMock, Mockito.times(3)).donneId();
//		Mockito.verifyNoMoreInteractions(clientMock);
//	}
	
	@Test
	public void testAjouteClientNonPresentMockV2() throws IOException, SecurityException, 
	NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
	    CanalChat canalChat = new CanalChat("Canal de test");

	    String id = "id test";

	    ClientChat clientMock = Mockito.mock(ClientChat.class);
	    Mockito.when(clientMock.donneId()).thenReturn(id);

	    canalChat.ajouteClient(clientMock);

	    String attributConcerne = "clients";
	    Field attribut;

        attribut = CanalChat.class.getDeclaredField(attributConcerne);
        attribut.setAccessible(true);
        Hashtable<String, ClientChat> clients = (Hashtable<String, ClientChat>) attribut.get(canalChat);

        assertEquals(1, clients.size(),"Nombre de client incorrect");
        assertEquals(clientMock, clients.get(id), "Client incorrect");
        assertNotNull(clients.get(id), "Client non présent");
	}

}
