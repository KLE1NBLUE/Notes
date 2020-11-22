import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LombokTest {



        private int id;
        private String name;

        public static void main(String[] args) {
            //传统方式
            LombokTest h1 = new LombokTest();
            h1.setId(1);
            h1.setName("garren");
            System.out.println(h1);

            //builder 方式
            LombokTest h2 =LombokTest.builder().id(2).name("kate").build();
            System.out.println(h2);
        }


}
