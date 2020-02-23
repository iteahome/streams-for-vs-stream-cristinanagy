package MyPackage;
import java.util.Arrays;
import java.util.List;


public class StreamBusiness {

    public static double averageWithForEach(List<Business> businessList) {
        int count = 0;
        int sum = 0;
        for (Business products : businessList) {
            if (products.getQuality() > 5) {
                sum += products.getQuality();
                count++;
            }
        }

        return sum / count;
    }

    public static double averageWithStream(List<Business>businessList) {
        return businessList.stream()
                .filter(st -> st.getQuality() > 5)
                .mapToInt(st -> st.getQuality())
                .average()
                .orElse(0);
    }

    public static void main(String[] args) {
        Business business1 = new Business(1, "Piatra", "Cluj", 104880);
        Business business2 = new Business(2, "Pietricica", "Bucuresti", 3764);
        Business business3 = new Business(3, "Pietruta", "Timisoara", 45464);

        List<Business> businessList = Arrays.asList(business1, business2, business3);
        System.out.println("Average with foreach: " + averageWithForEach(businessList));
        System.out.println("Average with stream: " + averageWithStream(businessList));
    }

    public static class Business {
        private int id;
        private String name;
        private String locations;
        private int FiscalValue;

        public Business(int id, String name, String locations, int FiscalValue) {
            this.id = id;
            this.name = name;
            this.locations = locations;
            this.FiscalValue = FiscalValue;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLocations() {
            return locations;
        }

        public int getQuality() {
            return FiscalValue;
        }
    }
}




