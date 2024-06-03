public class Example{
       public static void main(String args[]){
              System.out.println("========");
              for(String x: args){
                     System.out.println("Value: " + x);
              }
              System.out.println(System.getenv("jira-access-token"));
       }
}