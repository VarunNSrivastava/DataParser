//import java.util.ArrayList;
//import java.util.List;
//
//public class State {
//    private String name;
//    private List<County> counties;
//
//    public State(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<County> getCounties() {
//        return counties;
//    }
//
//    public County addCounty(County county) {
//        counties.add(county);
//    }
//
//    public void setCounties(List<County> counties) {
//        this.counties = counties;
//    }
//
//    public County getCountyName() {
//        for (County county : counties) {
//            if (county.getName().equals(name)) return county;
//        }
//        return null;
//    }
//
//}
