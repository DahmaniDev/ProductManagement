package tn.esprit.Service;

import static org.junit.Assert.assertNotEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.Entity.Client;
import tn.esprit.Repository.ClientRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientServiceImplTest {
	
	@Autowired
	ClientRepository clientRepository;
	@Autowired
	IClientService clientService;
	
	@Test
	public void testRetrieveClientsByBirthDate(){
		List<Client> clients = clientRepository.retrieveClientsByBirthDate();
		int expected = clients.size();
		Client c1 = new Client();
		c1.setNom("Test 1 Nom");
		c1.setDateNaissance(new Date(1995,10,10));
		Client c2 = new Client();
		c2.setNom("Test 2 Nom");
		c2.setDateNaissance(new Date(1998,8,8));
		Client savecClient1 = clientService.addClient(c1);
		Client savecClient2 = clientService.addClient(c2);
		assertNotEquals(expected+2,clientRepository.retrieveClientsByBirthDate());
		clientService.deleteClient(savecClient1.getIdClient());
		clientService.deleteClient(savecClient2.getIdClient());
	}

}
