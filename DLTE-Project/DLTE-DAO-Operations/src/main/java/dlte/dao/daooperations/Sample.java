package dlte.dao.daooperations;

public class Sample {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        System.out.println(bankService.listAll());
        //System.out.println(bankService.getByUsername("kirtan1234","kirtan@1234"));
    }
}
