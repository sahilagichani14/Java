package annotations_reflectionapi;

@MyCustomAnnotation(priority = 2, tags = {"important", "feature"})
public class Info {
    @MyCustomAnnotation(tags = {"details"})
    public void getDetailedInfo() {
        System.out.println("giving imp details");
    }
}
