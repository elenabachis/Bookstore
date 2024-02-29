//package Tests;
//
//import main.model.Buch;
//import main.repository.BuchRepo;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class RepoTest {
//
//    @Test
//    public void test_BuchRepo_add(){
//        Buch b1 = new Buch("1b","Pride and Prejudice","Jane Austen", "Classic", 320, 1920, 34);
//        List<Buch> buchList= new ArrayList<>();
//        BuchRepo buchRepo = BuchRepo.getInstance(buchList);
//
//        buchRepo.add(b1);
//        assertEquals(1, buchList.size());
//    }
//
//    @Test
//    public void test_BuchRepo_delete() {
//        Buch b1 = new Buch("1b","Pride and Prejudice","Jane Austen", "Classic", 320, 1920, 34);
//        Buch b2 = new Buch("2b","Pride and Prejudice","Jane Austen", "Classic", 320, 1920, 34);
//        List<Buch> buchList= new ArrayList<>();
//        BuchRepo buchRepo = BuchRepo.getInstance(buchList);
//        buchRepo.add(b1);
//        buchRepo.add(b2);
//
////        buchRepo.delete(b1.getIdBuch());
////        assertEquals(1, buchList.size());
//    }
//}
