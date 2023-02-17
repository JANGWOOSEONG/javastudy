package service;

public interface ContactService {
	
	    // 서비스 만들때 인터페이스를 먼저 만든다
		// 인터페이스를 구성하는 클래스를 만든다
		// xxxService 이렇게 이름을 만든다
		// xxxService impl
	
	public void addContact();
	public void removeContact();
	public void modifyContact();
	public void findContactByName();
	public void findAllContacts();
	
	

	
}


